package com.webb.app.pojo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class HourlyForecast {
	private long dt;
	private Main main;
	private List<Weather> weather;
	private String dt_txt;
	
	public String getHour() {
		String hour = new java.text.SimpleDateFormat("h a").format(new java.util.Date (getDt()*1000));
		return hour;
	}
}
