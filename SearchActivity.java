package com.example.personal.diary;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {


    EditText searchBox;
    Button back,search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        search = (Button)findViewById(R.id.SearchButton);
        back = (Button)findViewById(R.id.backbutton);
        searchBox = (EditText)findViewById(R.id.searchbox);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SearchActivity.this , FunctionActivity.class));
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("INSIDE" , searchBox.getText().toString());
                if (searchBox.getText().toString() != null)
                {
                    String wanted_heading = searchBox.getText().toString() ;
                    String[] desc;
                    desc = FunctionActivity.myDb.getDescription(wanted_heading);
                    if (desc!=null)
                    {
                        Intent intent = new Intent(SearchActivity.this , SearchFoundActivity.class);
                        intent.putExtra("heading" , desc[0]);
                        intent.putExtra("description" , desc[1]);
                        startActivity(intent);
                    }
                    else
                        Toast.makeText(SearchActivity.this , "NOT FOUND" , Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
