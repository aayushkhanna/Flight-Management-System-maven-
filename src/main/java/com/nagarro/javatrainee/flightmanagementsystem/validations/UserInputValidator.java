
package com.nagarro.javatrainee.flightmanagementsystem.validations;
/*
 * @Aayush Khanna
 * Trainee Technology
 * User Input Validation
 * 
 * 
 * This class checks whether user input is valid or not
 * 
 * 
 * */
import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import com.nagarro.javatrainee.flightmanagementsystem.flightdetails.AboutFlight;
import com.nagarro.javatrainee.flightmanagementsystem.modals.ConstantValues;
import com.nagarro.javatrainee.flightmanagementsystem.result.MainClass;

public class UserInputValidator extends ConstantValues {
	
	//Checking the validity for date format entered by the user
	public static Date validateFlightDate(String string) {

		Date validTill = null;
		try {
			validTill = dateformat.parse(string);
			
			//Unexpected Error reached
		} catch (ParseException e) {
			System.err.print(DATE_ERROR);
		}
		return validTill;
	}

	// Checking validity of departure location
	public static String validateDepartureLocation(String departure_location) {
		synchronized (MainClass.flightsInformation) {
			for (HashSet<AboutFlight> flightset : MainClass.flightsInformation.values()) {
				
				// for each loop to fetch the departure location
				for (AboutFlight aboutflight : flightset) {
					if (aboutflight.getDepartureLocation().equalsIgnoreCase(departure_location))
						return aboutflight.getDepartureLocation();
				}
			}
		}
		System.err.print(DEPARTURE_LOCATION_ERROR);
		return null;
	}
	

	// Validity of Arrival location
	public static String validateArrivalLocation(String arrival_location) {
		synchronized (MainClass.flightsInformation) {
			for (HashSet<AboutFlight> flightset : MainClass.flightsInformation.values()) {
				
				// Checking the availability of arrival location
				for (AboutFlight aboutflight : flightset) {
					if (aboutflight.getArrivalLocation().equalsIgnoreCase(arrival_location))
						return aboutflight.getArrivalLocation();
				}
			}
		}
		System.err.print(ARRIVAL_LOCATION_ERROR);
		return null;
	}

	
	// Validity of Flight Class
	public static String validateFlightClass(String string) {
		if (string.equalsIgnoreCase("E") || string.equalsIgnoreCase("B") || string.equalsIgnoreCase("EB")) {
			if (string.equalsIgnoreCase("B")) {
				String check = "EB";
				return check.toUpperCase();
			}
			return string.toUpperCase();
		} else {
			System.err.print(FLIGHT_CLASS_ERROR);
			return null;
		}
	}

	
	// Preferable sorting order of output in ascending order
	public static int validateOutputPreference(int i) {
		if ((i == 1) || (i == 2)) {
			return i;
		} else {
			System.err.print(OUTPUT_PREFERENCE_ERROR);
			return 0;
		}
	}
}
