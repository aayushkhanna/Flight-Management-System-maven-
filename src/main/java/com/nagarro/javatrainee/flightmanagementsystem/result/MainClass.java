package com.nagarro.javatrainee.flightmanagementsystem.result;
/*
 * @Aayush Khanna
 * Trainee Technology
 * Main CLass
 * 
 * 
 * This class is Main class which is made to produce the accurate results
 * 
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.nagarro.javatrainee.flightmanagementsystem.flightdetails.AboutFlight;
import com.nagarro.javatrainee.flightmanagementsystem.flightdetails.FlightDurationComparison;
import com.nagarro.javatrainee.flightmanagementsystem.flightdetails.FlightPriceComparison;
import com.nagarro.javatrainee.flightmanagementsystem.inputpackage.InputAcceptor;
import com.nagarro.javatrainee.flightmanagementsystem.inputpackage.ModificationClass;
import com.nagarro.javatrainee.flightmanagementsystem.inputpackage.UserInput;
import com.nagarro.javatrainee.flightmanagementsystem.modals.ConstantValues;

public class MainClass extends ConstantValues{

	public static HashMap<String, HashSet<AboutFlight>> flightsInformation = new HashMap<String, HashSet<AboutFlight>>();

	public static void main(String[] args) throws IOException {

		// Buffered Reader for user input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Result to be stored in arraylist
		ArrayList<AboutFlight> result = new ArrayList<AboutFlight>();
		String choice = null;
		UserInput userinput;

		// Schedule the task with different options..... Comes under threads in java
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

		// Execution after getting initial delays
		service.scheduleAtFixedRate(new ModificationClass(), 0, 3, TimeUnit.SECONDS);

		do {

			// Calling InputAcceptor class to fetch user input
			userinput = InputAcceptor.enterInput();
			result.clear();

			{

				// Checking values from aboutflight class using hashset
				for (HashSet<AboutFlight> set : flightsInformation.values()) {

					// For each loop to access aboutFlight class
					for (AboutFlight aboutflight : set) {
						if (aboutflight.getDepartureLocation().equalsIgnoreCase(userinput.getDepartureLocation())
								&& aboutflight.getArrivalLocation().equalsIgnoreCase(userinput.getArrivalLocation())
								&& aboutflight.getFlightClass().equalsIgnoreCase(userinput.getFlightClass())
								&& (userinput.getFlightDate().compareTo(aboutflight.getValidTill()) <= 0)
								&& aboutflight.isSeatAvailability())
							result.add(aboutflight);
					}
				}
			}

			// Preferable for sorting
			if (userinput.getOutputPreference() == 1)
				Collections.sort(result, new FlightPriceComparison());
			else
				Collections.sort(result, new FlightDurationComparison());
			System.out.println(RESULT);

			// Result via foreach loop
			for (AboutFlight aboutflight : result) {
				System.out.println(aboutflight);
			}

			// Asking user input for exiting or not.
			System.out.println(EXIT_STATEMENT);
			while (!((choice = br.readLine()).equalsIgnoreCase("y") || choice.equalsIgnoreCase("n")))
				System.err.print(EXIT_STATEMENT_ERROR); // userfriendly
		} while (choice.equalsIgnoreCase("n"));
		System.out.println(CLOSING_STATEMENT_ONE);
		System.out.println(CLOSING_STATEMENT_TWO);
		
		//service is stopped
		service.shutdown();
	}
}
