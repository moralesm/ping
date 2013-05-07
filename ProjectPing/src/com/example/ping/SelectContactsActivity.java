package com.example.ping;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;

public class SelectContactsActivity extends Activity {
	private ListView contactListView;


	ArrayList<String> data_rcvd;
	Intent rcvdIntent;
	ArrayList<String> friends;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_contact);
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

		ContactAdapter adapter = new ContactAdapter(this, 
				R.layout.contact_list_item, contact_data);

		contactListView = (ListView) findViewById(R.id.contactListView);

		//		View header = (View)getLayoutInflater().inflate(R.layout.select_contact_list_view_header, null);
		//		eventsListView.addHeaderView(header);
		contactListView.setAdapter(adapter);

		//handling intents 
		rcvdIntent = getIntent();
		try{
			data_rcvd= rcvdIntent.getStringArrayListExtra("data");
		}
		catch(NullPointerException e){
			System.out.println("This is the first time we're accessing this screen");
		}




	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_select_contact, menu);
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
		case R.id.selectionDone:
			sendSelectedFriends();
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	public void newPing(){
		Intent newPingIntent = new Intent(SelectContactsActivity.this, NewPingActivity.class);
		newPingIntent.putExtra("test", "We're trying to pass this value to a new Activity");
		SelectContactsActivity.this.startActivity(newPingIntent);
	}

	public void sendSelectedFriends(){


		Intent friendsSelectedIntent= new Intent(SelectContactsActivity.this, NewPingActivity.class );
		friendsSelectedIntent.putStringArrayListExtra("data",data_rcvd);
		friendsSelectedIntent.putStringArrayListExtra("friends", friends);
	}
//
//	public void contactClicked(View v){
//		if (((CheckBox)v).isChecked()){
//			friends.add(v.getText());
//		}
//	}
}