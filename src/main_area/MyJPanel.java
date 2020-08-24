package main_area;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * JPanel for painting.
 */
public class MyJPanel extends JPanel {
    private Field field;
    private Storage storage;
    
    /**
     * Constructor.
     * @param f field
     * @param s set of cars
     * These parameters are needed to accurately paint.
     */
    public MyJPanel(Field f, Storage s) {
    	super();
    	field=f;
    	storage=s;
    }
    
    /**
     * Painting in the window.
     */
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        for (int y = 0; y<field.maxY; y++) {
			for (int x = 0; x<field.maxX; x++) {
				if ( field.get(x, y) == 1 ) {
					g.drawRect(8*x, 8*y, 16, 16);
				}
			}
		}
        g.setColor(Color.RED);
        double a1 = storage.best.getVector().getX()*12;
        double b1 = storage.best.getVector().getY()*8;
        int x = storage.best.x*8;
        int y = storage.best.y*8;
        
        double a2= -b1/8*12;
        double b2= a1/12*8;
        int[] X = {(int)(x-a1-a2), (int)(x+a1-a2), (int)(x+a1+a2), (int)(x-a1+a2)};
        int[] Y = {(int)(y-b1-b2), (int)(y+b1-b2), (int)(y+b1+b2), (int)(y-b1+b2)};
        g.fillPolygon(X, Y, 4);
        
        Car c = new Car();
        Point last = new Point(Car.startX, Car.startY);
        for (Point i : RobotCar.route) {
        	c.accelerate((int)i.getX());
        	c.rotate((int)i.getY());
        	c.move();
        	g.drawLine(8*(int)last.getX()+4, 8*(int)last.getY()+4, 8*(int)c.x+4, 8*(int)c.y+4);
        	last = new Point(c.x, c.y);
        }
    }
}
