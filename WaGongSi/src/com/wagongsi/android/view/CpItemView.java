package com.wagongsi.android.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.wagongsi.android.R;
import com.wagongsi.android.bean.CompanyInfoBean;

public class CpItemView extends FrameLayout {

	private Context mContext;

	private TextView mCpName, mPrjDesc, mDreamingBg, mCommentCount, mLikeCount;

	private Button mLikeButton;

	public CpItemView(Context context) {
		super(context);
		init(context);
	}

	public CpItemView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	private void init(Context context) {
		mContext = context;
		LayoutInflater inflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.view_cp_info, this, true);
		setupViews();
	}

	private void setupViews() {
		mCpName = (TextView) findViewById(R.id.cpName);
		mPrjDesc = (TextView) findViewById(R.id.cpPrjDesc);
		mDreamingBg = (TextView) findViewById(R.id.cpDreamBg);
		mCommentCount = (TextView) findViewById(R.id.cpCommentCount);
		mLikeCount = (TextView) findViewById(R.id.cpLikeCount);
		mLikeButton = (Button) findViewById(R.id.btnLike);
		mLikeButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			}
		});
	}

	public void setData(CompanyInfoBean data) {
		if (data != null) {
			mCpName.setText(data.getCompanyName());
			mPrjDesc.setText(data.getProjectDescription());
			mDreamingBg.setText(data.getDreamingBackground());
			mCommentCount.setText("" + data.getCommentCount());
			mLikeCount.setText("" + data.getLikeCount());
		}
	}
}
