package com.wagongsi.android;

import android.os.Bundle;

public class FragmentHot extends TabFragment{
	
	public FragmentHot() {}
	
	@Override
	public String getTitle() {
		return "最热";
	}

	@Override
	protected int onLoadViewResource() {
		return R.layout.fragment_hot;
	}

	public static TabFragment newInstance(Bundle arg) {
		FragmentHot f = new FragmentHot();
		f.setArguments(arg);
		return f;
	}

}
