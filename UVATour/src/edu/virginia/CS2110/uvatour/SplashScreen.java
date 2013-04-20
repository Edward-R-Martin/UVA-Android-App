package edu.virginia.CS2110.uvatour;



import sofia.app.Screen;
import sofia.util.Timer;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.ProgressBar;

public class SplashScreen extends Screen {

	private Button endButton;
	private ProgressBar progressBar;

	@Override
	public void finish() {
		endButton.setVisibility(0);
		progressBar.setVisibility(4);
		presentScreen(InfoScreen.class);
	}
	
	public void endButtonClicked() {
		super.finish();
	}
	
	public void initialize(){
		progressBar.animate();
		sofia.util.Timer.callOnce(this, "finish", 2000);
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

		endButton.setVisibility(4);
		return true;
	}

}
