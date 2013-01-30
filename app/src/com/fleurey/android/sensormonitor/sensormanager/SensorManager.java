package com.fleurey.android.sensormonitor.sensormanager;

import java.util.List;

import android.content.Context;
import android.hardware.Sensor;

public class SensorManager {
	
	private android.hardware.SensorManager mSensorManager;

	public SensorManager(Context context) {
		mSensorManager = (android.hardware.SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
	}
	
	public List<Sensor> getSensors() {
		return mSensorManager.getSensorList(Sensor.TYPE_ALL);
	}
}
