package com.nagarro.javatrainee.flightmanagementsystem.inputpackage;
/*
 * @Aayush Khanna
 * Trainee Technology
 * Modification Class
 * 
 * 
 * This class helps in checking the new file in CSV folder
 * 
 * */
import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.nagarro.javatrainee.flightmanagementsystem.modals.*;
import com.nagarro.javatrainee.flightmanagementsystem.result.DirectoryReader;
import com.nagarro.javatrainee.flightmanagementsystem.result.MainClass;

public class ModificationClass extends ConstantValues implements Runnable {
	HashMap<String, Long> lastModifiedAt = new HashMap<String, Long>();

	/*
	 * runnable interface calls run method to create thread for executing multiple
	 * processes as we need to check multiple files
	 */
	
	public void run() {
		File files[] = file.listFiles();

		// Initializing Array List
		ArrayList<String> list = new ArrayList<String>();
		for (File f : files) {
			//Checking whether any new file is added or not
			if ((!(lastModifiedAt.containsKey(f.getName()))) || (f.lastModified() > lastModifiedAt.get(f.getName()))) {
				lastModifiedAt.put(f.getName(), f.lastModified());
				
				//when multiple resources are using same resource
				synchronized (MainClass.flightsInformation) {
					MainClass.flightsInformation.put(f.getName(), DirectoryReader.readFile(f));
				}
			}
			list.add(f.getName());
		}
		
		//Fetching the data from the new file if added
		Set<String> fc = lastModifiedAt.keySet();
		Set<String> fname = new HashSet<String>();
		fname.addAll(fc);

		//Checking whether the new file is added or not
		if (fc.size() == list.size()) {
			return;
		}

		for (String string : fname) {
			if (!(list.contains(string))) {
				lastModifiedAt.remove(string);
				synchronized (MainClass.flightsInformation) {
					MainClass.flightsInformation.remove(string);
				}
			}
		}
	}
}
