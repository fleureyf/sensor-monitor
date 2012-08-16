package com.fleurey.android.test;

import com.fleurey.android.HelloWorldActivity;

import android.test.ActivityInstrumentationTestCase2;

import com.jayway.android.robotium.solo.Solo;

public class SimpleUITest extends ActivityInstrumentationTestCase2<HelloWorldActivity> {

	private Solo solo;
	
	public SimpleUITest() {
		super(HelloWorldActivity.class);
	}
	
	@Override
	public void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	public void testButtonOnClick() {
		solo.clickOnButton("Hello World");
		solo.waitForText("Hello World had been clicked!", 0, 3000);
		assertTrue(solo.searchText("Hello World had been clicked!"));
	}
	
	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}
}
