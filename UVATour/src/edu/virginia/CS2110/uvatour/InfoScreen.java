package edu.virginia.CS2110.uvatour;

import android.widget.Button;
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
	private EditText temperature;


	public void finishClicked() {
		finish();
	}

	public void startTourClicked() {
		
	}
}
