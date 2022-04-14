package com.webb.app.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.webb.app.pojo.Forecast;
import com.webb.app.pojo.WeatherApiMain;
import com.webb.app.util.Json;

@RestController
public class WeatherApi {
	
	private final String apiKey = "";
	private WeatherApiMain wam;
	private Forecast foreCast;
	private double lat;
	private double lon;
	
	@RequestMapping("/weather")
    public WeatherApiMain displayWeather() {
    	
    	String uri = "https://api.openweathermap.org/data/2.5/weather?q=Iloilo&units=metric&APPID="+this.apiKey;
    	
    	RestTemplate template = new RestTemplate();
    	
    	String data = template.getForObject(uri, String.class);
    	
    	try {
			JsonNode node = Json.parse(data);
			this.wam = Json.fromJson(node, WeatherApiMain.class);
			setLat(node.at("/coord/lat").asDouble());
			setLon(node.at("/coord/lon").asDouble());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	//System.out.println(wam.getName());
//    	setLat(wam.getCoordinates().getLatitude());
//		setLon(wam.getCoordinates().getLongitude());
    	
    	return this.wam;
    }
	
	@RequestMapping("/forecast")
	public Forecast displayForecast() {
		
		String uri = "https://api.openweathermap.org/data/2.5/forecast?lat="+getLat()+"&lon="+getLon()+"&cnt=5&units=metric&APPID=fc383a8b7d325896d7aafba1624d3ed5";
		
		RestTemplate template = new RestTemplate();
		String data = template.getForObject(uri, String.class);
		
		try {
			JsonNode node = Json.parse(data);
			this.foreCast = Json.fromJson(node, Forecast.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.foreCast;
	}
	
	
	//@RequestMapping(value="/get-city", method = RequestMethod.POST)
	public WeatherApiMain setCity(String cityName) {
		String uri = "https://api.openweathermap.org/data/2.5/weather?q="+cityName+"&units=metric&APPID="+this.apiKey;
	
		//System.out.println(cityName + "123");
		RestTemplate template = new RestTemplate();
		String data = template.getForObject(uri, String.class);
		
		//System.out.println(data);
		this.wam = null;
		
		try {
			JsonNode node = Json.parse(data);
			wam = Json.fromJson(node, WeatherApiMain.class);
			setLat(node.at("/coord/lat").asDouble());
			setLon(node.at("/coord/lon").asDouble());
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		//System.out.println(wam.getName());
		
    	return this.wam;
		
	}
	
	private void setLon(double lon) {
		this.lon = lon;
	}
	private void setLat(double lat) {
		this.lat = lat;
	}
	
	private double getLon() {
		return this.lon;
	}
	private double getLat() {
		return this.lat;
	}
    
	
}
