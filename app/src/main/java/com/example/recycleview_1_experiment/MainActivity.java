package com.example.recycleview_1_experiment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private    ArrayList<Example_itam> mexample_items;
    private    RecyclerView recyclerView;
    private    Example_itam_Adapter adapter;
    private    RecyclerView.LayoutManager layoutManager;
    private    Button button_insert;
    private    Button button_delete;
    private    EditText editText_insert;
    private    EditText editText_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Create_Example_List();
        Building_Recycler_view();
        setButton();


    }

    public void  Insert_Item(int position){

        mexample_items.add(position,new Example_itam(R.drawable.ic_6,"New Itam" + position,"Line 2nd new" ));

        adapter.notifyItemInserted(position);
    }

    public void Delete_Item (int position){

        mexample_items.remove(position);
        adapter.notifyItemRemoved(position);


    }

    public void changeItem (int position ,String text){
        mexample_items.get(position).changeText1(text);
        adapter.notifyItemChanged(position);
    }

    private void Create_Example_List() {

        mexample_items  = new ArrayList<>();

        mexample_items.add(new Example_itam(R.drawable.ic_1,"Line 1","Line 2"));
        mexample_items.add(new Example_itam(R.drawable.ic_2,"Line 3","Line 4"));
        mexample_items.add(new Example_itam(R.drawable.ic_3,"Line 5","Line 6"));
        mexample_items.add(new Example_itam(R.drawable.ic_4,"Line 7","Line 8"));
        mexample_items.add(new Example_itam(R.drawable.ic_5,"Line 9","Line 10"));
        mexample_items.add(new Example_itam(R.drawable.ic_6,"Line 11","Line 12"));
        mexample_items.add(new Example_itam(R.drawable.ic_7,"Line 13","Line 14"));
        mexample_items.add(new Example_itam(R.drawable.ic_8,"Line 15","Line 16"));
        mexample_items.add(new Example_itam(R.drawable.ic_9,"Line 17","Line 18"));
        mexample_items.add(new Example_itam(R.drawable.ic_10,"Line 19","Line 20"));

        mexample_items.add(new Example_itam(R.drawable.ic_5,"Line 21","Line 22"));
        mexample_items.add(new Example_itam(R.drawable.ic_4,"Line 23","Line 24"));
        mexample_items.add(new Example_itam(R.drawable.ic_3,"Line 25","Line 26"));
        mexample_items.add(new Example_itam(R.drawable.ic_2,"Line 27","Line 28"));
        mexample_items.add(new Example_itam(R.drawable.ic_1,"Line 29","Line 30"));
        mexample_items.add(new Example_itam(R.drawable.ic_6,"Line 31","Line 32"));
        mexample_items.add(new Example_itam(R.drawable.ic_7,"Line 33","Line 34"));
        mexample_items.add(new Example_itam(R.drawable.ic_8,"Line 35","Line 36"));

        mexample_items.add(new Example_itam(R.drawable.ic_9,"Line 37","Line 38"));
        mexample_items.add(new Example_itam(R.drawable.ic_10,"Line 39","Line 40"));

    }

    private void Building_Recycler_view() {

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new Example_itam_Adapter(mexample_items);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new Example_itam_Adapter.onItemClickListener() {
            @Override
            public void onItemclick(int position) {

                changeItem(position,"Clicked");
            }

            @Override
            public void onDeleteClick(int position) {
                Delete_Item(position);
            }
        });

    }

    private void setButton() {

        button_insert = findViewById(R.id.button_insert);
        button_delete = findViewById(R.id.button_delete);
        editText_insert = findViewById(R.id.edit_text_instart);
        editText_delete = findViewById(R.id.edit_text_delete);

        button_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editText_insert.getText().toString());
                Insert_Item(position);

            }
        });


        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editText_delete.getText().toString());
                Delete_Item(position);

            }
        });
    }

}
