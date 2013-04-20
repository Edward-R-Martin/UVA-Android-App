package edu.virginia.CS2110.uvatour;

public class SlidingMenuModel extends sofia.util.Observable
{
	private double currentCoords = 500;
	private double nextCoords = 200;
	public double getCurrentCoords()
	{
		return currentCoords;
	}
	public void setCurrentCoords(double coords) {
		currentCoords = coords;
		notifyObservers();
		// notifyObservers(String.valueOf(updateScore));
	}
}