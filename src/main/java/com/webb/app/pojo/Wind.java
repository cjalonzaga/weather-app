package com.webb.app.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class Wind {
	private double speed;
	private int deg;
	private double gust;
}
