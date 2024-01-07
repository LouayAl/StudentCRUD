package com.example.studentcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class readStudent extends AppCompatActivity {

    DatabaseHelper DB;
    Cursor cursor;

    TextView firstName, lastName, Age;
    ListView educationList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_student);
        getpersonalinfo();
        geteducations();


    }

    private void getpersonalinfo(){
        Intent intent = getIntent();
        DB = new DatabaseHelper(this);
        cursor = DB.getStudent(intent.getStringExtra("selectedId"));
        if (cursor != null && cursor.moveToFirst()){
            do {
                String firstname = cursor.getString(1);
                String lastname = cursor.getString(2);
                String age = String.valueOf(cursor.getInt(3));
                firstName = findViewById(R.id.Edtfirstname);
                lastName = findViewById(R.id.Edtlastname);
                Age = findViewById(R.id.Edtage);

                firstName.setText(firstname);
                lastName.setText(lastname);
                Age.setText(age);
            } while (cursor.moveToNext());
        }
    }

    private void geteducations(){
        Intent intent = getIntent();
        DB = new DatabaseHelper(this);
        cursor = DB.getEducations(intent.getStringExtra("selectedId"));
        educationList = findViewById(R.id.educationlist);
        String[] fromColumns = {"title","startDate" , "endDate","description"};

        int[] toViews = {R.id.titleeducationitem,R.id.startdateeducationitem,R.id.enddateeducationitem,R.id.desceducationitem};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,R.layout.education_item_list,cursor,fromColumns,toViews,0);
        educationList.setAdapter(adapter);

    }
}