package main_area;

/**
 * Point class that stores doubles.
 * Useful because the standard Point class stores int.
 */
public class Point {
	private double x;
	private double y;
	
	public Point(double X, double Y) {
		x=X;
		y=Y;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
}
