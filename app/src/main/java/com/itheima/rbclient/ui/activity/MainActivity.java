package com.itheima.rbclient.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.itheima.rbclient.R;
import com.itheima.rbclient.ui.fragment.BaseFragment;
import com.itheima.rbclient.ui.fragment.BrandFragment;
import com.itheima.rbclient.ui.fragment.CartFragment;
import com.itheima.rbclient.ui.fragment.HomeFragment;
import com.itheima.rbclient.ui.fragment.MoreFragment;
import com.itheima.rbclient.ui.fragment.SearchFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity implements OnCheckedChangeListener {

    RadioGroup mRadioGroup;
    ViewPager mainViewPager;

    private List<BaseFragment> mFragments = new ArrayList<BaseFragment>();
    private Button mTarget;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mRadioGroup = (RadioGroup) findViewById(R.id.rg_content_fragment);
        mTarget = (Button) findViewById(R.id.btn);

//声明初始化badgeview




        mainViewPager = (ViewPager) findViewById(R.id.main_vp);
    }

    @Override
    protected void initListener() {
        mRadioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    protected void initData() {
        mFragments.add(new HomeFragment(mTarget));
        mFragments.add(new SearchFragment());
        mFragments.add(new BrandFragment());
        mFragments.add(new CartFragment());
        mFragments.add(new MoreFragment());

        mainViewPager.setAdapter(new MainFragmentAdapter(getSupportFragmentManager()));


    }

    public class MainFragmentAdapter extends FragmentPagerAdapter {

        public MainFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId) {
            case R.id.rb_content_fragment_home:

                break;
            case R.id.rb_content_fragment_search:

                break;
            case R.id.rb_content_fragment_brand:

                break;
            case R.id.rb_content_fragment_shopping:

                break;
            case R.id.rb_content_fragment_more:

                break;
            default:
                break;
        }
    }



}
