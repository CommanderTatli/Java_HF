package main_area;

import java.util.Comparator;

/**
 * Compares the results of given cars
 */
public class RobotCarComparator implements Comparator<RobotCar>{
	public int compare(RobotCar c1, RobotCar c2) {
		if (c1.x<c2.x) return -1;
		if (c1.x>c2.x) return 1;
		
		if (c1.time<c2.time) return 1;
		if (c1.time>c2.time) return -1;
		
		return 0;
	}

}
