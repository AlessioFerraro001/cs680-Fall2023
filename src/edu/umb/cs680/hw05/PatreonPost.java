package edu.umb.cs680.hw05;

public class PatreonPost {
	private String message;
	private int tier;
	
	public PatreonPost(String message, int tier) {
		this.message = message;
		
		if (tier > 0 && tier < 4){
			this.tier = tier;
		}
		else {
			throw new RuntimeException("Invalid post tier number given: " + tier + ". Post tier must be 1, 2, or 3.");
		}
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public int getTier() {
		return this.tier;
	}
}
