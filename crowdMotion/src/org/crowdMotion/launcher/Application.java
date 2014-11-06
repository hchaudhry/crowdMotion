package org.crowdMotion.launcher;

import org.crowdMotion.models.Field;
import org.crowdMotion.utils.MapReader;

public class Application {

	
	public static void main(String[] args) {
		Field f = new Field("/home/hussam/Bureau/Foule/map.txt");
		String s = MapReader.readMapFile(f.getMapFileName());
		System.out.println(s);
	}
}
