package main_area;
import java.io.*;

/**
 * Map for storing the road.
 */
public class Field {
	private String file;
	private byte[][] blocks;
	public int maxX;
	public int maxY;
	public Field(int X, int Y, String file) throws FileNotFoundException, IOException, ClassNotFoundException{
		maxX=X;
		maxY=Y;
		this.file=file;
		this.load();
	}
	
	/**
	 * Get road at given position
	 * @param x x coordinate
	 * @param y y coordinate
	 * @return 0 if there is a wall, 1 if it's empty
	 */
	public int get(int x, int y){
		if (maxX<=x || maxY<=y || x<0 || y<0) {
			return 0;
		}
		if (blocks[y][x]==48) {
			return 0;
		}
		return 1;
	}
	
	/**
	 * Saves the map into file given in constructor
	 */
	public void save() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream(file) );
		oos.writeObject(blocks);
		oos.close();
	}
	
	/**
	 * Loads the map from file given in constructor
	 * @throws FileNotFoundException if data.dat is missing.
	 */
	public void load() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream( new FileInputStream(file) );
		blocks = (byte[][])ois.readObject();
		ois.close();
	}
	
	/**
	 * Loads map from map.txt. Useful for introducing new maps, since txt is easier to format.
	 * @throws IOException
	 */
	public void loadFromTxt() throws IOException {
		FileInputStream in = new FileInputStream("map.txt");
		for (int y=0; y<maxY; y++) {
			in.read(blocks[y], 0, maxX);	//reads everything except endline
			in.skip(2);						//skips endline
		}
		in.close();
	}
}
