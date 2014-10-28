package com.wagongsi.android;

import android.os.Bundle;

public class FragmentMe extends TabFragment{

	@Override
	public String getTitle() {
		return "我";
	}

	@Override
	protected int onLoadViewResource() {
		return R.layout.fragment_me;
	}

	public static TabFragment newInstance(Bundle arg) {
		FragmentMe f = new FragmentMe();
		f.setArguments(arg);
		return f;
	}

}
