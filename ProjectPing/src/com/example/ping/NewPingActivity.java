package com.example.ping;

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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_ping);
		EditText newPingTitleField = (EditText) findViewById(R.id.title_field);
		EditText newPingLocationField = (EditText) findViewById(R.id.location_field);
		EditText newPingTimeField = (EditText) findViewById(R.id.time_field);
		EditText newPingInvitedFriendsField = (EditText) findViewById(R.id.invited_friends_field);
		Button selectFriendsButton = (Button) findViewById(R.id.select_friends_button);
		Button cancelButton = (Button) findViewById(R.id.cancel_button);

		selectFriendsButton.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				//if(getFragmentManager().findFragmentById(R.id.fragment) == null) {

					Log.d(TAG,"adding fragment");



					Fragment f = new SampleFriendsFragment();
					//FragmentManager fragmentManager = getFragmentManager();

					FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

					ft.add(R.id.new_ping, f);

					ft.commit();

				}

			});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_new_ping, menu);
		return true;
	}


}
