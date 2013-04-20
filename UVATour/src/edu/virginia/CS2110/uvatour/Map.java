package edu.virginia.CS2110.uvatour;

import sofia.app.Screen;
import sofia.util.Timer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SlidingDrawer;
import android.widget.Toast;
import android.widget.SlidingDrawer.OnDrawerCloseListener;
import android.widget.SlidingDrawer.OnDrawerOpenListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class Map extends Screen implements OnClickListener, LocationListener {

	private SlidingDrawer information;
	private Button handle;
	private TextView currentCoords;
	private EditText nextCoord;
	private LocationManager locationManager;
	private String provider;
	private ScoreModel scoreModel;
	private TextView updateScore;
	private SlidingMenuModel menu;

	@Override
	public void onClick(View arg0) {

	}

	public void finishClicked() {
		presentScreen(ShowMap.class);
		finish();
	}

	public void initialize() {
		menu = new SlidingMenuModel();
		menu.addObserver(this);
		menu.setCurrentCoords(400f);
	}

	public void currentCoordsEditngDone() {
		Double coords;
		try {
			coords = Double.parseDouble(currentCoords.getText().toString());
		} catch (NumberFormatException e) {
			coords = 0.0;
		}

		menu.setCurrentCoords(coords);
	}

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);
		scoreModel = new ScoreModel();
		scoreModel.addObserver(this);
		scoreModel.setTempScore(1000);
		Timer.callRepeatedly(scoreModel, "updateScore", 1000);

		currentCoords = (TextView) findViewById(R.id.currentCoords);

		// Get the location manager
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		// Define the criteria how to select the location provider -> use
		// default
		Criteria criteria = new Criteria();
		provider = locationManager.getBestProvider(criteria, false);
		Location location = locationManager.getLastKnownLocation(provider);

		// Initialize the location fields
		if (location != null) {
			System.out.println("Provider " + provider + " has been selected.");
			onLocationChanged(location);
		} else {
			currentCoords.setText("Location not available");
		}
	}

	@Override
	public void onLocationChanged(Location location) {
		double lat = location.getLatitude();
		double lng = location.getLongitude();
		currentCoords.setText(String.valueOf(lat) + ", " + String.valueOf(lng));
	}

	@Override
	public void onProviderDisabled(String provider) {
		Toast.makeText(this, "Disabled provider " + provider,
				Toast.LENGTH_SHORT).show();

	}

	@Override
	public void onProviderEnabled(String provider) {
		Toast.makeText(this, "Enabled new provider " + provider,
				Toast.LENGTH_SHORT).show();

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onResume() {
		super.onResume();
		locationManager.requestLocationUpdates(provider, 400, 1, this);
	}

	@Override
	protected void onPause() {
		super.onPause();
		locationManager.removeUpdates(this);
	}

	@SuppressLint("DefaultLocale")
	public void changeWasObserved(ScoreModel theScoreModel, String str) {
		updateScore.setText(str);

	}

	@SuppressLint("DefaultLocale")
	public void changeWasObserved(SlidingMenuModel menu, String str) {
		String coords = String.format("%.2f", menu.getCurrentCoords());
		currentCoords.setText(coords);
	}

	// we used some of the code from this source
	// Vogel, Lars (2012) ShowLocationActivity (Version 4.1) [Source Code]
	// http://www.vogella.com/articles/AndroidLocationAPI/article.html

}
