package com.webb.app.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class City {
	private int id;
	private String name;
	private Coord coord;
	private String country;
	private long population;
	private int timezone;
	private long sunrise;
	private long sunset;
}
