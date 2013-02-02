package com.fleurey.android.sensormonitor.sensormanager;

import java.util.List;

import android.content.Context;
import android.hardware.Sensor;

public class SensorManager {
	
	private android.hardware.SensorManager mSensorManager;
	private List<Sensor> sensors;
	
	public SensorManager(Context context) {
		mSensorManager = (android.hardware.SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
		sensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
	}
	
	public List<Sensor> getSensors() {
		return sensors;
	}
	
	public Sensor findSensor(String name) {
		for (Sensor sensor : sensors) {
			if (name.equals(sensor.getName())) {
				return sensor;
			}
		}
		throw new IllegalArgumentException("Sensor name does not exits");
	}
}
