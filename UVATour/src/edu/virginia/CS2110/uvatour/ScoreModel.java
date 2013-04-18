package edu.virginia.CS2110.uvatour;

public class ScoreModel extends sofia.util.Observable {

	private int updateScore=1000;
	private int score;

	public int getTempScore() {
		System.out.println(updateScore);
		return updateScore;
	}

	public int getFullScore() {
		return score;
	}
	
	
	public void setTempScore(int newTempScore) {
		updateScore=newTempScore;
		System.out.println(updateScore);
		notifyObservers(String.valueOf(updateScore));
	}

	public void calculateFinalScore() {
		score += updateScore;
		updateScore = 1000;
		notifyObservers();
	}
}
