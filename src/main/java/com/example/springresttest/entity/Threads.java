package com.example.springresttest.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Threads")
public class Threads {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "threads_sequence")
	@SequenceGenerator(name = "threads_sequence", sequenceName = "threads_sequence", allocationSize = 1)
	@Column(name = "id_of_thread")
	private Long idOfThread;
	
	@Column(name = "uid")
	private String uid;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "short_title")
	private String shortTitle;
	
	@Column(name = "link_of_method")
	private String linkOfMethod;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	@JoinColumn(name = "id_of_carrier")
	private Carriers carrier;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	@JoinColumn(name = "id_of_category_of_transport")
	private CategorysOfTransport categoryOfTransport;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	@JoinColumn(name = "id_of_transport")
	private Transports transport;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	@JoinColumn(name = "id_of_sub_category_of_transport")
	private SubCategorysOfTransport subCategoryOfTransport;
	
	@Column(name = "express_type")
	private String expressType;
	
	@OneToMany(mappedBy = "thread", fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Stops> stops = new ArrayList<Stops>();
	
	@OneToMany(mappedBy = "thread", fetch = FetchType.LAZY)
	private List<Timetables> timetables = new ArrayList<Timetables>();
	
	
	public Threads() {
		
	}

	public Long getIdOfThread() {
		return idOfThread;
	}

	public void setIdOfThread(Long idOfThread) {
		this.idOfThread = idOfThread;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortTitle() {
		return shortTitle;
	}

	public void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}

	public String getLinkOfMethod() {
		return linkOfMethod;
	}

	public void setLinkOfMethod(String linkOfMethod) {
		this.linkOfMethod = linkOfMethod;
	}

	public Carriers getCarrier() {
		return carrier;
	}

	public void setCarrier(Carriers carrier) {
		this.carrier = carrier;
	}

	public CategorysOfTransport getCategoryOfTransport() {
		return categoryOfTransport;
	}

	public void setCategoryOfTransport(CategorysOfTransport categoryOfTransport) {
		this.categoryOfTransport = categoryOfTransport;
	}

	public Transports getTransport() {
		return transport;
	}

	public void setTransport(Transports transport) {
		this.transport = transport;
	}

	public SubCategorysOfTransport getSubCategoryOfTransport() {
		return subCategoryOfTransport;
	}

	public void setSubCategoryOfTransport(SubCategorysOfTransport subCategoryOfTransport) {
		this.subCategoryOfTransport = subCategoryOfTransport;
	}

	public String getExpressType() {
		return expressType;
	}

	public void setExpressType(String expressType) {
		this.expressType = expressType;
	}
	
	public List<Stops> getStops() {
		return stops;
	}

	public void setStops(List<Stops> stops) {
		this.stops = stops;
	}
	
	public void addStop(Stops stop) {
		this.stops.add(stop);
	}
	
	public void delStops(Stops stop) {
		if (this.stops.contains(stop)) {
			this.stops.remove(stop);
		}
	}

	public List<Timetables> getTimetables() {
		return timetables;
	}

	public void setTimetables(List<Timetables> timetables) {
		this.timetables = timetables;
	}
	
	public void addTimetable(Timetables timetable) {
		this.timetables.add(timetable);
	}
	
	public void delTimetable(Timetables timetable) {
		if (this.timetables.contains(timetable)) {
			this.timetables.remove(timetable);
		}
	}
}