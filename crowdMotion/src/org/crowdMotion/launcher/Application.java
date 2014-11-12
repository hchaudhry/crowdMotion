package org.crowdMotion.launcher;

import java.awt.Dimension;

import javax.swing.JFrame;

import org.crowdMotion.models.Field;
import org.crowdMotion.utils.MapLinesContainer;
import org.crowdMotion.utils.MapReader;
import org.crowdMotion.utils.MapRender;

public class Application 
{

	public static void main(String[] args) 
	{
		/*Field f = new Field("/home/neimad/Bureau/map.txt");
		String s = MapReader.readMapFile(f.getMapFileName());
		System.out.println(s);

		createWindow(new MapRender());*/
		
		
		Field f = new Field("/home/neimad/Bureau/map.txt");
		MapLinesContainer c = MapReader.readMapFile2(f.getMapFileName());
		

		createWindow(new MapRender(c));
	}

	
	public static void createWindow(MapRender render) 
	{
		JFrame frame = new JFrame("FrameDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(1050, 480));
		frame.setContentPane(render);
		frame.pack();
		frame.setVisible(true);
	}
}
