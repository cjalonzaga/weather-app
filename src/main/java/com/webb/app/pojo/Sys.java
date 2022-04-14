package com.webb.app.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class Sys {
	private String country;
	private String name;
	private int cod;
	private long sunrise;
	private long sunset;
}
