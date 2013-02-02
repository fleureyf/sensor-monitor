package com.fleurey.android.sensormonitor.fragments;

import android.hardware.Sensor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fleurey.android.sensormonitor.MainActivity;
import com.fleurey.android.sensormonitor.R;
import com.fleurey.android.sensormonitor.sensormanager.SensorManager;

public class SensorFragment extends Fragment {

	public static final String EXTRA_NAME = SensorFragment.class.getName() + ".EXTRA_NAME";
	
	private SensorManager mSensorManager;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_sensor, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mSensorManager = ((MainActivity) getActivity()).getSensorManager();
		populate();
	}
	
	private void populate() {
		Sensor sensor = mSensorManager.findSensor(getArguments().getString(EXTRA_NAME));
		((TextView) getView().findViewById(R.id.name)).setText(sensor.getName());
		((TextView) getView().findViewById(R.id.vendor)).setText(sensor.getVendor());
		((TextView) getView().findViewById(R.id.version)).setText(String.valueOf(sensor.getVersion()));
		((TextView) getView().findViewById(R.id.range_max)).setText(String.valueOf(sensor.getMaximumRange()));
		((TextView) getView().findViewById(R.id.comsumption)).setText(String.valueOf(sensor.getPower()));
	}
}
