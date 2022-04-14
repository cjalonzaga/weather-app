package com.webb.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@Autowired
	private WeatherApi weatherApi;
	
	@GetMapping("/")
	public String home(Model model) {
		
		model.addAttribute("today" , weatherApi.displayWeather());
		
		if( weatherApi.displayForecast() != null ) {
			model.addAttribute("forecast", weatherApi.displayForecast());
		}
		
		return "home";
	}
	
	@RequestMapping(value="/get-city", method = RequestMethod.GET)
	public String setCityWeather(@RequestParam(value = "cityname", required=true) String cityName , Model model) {
		
		model.addAttribute("today", weatherApi.setCity(cityName));
		model.addAttribute("forecast", weatherApi.displayForecast());
		
		return "home";
	}
	
//	@RequestMapping("/")
//	public String setForecast(Model model) {
//		
//		model.addAttribute("forecast", weatherApi.displayForecast());
//		
//		return "home";
//	}
}
