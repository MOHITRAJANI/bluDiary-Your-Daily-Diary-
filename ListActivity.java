package com.example.personal.diary;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    Button back;
    ListItem listItem ;
    private List<ListItem> listItems;
    Cursor c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView =(RecyclerView) findViewById(R.id.recyclerview1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listItems = new ArrayList<>();
        back = (Button)findViewById(R.id.backbutton);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListActivity.this , FunctionActivity.class));
            }
        });

        Cursor c = FunctionActivity.myDb.getAllData();
        Log.d("INSIDE" , String.valueOf(c.getCount()));
        if(c.getCount() == 0)
        {
            Toast.makeText(this , "EMPTY TABLE" , Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
           StringBuffer buffer = new StringBuffer();
           while(c.moveToNext())
           {
               listItem = new ListItem(c.getString(0) , c.getString(1));
               listItems.add(listItem);
           }



        }

        adapter = new MyAdapter(listItems , this);

        recyclerView.setAdapter(adapter);
       /* for(int i=0 ; i<10 ; i++)
        {
            ListItem listItem = new ListItem(
                    "heading" + (i+1),
                    "description "
            ) ; */

            
        }
    }


