package com.wagongsi.android;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import com.wagongsi.android.core.BindView;
import com.wagongsi.android.view.TextPagerIndicator;
import com.wagongsi.android.view.TextPagerIndicator.OnItemClickListener;

public class FragmentHome extends TabFragment implements OnPageChangeListener{
	
	
	private static final String[] TITLES = {"最新", "最热"};
	@BindView(id = R.id.textIndicator)
	private TextPagerIndicator mIndicator;
	
	@BindView(id = R.id.pager)
	private ViewPager mViewPager;
	
	private Adapter mAdapter;
	
	@Override
	protected int onLoadViewResource() {
		return R.layout.fragment_home;
	}
	
	@Override
	protected void onViewDidLoad(Bundle savedInstanceState) {
		super.onViewDidLoad(savedInstanceState);
		initIndicator();
		mAdapter = new Adapter(getFragmentManager());
		mViewPager.setAdapter(mAdapter);
		mViewPager.setOnPageChangeListener(this);
	}

	public void initIndicator() {
		mIndicator.initIndicator(2, TITLES,  R.drawable.ic_tab_normal, R.drawable.ic_tab_selected);
		mIndicator.setOnItemClickListener(new OnItemClickListener() {
			
			public void onItemClick(int index) {
				mIndicator.selectItem(index);
				mViewPager.setCurrentItem(index);
			}
		});
		mIndicator.selectItem(0);
	}
	

	public static TabFragment newInstance(Bundle arg) {
		FragmentHome f = new FragmentHome();
		f.setArguments(arg);
		return f;
	}

	@Override
	public String getTitle() {
		return "首页";
	}
	
	public static class Adapter extends FragmentPagerAdapter {

		private static final int TAB_COUNT = 2;

		public Adapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int arg0) {
			return TabFragmentFactory.createHomeTab(arg0, null);
		}

		@Override
		public int getCount() {
			return TAB_COUNT;
		}
		
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int arg0) {
		mIndicator.selectItem(arg0);
	}

}
