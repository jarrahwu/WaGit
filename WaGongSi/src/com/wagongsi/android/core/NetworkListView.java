package com.wagongsi.android.core;

import java.util.ArrayList;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.wagongsi.android.core.AbsWorker.AbsLoader;
import com.wagongsi.android.core.Constant.Debug;

public class NetworkListView<V extends View, DT> extends PullToRefreshListView
		implements Debug {

	private AbsWorker<V, ListView, DT> mWorker;

	public NetworkListView(Context context) {
		super(context);
		init();
	}

	public NetworkListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	private void init() {
		mWorker = new AbsWorker<V, ListView, DT>(getContext(), this);
		setShowIndicator(false);
	}

	@Override
	protected void onDetachedFromWindow() {
		super.onDetachedFromWindow();
		mWorker.cancelRequest();
	}

	public void request(String url, AbsLoader<V, DT> loader) {
		mWorker.request(url, loader);
	}
	
	public void setLoader(AbsLoader<V, DT> loader) {
		mWorker.setLoader(loader);
	}
	
	public void setUrl(String url) {
		mWorker.setRequestUrl(url);
	} 
	
	public void request() {
		mWorker.request();
	}
	
	public void setAdapterData(ArrayList<DT> data, boolean isLoadMore) {
		mWorker.setAdapterData(data, isLoadMore);
	}
	
	public void notifyDataSetChanged() {
		mWorker.notifyDataSetChanged();
	}
}
