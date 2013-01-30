package com.fleurey.android.sensormonitor.fragments;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.hardware.Sensor;
import android.os.Bundle;
import android.support.v4.app.ListFragment;

import com.fleurey.android.sensormonitor.sensormanager.SensorAdapter;
import com.fleurey.android.sensormonitor.sensormanager.SensorManager;

public class SensorListFragment extends ListFragment {

	private List<Sensor> sensors = new ArrayList<Sensor>();
	private SensorManager mSensorManager;
	private SensorAdapter mSensorAdapter;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mSensorManager = new SensorManager(activity.getApplicationContext());
		mSensorAdapter = new SensorAdapter(activity.getApplicationContext(), sensors);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		populate();
	}
	
	private void populate() {
		setListAdapter(mSensorAdapter);
		sensors.addAll(mSensorManager.getSensors());
		mSensorAdapter.notifyDataSetChanged();
	}
}
