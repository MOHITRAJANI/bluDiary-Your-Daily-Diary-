package com.example.personal.diary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SearchFoundActivity extends AppCompatActivity {

    Button back;
    public static TextView heading , description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_found);

        back = (Button)findViewById(R.id.backbutton);
        heading = (TextView)findViewById(R.id.heading);
        description = (TextView)findViewById(R.id.desc);

        if (getIntent().hasExtra("heading") && getIntent().hasExtra("description")){

            heading.setText(getIntent().getStringExtra("heading"));
            description.setText(getIntent().getStringExtra("description"));
        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SearchFoundActivity.this , SearchActivity.class));
            }
        });

    }
}
