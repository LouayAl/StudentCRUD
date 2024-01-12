package com.example.studentcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DB=new DatabaseHelper(this);
        Button homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to MainActivity
                Intent intent = new Intent(MainActivity.this, MainActivity.class);

                // Start the MainActivity
                startActivity(intent);
            }
        });
    }

    public void goAddStudentForm(View v){
        Intent intent = new
                Intent(MainActivity.this, addStudent.class);
        startActivity(intent);
    }

    public void goShowAllStudents(View v){
        Intent intent = new Intent(MainActivity.this, showAllStudents.class);
        startActivity(intent);
    }






}