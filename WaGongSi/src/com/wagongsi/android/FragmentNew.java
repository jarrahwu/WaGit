package com.wagongsi.android;

import java.util.ArrayList;

import org.json.JSONObject;

import com.wagongsi.android.bean.CompanyInfoBean;
import com.wagongsi.android.core.AbsWorker.AbsLoader;
import com.wagongsi.android.core.ArrayResponse;
import com.wagongsi.android.core.BindView;
import com.wagongsi.android.core.BindableFragment;
import com.wagongsi.android.core.NetworkListView;
import com.wagongsi.android.core.Constant.Home;
import com.wagongsi.android.view.CpItemView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class FragmentNew extends TabFragment implements Home{
	
	@BindView(id = R.id.infoList)
	private NetworkListView<CpItemView, CompanyInfoBean> mListView;
	
	private AbsLoader<CpItemView, CompanyInfoBean> mLoader;
	
	
	public FragmentNew() {}
	
	@Override
	protected int onLoadViewResource() {
		return R.layout.fragment_new;
	}

	@Override
	protected void onViewDidLoad(Bundle savedInstanceState) {
		super.onViewDidLoad(savedInstanceState);
		mLoader = new AbsLoader<CpItemView, CompanyInfoBean>() {

			@Override
			public String parseNextUrl(JSONObject response) {
				ArrayResponse ar = JacksonWrapper.json2Bean(response, ArrayResponse.class);
				if (ar != null) {
					return Util.getHrefByRel("next", ar.getLinks());
				}else {
					Util.toast("数据解析出错了");
					return null;
				}
			}

			@Override
			public ArrayList<CompanyInfoBean> parseJSON2ArrayList(
					JSONObject response) {
				ArrayResponse ar = JacksonWrapper.json2Bean(response, ArrayResponse.class);
				if (ar != null) {
					return ar.getItems();
				}else {
					Util.toast("数据解析出错了");
					return null;
				}
				
			}

			@Override
			public void updateItemUI(int position, final CompanyInfoBean data,
					CpItemView itemView) {
				itemView.setData(data);
				itemView.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						ActivityDetail.start(getActivity(), data);
					}
				});
			}

			@Override
			public CpItemView makeItem(LayoutInflater inflater, int position,
					View convertView, ViewGroup parent) {
				return new CpItemView(getActivity());
			}
		};
		mListView.request(URL, mLoader);
	}

	@Override
	public String getTitle() {
		return "最新";
	}

	public static TabFragment newInstance(Bundle arg) {
		FragmentNew f = new FragmentNew();
		f.setArguments(arg);
		return f;
	}
}
