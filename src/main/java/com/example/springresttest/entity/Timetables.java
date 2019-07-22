package com.example.springresttest.entity;

import javax.persistence.*;

@Entity
@Table(name = "timetables")
public class Timetables {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "timetables_sequence")
	@SequenceGenerator(name = "timetables_sequence", sequenceName = "timetables_sequence", allocationSize = 1)
	@Column(name = "id_of_timetable")
	private Long id0fTimetable;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_of_flyght")
	private Flyghts flyght;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_of_thread")
	private Threads thread;
	
	public Timetables() {
		
	}

	public Long getId0fTimetable() {
		return id0fTimetable;
	}

	public void setId0fTimetable(Long id0fTimetable) {
		this.id0fTimetable = id0fTimetable;
	}

	public Flyghts getFlyght() {
		return flyght;
	}

	public void setFlyght(Flyghts flyght) {
		this.flyght = flyght;
	}

	public Threads getThread() {
		return thread;
	}

	public void setThread(Threads thread) {
		this.thread = thread;
	}
	
}
