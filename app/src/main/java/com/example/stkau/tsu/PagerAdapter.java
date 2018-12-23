package com.example.stkau.tsu;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class PagerAdapter extends android.support.v4.view.PagerAdapter {

    private int itemCount;
    private  Lesson[][] lessons;
    private LayoutInflater inflater;
    private  Context context;


    public PagerAdapter(Context context , Lesson[][] a_less){
        lessons = a_less;
        itemCount = 7;
        this.context = context;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        inflater =(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        /*View v = inflater.inflate(R.layout.week_item, collection , false);
        RecyclerView lessonList = v.findViewById(R.id.lessonList);

        LinearLayoutManager manager = new LinearLayoutManager(context);

        LessonAdapter adapter = new LessonAdapter(7 , lessons , position);

        lessonList.setHasFixedSize(true);
        lessonList.setLayoutManager(manager);
        lessonList.setAdapter(adapter);
        */
        Button btn = new Button(collection.getContext());
        btn.setText("AAAA");

        collection.addView(btn);



        return btn;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return object.getClass()==view.getClass();
    }


    @Override
    public int getCount() {
        return 7;
    }
}
