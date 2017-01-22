package com.itheima.rbclient.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itheima.rbclient.App;
import com.itheima.rbclient.R;
import com.itheima.rbclient.RBConstants;
import com.itheima.rbclient.ui.domain.Topic;

import org.senydevpkg.base.AbsBaseAdapter;
import org.senydevpkg.base.BaseHolder;
import org.senydevpkg.net.HttpLoader;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TopicAdapter extends AbsBaseAdapter<Topic.TopicBean> {

    /**
     * 接收AbsListView要显示的数据
     *
     * @param data 要显示的数据
     */
    public TopicAdapter(List<Topic.TopicBean> data) {
        super(data);
    }

    @Override
    protected BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TopicHolder(App.context);
    }

    public class TopicHolder extends BaseHolder<Topic.TopicBean> {
        @Bind(R.id.iv)
        ImageView mIv;
        @Bind(R.id.tv)
        TextView mTv;

        public TopicHolder(Context context) {
            super(context);
        }

        @Override
        protected View initView() {
            View view = View.inflate(App.context, R.layout.item_brand, null);
            ButterKnife.bind(this, view);
            return view;
        }

        @Override
        public void bindData(Topic.TopicBean data) {
            mTv.setText(data.name);
            HttpLoader.getInstance(App.context).display(mIv, RBConstants.SERVER_URL+data.pic);
        }
    }
}
