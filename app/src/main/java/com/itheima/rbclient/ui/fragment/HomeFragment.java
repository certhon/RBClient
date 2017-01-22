package com.itheima.rbclient.ui.fragment;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.itheima.rbclient.R;
import com.jauker.widget.BadgeView;


public class HomeFragment extends BaseFragment {


    private Button bt;
    private Button mTarget;

    public HomeFragment(Button target) {
        super();
        mTarget = target;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {

        bt = (Button) mViewRoot.findViewById(R.id.btn_home_topic);

    }

    @Override
    protected void initListener() {
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BadgeView bv = new BadgeView(getContext());
                bv.setTargetView(bt);
                bv.setText("9+");

                bv.setTextColor(Color.RED);
                bv.setBadgeGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);
                bv.setTextSize(10);
            }
        });
    }

    @Override
    protected void initData() {

        BadgeView bv = new BadgeView(getContext());
        bv.setTargetView(mTarget);
        bv.setText("9");
        bv.setTextColor(Color.RED);
        mTarget.setBackgroundColor(getResources().getColor(R.color.transparent));
      //  bv.setBadgeGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);
        bv.setTextSize(10);

    }
    

}
