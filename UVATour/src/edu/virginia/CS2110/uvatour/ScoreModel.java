package edu.virginia.CS2110.uvatour;

public class ScoreModel extends sofia.util.Observable {

	private int tempScore;
	private int fullScore;

	public int getTempScore() {
		return tempScore;
	}

	public int getFullScore() {
		return fullScore;
	}
	
	
	public void setTempScore(int newTempScore) {
		tempScore=newTempScore;
		notifyObservers("string");
	}

	public void calculateFinalScore() {
		fullScore += tempScore;
		tempScore = 1000;
		notifyObservers();
	}
}
