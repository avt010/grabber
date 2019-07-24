package com.example.springresttest.parsersComponents;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class UriList {
	
	private Map<String, Uri> uris = new HashMap<String, Uri>();
	
	public UriList() {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("apikey", "c0743246-738c-403c-bd41-45d7375e3e4f");
		parameters.put("format", "json");
		parameters.put("from", "c146");
		parameters.put("to", "c213");
		parameters.put("lang", "ru_RU");
		parameters.put("date", "2019-06-30");
		this.uris.put("flyghts", new Uri("https", "api.rasp.yandex.net", "v3.0/search/", "", parameters));//"https://api.rasp.yandex.net/v3.0/search/?apikey=6728300a-e1b7-4fc1-a4f8-1c76fcd468e9&format=json&from=c146&to=c213&lang=ru_RU&page=1&date=2019-06-21");
		parameters = new HashMap<String, String>();
		parameters.put("apikey", "c0743246-738c-403c-bd41-45d7375e3e4f");
		parameters.put("format", "json");
		parameters.put("lang", "ru_RU");
		//parameters.put("date", "2019-07-17");
		this.uris.put("timetable", new Uri("https", "api.rasp.yandex.net", "v3.0/schedule/", "", parameters));
		parameters = new HashMap<String, String>();
		parameters.put("apikey", "c0743246-738c-403c-bd41-45d7375e3e4f");
		parameters.put("format", "json");
		parameters.put("lang", "ru_RU");
		this.uris.put("thread", new Uri("https", "api.rasp.yandex.net", "v3.0/thread/", "", parameters));
		parameters = new HashMap<String, String>();
		parameters.put("apikey", "c0743246-738c-403c-bd41-45d7375e3e4f");
		parameters.put("format", "json");
		parameters.put("lang", "ru_RU");
		this.uris.put("carrier", new Uri("https", "api.rasp.yandex.net", "v3.0/carrier/", "", parameters));
		parameters = new HashMap<String, String>();
		parameters.put("apikey", "c0743246-738c-403c-bd41-45d7375e3e4f");
		parameters.put("format", "json");
		parameters.put("lang", "ru_RU");
		this.uris.put("station", new Uri("https", "api.rasp.yandex.net", "v3.0/stations_list/", "", parameters));
	}
	
	public void setUris(Map<String, Uri> uris) {
		this.uris = uris;
	}
	
	public void addUri(String name, Uri uri) {
		this.uris.put(name,  uri);
	}
	
	public Map<String, Uri> getUris() {
		return this.uris;
	}
	
	public Uri getUri(String name) {
		return this.uris.get(name);
	}
	
	public void updateUri(String name, Uri uri) {
		this.uris.replace(name,  uri);
	}
	
	public Boolean has(String name) {
		return this.uris.containsKey(name);
	}
	
	public void delUri(String name, Uri uri) {
		if (this.uris.containsKey(name)) {
			this.uris.remove(name);
		}
	}
}
