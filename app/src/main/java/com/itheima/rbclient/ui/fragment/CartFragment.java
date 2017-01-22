package com.itheima.rbclient.ui.fragment;

import android.widget.RadioButton;

import com.itheima.rbclient.R;


public class CartFragment extends BaseFragment {
	public CartFragment(){};

	private RadioButton mTarget;

	public CartFragment(RadioButton target) {
		mTarget = target;

	}

	@Override
	protected int getLayoutId() {
		return R.layout.fragment_cart;
	}

	@Override
	protected void initView() {

	}

	@Override
	protected void initListener() {

	}

	@Override
	protected void initData() {

	}
}
