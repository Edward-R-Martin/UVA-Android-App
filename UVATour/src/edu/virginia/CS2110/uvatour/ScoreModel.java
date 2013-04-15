package edu.virginia.CS2110.uvatour;

public class ScoreModel extends sofia.util.Observable {

	private int tempScore;
	private int fullScore;

	public int getTempScore() {
		if (tempScore>0)
		{
			tempScore--;
		}
		notifyObservers();
		return tempScore;
	}

	public int getFullScore() {
		notifyObservers();
		return fullScore;
	}
	
	public void setTempScore(int score) {
		tempScore=score;
		notifyObservers();
	}

	public void calculateFinalScore() {
		fullScore += tempScore;
		tempScore = 1000;
		notifyObservers();
	}
}
