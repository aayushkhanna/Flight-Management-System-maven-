package com.nagarro.javatrainee.flightmanagementsystem.flightdetails;
/*
 * @Aayush Khanna
 * Trainee Technology
 * Flight Duration Comparison
 * 
 * 
 * This class is contains all the information about the flights
 * 
 * */
import java.util.Comparator;

public class FlightDurationComparison implements Comparator<AboutFlight> {
	
	// comparing the flight duration for sorting and will be displayed in ascending
	// order
	public int compare(AboutFlight one, AboutFlight two) {
		Double duration = one.getFlightDuration() - two.getFlightDuration();
		if (duration < 0) {
			return -1;
		} else if (duration > 0) {
			return 1;
		} else {
			return 0;
		}
	}
}
