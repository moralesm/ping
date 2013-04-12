package com.example.ping;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;

public class HomeActivity extends Activity {
	private Intent intent;
	private ArrayList<String> data;
	private ArrayList<String> friends;
	private TextView tv;
	private MenuItem menu_newPing;
//	private Menu settingsPopUp;
//	private Menu settingsMenu;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
//
//		settingsPopUp =(Menu) new Menu(this, findViewById(R.id.menu_settings));
//		settingsPopUp.add(Menu.NONE, 1, Menu.NONE, "Item 1");
//		settingsPopUp.add(Menu.NONE, 2, Menu.NONE, "Item 1");
//		settingsPopUp.add(Menu.NONE, 3, Menu.NONE, "Item 3");

		tv = (TextView) findViewById(R.id.textView1);

		menu_newPing = (MenuItem) findViewById(R.id.menu_newping);


		intent = getIntent();
		try{
			data = intent.getStringArrayListExtra("data");
			friends = intent.getStringArrayListExtra("friends");

			String f = "";
			for(int i=0; i<friends.size(); i++)
				f += friends.get(i) + "   ";


			tv.setText("Title: " + data.get(0) + "\n" 
					+ "Location: " + data.get(1) + "\n" 
					+ "Date: " + data.get(2) + "\n"
					+ "Time: " + data.get(3));

		}
		catch(NullPointerException e){
			System.out.println("This is the first time we're accessing this screen");
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.activity_home, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {

		switch(item.getItemId()){
		case R.id.menu_newping:
			newPing();
			return true;
		case R.id.menu_settings:
//			settingsPopUp.show();
			return true;
		}
		return false;}



	public void newPing(){
		Intent newPingIntent = new Intent(HomeActivity.this, NewPingActivity.class);
		newPingIntent.putExtra("test", "We're trying to pass this value to a new Activity");
		HomeActivity.this.startActivity(newPingIntent);
	}

}
