package com.webService.weather_client.test;

import java.util.List;

import com.webService.weather_client.webxml.ArrayOfString;
import com.webService.weather_client.webxml.WeatherWS;
import com.webService.weather_client.webxml.WeatherWSSoap;


public class weatherTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WeatherWS weatherWS = new WeatherWS();
		WeatherWSSoap weatherWSSoap = weatherWS.getWeatherWSSoap();
		ArrayOfString weather = weatherWSSoap.getWeather("伦敦",null);
		List<String> weatherList = weather.getString();
		for(String listcontent:weatherList){
				System.out.println("weatherList==" + listcontent);
        }
	}

}
