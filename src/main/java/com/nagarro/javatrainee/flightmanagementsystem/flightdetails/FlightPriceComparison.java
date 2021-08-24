package com.nagarro.javatrainee.flightmanagementsystem.flightdetails;
/*
 * @Aayush Khanna
 * Trainee Technology
 * Flight Price Comparison
 * 
 * 
 * This class is used to compare the cost of two flights and according to which the reults can be displayed in ascending order
 * */
import java.util.Comparator;

public class FlightPriceComparison implements Comparator<AboutFlight> {

	// compare method is used to compare both the flights fare.
	public int compare(AboutFlight oneprice, AboutFlight twoprice) {
		return oneprice.getFlightFare() - twoprice.getFlightFare(); // return difference of two flights fare
	}
}
