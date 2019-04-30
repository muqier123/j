package com.example.chouqu.bean;

import java.util.List;

public class ShujuBean {

    /**
     * code : 200
     * message : 成功!
     * result : [{"sid":"29426028","text":"追不上我吧！","type":"video","thumbnail":"http://wimg.spriteapp.cn/picture/2019/0425/b1fc7a96-6725-11e9-81af-1866daeb0df1_wpd.jpg","video":"http://uvideo.spriteapp.cn/video/2019/0425/b1fc7a96-6725-11e9-81af-1866daeb0df1_wpd.mp4","images":null,"up":"58","down":"4","forward":"0","comment":"5","uid":"22904192","name":"爆笑君","header":"http://wimg.spriteapp.cn/profile/20180809175405412650.jpg","top_comments_content":null,"top_comments_voiceuri":null,"top_comments_uid":null,"top_comments_name":null,"top_comments_header":null,"passtime":"2019-04-26 02:57:01"},{"sid":"29425154","text":"就算女汉子也得会撒娇","type":"video","thumbnail":"http://wimg.spriteapp.cn/picture/2019/0425/0fc4190c-66fb-11e9-be5b-1866daeb0df1_wpd.jpg","video":"http://uvideo.spriteapp.cn/video/2019/0425/0fc4190c-66fb-11e9-be5b-1866daeb0df1_wpd.mp4","images":null,"up":"67","down":"8","forward":"0","comment":"3","uid":"22904189","name":"搞笑二货","header":"http://wimg.spriteapp.cn/profile/20180809175305264102.png","top_comments_content":"兄弟你女朋友如果不要，就赶紧拿去销毁了，我们也不要！","top_comments_voiceuri":"","top_comments_uid":"22991439","top_comments_name":"麦兜兜","top_comments_header":"http://wimg.spriteapp.cn/profile/large/2018/11/30/5c01414399eb3_mini.jpg","passtime":"2019-04-26 02:17:02"}]
     */

    private int code;
    private String message;
    private List<ResultBean> result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * sid : 29426028
         * text : 追不上我吧！
         * type : video
         * thumbnail : http://wimg.spriteapp.cn/picture/2019/0425/b1fc7a96-6725-11e9-81af-1866daeb0df1_wpd.jpg
         * video : http://uvideo.spriteapp.cn/video/2019/0425/b1fc7a96-6725-11e9-81af-1866daeb0df1_wpd.mp4
         * images : null
         * up : 58
         * down : 4
         * forward : 0
         * comment : 5
         * uid : 22904192
         * name : 爆笑君
         * header : http://wimg.spriteapp.cn/profile/20180809175405412650.jpg
         * top_comments_content : null
         * top_comments_voiceuri : null
         * top_comments_uid : null
         * top_comments_name : null
         * top_comments_header : null
         * passtime : 2019-04-26 02:57:01
         */

        private String sid;
        private String text;
        private String type;
        private String thumbnail;
        private String video;
        private Object images;
        private String up;
        private String down;
        private String forward;
        private String comment;
        private String uid;
        private String name;
        private String header;
        private Object top_comments_content;
        private Object top_comments_voiceuri;
        private Object top_comments_uid;
        private Object top_comments_name;
        private Object top_comments_header;
        private String passtime;

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        public Object getImages() {
            return images;
        }

        public void setImages(Object images) {
            this.images = images;
        }

        public String getUp() {
            return up;
        }

        public void setUp(String up) {
            this.up = up;
        }

        public String getDown() {
            return down;
        }

        public void setDown(String down) {
            this.down = down;
        }

        public String getForward() {
            return forward;
        }

        public void setForward(String forward) {
            this.forward = forward;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHeader() {
            return header;
        }

        public void setHeader(String header) {
            this.header = header;
        }

        public Object getTop_comments_content() {
            return top_comments_content;
        }

        public void setTop_comments_content(Object top_comments_content) {
            this.top_comments_content = top_comments_content;
        }

        public Object getTop_comments_voiceuri() {
            return top_comments_voiceuri;
        }

        public void setTop_comments_voiceuri(Object top_comments_voiceuri) {
            this.top_comments_voiceuri = top_comments_voiceuri;
        }

        public Object getTop_comments_uid() {
            return top_comments_uid;
        }

        public void setTop_comments_uid(Object top_comments_uid) {
            this.top_comments_uid = top_comments_uid;
        }

        public Object getTop_comments_name() {
            return top_comments_name;
        }

        public void setTop_comments_name(Object top_comments_name) {
            this.top_comments_name = top_comments_name;
        }

        public Object getTop_comments_header() {
            return top_comments_header;
        }

        public void setTop_comments_header(Object top_comments_header) {
            this.top_comments_header = top_comments_header;
        }

        public String getPasstime() {
            return passtime;
        }

        public void setPasstime(String passtime) {
            this.passtime = passtime;
        }
    }
}
