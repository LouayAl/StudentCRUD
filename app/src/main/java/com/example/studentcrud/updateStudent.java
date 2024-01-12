package com.example.studentcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
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


public class updateStudent extends AppCompatActivity {

    DatabaseHelper DB;
    EditText EditAge;
    TextView firstName, lastName;
    EditText title, startDate, endDate, description, endDateExperience, startDateExperience, titleExperience, descExperience, nameSkill, levelSkill, nameLanguage, levelLanguage, nameInterest;

    Button confirmButton;

    String id ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_student);

        DB = new DatabaseHelper(this);

        confirmButton = findViewById(R.id.confirmButton);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveChanges();
                Intent intent = new Intent(updateStudent.this, showAllStudents.class);
                startActivity(intent);
            }
        });


        EditAge = (EditText) findViewById(R.id.Updateage);
        firstName = (TextView) findViewById(R.id.Updatefirstname);
        lastName = (TextView) findViewById(R.id.Updatelastname);

        title = (EditText) findViewById(R.id.titleeducationitemU2);
        startDate = (EditText) findViewById(R.id.startdateeducationitem);
        endDate = (EditText) findViewById(R.id.enddateeducationitem);
        description = (EditText) findViewById(R.id.desceducationitem);

        endDateExperience = (EditText) findViewById(R.id.enddateexperienceitem);
        startDateExperience = (EditText) findViewById(R.id.startdateexperienceitem);
        titleExperience = (EditText) findViewById(R.id.titleexperienceitem);
        descExperience = (EditText) findViewById(R.id.descexperienceitem);

        nameSkill = (EditText) findViewById(R.id.nameskillitem);
        levelSkill = (EditText) findViewById(R.id.levelskillitem);

        nameLanguage = (EditText) findViewById(R.id.namelanguageitem);
        levelLanguage = (EditText) findViewById(R.id.levellanguageitem);

        nameInterest = (EditText) findViewById(R.id.nameinterestitem);

        getPersonalData();

        getEducations();
        getExperiences();
        getInterests();
        getSkills();
        getLanguages();


    }



////////////////////////////////////////////////////// - UPDATE STUDENT CV DATA - \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    // Update StudentInformation table
    private void UpdateStudent() {
        System.out.println(DB.updateStudent( id, Integer.parseInt(EditAge.getText().toString())));
    }

    // Update Education table
    private void UpdateEducation() {
        System.out.println(DB.updateEducation(id, title.getText().toString(), startDate.getText().toString(), endDate.getText().toString(), description.getText().toString()));
    }

    // Update Experience table
    private void UpdateExperience() {
        System.out.println(DB.updateExperience(id, titleExperience.getText().toString(), startDateExperience.getText().toString(), endDateExperience.getText().toString(), descExperience.getText().toString()));
    }

    // Update Skill table
    private void UpdateSkill() {
        System.out.println(DB.updateSkill(id, nameSkill.getText().toString(), levelSkill.getText().toString()));
    }

    // Update Language table
    private void UpdateLanguage() {
        System.out.println(DB.updateLanguage(id, nameLanguage.getText().toString(), levelLanguage.getText().toString()));
    }

    // Update Interest table
    private void UpdateInterest() {
        System.out.println(DB.updateInterest(id, nameInterest.getText().toString()));
    }

    // Call the update methods to save the changes
    private void saveChanges() {
        UpdateStudent();
        UpdateEducation();
        UpdateExperience();
        UpdateSkill();
        UpdateLanguage();
        UpdateInterest();
    }

////////////////////////////////////////////////////// - READ STUDENT CV DATA - \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    private void getEducations(){
        Intent intent = getIntent();

        String EducationTitle = intent.getStringExtra("title");
        String EducationStartDate = intent.getStringExtra("startDate");
        String EducationEndDate= intent.getStringExtra("endDate");
        String EducationDesc = intent.getStringExtra("description");

        title.setText(EducationTitle);
        startDate.setText(EducationStartDate);
        endDate.setText(EducationEndDate);
        description.setText(EducationDesc);

    }

    private void getExperiences(){
        Intent intent = getIntent();

        String ExpTitle = intent.getStringExtra("titleExperience");
        String ExpStartDate = intent.getStringExtra("startDateExperience");
        String ExpEndDate= intent.getStringExtra("endDateExperience");
        String ExpDesc = intent.getStringExtra("descExperience");

        titleExperience.setText(ExpTitle);
        startDateExperience.setText(ExpStartDate);
        endDateExperience.setText(ExpEndDate);
        descExperience.setText(ExpDesc);
    }

    private void getSkills(){
        Intent intent = getIntent();

        String SkillName= intent.getStringExtra("nameSkill");
        String SkillLevel = intent.getStringExtra("levelSkill");

        nameSkill.setText(SkillName);
        levelSkill.setText(SkillLevel);

    }

    private void getLanguages(){
        Intent intent = getIntent();

        String LanguageName= intent.getStringExtra("nameLanguage");
        String LanguageLevel = intent.getStringExtra("levelLanguage");

        nameLanguage.setText(LanguageName);
        levelLanguage.setText(LanguageLevel);

    }

    private void getInterests(){
        Intent intent = getIntent();

        String InterestName = intent.getStringExtra("nameInterest");

        nameInterest.setText(InterestName);


    }

    void getPersonalData(){
        Intent intent = getIntent();


        String age = intent.getStringExtra("Age");
        String lastname = intent.getStringExtra("LastName");
        String firstname = intent.getStringExtra("FirstName");

        id = intent.getStringExtra("IdStudent");

        EditAge.setText(age);
        firstName.setText(firstname);
        lastName.setText(lastname);

    }
}