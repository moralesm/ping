package com.example.ping;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends Activity {

	private Intent intent;
	private ArrayList<String> data;
	private ArrayList<String> friends;
	
	private TextView tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		tv = (TextView) findViewById(R.id.textView1);
		
		intent = getIntent();
		try{
			data = intent.getStringArrayListExtra("data");
			friends = intent.getStringArrayListExtra("friends");
			
			String f = "";
			for(int i=0; i<friends.size(); i++)
				f += friends.get(i) + "   ";
			
			
			tv.setText("Title: " + data.get(0) + "\n" 
					+ "Location: " + data.get(1) + "\n" 
					+ "Date: " + data.get(2) + "\n"
					+ "Time: " + data.get(3));
			
		}
		catch(NullPointerException e){
			System.out.println("This is the first time we're accessing this screen");
		}
		
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
