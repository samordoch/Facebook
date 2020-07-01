package com.example.facebook;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
//THIS IS THE ADAPTER FOR THE POSTS
public class FeedAdapter extends ArrayAdapter<FeedModel> {


    private List<FeedModel> posts;
    private  Context activity;
    private int layoutId;

    public FeedAdapter(@NonNull Context context, int resource, @NonNull List<FeedModel> objects) {
        super(context, resource, objects);
        this.activity=context;
        this.layoutId=resource;
        this.posts=objects;

    }


    

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.feed, parent, false);
        //announcing vals and setting them
        TextView name_tv,time_tv,likes_tv,status_tv,comments_tv;
        RelativeLayout like_btn,com_btn;
        ImageView imageView_ProPic,imageView_postPic;
        name_tv=convertView.findViewById(R.id.name_tv);
        time_tv=convertView.findViewById(R.id.time_tv);
        likes_tv=convertView.findViewById(R.id.like_tv);
        status_tv=convertView.findViewById(R.id.status_tv);
        comments_tv=convertView.findViewById(R.id.comments_tv);
        imageView_postPic=convertView.findViewById(R.id.post_iv);
        imageView_ProPic=convertView.findViewById(R.id.profilePic);
        like_btn=convertView.findViewById(R.id.like_button);
        com_btn=convertView.findViewById(R.id.comment_button);
        //getting curr pos
        FeedModel post=this.posts.get(position);
        TextView name1,time1,com1;
        ImageView pic1;
        //assign comments
        if(post.commentsList.size()>0){
            pic1=convertView.findViewById(R.id.profilePic1);
            name1=convertView.findViewById(R.id.name1_tv);
            time1=convertView.findViewById(R.id.time1_tv);
            com1=convertView.findViewById(R.id.com1_tv);
            com1.setText(post.commentsList.get(0).com);
            time1.setText(post.commentsList.get(0).time);
            name1.setText(post.commentsList.get(0).name);
            pic1.setImageResource(post.commentsList.get(0).proPic);
            LinearLayout comenntsLayout=convertView.findViewById(R.id.com_view);
            convertView.findViewById(R.id.com1_tab).setVisibility(View.VISIBLE);
            View.OnClickListener comOpener = (view) -> {
                comenntsLayout.setVisibility(View.VISIBLE);
            };
            com_btn.setOnClickListener(comOpener);
            comments_tv.setOnClickListener(comOpener);
            //if the comment section or the button was pressed comments will open
            //this is by purpose like in the original app
            if(post.commentsList.size()>1){
                pic1=convertView.findViewById(R.id.profilePic2);
                name1=convertView.findViewById(R.id.name2_tv);
                time1=convertView.findViewById(R.id.time2_tv);
                com1=convertView.findViewById(R.id.com2_tv);
                com1.setText(post.commentsList.get(1).com);
                time1.setText(post.commentsList.get(1).time);
                name1.setText(post.commentsList.get(1).name);
                pic1.setImageResource(post.commentsList.get(1).proPic);
                convertView.findViewById(R.id.com2_tab).setVisibility(View.VISIBLE);
                if(post.commentsList.size()>2){
                    pic1=convertView.findViewById(R.id.profilePic3);
                    name1=convertView.findViewById(R.id.name3_tv);
                    time1=convertView.findViewById(R.id.time3_tv);
                    com1=convertView.findViewById(R.id.com3_tv);
                    com1.setText(post.commentsList.get(2).com);
                    time1.setText(post.commentsList.get(2).time);
                    name1.setText(post.commentsList.get(2).name);
                    pic1.setImageResource(post.commentsList.get(2).proPic);
                    convertView.findViewById(R.id.com3_tab).setVisibility(View.VISIBLE);
                }
            }
        }
        if(post.liked){//setting the button to clicked form
            like_btn.setAlpha(0.5f);
        }
        //like onclick func
        like_btn.setOnClickListener((view)->{Log.i("like","was pressed");
        if(post.liked){
            post.liked=false;
            post.likes--;
            like_btn.setAlpha(1f);
            likes_tv.setText(""+post.likes+" Likes");//this will update after click
        }else{
            post.liked=true;
            post.likes++;
            like_btn.setAlpha(0.5f);
            likes_tv.setText("You and "+(post.likes-1)+" others liked it");//this will update after click
        }
        });
        name_tv.setText(post.name);
        time_tv.setText(post.time);
        //i know this is code duplication but that fix a bug whit removing the like after scroll
        //if there is a smother solution i would love to know about it
        if(post.liked){
            likes_tv.setText("You and "+(post.likes-1)+" others liked it");
        } else
            likes_tv.setText(""+post.likes+" Likes");
        status_tv.setText(post.status);
        comments_tv.setText(""+post.comments+" Comments");
        imageView_ProPic.setImageResource(post.profilePic);
        imageView_postPic.setImageResource(post.postPic);
        return convertView;
    }


}
