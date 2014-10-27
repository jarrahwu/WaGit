package com.wagongsi.android;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ActivityCpDetail extends ActivityBase{

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.activity_cp_detail, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.abuse) {
			System.out.println("举报...");
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
