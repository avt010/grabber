package com.example.springresttest.parsersComponents;

import java.util.HashMap;
import java.util.Map;

public class Uri {
	
	private String protocol;
	
	private String domain;
	
	private String path;
	
	private String anchor;
	
	private Map<String, String> parameters;
	
	public Uri() {
		this.protocol = "";
		this.domain = "";
		this.path = "";
		this.anchor = "";
		this.parameters = new HashMap<String, String>();
	}
	
	public Uri(String protocol, String domain, String path, String anchor, Map<String, String> parameters) {
		this.protocol = protocol;
		this.domain = domain;
		this.path = path;
		this.anchor = anchor;
		this.parameters = parameters;
	}
	
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public void setAnchor(String anchor) {
		this.anchor = anchor;
	}
	
	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}
	
	public void addParameter(String name, String value) {
		this.parameters.put(name,  value);
	}
	
	public String getProtocol() {
		return this.protocol;
	}
	
	public String getDomain() {
		return this.domain;
	}
	
	public String getPath() {
		return this.path;
	}
	
	public String getAnchor() {
		return this.anchor;
	}
	
	public Map<String, String> getParameters() {
		return this.parameters;
	}
	
	public String getParametr(String name) {
		return this.parameters.get(name);
	}
	
	public void delParameter(String name) {
		if (this.parameters.containsKey(name)) {
			this.parameters.remove(name);
		}
	}
	
	public String getUriAsString() {
		String result = protocol + "://" + domain + "/" + path;
		if (!parameters.isEmpty()) {
			result += "?";
			Integer count = parameters.size();
			Integer i = 0;
			for (Map.Entry<String, String> parametr : parameters.entrySet()) {
				i++;
				result += parametr.getKey() + "=" + parametr.getValue();
				if (i != count) result += "&";
			}
		}
		if (anchor != null && anchor != "") result +="#" + anchor;
		return result;
	}
}
