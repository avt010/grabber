package com.example.springresttest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springresttest.entity.Flyghts;
import com.example.springresttest.entity.Threads;
import com.example.springresttest.entity.Timetables;
import com.example.springresttest.models.Segment;
import com.example.springresttest.models.TimetableJson;
import com.example.springresttest.parsersComponents.Data;
import com.example.springresttest.repository.TimetablesRepository;

@Service
public class TimetablesService {
	
	@Autowired
	private TimetablesRepository timetablesRepository;
	
	@Autowired
	private FlyghtsService flyghtsService;
	
	@Autowired
	private ThreadsService threadsService;
	
	@Autowired
	private Data data;
	
	@Transactional
	public void saveTimetable() {
		List<TimetableJson> timetablesJson = data.getTimetables();
		for (TimetableJson timetableJson : timetablesJson) {
			List<Segment> segments = timetableJson.getSegments();
			for (Segment segment : segments) {
				Timetables timetable = new Timetables();
				if (segment.getThreadOfFlyghts().getNumber() == "" || segment.getThreadOfFlyghts().getNumber() == null) continue; 
				Flyghts flyght = flyghtsService.saveFlyghtAndGet(segment);
				Threads thread = threadsService.saveThreadAndGet(segment.getThreadOfFlyghts());
				Optional<Timetables> timetableOptional = timetablesRepository.findByFlyght_IdOfFlyghtAndThread_IdOfThread(flyght.getIdOfFlyght(), thread.getIdOfThread());
				if (timetableOptional.isPresent()) continue;
				timetable.setFlyght(flyght);
				timetable.setThread(thread);
				System.out.println(timetable.toString());
				flyght.addTimetable(timetable);
				System.out.println(timetable.toString());
				thread.addTimetable(timetable);
				timetablesRepository.save(timetable);
			}
		}
		return;
	}

	public List<Flyghts> getAllTimetablesByThread(Threads thread) {
		List<Timetables> timetables = timetablesRepository.findByThread(thread);
		List<Flyghts> flyghts = new ArrayList<Flyghts>();
		for (Timetables timetable : timetables) {
			flyghts.add(timetable.getFlyght());
		}
		return flyghts;
	}
}
