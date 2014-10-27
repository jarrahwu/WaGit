package com.wagongsi.android;

import java.util.ArrayList;

import com.wagongsi.android.bean.LinkBean;


import android.widget.Toast;

public class Util {

	public static void toast(Object text) {
		Toast.makeText(Application.getInstance().getApplicationContext(),
				text.toString(), Toast.LENGTH_SHORT).show();
	}
	
	public static String getHrefByRel(String rel, ArrayList<LinkBean> links) {
		String href = null;
		
		if (links != null) {
			for (int i = 0; i < links.size(); i++) {
				LinkBean lb = links.get(i);
				if (lb.getRel().equals(rel)) {
					href = lb.getHref();
					break;
				}
			}
		}
		return href;
	}
}
