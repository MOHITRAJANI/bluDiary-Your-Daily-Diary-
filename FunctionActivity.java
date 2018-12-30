package com.example.personal.diary;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class FunctionActivity extends AppCompatActivity {

    Button logout;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;
    Button addButton , listButton , searchButton , deleteButton;
    public static DatabaseHelper myDb;
    int id_to_remember ;
    Cursor c;
 /*   @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);


    } */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);
        logout = (Button) findViewById(R.id.logout);
        addButton = (Button)findViewById(R.id.AddButton);
        searchButton = (Button)findViewById(R.id.SearchButton);
        listButton = (Button)findViewById(R.id.ListButton);
        deleteButton = (Button)findViewById(R.id.DeleteButton);
        myDb = new DatabaseHelper(this);
        mAuth = FirebaseAuth.getInstance();
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                startActivity(new Intent(FunctionActivity.this , LoginActivity.class));
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FunctionActivity.this , AddActivity.class));
            }
        });

        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = myDb.getId();
                if(c!=null && c.moveToFirst())
                {
                    id_to_remember = c.getInt(0);
                }
                else
                    id_to_remember = 1;
                startActivity(new Intent(FunctionActivity.this , ListActivity.class));

            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FunctionActivity.this , SearchActivity.class));
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FunctionActivity.this , DeleteActivity.class));
            }
        });


 /*       mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser() == null){
                    startActivity(new Intent(FunctionActivity.this , LoginActivity.class));

                }
            }
        }; */
    }
}
