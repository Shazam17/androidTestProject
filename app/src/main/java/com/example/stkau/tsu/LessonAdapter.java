package com.example.stkau.tsu;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.LessonViewHolder> {


    private static int viewHolderCount;
    private int numberItems;
    private Lesson[][] lessons;
    private int lessonDay;


    public LessonAdapter(int nmb , Lesson[][] p_les, int day){
        numberItems = nmb;
        viewHolderCount = 0;
        lessons = p_les;
        lessonDay = day;
    }

    @NonNull
    @Override
    public LessonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.list_item;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem,parent,false);

        LessonViewHolder viewHolder = new LessonViewHolder(view);
        viewHolder.number.setText(lessons[lessonDay][viewHolderCount].getName());
        viewHolderCount++;

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LessonViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return numberItems;
    }


    public class LessonViewHolder extends RecyclerView.ViewHolder{

        TextView listItem;
        TextView number;

         public LessonViewHolder(View itemView){
             super(itemView);

             listItem = itemView.findViewById(R.id.view_fr);
             number = itemView.findViewById(R.id.tv_view_Holder);

         }
         void bind(int listIndex){
             listItem.setText(String.valueOf(listIndex));
         }

     }




}