package com.example.ping;

import java.util.ArrayList;
import java.util.List;

import com.example.ping.R;
import android.os.Bundle;
import android.app.Activity;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class NewPingActivity extends FragmentActivity {

	protected static final String TAG = null;
	private List<String> data_to_send;
	private EditText newPingTitleField;
	private EditText newPingLocationField;
	private EditText newPingTimeField ;
	//private EditText newPingInvitedFriendsField;
	private Button selectFriendsButton;
	private Button cancelButton;

	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		data_to_send = new ArrayList<String>();
		
	
		setContentView(R.layout.activity_new_ping);
		
		newPingTitleField = (EditText) findViewById(R.id.title_field);
		newPingLocationField = (EditText) findViewById(R.id.location_field);
		newPingTimeField = (EditText) findViewById(R.id.time_field);
		//newPingInvitedFriendsField = (EditText) findViewById(R.id.invited_friends_field);
		selectFriendsButton = (Button) findViewById(R.id.select_friends_button);
		cancelButton = (Button) findViewById(R.id.cancel_button);

		
		selectFriendsButton.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				//if(getFragmentManager().findFragmentById(R.id.fragment) == null) {
				data_to_send.add(0, newPingTitleField.getText().toString());
				data_to_send.add(0, newPingLocationField.getText().toString());
				data_to_send.add(0, newPingTimeField.getText().toString());
				
				Intent selectFriendsIntent = new Intent(NewPingActivity.this, SelectFriendsActivity.class);
				selectFriendsIntent.putStringArrayListExtra("data", (ArrayList<String>) data_to_send);
				startActivity(selectFriendsIntent);
			}});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_new_ping, menu);
		return true;
	}


}
