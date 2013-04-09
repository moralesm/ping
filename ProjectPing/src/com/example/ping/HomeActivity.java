package com.example.ping;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class HomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_home, menu);
		return true;
	}
	
	public void newPing(View view){
		Intent newPingIntent = new Intent(HomeActivity.this, NewPingActivity.class);
		newPingIntent.putExtra("test", "We're trying to pass this value to a new Activity");
		HomeActivity.this.startActivity(newPingIntent);
	}

}
