package rootProject;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class rootProjectJUnit {

	/* 
	 * Tests for infoDictionary() 
	 */
	@Test
	public void testInfoDic_invalidInput() {
		// test when the input is invalid
		rootProject tester = new rootProject();
		String[] details = new String[] {"Trip"}; // input is invalid
		List<Driver> driverList = new ArrayList<>();
		tester.infoDictionary(details, driverList);
		List<Driver> expectedList = new ArrayList<>();
		assertArrayEquals(expectedList.toArray(), driverList.toArray());
	}
	@Test
	public void testInfoDic_handleDriver() {
		// test if the arraylist adds the driver  
		rootProject tester = new rootProject();
		String[] details = new String[] {"Driver", "Dan"};
		List<Driver> driverList = new ArrayList<>();
		tester.infoDictionary(details, driverList);
		List<Driver> expectedList = Arrays.asList(new Driver("Dan"));
		assertArrayEquals(expectedList.toArray(), driverList.toArray());
		
	}

	@Test
	public void testInfoDic_handleSameDriver() {
		// test if the arraylist handles the same driver  
		rootProject tester = new rootProject();
		String[] details = new String[] {"Driver", "Dan"}; 
		// input the same person while the list has already contained this person
		List<Driver> driverList = Arrays.asList(new Driver("Dan"));
		tester.infoDictionary(details, driverList);
		List<Driver> expectedList = Arrays.asList(new Driver("Dan"));
		assertArrayEquals(expectedList.toArray(), driverList.toArray());		
	}
	
	@Test
	public void testInfoDic_handleTrips() {
		// test if miles and time are added
		rootProject tester = new rootProject();
		String[] details = new String[] {"Trip", "Dan", "07:15", "07:45", "17.3"};
		List<Driver> driverList = Arrays.asList(new Driver("Dan", 21.8, 0.5));
		tester.infoDictionary(details, driverList);
		List<Driver> expectedList = Arrays.asList(new Driver("Dan", 39.1, 1));
		assertArrayEquals(expectedList.toArray(), driverList.toArray());
		
	}
	
	@Test
	public void testInfoDic_handleNoDriver() {
		// test when there's no driver info stored
		rootProject tester = new rootProject();
		String[] details = new String[] {"Trip", "Dan", "07:15", "07:45", "17.3"};
		List<Driver> driverList = new ArrayList<>();
		tester.infoDictionary(details, driverList);
		List<Driver> expectedList = new ArrayList<>();
		assertArrayEquals(expectedList.toArray(), driverList.toArray());
	}
	
	/* 
	 * Tests for sortingInfo()
	 */
	@Test
	public void testSortingInfo_desending() {
		// test if the sorter can sort in a descending order based on mileage
		// test if the sorter can sort the mileages within hundreds precision
		rootProject tester = new rootProject();
		List<Driver> driverList = Arrays.asList(new Driver("Lauren", 1.23, 1),
												new Driver("Tom",1.24, 1),
												new Driver("Michael", 1.25, 1));
		tester.sortingInfo(driverList);
		List<Driver> expectedList = Arrays.asList(new Driver("Michael", 1.25, 1),
				new Driver("Tom",1.24, 1), new Driver("Lauren", 1.23, 1));
		assertArrayEquals(expectedList.toArray(), driverList.toArray());
	}
	@Test
	public void testSortingInfo_sameMilage() {
		// test if the sorter can sort well when there is the value based on mileage
		rootProject tester = new rootProject();
		List<Driver> driverList = Arrays.asList(new Driver("Lauren", 1.24, 1),
												new Driver("Tom",1.24, 1),
												new Driver("Michael", 1.25, 1));
		tester.sortingInfo(driverList);
		List<Driver> expectedList = Arrays.asList(new Driver("Michael", 1.25, 1),
				 new Driver("Lauren", 1.24, 1), new Driver("Tom",1.24, 1));
		assertArrayEquals(expectedList.toArray(), driverList.toArray());
	}
}
