package com.fleurey.android.sensormonitor.sensormanager;

import java.util.List;

import android.content.Context;
import android.hardware.Sensor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.fleurey.android.sensormonitor.R;

public class SensorAdapter extends BaseAdapter {

	private LayoutInflater mLayoutInflater;
	private List<Sensor> sensors;
	
	private static class ViewHolder {
		TextView name;
	}
	
	public SensorAdapter(Context context, List<Sensor> sensors) {
		super();
		mLayoutInflater = LayoutInflater.from(context);
		this.sensors = sensors;
	}

	@Override
	public int getCount() {
		return sensors.size();
	}

	@Override
	public Object getItem(int position) {
		return sensors.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		View view = convertView;
		if(view == null) {
			holder = new ViewHolder();
			view = mLayoutInflater.inflate(R.layout.row_sensor, null);
			holder.name = (TextView) view.findViewById(R.id.name);
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}
		holder.name.setText(((Sensor) getItem(position)).getName());
		return view;
	}
}
