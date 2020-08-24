package main_area;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Storage of RobotCars.
 * This class manages the cars as a group: it can repeatedly move them and select the best cars of the run.
 */
public class Storage {
	private ArrayList<RobotCar> cars;
	public RobotCar best;
	
	public Storage(int precision) {
		cars = new ArrayList<RobotCar>();
		for (int i=0; i<precision; i++) cars.add( new RobotCar() );
		best = cars.get(0);
	}
	
	/**
	 * Runs all cars until they hit a wall.
	 * Selects the best car, sets the preferred route to its route, and resets them before the next run.
	 */
	public void run() {
		//reseting cars
		for (int i=0; i<cars.size(); i++) {
			cars.get(i).reset();
		}
		//moving cars
		for (int i=0; i<cars.size(); i++) {
			cars.get(i).moveUntilWall();
		}
		//selecting the most successful and setting it up
		best = Collections.max( cars, new RobotCarComparator() );
		RobotCar.setRoute(best.thisRoute);
	}
	/**
	 * Restarts the simulation.
	 * Resets all the cars along with the preferred route.
	 * Note: resetting is not necessary since run() starts with resetting
	 * but it repaints the window so the user sees its effect. That's why it is enough to reset the best car.
	 */
	public void restart() {
		best.reset();
		RobotCar.setRoute( best.thisRoute );
	}
}
