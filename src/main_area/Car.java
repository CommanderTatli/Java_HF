package main_area;

public class Car {
	static public int startX;
	static public int startY;
	static public int startAngle;
	static public Point[] vectors;
	static public Field field;

	protected float v;
	public int x;
	public int y;
	protected boolean alive;
	/**
	 * Index to its vectortable. Varies between 0 and 35
	 */
	protected int angle;
	
	public Car(int X, int Y, int Angle) {
		x=X;
		y=Y;
		v=0;
		angle=Angle;
		alive=true;
	}
	public Car() {
		this(startX, startY, startAngle);
	}
	
	/**
	 * @return Point element containing the (x, y) 1 long vector of the car as (Point.x, Point.y).
	 */
	public Point getVector() {
		return vectors[angle];
	}
	/**
	 * @return the speed of the car
	 */
	public float getV() {
		return v;
	}
	
	/**
	 * Rotate with 10 degrees times amount
	 * @param amount must be between -2 and 2
	 */
	public void rotate(int amount) {
		if (amount<-2 || 2<amount) {
			return;
		}
		
		angle+=amount;
		if (angle<0) {
			angle+=36;
		}
		if (36<=angle) {
			angle-=36;
		}
	}
	
	/**
	 * Accelerate speed with a given number. Speed must stay between 0 and 10.
	 * @param amount must be between -2 and 2
	 */
	public void accelerate(int amount) {
		if (amount<-2||2<amount||amount==0) {
			return;
		}
		v+=amount;
		if (v<0) {
			v=0;
		}
		if (10<v) {
			v=10;
		}
	}
	
	/**
	 * Moves the Car. If it hits wall, kills it.
	 */
	public void move() {
		if (alive==false) {
			return;
		}
		double X=getVector().getX();
		double Y=getVector().getY();
		int i=0;
		for (;i<v; i++) {
			if ( field.get( x+(int)(X*i), y+(int)(Y*i) ) == 0 ) {
				alive=false;
				break;
			}
		}
		x+=(int)(X*i);
		y+=(int)(Y*i);
	}
}
