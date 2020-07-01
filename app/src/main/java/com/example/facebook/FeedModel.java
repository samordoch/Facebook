package com.example.facebook;

import android.widget.ListView;

import java.util.List;
//THIS IS A MODEL OF ALL THINGS POST SHULD HAVE

public class FeedModel {
    protected int likes,comments,profilePic,postPic;
    protected String name,time,status;
    protected Boolean liked;
    protected List<CommentModel> commentsList;

    public FeedModel(int likes, int profilePic, int postPic, String name, String time, String status, List<CommentModel> commentsList,Boolean liked) {
        this.likes = likes;
        this.profilePic = profilePic;
        this.postPic = postPic;
        this.name = name;
        this.time = time;
        this.status = status;
        this.commentsList = commentsList;
        this.liked=liked;
        this.comments=commentsList.size();
    }
}
