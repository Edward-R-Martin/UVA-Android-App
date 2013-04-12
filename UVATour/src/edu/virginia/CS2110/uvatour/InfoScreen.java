package edu.virginia.CS2110.uvatour;

import android.widget.Button;
import android.widget.EditText;
import sofia.app.Screen;

public class InfoScreen extends Screen
{
	private Button finish;
	private EditText updateScore;
	private EditText currentCoords;
	
	
	public void finishClicked() {
		finish();
	}
    
}
