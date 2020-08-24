import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;
import main_area.*;

public class StorageTest {
	private static Storage s;
	@BeforeClass
	static public void setup() throws FileNotFoundException, ClassNotFoundException, IOException {
		//setting up the static variables
		Car.startX=0;
		Car.startY=10;
		Car.startAngle=0;
		Car.vectors = new Point[36];
		for (int i=0; i<36; i++) {
			Car.vectors[i]=new Point( Math.cos(Math.toRadians(10*i)), Math.sin(Math.toRadians(10*i)) );
		}
		RobotCar.route = new ArrayList<Point>();
		Car.field=new Field(200, 100, "data.dat");
		s = new Storage(10000);
	}
	
	@Test
	public void runTest() {
		RobotCarComparator comparator = new RobotCarComparator();
		s.run();
		RobotCar car1 = s.best;
		s.run();
		assertTrue(0>=comparator.compare(car1, s.best));
	}
}
