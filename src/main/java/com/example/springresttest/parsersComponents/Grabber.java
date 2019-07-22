package com.example.springresttest.parsersComponents;

import com.example.springresttest.entity.CategorysOfStation;
import com.example.springresttest.entity.CategorysOfTransport;
import com.example.springresttest.entity.Flyghts;
import com.example.springresttest.entity.Stations;
import com.example.springresttest.entity.Stops;
import com.example.springresttest.entity.Threads;
import com.example.springresttest.models.Carrier;
import com.example.springresttest.models.CarrierWrapper;
import com.example.springresttest.models.FlyghtsResponseJsonObject;
import com.example.springresttest.models.Segment;
import com.example.springresttest.models.Station;
import com.example.springresttest.models.StopJson;
import com.example.springresttest.models.ThreadOfFlyghts;
import com.example.springresttest.models.TimetableJson;
import com.example.springresttest.parsersComponents.GrabberConfig;
import com.example.springresttest.repository.*;
import com.example.springresttest.services.CarriersService;
import com.example.springresttest.services.FlyghtsService;
import com.example.springresttest.services.StopsService;
import com.example.springresttest.services.TimetablesService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.sql.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class Grabber {
	
	@Autowired
	private TimetablesService timetablesService;
	
	@Autowired
	private GrabberConfig grabberConfig;
	
	@Autowired
	private Data data;
	
	@Autowired
	private UriList uriList;
	
	@Autowired
	private StopsService stopsService;
	
	@Autowired
	private CarriersService carriersService;
	
	@Autowired
	private StationList stationList;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	public Grabber() {
		
	}
	
	Grabber(String siteUri) {
		grabberConfig.setSiteUri(siteUri);
	}
	
	@Scheduled(fixedRate = 3600000)
	public void run() {
		getData();
		/*if (request.getRequestConfig().getMethod() == "GET") {
			Request.send();get();
		}*/
	}
	
	private void getData() {
		this.getFlyghts();
		this.getStops();
		this.getCarriers();
		this.saveData();
	}
	
	private void getFlyghts() {
		TimetableJson timetable;
		//System.out.println(uriList.getUri("flyghts").getUriAsString());
		try {
			for (String station : stationList.getStations()) {
				Uri uri = uriList.getUri("timetable");
				uri.addParameter("station", station);
				timetable = restTemplate.getForObject(uriList.getUri("timetable").getUriAsString(), TimetableJson.class);
				//System.out.println(result);
				//ResponseParser responseFlyghtsParser = new ResponseFlyghtsParser();
				//responseFlyghtsParser.parseJson(result);
				System.out.println(timetable.toString());
				uri.delParameter("station");
				uriList.updateUri("timetable", uri);
				//System.out.println(0);
				data.addTimetable(timetable);
			}
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		//System.out.println(0);
		/* try {
			DefaultHttpClient httpClient = new DefaultHttpClient();
			UriList uriList = new UriList();
			System.out.println(uriList.getUri("flyghts").getUriAsString());
			HttpGet getRequest = new HttpGet(uriList.getUri("flyghts").getUriAsString());
			getRequest.addHeader("accept", "application/json");
			HttpResponse response = httpClient.execute(getRequest);
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
				   + response.getStatusLine().getStatusCode());
			}
			BufferedReader br = new BufferedReader(
	                         new InputStreamReader((response.getEntity().getContent())));
			String output;
			System.out.println("Output from Server .... \n");
			String flyghtsJson = "";
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				flyghtsJson += output;
			}
			
			ResponseParser responseFlyghtsParser = new ResponseFlyghtsParser();
			responseFlyghtsParser.parseJson(flyghtsJson);
			httpClient.getConnectionManager().shutdown();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		return;
	}
	
	private void getStops() {
		List<TimetableJson> timetablesJson = data.getTimetables();
		for (TimetableJson timetable : timetablesJson) {
			List<Segment> segments = timetable.getSegments();
			for (Iterator<Segment> iter = segments.iterator(); iter.hasNext();) {
				Segment segment = iter.next();
				StopJson stopJson;
				try {
					Uri uri = uriList.getUri("thread");
					uri.addParameter("uid", segment.getThreadOfFlyghts().getUid());
					stopJson = restTemplate.getForObject(uri.getUriAsString(), StopJson.class);
					//segment.setStops();
					uri.delParameter("uid");
					uriList.updateUri("thread", uri);
					data.addStopJson(stopJson);
					//System.out.println(stopJson.toString());
				} catch(RestClientException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void getCarriers() {
		List<TimetableJson> timetablesJson = data.getTimetables();
		for (TimetableJson timetable : timetablesJson) {
			List<Segment> segments = timetable.getSegments();
			for (Iterator<Segment> iter = segments.iterator(); iter.hasNext();) {
				Segment segment = iter.next();
				CarrierWrapper carrierJson;
				if (segment.getThreadOfFlyghts().getCarrier() == null || segment.getThreadOfFlyghts().getCarrier().getCode() == null) continue;
				try {
					Uri uri = uriList.getUri("carrier");
					uri.addParameter("code", segment.getThreadOfFlyghts().getCarrier().getCode());
					carrierJson = restTemplate.getForObject(uri.getUriAsString(), CarrierWrapper.class);
					uri.delParameter("code");
					uriList.updateUri("carrier", uri);
					data.addCarrierJson(carrierJson);
					//System.out.println(segment.getThreadOfFlyghts(), );
					//System.out.println(stopJson.toString());
				} catch(RestClientException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void saveData() {
		this.saveTimetable();
		this.saveStops();
		this.saveCarriers();
	}
	
	private void saveTimetable() {
		timetablesService.saveTimetable();
		return;
	}
	
	private void saveStops() {
		stopsService.saveStops();
		return;
	}
	
	private void saveCarriers() {
		carriersService.saveCarriers();
		return;
	}
	
	/*private void get() {
		try {
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet getRequest = new HttpGet(
				"http://localhost:8080/RESTfulExample/json/product/get");
			getRequest.addHeader("accept", "application/json");
			HttpResponse response = httpClient.execute(getRequest);
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
				   + response.getStatusLine().getStatusCode());
			}
			BufferedReader br = new BufferedReader(
	                         new InputStreamReader((response.getEntity().getContent())));
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			httpClient.getConnectionManager().shutdown();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}*/
}
