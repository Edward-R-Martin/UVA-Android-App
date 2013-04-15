package edu.virginia.CS2110.uvatour;

import android.widget.Button;
import android.annotation.SuppressLint;
import android.location.*;
import android.widget.EditText;
import sofia.app.Screen;
import sofia.app.ScreenLayout;
import sofia.util.Timer;

@ScreenLayout(scroll = true)
public class InfoScreen extends Screen {
	
	private Button finish;
	private Button startTour;
	private EditText updateScore;
	private EditText score;
	
	private ScoreModel scoreModel;


	public void initialize() {
		scoreModel = new ScoreModel();
		scoreModel.addObserver(this);
		
		//scoreModel.setTempScore(10);
	}
	
	public void finishClicked() {
		finish();
	}

	public void startTourClicked() {
		//scoreModel.setTempScore(100);
		presentScreen(Map.class);
	}
	
	@SuppressLint("DefaultLocale")
    public void changeWasObserved(ScoreModel theScoreModel)
    {
		String updateScoreString = String.format("%d", scoreModel.getTempScore());
		String scoreString = String.format("%d", scoreModel.getFullScore());
		updateScore.setText(updateScoreString);
		score.setText(scoreString);
    }
}
