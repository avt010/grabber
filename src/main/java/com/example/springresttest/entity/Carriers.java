package com.example.springresttest.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;




@Entity
@Table(name = "carriers")
public class Carriers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carriers_sequence")
	@SequenceGenerator(name = "carriers_sequence", sequenceName = "carriers_sequence", allocationSize = 1)
	@Column(name = "id_of_carrier")
	private Long idOfCarrier;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "contacts")
	private String contacts;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "logo_svg")
	private String logoSvg;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "logo")
	private String logo;
	
	@Column(name = "email")
	private String email;
	
	@OneToMany(mappedBy = "carrier", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})//true
	private List<Threads> threads = new ArrayList<Threads>();
	
	public Carriers() {
		
	}

	public Long getIdOfCarrier() {
		return idOfCarrier;
	}

	public void setIdOfCarrier(Long idOfCarrier) {
		this.idOfCarrier = idOfCarrier;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLogoSvg() {
		return logoSvg;
	}

	public void setLogoSvg(String logoSvg) {
		this.logoSvg = logoSvg;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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