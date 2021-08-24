package com.nagarro.javatrainee.flightmanagementsystem.result;
/*
 * @Aayush Khanna
 * Trainee Technology
 * Directory Reader
 * 
 * 
 * This class helps in accessing the csv files
 * 
 * */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.StringTokenizer;

import com.nagarro.javatrainee.flightmanagementsystem.flightdetails.AboutFlight;
import com.nagarro.javatrainee.flightmanagementsystem.modals.ConstantValues;
import com.nagarro.javatrainee.flightmanagementsystem.result.MainClass;

public class DirectoryReader extends ConstantValues {
	public static void readDirectory() {
		
		//Initilization of hasset and variable
		int i;
		HashSet<AboutFlight> flightset;

		// fetching the information from CSV file
		File files[] = file.listFiles();
		for (i = 0; i < files.length; i++) {
			System.out.println("Reading File:" + files[i]);
			flightset = readFile(files[i]);
			synchronized (MainClass.flightsInformation) {
				MainClass.flightsInformation.put(files[i].getName(), flightset);
			}
		}
		//System.out.println("Read All CSV Files");
	}

	public static HashSet<AboutFlight> readFile(File file) {
		BufferedReader bfrd = null;
		HashSet<AboutFlight> flightset = new HashSet<AboutFlight>();

		// if file cannot be read then error will be displayed
		try {
			bfrd = new BufferedReader(new FileReader(file));
			String line = bfrd.readLine();
			line = bfrd.readLine();

			while (line != null) {
				AboutFlight aboutflight = manipulateLine(line);
				line = bfrd.readLine();
				flightset.add(aboutflight);
			}
		} catch (Exception e) {
			System.err.println(FILE_CANNOT_READ);
		}

		// will be executed no matter program executes or not
		finally {
			if (bfrd != null) {
				try {
					bfrd.close();
				} catch (Exception ex) {
					System.err.println(FILE_CANNOT_CLOSE);
				}
			}
		}
		return flightset;
	}

	//Manipulating the file
	private static AboutFlight manipulateLine(String line) {

		// breaks string into tokens
		StringTokenizer stringtokenizer = new StringTokenizer(line, "|");

		String flightNumber = stringtokenizer.nextToken();
		String departureLocation = stringtokenizer.nextToken();
		String arrivalLocation = stringtokenizer.nextToken();

		String validTillDate = stringtokenizer.nextToken();
		Date validTill = new Date();

		try {
			validTill = dateformat.parse(validTillDate);
		} catch (ParseException e) {
			System.err.print(INAPPROPRIATE_DATE_FORMAT_ERROR);
		}

		String flightTime = stringtokenizer.nextToken();
		Double flightDuration = Double.parseDouble(stringtokenizer.nextToken());
		int flightFare = Integer.parseInt(stringtokenizer.nextToken());

		String seat_Availability = stringtokenizer.nextToken();
		Boolean seatAvailability;
		if (seat_Availability.charAt(0) == 'Y') {
			seatAvailability = true;
		} else {
			seatAvailability = false;
		}

		String flightClass = stringtokenizer.nextToken();

		// Returns the data fetched from the files.
		return new AboutFlight(flightNumber, departureLocation, arrivalLocation, flightFare, validTill, flightTime,
				flightDuration, seatAvailability, flightClass);
	}
}
