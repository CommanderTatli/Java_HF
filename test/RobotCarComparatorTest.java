import static org.junit.Assert.*;

import org.junit.*;
import main_area.*;

public class RobotCarComparatorTest {
	static public RobotCarComparator comparator;
	static public RobotCar car;
	@BeforeClass
	static public void setup() {
		comparator = new RobotCarComparator();
		car = new RobotCar();
	}
	@Test
	public void equalityTest() {
		RobotCar car2 = new RobotCar();
		assertTrue(comparator.compare(car2, car)==0);
	}
	@Test
	public void compareTest() {
		RobotCar car2 = new RobotCar();
		car.x=0;
		car2.x=100;
		assertTrue(0>comparator.compare(car, car2));
	}

}
