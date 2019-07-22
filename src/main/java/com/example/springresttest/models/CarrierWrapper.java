package com.example.springresttest.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarrierWrapper {
	
	@JsonProperty("carrier")
	private Carrier carrier = new Carrier();
	
	public CarrierWrapper() {
		
	}
	
	public CarrierWrapper(Carrier carrier) {
		super();
		this.carrier = carrier;
	}
	public Carrier getCarrier() {
		return carrier;
	}
	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}
	@Override
	public String toString() {
		return "CarrierWrapper [carrier=" + carrier + "]";
	}
}
