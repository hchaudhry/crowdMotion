package org.crowdMotion.models;

import java.util.ArrayList;
import java.util.List;

public class Crowd {

	private List<Mouse> mousesList;
	
	public Crowd(){
		mousesList = new ArrayList<Mouse>();
	}

	public List<Mouse> getMousesList() {
		return mousesList;
	}

	public void setMousesList(List<Mouse> mousesList) {
		this.mousesList = mousesList;
	}
	
	
}
