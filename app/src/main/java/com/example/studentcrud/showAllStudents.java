package com.example.studentcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class showAllStudents extends AppCompatActivity {

    private DatabaseHelper DB;
    private ListView ListStudents;
    private Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_students);

        ListAllStudents();

        ListView listView = findViewById(R.id.listAllStudents);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            // Get the selected item view from the list
            View selectedItemView = parent.getChildAt(position);


            // Extract the id from the selected item view
            TextView idTextView = selectedItemView.findViewById(R.id.iditemview);
            String selectedId = idTextView.getText().toString();

            // Create an Intent to start the new activity
            Intent intent = new Intent(showAllStudents.this, readStudent.class);

            // Pass the selected id to the other activity
            intent.putExtra("selectedId", selectedId);

            // Start the new activity
            startActivity(intent);
        });
        Button homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to MainActivity
                Intent intent = new Intent(showAllStudents.this, MainActivity.class);

                // Start the MainActivity
                startActivity(intent);
            }
        });


    }

    private void ListAllStudents(){
        DB = new DatabaseHelper(this);
        cursor = DB.getAllStudents();
        ListStudents = findViewById(R.id.listAllStudents);
        String[] fromColumns = {"_id","firstName" , "lastName"};

        int[] toViews = {R.id.iditemview,R.id.firstnameitemview,R.id.lastnameitemview};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,R.layout.list_item_layout,cursor,fromColumns,toViews,0);
        ListStudents.setAdapter(adapter);
//        TextView id = findViewById(R.id.iditemview);
//        id.setVisibility(View.GONE);
    }




 }

