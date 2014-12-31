package com.example.heartpatientsimulator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Reading extends ListFragment {
		
		String[] reading = {"Backround Infomation","Healthy", "Bundle Branch Block", "Cardiomyopathy", "Ventricular Fibrillation", "Atrial Fibrillation", "Hypertrophy", "Myocardial Infarction", "Myocarditis", "Unstable Angina", "Valvular Heart Disease","Ventricular Tachycardia"};
	
		@Override
		public void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanceState);
		}
		
		@Override
		public void onActivityCreated(Bundle savedInstanceState){
			super.onActivityCreated(savedInstanceState);
			setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, reading));
			ListView list = getListView();
			list.setTextFilterEnabled(true);
			list.setOnItemClickListener(new OnItemClickListener() {

			        @Override
			        public void onItemClick(AdapterView<?> arg0, View view, int arg1, long arg2) {
			            switch (arg1) {
			            case 0:
			                Intent myIntent0 = new Intent(view.getContext(), BackgroundInfo.class);
			                startActivityForResult(myIntent0, 0);
			                break;
			            case 1:
			                Intent myIntent1 = new Intent(view.getContext(), ReadingHealthy.class);
			                startActivityForResult(myIntent1, 0);
			                break;
			            case 2:
			                Intent myIntent2 = new Intent(view.getContext(), ReadingBundleBranchBlock.class);
			                startActivityForResult(myIntent2, 0);
			                break;
			            case 3:
			                Intent myIntent3 = new Intent(view.getContext(), ReadingCardiomyopathy.class);
			                startActivityForResult(myIntent3, 0);
			                break;
			            case 4:
			                Intent myIntent4 = new Intent(view.getContext(), ReadingVentricularFibrillation.class);
			                startActivityForResult(myIntent4, 0);
			                break;
			            case 5:
			                Intent myIntent5 = new Intent(view.getContext(), ReadingAtrialFibrillation.class);
			                startActivityForResult(myIntent5, 0);
			                break;
			            case 6:
			                Intent myIntent6 = new Intent(view.getContext(), ReadingHypertrophy.class);
			                startActivityForResult(myIntent6, 0);
			                break;
			            case 7:
			                Intent myIntent7 = new Intent(view.getContext(), ReadingMyocardialInfarction.class);
			                startActivityForResult(myIntent7, 0);
			                break;
			            case 8:
			                Intent myIntent8 = new Intent(view.getContext(), ReadingMyocarditis.class);
			                startActivityForResult(myIntent8, 0);
			                break;
			            case 9:
			                Intent myIntent9 = new Intent(view.getContext(), ReadingUnstableAngina.class);
			                startActivityForResult(myIntent9, 0);
			                break;
			            case 10:
			                Intent myIntent10 = new Intent(view.getContext(), ReadingValvularHeartDisease.class);
			                startActivityForResult(myIntent10, 0);
			                break;
			            case 11:
			                Intent myIntent11 = new Intent(view.getContext(), ReadingVentricularTachycardia.class);
			                startActivityForResult(myIntent11, 0);
			                break;
			            }
			        }
			        });
			    }
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		return inflater.inflate(R.layout.reading, container, false);
		
	}
	
}