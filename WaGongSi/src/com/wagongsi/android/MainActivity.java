package com.wagongsi.android;

import com.wagongsi.android.core.BaseActionBarActivity;
import com.wagongsi.android.core.BindView;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends BaseActionBarActivity{
	
	private static final int FIRST_TAB = R.id.tab0;
	
	@BindView(id = R.id.bottomTabBar)
	private RadioGroup mBottomTabBar;
	
	private TabFragment[] mTabFragments;
	private TabFragment mLastShowing;
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected int onLoadViewResource() {
		return R.layout.activity_main;
	}

	@Override
	protected void onViewDidLoad(Bundle savedInstanceState) {
		initFragments();
		initButtomBar();
		switchFragment(FIRST_TAB);
	}
	
	private void initButtomBar() {
		mBottomTabBar.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switchFragment(checkedId);
			}
		});
	}
	
	private void switchFragment(int tabId) {
		final int fragmentIndex = tabId - FIRST_TAB;

		final TabFragment f = mTabFragments[fragmentIndex];

		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction trans = fm.beginTransaction();

		if (mLastShowing != null) {
			trans.hide(mLastShowing);
		}

		trans.show(f);
		mLastShowing = f;
		trans.commit();
	}
	
	private void initFragments() {
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction trs = fm.beginTransaction();
		int length = 3;
		if (mTabFragments == null) {
			mTabFragments = new TabFragment[length];
			for (int i = 0; i < length; i++) {
				mTabFragments[i] = TabFragmentFactory.createMain(i, null);
				trs.add(R.id.container, mTabFragments[i], "" + i);
				trs.hide(mTabFragments[i]);
			}
		}
		trs.commit();
	}

}
