package com.wagongsi.android;

import android.os.Bundle;

public class FragmentCreateCp extends TabFragment{

	@Override
	public String getTitle() {
		return "立即开公司";
	}

	@Override
	protected int onLoadViewResource() {
		return R.layout.fragment_create_cp;
	}

	public static TabFragment newInstance(Bundle arg) {
		FragmentCreateCp f = new FragmentCreateCp();
		f.setArguments(arg);
		return f;
	}

}
