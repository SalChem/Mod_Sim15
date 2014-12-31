package com.example.heartpatientsimulator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ReadingValvularHeartDisease extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.readingvalvularheartdisease);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reading_valvular_heart_disease, menu);
		return true;
	}

}
