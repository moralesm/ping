package com.example.ping;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;

public class SelectFriendsActivity extends Activity {
	
	private CheckBox friend1, friend2, friend3, friend4, friend5;
	private ArrayList<CheckBox> contacts;
	private ArrayList<String> friendsSelected = new ArrayList<String>();
	//private Button selectionDoneButton;
	
	private Intent intent;
	private ArrayList<String> data_received;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_friends);
		
		intent = getIntent();
		data_received = intent.getStringArrayListExtra("data");
		
		friend1 = (CheckBox) findViewById(R.id.friend1);
		friend2 = (CheckBox) findViewById(R.id.friend2);
		friend3 = (CheckBox) findViewById(R.id.friend3);
		friend4 = (CheckBox) findViewById(R.id.friend4);
		friend5 = (CheckBox) findViewById(R.id.friend5);
		contacts= new ArrayList<CheckBox>();
		contacts.add(friend1);
		contacts.add(friend2);
		contacts.add(friend3);
		contacts.add(friend4);
		contacts.add(friend5);
		
		//selectionDoneButton = (Button) findViewById(R.id.select_friends_done_button);
		
	}

	public void returnFriendsSelected(View view){
		
		for (CheckBox i: contacts)
			if (i.isChecked())
				friendsSelected.add(i.getText().toString());
		
		Intent friends = new Intent(this, NewPingActivity.class);
		friends.putStringArrayListExtra("friends", friendsSelected);
		friends.putStringArrayListExtra("data", data_received);
		friends.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(friends);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_select_friends, menu);
		return true;
	}

}
