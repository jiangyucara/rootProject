package rootProject;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class rootProject {
	
 	public void sortingInfo(List<Driver> driverList) {
		// TODO Auto-generated method stub
 		Collections.sort(driverList, new distanceSorter());

	}
	
	public void infoDictionary(String[] details, List<Driver> driverList) {				
		if(details.length <= 1) {
			System.out.println("Invalid input");
			return;
		}
		Driver driver = new Driver(details[1]);
		// Driver: details[0]: "Driver", details[1]: name
		if(details[0].equals("Driver") && !driverList.contains(driver)) {
			driverList.add(driver);
		}else if(details[0].equals("Trip")) {
			// Trip: details[0]: "Trip", details[1]: name, details[2]: start time, details[3]: end time, details[4]: miles
			double hrs = calculateHrs(details[2], details[3]);
			double miles = Double.parseDouble(details[4]);		
			if(driverList.contains(driver)) {
				int index = driverList.indexOf(driver);
				double mph = miles / hrs;
				if(mph <= 100 && mph >= 5) {
					driverList.get(index).totalDuration += hrs;
					driverList.get(index).totalDistance += miles;		
				}				
			}else {
				System.out.println("No Driver " + details[1] + " info.");
			}			
		}		
	}

	private double calculateHrs(String start, String end) {
		// TODO Auto-generated method stub
		String[] startTime = start.split(":");
		String[] endTime = end.split(":");
		double hrs = ((Integer.parseInt(endTime[0]) - Integer.parseInt(startTime[0])) * 60 + 
				(Integer.parseInt(endTime[1]) - Integer.parseInt(startTime[1]))) / 60.0;
		return hrs;
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		rootProject root = new rootProject();
		
		Scanner user = new Scanner(System.in);
		String inputFileName;
		
		System.out.println("Input File Name: ");
		inputFileName = user.nextLine().trim();
		
		File input = new File(inputFileName);
		Scanner scan = new Scanner(input);
		
		List<Driver> driverList = new ArrayList<>();
		while(scan.hasNextLine()) {
			String info = scan.nextLine();
			String[] details = info.split(" ");
			root.infoDictionary(details, driverList);
		}
		
		user.close();
		scan.close();
		root.sortingInfo(driverList);
		
		String outputFileName = "out.txt";
		
		try {
			PrintWriter outputFile = new PrintWriter(outputFileName);
			
			for(Driver driver: driverList) {
				driver.averageSpeed = driver.totalDistance / driver.totalDuration;
				if((int) Math.round(driver.totalDistance) == 0) {
					System.out.println(driver.name + ": " + "0 miles");
					outputFile.println(driver.name + ": " + "0 miles");
				}else {
					System.out.println(driver.name + ": " + (int) Math.round(driver.totalDistance) + " miles @ " 
										+ (int) Math.round(driver.averageSpeed) + " mph");
					outputFile.println(driver.name + ": " + (int) Math.round(driver.totalDistance) + " miles @ " 
										+ (int) Math.round(driver.averageSpeed) + " mph");
				}
			}						
			outputFile.close();
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		 
	}

	

}
