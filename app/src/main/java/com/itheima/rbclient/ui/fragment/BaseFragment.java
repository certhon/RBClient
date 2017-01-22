package com.itheima.rbclient.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.senydevpkg.utils.ALog;


public abstract class BaseFragment extends Fragment {
	
	protected Context mContext;
	protected View mViewRoot;

	private boolean isInit;


	@Override
	public void onAttach(Context context) {
		super.onAttach(context);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		//判断为空，为空就去加载布局，onCreateView在界面切换的时候会被多次调用,防止界面跳转回来的时候显示空白
		if (mViewRoot==null) {
			ALog.d("onCreateView:"+this.getClass().getSimpleName());
			mViewRoot = inflater.inflate(getLayoutId(),null);
			initView();
			initListener();
			if(!isInit) {
				ALog.d("init data:"+this.getClass().getSimpleName());
				initData();
				isInit = true;
			}
		}

		return mViewRoot;
	}

	protected abstract int getLayoutId();

	protected abstract void initView() ;

	protected abstract void initListener();

	protected abstract void initData() ;


	
	
	//当前的界面被切换出去的时候被调用,解决ViewGroup只有一个子View的bug
	@Override
	public void onDestroyView() {
		ALog.d("onDestroyView:"+this.getClass().getSimpleName());
		super.onDestroyView();

		if (mViewRoot!=null) {
			ViewParent parent = mViewRoot.getParent();
			if (parent instanceof ViewGroup) {
				ViewGroup viewGroup = (ViewGroup) parent;
				viewGroup.removeView(mViewRoot);
			}
		}
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}



}
