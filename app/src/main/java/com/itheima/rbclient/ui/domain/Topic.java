package com.itheima.rbclient.ui.domain;

import java.util.List;

public class Topic {

    public String response;
    public List<TopicBean> topic;

    public static class TopicBean {
        public int id;
        public String name;
        public String pic;
    }
}
