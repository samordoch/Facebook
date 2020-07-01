package com.example.facebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
//this was a try to do the comments as a list but it failed
public class ComAdapter extends ArrayAdapter<CommentModel> {
    private List<CommentModel> comments;
    private Context activity;
    private int layoutId;

    public ComAdapter(@NonNull Context context, int resource, @NonNull List<CommentModel> objects) {
        super(context, resource, objects);
        this.comments = comments;
        this.activity = activity;
        this.layoutId = layoutId;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.comments, parent, false);

        TextView name_tv,time_tv,comment_tv;
        ImageView imageView_ProPic;
        name_tv=convertView.findViewById(R.id.name_tv);
        time_tv=convertView.findViewById(R.id.time_tv);
        comment_tv=convertView.findViewById(R.id.comment_tv);
        imageView_ProPic=convertView.findViewById(R.id.profilePic);

        CommentModel comment=this.comments.get(position);


        //name_tv.setText(comment.name);
       // time_tv.setText(comment.time);
       // imageView_ProPic.setImageResource(comment.proPic);
        //comment_tv.setText(comment.com);
        return convertView;
    }
}
