package com.example.heartpatientsimulator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ReadingAtrialFibrillation extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.readingatrialfibrillation);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reading_atrial_fibrillation, menu);
		return true;
	}

}
