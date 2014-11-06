package org.crowdMotion.models;

import java.util.UUID;

public class Mouse {

	
	private UUID mouseId;

	public Mouse(){
		mouseId = UUID.randomUUID();
	}
	
	public UUID getId() {
		return mouseId;
	}
}
