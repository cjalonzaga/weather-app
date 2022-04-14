package com.webb.app.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class Main {
	private double temp;
	private double feels_like;
	private double temp_min;
	private double temp_max;
	private int pressure;
	private int humidity;
	private int seaLevel;
	private int groundLevel;
}
