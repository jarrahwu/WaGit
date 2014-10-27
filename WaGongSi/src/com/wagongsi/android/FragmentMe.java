package com.wagongsi.android;

import java.util.ArrayList;

import com.wagongsi.android.core.BaseAdapter;
import com.wagongsi.android.core.BindView;
import com.wagongsi.android.core.BindableView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class FragmentMe extends TabFragment {

	@BindView(id = R.id.meList)
	private ListView mListView;

	private Adapter mAdapter;

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

	@Override
	protected void onViewDidLoad(Bundle savedInstanceState) {
		super.onViewDidLoad(savedInstanceState);
		mAdapter = new Adapter(getActivity());
		mListView.setAdapter(mAdapter);
		mAdapter.setData(getMeLabels());
	}

	private ArrayList<Item> getMeLabels() {
		String[] labels = getResources().getStringArray(R.array.meLabels);
		ArrayList<Item> ret = new ArrayList<Item>();
		for (int i = 0; i < labels.length; i++) {
			ret.add(new Item(labels[i]));
		}
		return ret;
	}

	public static class Adapter extends BaseAdapter<Item, ItemView> {

		public Adapter(Context context) {
			super(context);
		}

		@Override
		public void onDispatchData(int position, Item data, ItemView itemView) {
			itemView.name.setText(data.name);
		}

		@Override
		public ItemView newView(LayoutInflater inflater, int position,
				View convertView, ViewGroup parent) {
			return new ItemView(getContext());
		}
	}

	public static class Item {

		public Item(String name) {
			this.name = name;
		}

		String name;
	}

	public static class ItemView extends BindableView {

		@BindView(id = R.id.name)
		TextView name;

		@BindView(id = R.id.extra)
		TextView extra;

		public ItemView(Context context) {
			super(context);
		}

		@Override
		public void onViewDidLoad() {

		}

		@Override
		public int onLoadViewResource() {
			return R.layout.view_me_item;
		}

	}

}
