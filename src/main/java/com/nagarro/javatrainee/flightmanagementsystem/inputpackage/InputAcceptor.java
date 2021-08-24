
/*
 * @Aayush Khanna
 * Trainee Technology
 * Input Acceptor
 * 
 * 
 * This class helps in asking user input
 * 
 * */
package com.nagarro.javatrainee.flightmanagementsystem.inputpackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import com.nagarro.javatrainee.flightmanagementsystem.modals.ConstantValues;
import com.nagarro.javatrainee.flightmanagementsystem.validations.UserInputValidator;

public class InputAcceptor extends ConstantValues {

	public static UserInput enterInput() throws IOException {
		BufferedReader bfrd = new BufferedReader(new InputStreamReader(System.in));
		String departureLocation, arrivalLocation, flightClass;
		int outputPreference;
		Date flightDate = null;

		System.out.print(INPUT_DEPARTURE_LOCATION);

		// calling validation methods from UserInputValidator class to check input
		// provided
		while ((departureLocation = UserInputValidator.validateDepartureLocation(bfrd.readLine())) == null) {
			continue;
		}
		
		//Arrival location as user input
		System.out.print(INPUT_ARRIVAL_LOCATION);
		while ((arrivalLocation = UserInputValidator.validateArrivalLocation(bfrd.readLine())) == null) {
			continue;
		}

		//flight class as user input
		System.out.print(INPUT_FLIGHT_CLASS);
		while ((flightClass = UserInputValidator.validateFlightClass(bfrd.readLine())) == null) {
			continue;
		}

		//date of arrival as user input
		System.out.print(INPUT_DATE_OF_TRAVEL);
		while ((flightDate = UserInputValidator.validateFlightDate(bfrd.readLine())) == null) {
			continue;
		}

		//input preference as user input
		System.out.print(INPUT_OUTPUT_PREFERENCE);
		while ((outputPreference = UserInputValidator
				.validateOutputPreference(Integer.parseInt(bfrd.readLine()))) == 0) {
			continue;
		}

		// returning userinput
		return new UserInput(departureLocation, arrivalLocation, flightDate, flightClass, outputPreference);
	}
}
