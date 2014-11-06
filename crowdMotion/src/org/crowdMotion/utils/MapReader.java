package org.crowdMotion.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MapReader {

	
	public static String readMapFile(String mapFile){
	    try {
	    	BufferedReader br = new BufferedReader(new FileReader(mapFile));
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	
	        while (line != null) {
	            sb.append(line);
	            sb.append(System.lineSeparator());
	            line = br.readLine();
	        }
	        br.close();
	        String everything = sb.toString();	        
	        
	        return everything;
	        
	    } catch(FileNotFoundException e) {
	    	e.printStackTrace();
	    	return null;
	    } catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
}
