package com.example.facebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView feed=findViewById(R.id.feed_lv);
        List<FeedModel> posts=new ArrayList<>();//adding comments to posts
        coments.add(new CommentModel(R.drawable.profile_pic,"Reachel Green","we love you too mon <3","2 min ago"));
        coments.add(new CommentModel(R.drawable.chan_pro,"Chandler Bing","i love my wife","3 min ago"));
        coments.add(new CommentModel(R.drawable.joey_pro,"Joey Tribbiani","we love your food too mon <3","4 min ago"));
        coments1.add(new CommentModel(R.drawable.joey_pro,"Joey Tribbiani","lets hope this time @ross geller don't mess up","7 min ago"));
        coments1.add(new CommentModel(R.drawable.phobbe_pro,"Phoebe Buffay","lol @joey tribbiani ","3 min ago"));
        coments1.add(new CommentModel(R.drawable.roos_pro,"Ross Geller","WE WERE ON A BRAKE @joey tribbiani","2 min ago"));
        coments2.add(new CommentModel(R.drawable.profile_pic,"Reachel Green","looks good ","2 min ago"));
        coments2.add(new CommentModel(R.drawable.chan_pro,"Chandler Bing","i coming over save me a bite","3 min ago"));
        coments2.add(new CommentModel(R.drawable.joey_pro,"Joey Tribbiani","JOEY DOSENT SHARE FOOD @Chandler Bing","4 min ago"));
        coments3.add(new CommentModel(R.drawable.mon_pro,"Monica Bing","watch out from the jellyfish lol @Chandler Bing @Joey Tribbiani","4 min ago"));
        coments4.add(new CommentModel(R.drawable.roos_pro,"Ross Geller","lets try to write a song about dinosaur together","2 min ago"));
//adding posts
        posts.add(new FeedModel(3, R.drawable.mon_pro, R.drawable.mon_post, "Monica Bing", "5 hours ago", "i love my F.R.I.E.N.D.S", coments,false));
        posts.add(new FeedModel(4, R.drawable.profile_pic, R.drawable.ross_rach_post, "Reachel Green", "4 hours ago", "at least #LOVE", coments1,true));
        posts.add(new FeedModel(19, R.drawable.phobbe_pro,0, "Phoebe Buffay", "17 hours ago", "Smelly Cat, Smelly Cat,\n" +
                "What are they feeding you?\n" +
                "Smelly Cat, Smelly Cat,\n" +
                "It's not your fault", coments4,false));
        posts.add(new FeedModel(5, R.drawable.joey_pro, R.drawable.joey_post, "Joey Tribbiani", "2 days ago", "its about to get messy", coments2,false));
        posts.add(new FeedModel(1, R.drawable.profile_pic, R.drawable.post_pic, "Reachel Green", "23 hours ago", "i love the beach", coments3,false));

//calling the adapter
        FeedAdapter feedAdapter=new FeedAdapter(this,R.layout.feed,posts);
        feed.setAdapter(feedAdapter);

    }
    List<CommentModel> coments=new ArrayList<>();
    List<CommentModel> coments1=new ArrayList<>();
    List<CommentModel> coments2=new ArrayList<>();
    List<CommentModel> coments3=new ArrayList<>();
    List<CommentModel> coments4=new ArrayList<>();




}
