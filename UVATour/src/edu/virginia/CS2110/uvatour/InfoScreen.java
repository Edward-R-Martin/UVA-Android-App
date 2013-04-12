package edu.virginia.CS2110.uvatour;

import android.widget.Button;
import android.location.*;
import android.widget.EditText;
import sofia.app.Screen;
import sofia.util.Timer;

public class InfoScreen extends Screen {
	private Button finish;
	private Button startTour;
	private EditText updateScore;
	private EditText currentCoords;
	private EditText temperature;
	private int score = 1000;

	public void updateScore() {
		score--;
		//updateScore.
		//updateScore.getText().append(score+"");
	}

	public void finishClicked() {
		finish();
	}

	public void startTourClicked() {
		Timer.callRepeatedly(this, "updateScore", 1000);
	}
}
