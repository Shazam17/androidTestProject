package com.example.stkau.tsu;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class cardViewAdapter extends RecyclerView.Adapter<cardViewAdapter.MyViewHolder> {

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public Lesson mLesson;
        public View mTextView;
        CardView cv;


        public MyViewHolder(View v) {
            super(v);
            mTextView = v;
        }
    }


    public cardViewAdapter(){

    }

    @NonNull
    @Override
    public cardViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull cardViewAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
