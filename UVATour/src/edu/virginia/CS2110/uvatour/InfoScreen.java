package edu.virginia.CS2110.uvatour;

import android.widget.Button;
import android.widget.TextView;
import android.annotation.SuppressLint;
import android.location.*;
import android.widget.EditText;
import sofia.app.Screen;
import sofia.app.ScreenLayout;
import sofia.util.Timer;

@ScreenLayout(scroll = true)
public class InfoScreen extends Screen {
	
	@SuppressWarnings("unused")
	private Button finish;
	@SuppressWarnings("unused")
	private Button startTour;
	private TextView updateScore;
	private TextView score;
	
	private ScoreModel scoreModel;


	public void initialize() {
		scoreModel = new ScoreModel();
		scoreModel.addObserver(this);
		
		scoreModel.setTempScore(1000);
		Timer.callRepeatedly(scoreModel, "updateScore", 1000);
	}
	
	public void finishClicked() {
		finish();
	}

	public void startTourClicked() {
		//scoreModel.setTempScore(100);
		presentScreen(Map.class);
	}
	
	@SuppressLint("DefaultLocale")
    public void changeWasObserved(ScoreModel theScoreModel, String str)
    {
		System.out.println(str);
		updateScore.setText(str);
		//score.setText(scoreString);
    }
}
