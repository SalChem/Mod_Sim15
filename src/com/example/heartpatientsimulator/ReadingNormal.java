package com.example.heartpatientsimulator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ReadingNormal extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reading_normal);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reading_normal, menu);
		return true;
	}

}
