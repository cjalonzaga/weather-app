package com.webb.app.pojo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
public class Forecast {
	private int cod;
	private int cnt;
	private List<HourlyForecast> list;
	private City city;
}
