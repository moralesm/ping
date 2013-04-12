package com.example.ping;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CondensedEventAdapter extends ArrayAdapter<Event>{
    Context context; 
    int layoutResourceId;    
    Event data[] = null;
    
    public CondensedEventAdapter(Context context, int layoutResourceId, Event[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        CondensedEventHolder holder = null;
        
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            
            holder = new CondensedEventHolder();
            holder.txtTitle = (TextView)row.findViewById(R.id.eventTitle);
            holder.txtLocation = (TextView)row.findViewById(R.id.eventLocation);
            holder.txtDate = (TextView)row.findViewById(R.id.eventDate);
            holder.txtTime = (TextView)row.findViewById(R.id.eventTime);
            
            row.setTag(holder);
        }
        else
        {
            holder = (CondensedEventHolder)row.getTag();
        }
        
        Event event = data[position];
        holder.txtTitle.setText(event.title);
        holder.txtLocation.setText(event.location);
        holder.txtDate.setText(event.date);
        holder.txtTime.setText(event.time);
        
        
        return row;
    }
    
    static class CondensedEventHolder
    {
        TextView txtTitle;
        TextView txtLocation;
        TextView txtDate;
        TextView txtTime;
    }

}
