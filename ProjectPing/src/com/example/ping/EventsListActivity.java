package com.example.ping;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

public class EventsListActivity extends Activity {
	
	private ListView eventsListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_events_list);
		
        Event event_data[] = new Event[]
        {
            new Event("Dinner", "Kojo", "Student Center","Tomorrow", "5pm" ),
            new Event("Pset Part", "Peter", "Student Center","Friday", "2pm" ),

        };
        
        CondensedEventAdapter adapter = new CondensedEventAdapter(this, 
                R.layout.event_list_item, event_data);
        
        eventsListView = (ListView) findViewById(R.id.eventsListView);
        
        View header = (View)getLayoutInflater().inflate(R.layout.events_list_view_header, null);
        eventsListView.addHeaderView(header);
        eventsListView.setAdapter(adapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_events_list, menu);
		return true;
	}

}
