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

public class TopicAdapterBackup extends AbsBaseAdapter<Topic.TopicBean> {
    /**
     * 接收AbsListView要显示的数据
     *
     * @param data 要显示的数据
     */
    public TopicAdapterBackup(List<Topic.TopicBean> data) {
        super(data);
    }

    @Override
    protected BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(App.context);
    }


    static class ViewHolder extends BaseHolder<Topic.TopicBean> {

        private TextView tv;
        private ImageView iv;

        public ViewHolder(Context context) {
            super(context);
        }

        @Override
        protected View initView() {
            View view = View.inflate(getContext(), R.layout.item_brand, null);
            tv = (TextView) view.findViewById(R.id.tv);
            iv = (ImageView) view.findViewById(R.id.iv);
            return view;
        }

        @Override
        public void bindData(Topic.TopicBean data) {
            tv.setText(data.name);
            //  picasso glide UIL fresco

            HttpLoader.getInstance(getContext()).display(iv, RBConstants.SERVER_URL+data.pic);



        }
    }
}
