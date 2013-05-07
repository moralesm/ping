package com.example.ping;

import java.util.ArrayList;

import com.example.ping.R;
import android.os.Bundle;
import android.app.Activity;


import android.content.Intent;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


public class NewPingActivity extends Activity {

	protected static final String TAG = null;
	private EditText newPingTitle;
	private EditText newPingLocation;
	//private EditText newPingDateField;
	//private EditText newPingTimeField;
	private TextView friendList;
	private Button send;
	private TextView selectedFriendsLabel;
	private DatePicker newPingDate;
	private TimePicker newPingTime;



	private Intent intent;
	private ArrayList<String> data_rcvd;
	private ArrayList<String> friends;
	private ArrayList<String> data_to_send = new ArrayList<String>();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_ping);
		getActionBar().setDisplayHomeAsUpEnabled (true);

		newPingTitle = (EditText) findViewById(R.id.title_field);
		newPingLocation = (EditText) findViewById(R.id.location_field);
		//newPingDateField = (EditText) findViewById(R.id.date_field);
		//newPingTimeField = (EditText) findViewById(R.id.time_field);
		friendList = (EditText) findViewById(R.id.friendsList);
		send = (Button) findViewById(R.id.send);
		selectedFriendsLabel = (TextView) findViewById(R.id.selected_friends_label);
		newPingDate = (DatePicker) findViewById(R.id.newping_datepicker);
		newPingTime = (TimePicker) findViewById(R.id.newping_timepicker);

		intent = getIntent();
		try{
			data_rcvd = intent.getStringArrayListExtra("data");
			friends = intent.getStringArrayListExtra("friends");

			String f = "";
			for(int i=0; i<friends.size(); i++)
				f += friends.get(i) + "\n";

			readdData(data_rcvd);

			selectedFriendsLabel.setVisibility(0);
			friendList.setVisibility(0);
			friendList.setText(f);

			send.setVisibility(0);
		}
		catch(Exception e){
			System.out.println("This is the first time we're accessing this screen");
		}

	}

	public void selectFriends(View view){

		if ((newPingTitle.getText().toString().trim().equals(""))||(newPingLocation.getText().toString().trim().equals(""))){
			Toast incomplete = Toast.makeText(getApplicationContext(), "Incomplete Entry", Toast.LENGTH_SHORT);
			incomplete.setGravity(Gravity.TOP, 0, 100);
			incomplete.show();
		}
		else{
			data_to_send.add(newPingTitle.getText().toString());
			data_to_send.add(newPingLocation.getText().toString());
			System.out.println(newPingLocation.getText().toString());
			
			String date_to_send = Integer.toString(newPingDate.getDayOfMonth()) + "-" + 
								Integer.toString(newPingDate.getMonth()) + "-" + Integer.toString(newPingDate.getYear());

			newPingTime.is24HourView();
			String time_to_send = Integer.toString(newPingTime.getCurrentHour()) + "-" +  Integer.toString(newPingTime.getCurrentMinute()); 
			
			data_to_send.add(date_to_send);
			data_to_send.add(time_to_send);
			

			Intent selectFriendsIntent = new Intent(NewPingActivity.this, SelectContactsActivity.class);
			selectFriendsIntent.putStringArrayListExtra("data", data_to_send);
			startActivity(selectFriendsIntent);
		}
	}
	
	public void send(View view){
		Intent returnHome = new Intent(this, EventsListActivity.class);
		returnHome.putStringArrayListExtra("friends", friends);
		returnHome.putStringArrayListExtra("data", data_rcvd);
		returnHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(returnHome);
	}

	public void cancel(View view){
		finish();
	}

	public void readdData(ArrayList<String> d){
		newPingTitle.setText(d.get(0));
		newPingLocation.setText(d.get(1));
		String[] dateArray =d.get(2).split("-");
		String[] timeArray =d.get(3).split("-");
		
		newPingTime.setCurrentHour(Integer.parseInt(timeArray[0]));
		newPingTime.setCurrentMinute(Integer.parseInt(timeArray[1]));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.activity_new_ping, menu);		
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
		default:
			return super.onOptionsItemSelected(item);
		}
	}

//	public String[] DateToString(int month, int dayOfMonth, int year){
//		String[]
//		
//		return "";
		
	}
	

