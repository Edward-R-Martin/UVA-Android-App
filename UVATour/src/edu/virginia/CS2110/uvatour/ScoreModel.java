package edu.virginia.CS2110.uvatour;

public class ScoreModel extends sofia.util.Observable {

	private int tempScore;
	private int fullScore;

	public void scoreModel() {
		setTempScore(1000);
	}
	
	public void scoreModel(int score) {
		setTempScore(score);
	}

	public int getTempScore() {
		tempScore--;
		notifyObservers("temp");
		return tempScore;
	}

	public int getFullScore() {
		return fullScore;
	}
	
	public void setTempScore(int score) {
		tempScore=score;
		notifyObservers("null");
	}

	public void calculateFinalScore() {
		fullScore -= tempScore;
		tempScore = 1000;
		notifyObservers("yo");
	}
}
