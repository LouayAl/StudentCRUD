package com.example.studentcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class readStudent extends AppCompatActivity {

    DatabaseHelper DB;
    Cursor cursor;

    TextView firstName, lastName, Age;
    ListView educationList,experienceList,skillList,languageList,interestList;

    String title, startDate, endDate, description, endDateExperience, startDateExperience, titleExperience, descExperience, nameSkill, levelSkill, nameLanguage, levelLanguage, nameInterest;

    Button EditButton;



    String IdStudent ;

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


        EditButton = (Button) findViewById(R.id.editButton);
        EditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String age = Age.getText().toString();
                String FirstName = firstName.getText().toString();
                String LastName = lastName.getText().toString();


                Intent intent = new Intent(readStudent.this, updateStudent.class);
                intent.putExtra("Age", age);
                intent.putExtra("FirstName", FirstName);
                intent.putExtra("LastName", LastName);

                intent.putExtra("IdStudent", IdStudent);

                intent.putExtra("title", title);
                intent.putExtra("startDate", startDate);
                intent.putExtra("endDate", endDate);
                intent.putExtra("description", description);

                intent.putExtra("titleExperience", titleExperience);
                intent.putExtra("startDateExperience", startDateExperience);
                intent.putExtra("endDateExperience", endDateExperience);
                intent.putExtra("descExperience", descExperience);

                intent.putExtra("nameSkill", nameSkill);
                intent.putExtra("levelSkill", levelSkill);

                intent.putExtra("nameLanguage", nameLanguage);
                intent.putExtra("levelLanguage", levelLanguage);

                intent.putExtra("nameInterest", nameInterest);

                startActivity(intent);
            }
        });
    }

    private void getpersonalinfo(){
        Intent intent = getIntent();
        DB = new DatabaseHelper(this);
        cursor = DB.getStudent(intent.getStringExtra("selectedId"));


        //pass the Id of student to the Update CV activity
        IdStudent = intent.getStringExtra("selectedId");

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


        if (cursor != null && cursor.moveToFirst()){
            do {

                title = cursor.getString(1);
                startDate = cursor.getString(2);
                endDate = cursor.getString(3);
                description = cursor.getString(4);

            } while (cursor.moveToNext());
        }


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


        if (cursor != null && cursor.moveToFirst()){
            do {
                titleExperience = cursor.getString(1);
                startDateExperience = cursor.getString(2);
                endDateExperience = cursor.getString(3);
                descExperience = cursor.getString(4);

            } while (cursor.moveToNext());
        }



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

        if (cursor != null && cursor.moveToFirst()){
            do {
                nameSkill = cursor.getString(1);
                levelSkill = cursor.getString(2);

            } while (cursor.moveToNext());
        }

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

        if (cursor != null && cursor.moveToFirst()){
            do {
                nameLanguage = cursor.getString(1);
                levelLanguage = cursor.getString(2);

            } while (cursor.moveToNext());
        }

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


        if (cursor != null && cursor.moveToFirst()){
            do {
                nameInterest = cursor.getString(1);
            } while (cursor.moveToNext());
        }

        interestList = findViewById(R.id.interestlist);
        String[] fromColumns = {"name"};

        int[] toViews = {R.id.nameinterestitem};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,R.layout.interest_item_list,cursor,fromColumns,toViews,0);
        interestList.setAdapter(adapter);

    }


}