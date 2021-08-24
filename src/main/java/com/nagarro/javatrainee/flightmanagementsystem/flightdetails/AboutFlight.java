
package com.nagarro.javatrainee.flightmanagementsystem.flightdetails;
/*
 * @Aayush Khanna
 * Trainee Technology
 * Main CLass
 * 
 * 
 * This class is contains all the information about the flights
 * 
 * */
import java.util.Date;

import com.nagarro.javatrainee.flightmanagementsystem.modals.*;

public class AboutFlight extends ConstantValues {

	//Initializing variables
	String flightNumber;
	String departureLocation;
	String arrivalLocation;
	Date validTill;
	String flightTime;
	Double flightDuration;
	int flightFare;
	boolean seatAvailability;
	String flightClass;

	// AboutFlight constructor to assign values to given variables
	public AboutFlight(String flightNumber, String departureLocation, String arrivalLocation, int flightFare,
			Date validTill, String flightTime, Double flightDuration, boolean seatAvailability,
			String flightClass) {
		super();
		this.flightNumber = flightNumber;
		this.departureLocation = departureLocation;
		this.arrivalLocation = arrivalLocation;
		this.validTill = validTill;
		this.flightTime = flightTime;
		this.flightDuration = flightDuration;
		this.flightFare = flightFare;
		this.seatAvailability = seatAvailability;
		this.flightClass = flightClass;
		
		if (flightClass.equalsIgnoreCase("EB")) {
			flightFare = (int) (flightFare + (0.4*flightFare));
			this.flightFare = flightFare;
		}
	}

	// getter for flightNumber
	public String getFlightNumber() {
		return flightNumber;
	}

	//getter for departure Location
	public String getDepartureLocation() {
		return departureLocation;
	}

	//getter for arrival location
	public String getArrivalLocation() {
		return arrivalLocation;
	}

	//getter for flight fare
	public int getFlightFare() {
		return flightFare;
	}

	//getter for valid date
	public Date getValidTill() {
		return validTill;
	}

	//getter for flight time
	public String getFlightTime() {
		return flightTime;
	}

	//getter for flight duration
	public Double getFlightDuration() {
		return flightDuration;
	}

	//checking for seat availability
	public boolean isSeatAvailability() {
		return seatAvailability;
	}

	//getter for flight class
	public String getFlightClass() {
		return flightClass;
	}

	//to string method
	public String toString() {
		return "FLIGHT NUMBER" + " " + flightNumber + " " + "DEPARTURE LOCATION" + " " + departureLocation + " "
				+ "ARRIVAL LOCATION" + " " + arrivalLocation + " " + "VALID TILL" + " " + dateformat.format(validTill)
				+ " " + "FLIGHT TIME" + " " + flightTime + " " + "FLIGHT DURATION" + " "
				+ String.format("%.2f", flightDuration) + " " + "FLIGHT FARE" + " " + flightFare + " "
				+ "SEAT AVAILABILITY" + " " + seatAvailability + " " + "FLIGHT CLASS" + " " + flightClass;
	}

	
	// fetching flight_number using ternary operator
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flightNumber == null) ? 0 : flightNumber.hashCode());
		return result;
	}

	
	// Checking the values assigned to variables
	public boolean equals(Object obj) {
		AboutFlight aboutFlight = (AboutFlight) obj;
		if (arrivalLocation == null) {
			if (aboutFlight.arrivalLocation != null) {
				return false;
			}
		} else if (!arrivalLocation.equals(aboutFlight.arrivalLocation)) {
			return false;
		}

		if (departureLocation == null) {
			if (aboutFlight.departureLocation != null) {
				return false;
			}
		} else if (!departureLocation.equals(aboutFlight.departureLocation)) {
			return false;
		}
		if (flightNumber == null) {
			if (aboutFlight.flightNumber != null) {
				return false;
			}
		} else if (!flightNumber.equals(aboutFlight.flightNumber)) {
			return false;
		}
		if (flightTime == null) {
			if (aboutFlight.flightTime != null) {
				return false;
			}
		} else if (!flightTime.equals(aboutFlight.flightTime)) {
			return false;
		}

		if (seatAvailability != aboutFlight.seatAvailability) {
			return false;
		}
		if (validTill == null) {
			if (aboutFlight.validTill != null) {
				return false;
			} else if (!validTill.equals(aboutFlight.validTill)) {
				return false;
			}
		}
		return true;
	}
}