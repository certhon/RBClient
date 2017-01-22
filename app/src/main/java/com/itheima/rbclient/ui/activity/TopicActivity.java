package com.itheima.rbclient.ui.activity;

import android.widget.ListView;

import com.android.volley.VolleyError;
import com.itheima.rbclient.App;
import com.itheima.rbclient.R;
import com.itheima.rbclient.RBConstants;
import com.itheima.rbclient.adapter.TopicAdapter;
import com.itheima.rbclient.ui.domain.Topic;

import org.senydevpkg.net.HttpLoader;
import org.senydevpkg.net.HttpParams;
import org.senydevpkg.view.LoadStateLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TopicActivity extends BaseActivity implements HttpLoader.HttpListener<Topic> {

    @Bind(R.id.topic_listview)
    ListView mTopicListview;
    @Bind(R.id.topic_statelayout)
    LoadStateLayout mTopicStatelayout;
    private TopicAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_topic;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        mTopicStatelayout.setEmptyView(R.layout.stateview_empty);
        mTopicStatelayout.setErrorView(R.layout.stateview_error);
        mTopicStatelayout.setLoadingView(R.layout.stateview_loading);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
       mTopicStatelayout.setState(LoadStateLayout.STATE_LOADING);
        String url = RBConstants.URL_TOPIC;
        HttpParams params = new HttpParams();
        params.put("page", "1");
        params.put("pageNum", "8");
        Class clazz = Topic.class;
        final int requestCode = RBConstants.TOPIC_REQUEST_CODE;
        final HttpLoader.HttpListener listener = this;
        HttpLoader.getInstance(App.context).post(url, params, clazz, requestCode, listener);
    }


    @Override
    public void onGetResponseSuccess(int requestCode, Topic response) {
        if (response != null) {
            if (mAdapter == null) {
                mAdapter = new TopicAdapter(response.topic);
                mTopicListview.setAdapter(mAdapter);
                mTopicStatelayout.setState(LoadStateLayout.STATE_SUCCESS);
            } else {
                mAdapter.notifyDataSetChanged();
                mTopicStatelayout.setState(LoadStateLayout.STATE_EMPTY);
            }
        }
    }

    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        mTopicStatelayout.setState(LoadStateLayout.STATE_ERROR);
    }
}
