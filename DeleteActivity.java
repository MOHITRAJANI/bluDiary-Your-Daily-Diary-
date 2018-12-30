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
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DeleteActivity extends AppCompatActivity {

    public static Button deletebutton , backbutton;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    ListItem listItem ;
    private List<ListItem> listItems;

    Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        recyclerView =(RecyclerView) findViewById(R.id.recyclerview1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listItems = new ArrayList<>();


        backbutton = (Button)findViewById(R.id.backbutton);
        deletebutton = (Button)findViewById(R.id.deletebutton);
     //   deletebutton.setVisibility(View.INVISIBLE);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DeleteActivity.this , FunctionActivity.class));
            }
        });
        deletebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 boolean res = FunctionActivity.myDb.deleteEntry(listItem.getHead());
                  if (res ==true){
                      startActivity(new Intent(DeleteActivity.this , OkForDelete.class));
                  }
                  else
                      Toast.makeText(DeleteActivity.this , "Error Occurred" , Toast.LENGTH_SHORT).show();
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

        adapter = new AapterForDelete(listItems , this);

        recyclerView.setAdapter(adapter);

    }


}
