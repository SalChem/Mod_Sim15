package com.example.heartpatientsimulator;

import java.io.InputStream;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Myocarditis extends Activity {
	final static int PULSE_WIDTH = 100;
	final static double PULSE_COUNT_THEADSHOLD = 1.5;
	final static double FFT_WINDOWS_LEN = 1024;
	private int pulseCountAcc = 0;
	private double tempPulseLockVal = 0d;
	private final Handler mHandler = new Handler();
	private Runnable mTimer1;
	private Runnable mTimer2;
	private Runnable mTimer3;
	private GraphView graphView;
	private GraphViewSeries leadi; 
	private GraphViewSeries exampleSeries2;
	TextView heartrateLabel;
	Button plottingControl;
	private double XValue=0;
	private double YValue=0;
	private int heartRate = 0;
	private boolean isPlot = true;
	private boolean isPulseChecklock = false;
	int n = 0;
	
	static String[] signalDataArr;
	static String inputPath;
	
	InputStream inFile = null;
    String[] index = null;
    
    public void plottingControl(View view){
  		if(isPlot == true){
  			isPlot = false;
  			plottingControl.setText("Start");
  		}
  		else if(isPlot == false){
  			isPlot = true;
  			plottingControl.setText("Stop");
  		}
  		else{
  			isPlot = false;
  			plottingControl.setText("Start");
  		}
  	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.graph);
		
		Connect();	
	}

	private void Connect(){
		Button messageButton = (Button) findViewById(R.id.button1);
		messageButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Myocarditis.this, Bluetooth.class));
			}
		});
	
		inputPath = "Myocarditis Lead i.txt";
		InputStream input;
		AssetManager assetManager = getAssets();
		plottingControl = (Button) findViewById(R.id.StartStop);
		heartrateLabel = (TextView) findViewById(R.id.heartratetv);
		
	    try{
	    	input=assetManager.open(inputPath);
	    	int size =input.available();
	    	byte[] buffer = new byte [size];
	    	input.read(buffer);
	    	input.close();
	    	String text = new String(buffer);
	    	signalDataArr = text.split("\n");
	    }catch(Exception e){
	    	Log.d("specGram2", "Expection=" +e);
	    }
	    Log.d("audioBuf size","Expection= "+ signalDataArr.length);
		
    leadi = new GraphViewSeries(new GraphViewData[] {
			    new	GraphViewData (0, -1.0543d)
	});
	
    leadi.getStyle().color = Color.GREEN;
		 
	 graphView = new LineGraphView(
		      this // context
		      , "ECG" // heading
		); 
		
		graphView.addSeries(leadi); // data
		graphView.setViewPort(0, 3000);
	    graphView.setManualYAxisBounds(.253, -1.2);
		graphView.setHorizontalScrollBarEnabled(true);
		graphView.setScalable(true); 
		graphView.setScrollable(true);
		graphView.getGraphViewStyle().setVerticalLabelsColor(Color.GRAY);
		graphView.getGraphViewStyle().setHorizontalLabelsColor(Color.TRANSPARENT);
		LinearLayout layout = (LinearLayout) findViewById(R.id.graph1);
		layout.addView(graphView);
		
		exampleSeries2 = new GraphViewSeries(new GraphViewData[] {
			    new	GraphViewData (0, 3d)
	});
	
	exampleSeries2.getStyle().color = Color.GREEN;
		 
	 graphView = new LineGraphView(
		      this // context
		      , "ECG" // heading
		); 
		
		graphView.addSeries(exampleSeries2); // data
		graphView.setViewPort(0, 500);
		//graphView.setManualYAxisBounds(.399, -.625);
		graphView.setHorizontalScrollBarEnabled(true);
		graphView.setScalable(true); 
		graphView.setScrollable(true);
		graphView.getGraphViewStyle().setVerticalLabelsColor(Color.TRANSPARENT);
		graphView.getGraphViewStyle().setHorizontalLabelsColor(Color.TRANSPARENT);
		//layout = (LinearLayout) findViewById(R.id.graph2);
		layout.addView(graphView);
		
		runOnUiThread(new Runnable() {
			public void run() {
				heartrateLabel.setText(String.valueOf(heartRate));	
			}
			 });
	}
	
	@Override
	protected void onPause() {
		mHandler.removeCallbacks(mTimer1);
		mHandler.removeCallbacks(mTimer2);
		mHandler.removeCallbacks(mTimer3);
		super.onPause();
	}
	
	@Override
	protected void onResume() {
		super.onResume(); 
		mTimer1 = new Runnable() {
			@Override
			public void run() {
				if(isPlot == true){
				if((n < signalDataArr.length) && (n + PULSE_WIDTH < signalDataArr.length)){
					for (int k = 0; k < PULSE_WIDTH; k = k + 1){
						XValue += 1d;
						YValue = Double.parseDouble(signalDataArr[n+k]);
						leadi.appendData(new GraphViewData(XValue, YValue), true,230000);
						
						if((YValue >=PULSE_COUNT_THEADSHOLD) && (isPulseChecklock == false)){
							tempPulseLockVal = YValue;
							isPulseChecklock = true;
						}
						else if((YValue <= tempPulseLockVal) && (isPulseChecklock == true)){
							pulseCountAcc++;
							isPulseChecklock = false;
						}
						else{
						}
					}
					n = n + PULSE_WIDTH;	
				}
				else{
					n = 0;
				}
			}
				mHandler.postDelayed(this, 120);//speed (lower the faster)
			}
	};
		mHandler.postDelayed(mTimer1, 1); //timer to display top graph (larger the longer it takes)
	
		mTimer2 = new Runnable() {
			@Override
			public void run() {
				XValue += 1d;
				exampleSeries2.appendData(new GraphViewData (XValue,3d), true, 100);
				exampleSeries2.getStyle().color = Color.GREEN;
				mHandler.postDelayed(this, 800); //speed of bottom graph (lower the number the faster)
			}
		};
		mHandler.postDelayed(mTimer2, 1);
		
		mTimer3 = new Runnable() {	
		//@Override
		public void run() {
			if(isPlot == true){
				heartRate = pulseCountAcc * 6;
				heartrateLabel.setText(String.valueOf(heartRate));
				pulseCountAcc = 0;
			}
			else{	
			}
			mHandler.postDelayed(this, 9999999);
		}
	};
	mHandler.postDelayed(mTimer3, 9999999);
	}
 }
