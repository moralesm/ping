package com.example.ping;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class EventsListActivity extends Activity {
	
	private ListView eventsListView;
	private Intent intent;
	private ArrayList<String> data;
	private ArrayList<String> friends;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_events_list);
		
        Event event_data[] = new Event[]
        {
            new Event("Dinner", "Kojo Welbeck", "Student Center","05-10-2013", "5pm" ),
            new Event("Pset Meeting", "Peter Lee", "Student Center","05-11-2013", "2pm" )
            //new Event("test", "another test", "test location", "0230234", "1010pm")

        };
        
//        ArrayList<String> f = new ArrayList<String>();
//        f.add("Mario");
//        f.add("test 2");
//        f.add("Peter");
//        event_data[2].setAttending(f);
        
        intent = getIntent();
		try{
			data = intent.getStringArrayListExtra("data");
			friends = intent.getStringArrayListExtra("friends");

			Event event_data2[] = new Event[event_data.length + 1];
			for(int i=0; i<event_data.length; i++)
				event_data2[i] = event_data[i];
			event_data2[event_data.length] = new Event(data.get(0), "Mario Morales", data.get(1), data.get(2), data.get(3));
			
			CondensedEventAdapter adapter = new CondensedEventAdapter(this, 
	                R.layout.event_list_item, event_data2);
	        
	        eventsListView = (ListView) findViewById(R.id.eventsListView);
	        
	        View header = (View)getLayoutInflater().inflate(R.layout.events_list_view_header, null);
	        eventsListView.addHeaderView(header, null, false);
	        eventsListView.setAdapter(adapter);

		}
		catch(NullPointerException e){
			System.out.println("This is the first time we're accessing this screen");
			
			
			CondensedEventAdapter adapter = new CondensedEventAdapter(this, 
	                R.layout.event_list_item, event_data);
	        
	        eventsListView = (ListView) findViewById(R.id.eventsListView);
	        
	        View header = (View)getLayoutInflater().inflate(R.layout.events_list_view_header, null);
	        eventsListView.addHeaderView(header, null, false);
	        eventsListView.setAdapter(adapter);
			
		}
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_home, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {

		switch(item.getItemId()){
		case R.id.home_menu_newping:
			newPing();
			return true;
		case R.id.home_menu_settings:
			test();
//			
			return true;
		case R.id.home_menu_contacts:
			openContacts();
			return true;
		}
		
		return false;}
	
	public void launchEvent(View v){
		Intent eventIntent = new Intent(EventsListActivity.this, EventDetailActivity.class);
		EventsListActivity.this.startActivity(eventIntent);
	}
	
	public void newPing(){
		Intent newPingIntent = new Intent(EventsListActivity.this, NewPingActivity.class);
		newPingIntent.putExtra("test", "We're trying to pass this value to a new Activity");
		EventsListActivity.this.startActivity(newPingIntent);
	}
	public void openContacts(){
		Intent openContactsIntent = new Intent(EventsListActivity.this, PingContactsActivity.class);
		openContactsIntent.putExtra("test", "We're trying to pass this value to a new Activity");
		EventsListActivity.this.startActivity(openContactsIntent);

		
}
	public void test(){
		Intent testIntent = new Intent(EventsListActivity.this, SettingsActivity.class);
		EventsListActivity.this.startActivity(testIntent);
	}}
