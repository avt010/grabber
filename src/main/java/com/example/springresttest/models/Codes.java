package com.example.springresttest.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Codes {
	
	private String icao;
	
	private String sirena;
	
	private String iata;

	public Codes() {
		this.icao = "";
		this.sirena = "";
		this.iata = "";
	}

	public String getIcao() {
		return this.icao;
	}

	public void setIcao(String icao) {
		this.icao = icao;
	}

	public String getSirena() {
		return this.sirena;
	}

	public void setSirena(String sirena) {
		this.sirena = sirena;
	}

	public String getIata() {
		return this.iata;
	}

	public void setIata(String iata) {
		this.iata = iata;
	}

	@Override
	public String toString() {
		return "Codes [icao=" + icao + ", sirena=" + sirena + ", iata=" + iata + "]";
	}
	
}
