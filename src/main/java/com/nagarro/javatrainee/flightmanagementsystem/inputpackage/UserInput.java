package com.nagarro.javatrainee.flightmanagementsystem.inputpackage;
/*
 * @Aayush Khanna
 * Trainee Technology
 * User Input
 * 
 * 
 * This class helps in geting the user input basically this file contains all the getters and setters.
 * 
 * */
import java.util.Date;

import com.nagarro.javatrainee.flightmanagementsystem.modals.ConstantValues;

public class UserInput extends ConstantValues {

	// Initializing variables
	String departureLocation;
	String arrivalLocation;
	Date flightDate;
	String flightClass;
	int outputPreference;

	// UserInput method for calling the user input values
	public UserInput(String departureLocation, String arrivalLocation, Date flightDate, String flightClass,
			int outputPreference) {
		super();
		this.departureLocation = departureLocation;
		this.arrivalLocation = arrivalLocation;
		this.flightDate = flightDate;
		this.flightClass = flightClass;
		this.outputPreference = outputPreference;
	}

	// calling getters method to take user input and returning the values matching
	// to the input of user
	
	//getter for departure loacation
	public String getDepartureLocation() {
		return departureLocation;
	}

	//getter for arrival location
	public String getArrivalLocation() {
		return arrivalLocation;
	}

	//getter for date of flight
	public Date getFlightDate() {
		return flightDate;
	}

	//getter for flight class
	public String getFlightClass() {
		return flightClass;
	}

	//getter for output sorting preference
	public int getOutputPreference() {
		return outputPreference;
	}

	@Override
	// Date will be displayed into date format using toString method
	public String toString() {
		return "DEPARTURE LOCATION=" + departureLocation + ", ARRIVAL LOCATION=" + arrivalLocation + ", FLIGHT DATE="
				+ dateformat.format(flightDate) + ", FLIGHT CLASS=" + flightClass + ", OUTPUT PREFERENCE="
				+ outputPreference;
	}
}
