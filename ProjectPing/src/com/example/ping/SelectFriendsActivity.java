package com.example.ping;

import java.lang.reflect.Array;
import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class SelectFriendsActivity extends Activity {
	
	private CheckBox friend1, friend2, friend3, friend4, friend5;
	private ArrayList<CheckBox> contacts;
	private ArrayList<String> friendsSelected;
	private Button selectionDoneButton;
	
	
	private Intent intent = getIntent();
	private ArrayList<String> data_recieved = intent.getStringArrayListExtra("data");
	
	private ArrayList data_to_send = new ArrayList();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_friends);
		
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
		
		selectionDoneButton = (Button) findViewById(R.id.select_friends_done_button);
		selectionDoneButton.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				for (CheckBox i: contacts){
					if (i.isChecked()){
						friendsSelected.add((String) i.getText());
					}
				}
				data_to_send = data_recieved;
				data_to_send.add(friendsSelected);
				//Intent sendNewPingIntent = new Intent(SelectFriendsActivity.this,  );
				//sendNewPingIntent.putExtra("data", data_to_send);
			}
			
		});
		
		
		//data_recieved = intent.getStringArrayListExtra("test");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_select_friends, menu);
		return true;
	}

}
