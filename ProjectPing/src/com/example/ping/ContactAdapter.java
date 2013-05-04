
package com.example.ping;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class ContactAdapter extends ArrayAdapter<Contact>{//the select contact list of checkboxes
	Context context; 
	int layoutResourceId;    
	Contact[] data = null;

	public ContactAdapter(Context context, int layoutResourceId, Contact[] data) {
		super(context, layoutResourceId, data);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.data = data;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		ContactHolder holder = null;

		if(row == null)
		{
			LayoutInflater inflater = ((Activity)context).getLayoutInflater();
			row = inflater.inflate(layoutResourceId, parent, false);

			holder = new ContactHolder();
			holder.txtName = (CheckBox)row.findViewById(R.id.contactName);
//			holder.txtNumber = (TextView)row.findViewById(R.id.contactNumber);
//			holder.txtEmail = (TextView)row.findViewById(R.id.contactEmail);


			row.setTag(holder);
		}
		else
		{
			holder = (ContactHolder)row.getTag();
		}

		Contact contact = data[position];
		holder.txtName.setText(contact.name);
//		holder.txtNumber.setText(contact.number);
//		holder.txtEmail.setText(contact.email);



		return row;
	}

	static class ContactHolder
	{
		TextView txtName;
//		TextView txtNumber;
//		TextView txtEmail;
	}

}
