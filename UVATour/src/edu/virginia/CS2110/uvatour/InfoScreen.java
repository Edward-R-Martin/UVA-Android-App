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
	private EditText currentCoords;
	private EditText score;
	private EditText temperature;
	
	private ScoreModel scoreModel;


	public void initialize() {
		scoreModel = new ScoreModel();
		scoreModel.addObserver(this);
	}
	
	public void finishClicked() {
		finish();
	}

	public void startTourClicked() {
		
			Timer.callRepeatedly(scoreModel, "getTempScore", 5000);
	}
	
	@SuppressLint("DefaultLocale")
    public void changeWasObserved(ScoreModel theScoreModel)
    {
		String updateScoreString = ""+scoreModel.getTempScore();
		String scoreString = ""+scoreModel.getFullScore();
		updateScore.setText(updateScoreString);
		score.setText(scoreString);
    }
}
