import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import main_area.*;

public class CarTest {
	private Car car;
	
	@Before
	public void setup() throws FileNotFoundException, ClassNotFoundException, IOException {
		car = new Car();
		Car.startAngle=0;
		Car.startX=0;
		Car.startY=10;
		Car.vectors = new Point[36];
		for (int i=0; i<36; i++) {
			Car.vectors[i]=new Point( Math.cos(Math.toRadians(10*i)), Math.sin(Math.toRadians(10*i)) );
		}
		Car.field=new Field(200, 100, "data.dat");
	}
	
	@Test
	public void testAccelerate() {
		float v=car.getV();
		car.accelerate(100);
		assertTrue(car.getV()==v);
		car.accelerate(-2);
		assertTrue(car.getV()==0);
		for (int i=0; i<6; i++)
			car.accelerate(2);
		assertTrue(car.getV()==10);
	}
	
	@Test
	public void testRotate() {
		Point vector=car.getVector();
		car.rotate(3);
		assertTrue(car.getVector()==vector);
		for (int i=0; i<35; i++) {
			car.rotate(1);
			assertFalse(vector==car.getVector());
		}
		car.rotate(1);
		assertTrue(vector==car.getVector());
	}
	
	@Test
	public void testMove() {
		int x=car.x;
		int y=car.y;
		car.move();
		assertTrue(y==car.y);
		assertTrue(x==car.x);
		for (int i=0; i<6; i++) car.accelerate(2);
		assertTrue(car.getV()==10);
		assertTrue(car.getVector().getX()==1);
		car.move();
		assertTrue( (x+10)==car.x & y==car.y);
		car.move();
		car.move();
		x=car.x;
		y=car.y;
		car.move();
		assertTrue(x==car.x & y==car.y);
	}
}
