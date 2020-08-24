package main_area;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.Math;
import java.util.ArrayList;

public class Main {
	static public void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
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
		//starting algorithms
		Storage s = new Storage(10000);
		Gui gui = new Gui(Car.field, s);
	}
}
