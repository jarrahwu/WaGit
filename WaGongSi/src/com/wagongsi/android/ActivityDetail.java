package com.wagongsi.android;

import java.io.Serializable;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.wagongsi.android.bean.CompanyInfoBean;
import com.wagongsi.android.core.BaseActionBarActivity;
import com.wagongsi.android.core.BindView;
import com.wagongsi.android.core.BindableView;
import com.wagongsi.android.view.CpItemView;

public class ActivityDetail extends BaseActionBarActivity{
	
	private static final String KEY_DETAIL = "cp_detail";
	
	@BindView(id = R.id.cpInfo)
	private CpItemView mCpInfo;

	private CompanyInfoBean mBean;
	
//	private NetworkListView<View, DT>
	
	@Override
	protected int onLoadViewResource() {
		return R.layout.activity_detail;
	}

	@Override
	protected void onViewDidLoad(Bundle savedInstanceState) {
		mBean = getBean();
		if (mBean != null) {
			mCpInfo.setData(mBean);
		}
	}
	
	private CompanyInfoBean getBean() {
		Serializable cpBean = getIntent().getSerializableExtra(KEY_DETAIL);
		if (cpBean == null) {
			Log.e(KEY_DETAIL, "cp bean is null");
			return null;
		}
		return (CompanyInfoBean) cpBean;
	}
	
	public static class CommentItem extends BindableView {

		@BindView(id = R.id.content)
		TextView content;
		
		@BindView(id = R.id.floorNum)
		TextView floorNum;
		
		public CommentItem(Context context) {
			super(context);
		}

		@Override
		public void onViewDidLoad() {
			
		}

		@Override
		public int onLoadViewResource() {
			return R.layout.view_comment_item;
		}
		
	}
	

	public static void start(Activity activity, CompanyInfoBean data) {
		Intent i = new Intent();
		i.setClass(activity, ActivityDetail.class);
		i.putExtra(KEY_DETAIL, data);
		activity.startActivity(i);
	}

}
