package com.example.ping;

import java.util.ArrayList;

import com.example.ping.R;
import android.os.Bundle;
import android.app.Activity;


import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class NewPingActivity extends Activity {

	protected static final String TAG = null;
	private EditText newPingTitleField;
	private EditText newPingLocationField;
	private EditText newPingDateField;
	private EditText newPingTimeField;
	private TextView friendList;
	private Button send;
	private TextView selectedFriendsLabel;
	
	private Intent intent;
	private ArrayList<String> data;
	private ArrayList<String> friends;
	private ArrayList<String> data_to_send = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_ping);
		
		newPingTitleField = (EditText) findViewById(R.id.title_field);
		newPingLocationField = (EditText) findViewById(R.id.location_field);
		newPingDateField = (EditText) findViewById(R.id.date_field);
		newPingTimeField = (EditText) findViewById(R.id.time_field);
		friendList = (EditText) findViewById(R.id.friendsList);
		send = (Button) findViewById(R.id.send);
		selectedFriendsLabel = (TextView) findViewById(R.id.selected_friends_label);
		
		intent = getIntent();
		try{
			data = intent.getStringArrayListExtra("data");
			friends = intent.getStringArrayListExtra("friends");
			
			String f = "";
			for(int i=0; i<friends.size(); i++)
				f += friends.get(i) + "\n";
			
			readdData(data);
			
			selectedFriendsLabel.setVisibility(0);
			friendList.setVisibility(0);
			friendList.setText(f);
			
			send.setVisibility(0);
		}
		catch(NullPointerException e){
			System.out.println("This is the first time we're accessing this screen");
		}
		
	}

	public void selectFriends(View view){
		
		data_to_send.add(newPingTitleField.getText().toString());
		data_to_send.add(newPingLocationField.getText().toString());
		data_to_send.add(newPingDateField.getText().toString());
		data_to_send.add(newPingTimeField.getText().toString());
		
		Intent selectFriendsIntent = new Intent(NewPingActivity.this, SelectFriendsActivity.class);
		selectFriendsIntent.putStringArrayListExtra("data", data_to_send);
		startActivity(selectFriendsIntent);
	}
	
	public void send(View view){
		Intent returnHome = new Intent(this, HomeActivity.class);
		returnHome.putStringArrayListExtra("friends", friends);
		returnHome.putStringArrayListExtra("data", data);
		returnHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(returnHome);
	}
	
	public void cancel(View view){
		finish();
	}
	
	public void readdData(ArrayList<String> d){
		newPingTitleField.setText(d.get(0));
		newPingLocationField.setText(d.get(1));
		newPingDateField.setText(d.get(2));
		newPingTimeField.setText(d.get(3));
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.activity_new_ping, menu);		
		return true;
	}
	
}
