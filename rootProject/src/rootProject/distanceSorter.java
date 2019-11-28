package rootProject;

import java.util.Comparator;

public class distanceSorter implements Comparator<Driver> {

	@Override
	public int compare(Driver arg0, Driver arg1) {
		// TODO Auto-generated method stub
		if(arg0.totalDistance > arg1.totalDistance) return -1;
		else if(arg0.totalDistance == arg1.totalDistance) return 0;
		else return 1;
		
	}

}
