package com.itheima.rbclient.ui.activity;

import android.widget.ListView;

import com.android.volley.VolleyError;
import com.itheima.rbclient.R;
import com.itheima.rbclient.RBConstants;
import com.itheima.rbclient.adapter.TopicAdapter;
import com.itheima.rbclient.ui.domain.Topic;
import com.itheima.rbclient.util.NetUtil;

import org.senydevpkg.net.HttpLoader;
import org.senydevpkg.net.HttpParams;
import org.senydevpkg.view.LoadStateLayout;

public class TopicActivityBackUp extends BaseActivity implements HttpLoader.HttpListener<Topic> {

    private ListView mListView;
    private LoadStateLayout mLoadStateLayout;
    private TopicAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_topic;
    }

    @Override
    protected void initView() {
        mListView = (ListView) findViewById(R.id.topic_listview);
        mLoadStateLayout = (LoadStateLayout) findViewById(R.id.topic_statelayout);
        mLoadStateLayout.setEmptyView(R.layout.stateview_empty);
        mLoadStateLayout.setErrorView(R.layout.stateview_error);
        mLoadStateLayout.setLoadingView(R.layout.stateview_loading);

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        mLoadStateLayout.setState(LoadStateLayout.STATE_LOADING);
        HttpParams params = new HttpParams();
        params.addHeader(NetUtil.generateHeaders(this));
        params.put("page","1");
        params.put("pageNum","8");
        HttpLoader.getInstance(this).get(RBConstants.URL_TOPIC,params, Topic.class,RBConstants.TOPIC_REQUEST_CODE,this);
    }

    @Override
    public void onGetResponseSuccess(int requestCode, Topic response) {
        if(response != null) {
            if(adapter == null) {
                adapter = new TopicAdapter(response.topic);
                mListView.setAdapter(adapter);
            }else {
                adapter.notifyDataSetChanged(response.topic);
            }
            mLoadStateLayout.setState(LoadStateLayout.STATE_SUCCESS);
        }else {
            mLoadStateLayout.setState(LoadStateLayout.STATE_EMPTY);
        }


    }

    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        mLoadStateLayout.setState(LoadStateLayout.STATE_ERROR);
    }
}
