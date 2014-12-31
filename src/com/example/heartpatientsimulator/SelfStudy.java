package com.example.heartpatientsimulator;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

public class SelfStudy extends FragmentActivity implements TabListener {

	ViewPager viewPager;
	ActionBar actionBar;
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.self_study);
		
		viewPager=(ViewPager) findViewById(R.id.pager);
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				actionBar.setSelectedNavigationItem(arg0);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
		actionBar=getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		ActionBar.Tab tab1=actionBar.newTab();
		tab1.setText("Reading on Heart Disorder"); 
		tab1.setTabListener(this);
		
		ActionBar.Tab tab2=actionBar.newTab();
		tab2.setText("ECG Waves"); 
		tab2.setTabListener(this);
		
		//ActionBar.Tab tab3=actionBar.newTab();
		//tab3.setText("Professor"); 
		//tab3.setTabListener(this);
		
		actionBar.addTab(tab1);
		actionBar.addTab(tab2);
		//actionBar.addTab(tab3);
		
	}
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		viewPager.setCurrentItem(tab.getPosition());
	}
	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
}

class MyAdapter extends FragmentPagerAdapter
{

	public MyAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		Fragment fragment=null;
		if(arg0==0)
		{
			fragment=new Reading();
		}
		if(arg0==1)
		{
			fragment=new ECGWaves();
		}
		/*if(arg0==2)
		{
			fragment=new Professor();
		}*/
		return fragment;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 2;
	}
	
}