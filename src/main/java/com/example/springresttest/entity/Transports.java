package com.example.springresttest.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "transports")
public class Transports {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transports_sequence")
	@SequenceGenerator(name = "transports_sequence", sequenceName = "transports_sequence", allocationSize = 1)
	@Column(name = "id_of_transport")
	private Long idOfTransport;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	@JoinColumn(name = "id_of_category_of_transport")
	private CategorysOfTransport categoryOfTransport;
	
	@OneToMany(mappedBy = "transport", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	private List<Threads> threads = new ArrayList<Threads>();
	@Column(name = "number")
	private String number;
	
	public Transports() {
		
	}

	public Long getIdOfTransport() {
		return idOfTransport;
	}

	public void setIdOfTransport(Long idOfTransport) {
		this.idOfTransport = idOfTransport;
	}

	public CategorysOfTransport getCategoryOfTransport() {
		return categoryOfTransport;
	}

	public void setCategoryOfTransport(CategorysOfTransport categoryOfTransport) {
		this.categoryOfTransport = categoryOfTransport;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

		
	public void addThread(Threads thread) {
		this.threads.add(thread);
	}
	
	public void delThread(Threads thread) {
		if (this.threads.contains(thread)) {
			this.threads.remove(thread);
		}
	}

	public List<Threads> getThreads() {
		return threads;
	}

	public void setThreads(List<Threads> threads) {
		this.threads = threads;
	}

	@Override
	public String toString() {
		return "Transports [idOfTransport=" + idOfTransport + ", categoryOfTransport=" + categoryOfTransport
				+ ", threads=" + threads + ", number=" + number + "]";
	}
	
}