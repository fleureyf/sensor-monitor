package com.fleurey.android;

import com.fleurey.android.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class HelloWorldActivity extends Activity {

	private Button helloWorld;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.helloword_layout);
		helloWorld = (Button) findViewById(R.id.button_helloworld);
		helloWorld.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "Hello World had been clicked!", Toast.LENGTH_LONG).show();
			}
		});
	}
}
