package com.example.ping;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class PingContactsActivity extends Activity {

	ListView ping_contact_list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ping_contacts);

		ActionBar actionbar = getActionBar();
		actionbar.setDisplayHomeAsUpEnabled(true);


		Contact[] contact_data = new Contact[]
				{
				new Contact("Firstname Lastname", "#########","example@example.com"),
				new Contact("Firstname1 Lastname1", "#########1","example@example.com1"),
				new Contact("Firstname2 Lastname2", "#########2","example@example.com2"),
				new Contact("Firstname3 Lastname3", "#########3","example@example.com3"),
				new Contact("Firstname4 Lastname4", "#########4","example@example.com4"),
				new Contact("Firstname5 Lastname5", "#########5","example@example.com5"),
				new Contact("Firstname6 Lastname6", "#########6","example@example.com6"),
				new Contact("Firstname7 Lastname7", "#########7","example@example.com7"),

				};

		pingContactsAdapter adapter = new pingContactsAdapter(this, 
				R.layout.ping_contact_list_item, contact_data);

		ping_contact_list = (ListView) findViewById(R.id.ping_contact_list_view);

		//		View header = (View)getLayoutInflater().inflate(R.layout.select_contact_list_view_header, null);
		//		eventsListView.addHeaderView(header);
		ping_contact_list.setAdapter(adapter);

	}


@Override
public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.activity_ping_contacts, menu);
	return true;
}

}
