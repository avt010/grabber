package com.example.springresttest.models;

import java.util.HashMap;
import java.util.Map;

import com.example.springresttest.parsersComponents.Uri;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class ThreadOfFlyghts {
	
	private String uid;
	
	private String title;
	
	@JsonProperty("number")
	private String number;
	
	@JsonProperty("short_title")
	private String shortTitle;
	
	private Carrier carrier = new Carrier();
	
	@JsonProperty("transport_type")
	private String transportType;
	
	private String vehicle;
	
	@JsonProperty("transport_subtype")
	private Transport transportSubtype;
	
	@JsonProperty("express_type")
	private String expressType;

	public ThreadOfFlyghts() {
		this.uid = "";
		this.title = "";
		this.number = "";
		this.shortTitle = "";
		this.carrier = new Carrier();
		this.transportType = "";
		this.vehicle = "";
		this.transportSubtype = new Transport();
		this.expressType = "";
	}

	public ThreadOfFlyghts(String uid, String title, String number, String shortTitle, Carrier carrier,
			String transportType, String vehicle, Transport transportSubtype, String expressType) {
		super();
		this.uid = uid;
		this.title = title;
		this.number = number;
		this.shortTitle = shortTitle;
		this.carrier = carrier;
		this.transportType = transportType;
		this.vehicle = vehicle;
		this.transportSubtype = transportSubtype;
		this.expressType = expressType;
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getShortTitle() {
		return shortTitle;
	}

	public void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	public String getTransportType() {
		return transportType;
	}

	public void setTransportType(String transportType) {
		this.transportType = transportType;
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public Transport getTransportSubtype() {
		return transportSubtype;
	}

	public void setTransportSubtype(Transport transportSubtype) {
		this.transportSubtype = transportSubtype;
	}

	public String getExpressType() {
		return expressType;
	}

	public void setExpressType(String expressType) {
		this.expressType = expressType;
	}
	
	public String getThreadMethodLink() {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("uid", this.uid);
		Uri uri = new Uri();
		uri.setProtocol("https");
		uri.setDomain("api.rasp.yandex.net");
		uri.setPath("v3.0/thread/");
		uri.setParameters(parameters);
		return uri.getUriAsString();
	}

	@Override
	public String toString() {
		return "ThreadOfFlyghts [uid=" + uid + ", title=" + title + ", number=" + number
				+ ", shortTitle=" + shortTitle + ", carrier=" + carrier
				+ ", transportType=" + transportType + ", vehicle=" + vehicle + ", transportSubtype=" + transportSubtype
				+ ", expressType=" + expressType + "]";
	}
	
}
