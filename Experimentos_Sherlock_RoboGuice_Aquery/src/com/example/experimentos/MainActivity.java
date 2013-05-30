package com.example.experimentos;

import android.os.Bundle;
import android.os.Vibrator;
import android.widget.Toast;

import com.actionbarsherlock.view.MenuInflater;
import com.androidquery.AQuery;
import com.github.rtyley.android.sherlock.roboguice.activity.RoboSherlockActivity;
import com.google.inject.Inject;


public class MainActivity extends RoboSherlockActivity {
	
	AQuery a;
	
	@Inject Vibrator v;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_main);
        a = new AQuery(this);
        a.id(R.id.btVibrar).clickable(true).clicked(this, "vibrar");
        getSupportActionBar().setTitle("Example!");
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
    	MenuInflater inflater = this.getSupportMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }
    
    
    public void vibrar(){
    	try {
			v.vibrate(1000);
			Toast.makeText(this, "Vibrando", Toast.LENGTH_LONG).show();
		} catch (Exception e) {
			Toast.makeText(this, e.toString() + " - " + e.getMessage(), Toast.LENGTH_LONG).show();
		}
    	
    }

}
