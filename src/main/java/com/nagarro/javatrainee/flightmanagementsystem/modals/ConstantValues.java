
package com.nagarro.javatrainee.flightmanagementsystem.modals;
/*
 * @Aayush Khanna
 * Trainee Technology
 * Constant values
 * 
 * 
 * This class contains all the constant values of strings and formats which have been used in  the project
 *  
 * */
import java.io.File;
import java.text.SimpleDateFormat;

public class ConstantValues {
	public static final File file = new File("CSV/");
	public static final SimpleDateFormat dateformat = new SimpleDateFormat("dd-mm-yyyy");
	public static final String DATE_ERROR = "Date not in appropriate(dd-MM-yyyy) format, Enter Again:";
	public static final String DEPARTURE_LOCATION_ERROR = "Flights from no such stations found, Kindly Enter Again:";
	public static final String ARRIVAL_LOCATION_ERROR = "Flights to no such stations found, Kindly Enter Again: ";
	public static final String FLIGHT_CLASS_ERROR = "Flight Class is invalid. Kindly enter flight class from (E\\\\B\\\\EB)";
	public static final String OUTPUT_PREFERENCE_ERROR = "Output preference entered Inappropriately (Enter either 1 or 2), Enter Again : ";
	public static final String FILE_CANNOT_READ = "Unable to support file reading";
	public static final String FILE_CANNOT_CLOSE = "Could Not Close the File";
	public static final String INAPPROPRIATE_DATE_FORMAT_ERROR = "Date is not in appropriate format (DD-MM-YYYY)";
	public static final String EXIT_STATEMENT = "Do want to exit (Enter Y/N)?";
	public static final String EXIT_STATEMENT_ERROR = "I could not Understand Enter Again:(y/n) or (Y/N)";
	public static final String CLOSING_STATEMENT_ONE = "Thank you for visiting!!!";
	public static final String CLOSING_STATEMENT_TWO = "Happy Journey!!!";
	public static final String RESULT = "Result:";
	public static final String INPUT_DEPARTURE_LOCATION = "Enter departure location: ";
	public static final String INPUT_ARRIVAL_LOCATION = "Enter arrival location: ";
	public static final String INPUT_FLIGHT_CLASS = "Enter flight class: ";
	public static final String INPUT_DATE_OF_TRAVEL = "Enter Date Of Travel(DD-MM-YYYY): ";
	public static final String INPUT_OUTPUT_PREFERENCE = "Enter Output preference(Sort by Fare/Duration)):\n(Enter 1/2): ";
}
