package com.example.personal.diary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    Button save , back;
    EditText heading , description ;
    String heading_data , description_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        save = (Button) findViewById(R.id.savebutton);
        back = (Button) findViewById(R.id.backbutton);
        heading = (EditText)findViewById(R.id.Heading);
        description = (EditText)findViewById(R.id.Description);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddActivity.this , FunctionActivity.class));
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(heading.getText().toString()!=null)
                {
                    heading_data = heading.getText().toString();
                    //Toast.makeText(AddActivity.this, heading_data, Toast.LENGTH_SHORT).show();

                    if (description.getText().toString()!=null)
                    {
                        description_data = description.getText().toString();
                        boolean result = FunctionActivity.myDb.insert(heading_data , description_data);
                        if (result==true)
                        {
                            Toast.makeText(AddActivity.this , "Added Successfully" , Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(AddActivity.this , OkActivity.class));
                        }

                        else
                            Toast.makeText(AddActivity.this, "Addition Failed" , Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(AddActivity.this , "Please Enter Some Description" , Toast.LENGTH_SHORT);
                }
                else
                    Toast.makeText(AddActivity.this, "Please Enter Heading And Description" , Toast.LENGTH_SHORT);


            }
        });


    }
}
