package main_area;
import java.util.Random;
import java.util.ArrayList;

/**
 * Clever car class, representing not only the physical car, but the driver too.
 * Has memory of its route, can drive in a route or randomly until it hits a wall.
 */
public class RobotCar extends Car{
    static private Random rand = new Random();
    static public ArrayList<Point> route;
    public ArrayList<Point> thisRoute;
    public int time;
    public int value;
    
    public RobotCar() {
    	super();
    	thisRoute = new ArrayList<Point>();
    }
    
	/**
	 * Resets data, so it's not necessary to create new RobotCars, we can just overwrite the existing ones which is faster
	 */
    public void reset() {
        time = 0;
        v = 0;
        angle = startAngle;
        x = startX;
        y = startY;
        alive = true;
        value = 0;
        thisRoute.clear();
    }
    
    /**
     * Sets route to the deep copy of
     * @param r
     */
    public static void setRoute(ArrayList<Point> r) {
    	route.clear();
    	for (Point p : r) {
    		route.add(p);
    	}
    }
    
    /**
     * Moves car.
     * @return true if car is still alive, false if not.
     */
    private boolean refresh() {
    	if (alive==false) {
    		return false;
    	}
        int acc;
        int trn;
        if (rand.nextInt(100)<=2 || route.size()<time+1) {
            acc = rand.nextInt( 5 ) -2;
            trn = rand.nextInt( 5 ) -2;
        }
        else {
            acc = (int)route.get(time).getX();
            trn = (int)route.get(time).getY();
        }
        
        accelerate(acc);
        rotate(trn);
        Point p = new Point(acc, trn);
        thisRoute.add(p);
        move();
        time++;
        return true;
    }
    
    /**
     * Moves car until it hits a wall
     */
    public void moveUntilWall() {
    	while ( refresh()==true ) {    		
    	}
    }
}