package edu.virginia.CS2110.uvatour;


import sofia.app.Screen;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SlidingDrawer;
import android.widget.Toast;
import android.widget.SlidingDrawer.OnDrawerCloseListener;
import android.widget.SlidingDrawer.OnDrawerOpenListener;

@SuppressWarnings("deprecation")
public class Map extends Screen implements OnClickListener{

	private SlidingDrawer information;
	private Button handle;
	
	@Override
	public void onClick(View arg0) {
		
		
	}
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
        setContentView(R.layout.map);
	}

}
