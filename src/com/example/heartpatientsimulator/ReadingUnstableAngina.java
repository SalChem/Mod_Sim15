package com.example.heartpatientsimulator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ReadingUnstableAngina extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.readingunstableangina);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reading_unstable_angina, menu);
		return true;
	}

}
