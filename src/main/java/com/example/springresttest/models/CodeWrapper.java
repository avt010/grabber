package com.example.springresttest.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class CodeWrapper {
	
	@JsonProperty("yandex_code")
	private String code;
	
	public CodeWrapper() {
		
	}

	public CodeWrapper(String code) {
		super();
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "CodeWrapper [code=" + code + "]";
	}
	
	
}
