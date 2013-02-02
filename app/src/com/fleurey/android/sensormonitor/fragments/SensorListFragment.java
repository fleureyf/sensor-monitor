package com.fleurey.android.sensormonitor.fragments;

import java.util.ArrayList;
import java.util.List;

import android.hardware.Sensor;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.fleurey.android.sensormonitor.MainActivity;
import com.fleurey.android.sensormonitor.R;
import com.fleurey.android.sensormonitor.sensormanager.SensorAdapter;
import com.fleurey.android.sensormonitor.sensormanager.SensorManager;

public class SensorListFragment extends ListFragment {

	private static final String TAG = SensorListFragment.class.getSimpleName();
	
	private List<Sensor> sensors = new ArrayList<Sensor>();
	private SensorManager mSensorManager;
	private SensorAdapter mSensorAdapter;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mSensorManager = ((MainActivity) getActivity()).getSensorManager();
		mSensorAdapter = new SensorAdapter(getActivity().getApplicationContext(), sensors);
		populate();
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		SensorFragment fragment = new SensorFragment();
		Bundle bundle = new Bundle();
		bundle.putString(SensorFragment.EXTRA_NAME, ((TextView) v.findViewById(R.id.name)).getText().toString());
		fragment.setArguments(bundle);
		FragmentTransaction transaction = getFragmentManager().beginTransaction();
		transaction.hide(this);
		transaction.add(((ViewGroup) getView().getParent().getParent()).getId(), fragment, SensorFragment.class.getName());
		transaction.addToBackStack(null);
		transaction.commit();
	}
	
	private void populate() {
		Log.d(TAG, "__POPULATE__");
		setListAdapter(mSensorAdapter);
		sensors.clear();
		sensors.addAll(mSensorManager.getSensors());
		mSensorAdapter.notifyDataSetChanged();
	}
}
