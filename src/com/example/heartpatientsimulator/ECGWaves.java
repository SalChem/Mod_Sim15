package com.example.heartpatientsimulator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.support.v4.app.ListFragment;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class ECGWaves extends ListFragment {

	String[] waves = {"Healthy", "Bundle Branch Block", "Cardiomyopathy", "Ventricular Fibrillation", "Atrial Fibrillation", "Hypertrophy", "Myocardial Infarction", "Myocarditis", "Unstable Angina", "Valvular Heart Disease","Ventricular Tachycardia"};

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
	} 
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, waves));
		ListView list = getListView();
		list.setTextFilterEnabled(true);
		list.setOnItemClickListener(new OnItemClickListener() {

		        @Override
		        public void onItemClick(AdapterView<?> arg0, View view, int arg1, long arg2) {
		            switch (arg1) {
		            case 0:
		                Intent myIntent0 = new Intent(view.getContext(), Healthy.class);
		                startActivityForResult(myIntent0, 0);
		                break;
		            case 1:
		                Intent myIntent1 = new Intent(view.getContext(), BundleBranchBlock.class);
		                startActivityForResult(myIntent1, 0);
		                break;
		            case 2:
		                Intent myIntent2 = new Intent(view.getContext(), Cardiomyopathy.class);
		                startActivityForResult(myIntent2, 0);
		                break;
		            case 3:
		                Intent myIntent3 = new Intent(view.getContext(), VentricularFibrillation.class);
		                startActivityForResult(myIntent3, 0);
		                break;
		            case 4:
		                Intent myIntent4 = new Intent(view.getContext(), AtrialFibrillation.class);
		                startActivityForResult(myIntent4, 0);
		                break;
		            case 5:
		                Intent myIntent5 = new Intent(view.getContext(), Hypertrophy.class);
		                startActivityForResult(myIntent5, 0);
		                break;
		            case 6:
		                Intent myIntent6 = new Intent(view.getContext(), MyocardialInfarction.class);
		                startActivityForResult(myIntent6, 0);
		                break;
		            case 7:
		                Intent myIntent7 = new Intent(view.getContext(), Myocarditis.class);
		                startActivityForResult(myIntent7, 0);
		                break;
		            case 8:
		                Intent myIntent8 = new Intent(view.getContext(), UnstableAngina.class);
		                startActivityForResult(myIntent8, 0);
		                break;
		            case 9:
		                Intent myIntent9 = new Intent(view.getContext(), ValvularHeartDisease.class);
		                startActivityForResult(myIntent9, 0);
		                break;
		            case 10:
		                Intent myIntent10 = new Intent(view.getContext(), VentricularTachycardia.class);
		                startActivityForResult(myIntent10, 0);
		                break;
		            }
		        }
		        });
		    }
		
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	
		return inflater
				.inflate(R.layout.ecg_waves, container, false);
	}

}
