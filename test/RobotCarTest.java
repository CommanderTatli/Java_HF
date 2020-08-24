import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.*;
import main_area.*;

public class RobotCarTest {
	private RobotCar car;
	
	@Before
	public void setup() throws FileNotFoundException, ClassNotFoundException, IOException {
		RobotCar.route = new ArrayList<Point>();
		Car.vectors = new Point[36];
		for (int i=0; i<36; i++) {
			Car.vectors[i]=new Point( Math.cos(Math.toRadians(10*i)), Math.sin(Math.toRadians(10*i)) );
		}
		Car.startX=0;
		Car.startY=10;
		Car.startAngle=0;
		Car.field=new Field(200, 100, "data.dat");
		car = new RobotCar();
	}
	
	@Test
	public void moveUntilWallTest() {
		boolean same=true;
		car.moveUntilWall();
		int x=car.x;
		int y=car.y;
		for (int i=0; i<1000; i++) {
			car=new RobotCar();
			car.moveUntilWall();
			if (car.x!=x || car.y!=y) same=false;
		};
		assertFalse(same);
	}
	
	@Test
	public void resetTest() {
		car.moveUntilWall();
		int x = car.x;
		car.reset();
		assertFalse(x==car.x);
	}
}
