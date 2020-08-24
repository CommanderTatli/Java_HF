import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.*;
import main_area.*;

public class FieldTest {
	private static Field field;
	
	@Test
	public void serialisationTest() throws FileNotFoundException, IOException, ClassNotFoundException {
		field = new Field(200, 100, "data.dat");
		ArrayList<Integer> elements = new ArrayList<Integer>();
		for (int x=0;x<field.maxX; x++) {
			for (int y=0; y<field.maxY; y++) {
				elements.add(field.get(x, y));
			}
		}
		field.save();
		field.load();
		for (int x=0;x<field.maxX; x++) {
			for (int y=0; y<field.maxY; y++) {
				assertTrue(field.get(x, y)==elements.get(x*field.maxY+y));
			}
		}
	}
	@Test(expected=FileNotFoundException.class)
	public void errorTest() throws FileNotFoundException, ClassNotFoundException, IOException {
		field = new Field(200, 100, "nofile.dat");
	}

}