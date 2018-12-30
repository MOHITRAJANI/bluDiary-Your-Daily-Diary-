package com.example.personal.diary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ListOpenActivity extends AppCompatActivity {

    Button back ;
    public static TextView header_data;
    public static TextView description_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_open);

        back = (Button)findViewById(R.id.backbutton);
        header_data = (TextView)findViewById(R.id.heading);
        description_data = (TextView)findViewById(R.id.desc);
        if (getIntent().hasExtra("heading") && getIntent().hasExtra("description")){

            header_data.setText(getIntent().getStringExtra("heading"));
            description_data.setText(getIntent().getStringExtra("description"));
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListOpenActivity.this , ListActivity.class));
            }
        });
    }
}
