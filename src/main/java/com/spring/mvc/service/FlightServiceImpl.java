package com.spring.mvc.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.mvc.component.Flight;


@Service
public class FlightServiceImpl {
	
	public static final Flight[] FLIGHT_ARRAY = getArray();
	
	public List<Flight> searchByAllParams(String fNum, String origin, String dest, String date) {
		List<Flight> flightList = Arrays.asList(FLIGHT_ARRAY);
        List<Flight> allParamsList = new ArrayList<Flight>();
        for (Flight flight : flightList) {
        	if((flight.getFlightNumber().equalsIgnoreCase(fNum) || 
        			(flight.getOrigin().equalsIgnoreCase(origin) && 
        			flight.getDestination().equalsIgnoreCase(dest)))
        			 && 
        			(!(date.isEmpty()) && flight.getDeparture().startsWith(date))) {
        		allParamsList.add(flight);
        	}
		}
		return allParamsList;
	}

	private static Flight[] getArray() {
		ObjectMapper mapper = new ObjectMapper();
		String filePath = "flight-docs/flight-sample.json";
		ClassLoader classLoader = Flight.class.getClassLoader();
		URL resource = classLoader.getResource(filePath);
		if (resource == null) {
			throw new IllegalArgumentException("file is not found");
		}
		
		String jsonArray = readFile(resource.getPath());

	    Flight[] flightArray = null;
		try {
			flightArray = mapper.readValue(jsonArray, Flight[].class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return flightArray;
	}

	public static String readFile(String filename) {
	    String result = "";
	    try {
	        FileReader fileReader = new FileReader(filename);
			BufferedReader br = new BufferedReader(fileReader);
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        while (line != null) {
	            sb.append(line);
	            line = br.readLine();
	        }
	        br.close();
	        result = sb.toString();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	    return result;
	}

}

