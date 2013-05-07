package com.example.ping;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class EventDetailActivity extends Activity {
	Event event;
	
	TextView title;
	TextView location;
	TextView time;
	TextView date;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event_detail);
		ActionBar actionbar = getActionBar();
		actionbar.setDisplayHomeAsUpEnabled (true);

		
		
		event =  new Event("Dinner", "Kojo Welbeck", "Student Center","05-10-2013", "5pm" );
		
		
		//title= (TextView) findViewById(R.id.eventTitle);
		//title.setText(event.title);
		actionbar.setTitle(event.title);		
		location=(TextView) findViewById(R.id.eventLocation);
		location.setText(event.location);
		
		time=(TextView)findViewById(R.id.eventTime);
		time.setText(event.time);
		
		date=(TextView)findViewById(R.id.eventDate);
		date.setText(event.date);
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_event_detail, menu);

		return true;
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// app icon in action bar clicked; go home
			Intent intent = new Intent(this, EventsListActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			return true;
		case R.id.eventmenu_messages:
			openMessages(event);
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	public void openMessages(Event e){
		Intent openMsgsIntent = new Intent(EventDetailActivity.this, EventMessagesActivity.class);
		EventDetailActivity.this.startActivity(openMsgsIntent);
	}
		
}
