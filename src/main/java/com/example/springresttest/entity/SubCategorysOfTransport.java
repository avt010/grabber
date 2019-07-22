package com.example.springresttest.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*; 

@Entity
@Table(name = "sub_categorys_of_transport")
public class SubCategorysOfTransport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sub_categorys_of_transport_sequence")
	@SequenceGenerator(name = "sub_categorys_of_transport_sequence", sequenceName = "sub_categorys_of_transport_sequence", allocationSize = 1)
	@Column(name = "id_of_sub_category_of_transport")
	private Long idOfSubCategoryOfTransport;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "name_of_sub_category_of_transport")
	private String nameOfSubCategoryOfTransport;
	
	@OneToMany(mappedBy = "subCategoryOfTransport", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	private List<Threads> threads = new ArrayList<Threads>();
	
	public SubCategorysOfTransport() {
		
	}

	public Long getIdOfSubCategoryOfTransport() {
		return idOfSubCategoryOfTransport;
	}

	public void setIdOfSubCategoryOfTransport(Long idOfSubCategoryOfTransport) {
		this.idOfSubCategoryOfTransport = idOfSubCategoryOfTransport;
	}

	public String getNameOfSubCategoryOfTransport() {
		return nameOfSubCategoryOfTransport;
	}

	public void setNameOfSubCategoryOfTransport(String nameOfSubCategoryOfTransport) {
		this.nameOfSubCategoryOfTransport = nameOfSubCategoryOfTransport;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Threads> getThreads() {
		return threads;
	}

	public void setThreads(List<Threads> threads) {
		this.threads = threads;
	}
	
	public void addThread(Threads thread) {
		this.threads.add(thread);
	}
	
	public void delThread(Threads thread) {
		if (this.threads.contains(thread)) {
			this.threads.remove(thread);
		}
	}
	
	
}