package com.wagongsi.android;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class TabFragmentFactory {

	public TabFragmentFactory() {
	}

	public static TabFragment createMain(int tabIndex, Bundle arg) {
		TabFragment tab = null;
		switch (tabIndex) {
		case 0:
			tab = FragmentHome.newInstance(arg);
			break;
		case 1:
			tab = FragmentCreateCp.newInstance(arg);
			break;
		case 2:
			tab = FragmentMe.newInstance(arg);
			break;
		default:
			break;
		}
		return tab;
	}

	public static Fragment createHomeTab(int tabIndex, Bundle arg) {
		TabFragment tab = null;
		switch (tabIndex) {
		case 0:
			tab = FragmentNew.newInstance(arg);
			break;
		case 1:
			tab = FragmentHot.newInstance(arg);
			break;
		default:
			break;
		}
		return tab;
	}
	
}
