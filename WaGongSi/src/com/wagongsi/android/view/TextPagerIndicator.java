package com.wagongsi.android.view;

import com.wagongsi.android.core.DensityUtil;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TextPagerIndicator extends FrameLayout implements OnClickListener {

	private static final float ITEM_PADDING = 4.0f;

	/**
	 * 小点点的总容器
	 */
	private LinearLayout mLinearLayout;

	private TextView mPreviousItem;

	private int mResNormal;

	private int mResSelected;

	private Context mContext;

	private OnItemClickListener mOnItemClickListener;

	public TextPagerIndicator(Context context) {
		super(context);
		init(context);
	}

	public TextPagerIndicator(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	private void init(Context context) {
		mContext = context;
		setupViews();
	}

	public void setupViews() {
		mLinearLayout = new LinearLayout(mContext);
		FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
				FrameLayout.LayoutParams.MATCH_PARENT,
				FrameLayout.LayoutParams.MATCH_PARENT, Gravity.CENTER);
		mLinearLayout.setLayoutParams(params);
		mLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
		addView(mLinearLayout);
	}

	public void initIndicator(int num, String[] strs, int resNormal, int resSelected) {
		mResNormal = resNormal;
		mResSelected = resSelected;
		for (int i = 0; i < num; i++) {
			if (i == 0) {
				mPreviousItem = getItem(strs[i], mResSelected, i);
				mLinearLayout.addView(mPreviousItem);
			} else {
				mLinearLayout.addView(getItem(strs[i], mResNormal, i));
			}
		}
	}

	public TextView getItem(String str, int res, int index) {
		TextView tv = new TextView(mContext);
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
		tv.setLayoutParams(lp);
		tv.setGravity(Gravity.CENTER);
		tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, res);
		int padding = (int) DensityUtil.dp2px(ITEM_PADDING);
		tv.setPadding(padding, 0, padding, 0);
		tv.setText(str);
		
		tv.setId(index);
		tv.setOnClickListener(this);
		return tv;
	}

	public void selectItem(int index) {
		if (mPreviousItem == getItem(index)) {
			return;
		} else {
			mPreviousItem.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,
					mResNormal);
			TextView select = getItem(index);
			select.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,
					mResSelected);
			mPreviousItem = select;
		}
	}

	public TextView getItem(int index) {
		return (TextView) mLinearLayout.getChildAt(index);
	}

	@Override
	public void onClick(View v) {
		if(mOnItemClickListener != null) {
			mOnItemClickListener.onItemClick(v.getId());
		}
	}
	
	public static interface OnItemClickListener {
		/**
		 * 当pager ITEM 被点击的时候回调
		 * @param index
		 */
		void onItemClick(int index);
	}
	
	public void setOnItemClickListener(OnItemClickListener l) {
		mOnItemClickListener = l;
	}

}
