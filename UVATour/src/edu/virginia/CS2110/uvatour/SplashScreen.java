package edu.virginia.CS2110.uvatour;



import sofia.app.Screen;
import sofia.util.Timer;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;

public class SplashScreen extends Screen {

	private Button startButton;

	public void startButtonClicked() {
		finish();
		presentScreen(InfoScreen.class);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splashscreen);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash_screen, menu);
		return true;
	}

}
