package com.example.studentcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class readStudent extends AppCompatActivity {

    DatabaseHelper DB;
    Cursor cursor;

    TextView firstName, lastName, Age;
    ListView educationList,experienceList,skillList,languageList,interestList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_student);
        getpersonalinfo();
        geteducations();
        getexperiences();
        getskills();
        getlanguages();
        getinterest();


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

    private void getexperiences(){
        Intent intent = getIntent();
        DB = new DatabaseHelper(this);
        cursor = DB.getExperiences(intent.getStringExtra("selectedId"));
        experienceList = findViewById(R.id.experiencelist);
        String[] fromColumns = {"title","startDate" , "endDate","description"};

        int[] toViews = {R.id.titleexperienceitem,R.id.startdateexperienceitem,R.id.enddateexperienceitem,R.id.descexperienceitem};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,R.layout.experience_item_list,cursor,fromColumns,toViews,0);
        experienceList.setAdapter(adapter);

    }

    private void getskills(){
        Intent intent = getIntent();
        DB = new DatabaseHelper(this);
        cursor = DB.getSkills(intent.getStringExtra("selectedId"));
        skillList = findViewById(R.id.skilllist);
        String[] fromColumns = {"name","level"};

        int[] toViews = {R.id.nameskillitem,R.id.levelskillitem};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,R.layout.skill_item_list,cursor,fromColumns,toViews,0);
        skillList.setAdapter(adapter);

    }

    private void getlanguages(){
        Intent intent = getIntent();
        DB = new DatabaseHelper(this);
        cursor = DB.getLanguages(intent.getStringExtra("selectedId"));
        languageList = findViewById(R.id.languagelist);
        String[] fromColumns = {"name","level"};

        int[] toViews = {R.id.namelanguageitem,R.id.levellanguageitem};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,R.layout.language_item_list,cursor,fromColumns,toViews,0);
        languageList.setAdapter(adapter);

    }

    private void getinterest(){
        Intent intent = getIntent();
        DB = new DatabaseHelper(this);
        cursor = DB.getInterests(intent.getStringExtra("selectedId"));
        interestList = findViewById(R.id.interestlist);
        String[] fromColumns = {"name"};

        int[] toViews = {R.id.nameinterestitem};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,R.layout.interest_item_list,cursor,fromColumns,toViews,0);
        interestList.setAdapter(adapter);

    }


}