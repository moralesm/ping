package com.example.ping;

import com.example.ping.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;


public class NewPingActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_ping);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_new_ping, menu);
		return true;
	}
	

}
