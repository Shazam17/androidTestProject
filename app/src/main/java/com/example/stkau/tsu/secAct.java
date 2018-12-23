package com.example.stkau.tsu;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class secAct extends AppCompatActivity {


    private TextView web;
    private Lesson[][] lessons;
    private LessonAdapter adapter;

    private ViewPager pager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);


        pager = findViewById(R.id.pager);
        lessons = new Lesson[6][];
        for(int i = 0 ; i < 6 ; i++){
            lessons[i] = new Lesson[7];
        }

        Document doc = new Document("");
        webThread th = new webThread(doc , "428-2" ,lessons );
        th.start();
        try {
            th.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pager = findViewById(R.id.pager);

        PagerAdapter adapter = new PagerAdapter(getApplicationContext() , lessons);
        pager.setAdapter(adapter);
    }



    private void makeList(){




    }
}
