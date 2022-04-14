package com.webb.app.pojo;


import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class WeatherApiMain {
	private Coordinates coordinates;
	private List<Weather> weather;
	private Main main;
	private Wind wind;
	private long dt;
	private Sys sys;
	private int timezone;
	private String name;
	private int cod;
	
	public String getDate() {
		String today = new java.text.SimpleDateFormat("EEE, MMM d, yyyy").format(new java.util.Date (getDt()*1000));
		return today;
	}
	
	public String getSunrise() {
		String sunrise = new java.text.SimpleDateFormat("h:mm a").format(new java.util.Date (sys.getSunrise()*1000));
		
		return sunrise;
	}
	
	public String getSunset() {
		String sunset = new java.text.SimpleDateFormat("h:mm a").format(new java.util.Date (sys.getSunset()*1000));
		
		//System.out.println("Hello");
		
		return sunset;
	}

}
