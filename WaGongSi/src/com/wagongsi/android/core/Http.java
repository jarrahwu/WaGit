package com.wagongsi.android.core;

import com.android.volley.RequestQueue;
import com.wagongsi.android.Application;

public class Http extends AbstractHttp<Http> {

	public Http() {

	}

	public Http(String cancelTag) {
		requestTag(cancelTag);
	}

	@Override
	public RequestQueue getQueue() {
		return Application.getInstance().getRequestQueue();
	}
}
