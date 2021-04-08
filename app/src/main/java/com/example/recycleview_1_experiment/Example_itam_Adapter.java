package com.example.recycleview_1_experiment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Example_itam_Adapter extends RecyclerView.Adapter<Example_itam_Adapter.ExampleViewHolder> {

    private ArrayList<Example_itam> mExampleList;
    private onItemClickListener mListener;

    public interface onItemClickListener {
        void onItemclick (int position);
        void onDeleteClick(int position);
    }

    public void setOnItemClickListener (onItemClickListener listener){
        mListener = listener;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{

        public ImageView mimageView;
        public TextView mtextView1;
        public TextView mtextView2;
        public ImageView mDeleteImage;

        public ExampleViewHolder(@NonNull View itemView, final onItemClickListener listener) {
            super(itemView);

            mimageView = itemView.findViewById(R.id.imageView);
            mtextView1 =itemView.findViewById(R.id.textView);
            mtextView2 = itemView.findViewById(R.id.textView2);
            mDeleteImage = itemView.findViewById(R.id.image_delete);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemclick(position);
                        }

                    }

                }
            });

            mDeleteImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onDeleteClick(position);
                        }

                    }
                }
            });
        }
    }

    public Example_itam_Adapter(ArrayList<Example_itam> exampleItams) {
        mExampleList = exampleItams ;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exmple_itam,parent,false);
       ExampleViewHolder evh = new ExampleViewHolder(view , mListener);
       return evh;

    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {

        Example_itam currentItam = mExampleList.get(position);
        holder.mimageView.setImageResource(currentItam.getmImageResource());
        holder.mtextView1.setText(currentItam.getmText1());
        holder.mtextView2.setText(currentItam.getmText2());
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}
