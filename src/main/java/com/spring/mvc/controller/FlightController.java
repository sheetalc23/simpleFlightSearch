package com.spring.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mvc.component.Flight;
import com.spring.mvc.service.FlightServiceImpl;

@RestController
@CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")
public class FlightController {

	@Autowired
	FlightServiceImpl flightService;
		
	@RequestMapping(value="/flights/",
			params= {"fNum", "ori", "dest", "date"},
			method=RequestMethod.GET)
	public List<Flight> getByAllParams(@RequestParam("fNum") String fNum,
			@RequestParam("ori") String origin, 
			@RequestParam("dest") String dest, 
			@RequestParam("date") String date) {
		List<Flight> flightList = new ArrayList<Flight>();
		flightList = flightService.searchByAllParams(fNum, origin, dest, date);
		return flightList;
	}
	
}
