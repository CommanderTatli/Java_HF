package main_area;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Class to manage all GUI functions.
 */
public class Gui {
	private JFrame frame;
	private MyJPanel panel;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem i1, i2;
	
	private Storage storage;
	/**
	 *ActionListener for the menu.
	 */
	private class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			if (ev.getSource()==i1) {
				storage.run();
				Car c = new Car();
		        for (Point p : storage.best.thisRoute) {
		            c.accelerate((int)p.getX());
		            c.rotate((int)p.getY());
		            c.move();
		            panel.repaint();
		        }
			}
			if (ev.getSource()==i2) {
				storage.restart();
				panel.repaint();
			}
		}
	}
	
	/**
	 * Creates the window representing the simulation
	 * Using @param map as the roads 
	 * and @param storage as the set of cars.
	 */
	public Gui(Field field, Storage storage) {
		this.storage=storage;
		
		frame = new JFrame("Learning");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(field.maxX*8, field.maxY*8);
		panel = new MyJPanel(field, storage);
		
		//creating menu
		menuBar = new JMenuBar();
		menu = new JMenu("File");
		menu.setFont(new Font("Arial", 9, 20));
		i1 = new JMenuItem("Next Turn");
		i1.setFont(new Font("Arial", 6, 20));
		i1.addActionListener(new MyActionListener());
		i2 = new JMenuItem("Restart");
		i2.setFont(new Font("Arial", 6, 20));
		i2.addActionListener(new MyActionListener());
		//adding menu to containers
		menu.add(i1);
		menu.add(i2);
		menuBar.add(menu);
		panel.add(menuBar, new FlowLayout() );
		//finalizing window
		frame.add(panel);
		frame.setVisible(true);
	}
}
