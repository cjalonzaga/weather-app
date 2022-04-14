package com.webb.app.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter 
@Getter
@NoArgsConstructor
public class Weather {
	private int id;
	private String main;
	private String description;
	private String icon;
}
