package com.example.studentcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class addStudentCV extends AppCompatActivity {

    private DatabaseHelper DB;
    private long studentId;
    private TextView txtStudentId;
    private LinearLayout formEducation;
    private LinearLayout formExperience;
    private LinearLayout formSkill;
    private LinearLayout formLanguage;
    private LinearLayout formInterest;
    private Button btnAddEducation;
    private Button btnAddExperience;
    private Button btnAddSkill;
    private Button btnAddLanguage;
    private Button btnAddInterest;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student_cv);

        DB=new DatabaseHelper(this);

        txtStudentId = findViewById(R.id.TxtStudent);
        Intent intent = getIntent();

        studentId = intent.getLongExtra("studentId",0);
        if(studentId == 0) addStudentCV.this.finish();

        txtStudentId.setText("Student ID = "+studentId);

        Toast.makeText(addStudentCV.this, intent.getStringExtra("Message"),
                Toast.LENGTH_SHORT).show();

        formEducation = findViewById(R.id.formEducation);
        formExperience = findViewById(R.id.formExperience);
        formSkill = findViewById(R.id.formSkill);
        formLanguage = findViewById(R.id.formLanguage);
        formInterest = findViewById(R.id.formInterest);

        btnAddEducation = findViewById(R.id.addEducation);
        btnAddExperience = findViewById(R.id.addExperience);
        btnAddSkill = findViewById(R.id.addSkill);
        btnAddLanguage = findViewById(R.id.addLanguage);
        btnAddInterest = findViewById(R.id.addInterest);
        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(addStudentCV.this, MainActivity.class));
            }
        });

        addEducation();
        addExperience();
        addSkill();
        addLanguage();
        addInterest();
    }

    private void disableForms(){
        formEducation.setVisibility(View.GONE);
        formExperience.setVisibility(View.GONE);
        formSkill.setVisibility(View.GONE);
        formLanguage.setVisibility(View.GONE);
        formInterest.setVisibility(View.GONE);
    }
    public void showEducationForm(View view){
        disableForms();
        formEducation.setVisibility(View.VISIBLE);
    }
    public void showExperienceForm(View view){
        disableForms();
        formExperience.setVisibility(View.VISIBLE);
    }
    public void showSkillForm(View view){
        disableForms();
        formSkill.setVisibility(View.VISIBLE);
    }
    public void showLanguageForm(View view){
        disableForms();
        formLanguage.setVisibility(View.VISIBLE);
    }
    public void showInterestForm(View view){
        disableForms();
        formInterest.setVisibility(View.VISIBLE);
    }

    public void addEducation(){
        btnAddEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText title = findViewById(R.id.editEducationTitle);
                EditText startDate = findViewById(R.id.editEducationStart);
                EditText endDate = findViewById(R.id.editEducationEnd);
                EditText description = findViewById(R.id.editEducationDescription);

                boolean result = DB.insertEducation(
                        title.getText().toString(),
                        startDate.getText().toString(),
                        endDate.getText().toString(),
                        description.getText().toString(),
                        studentId);

                if(result){
                    Toast.makeText(addStudentCV.this, "Education is Added Successfully",
                            Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(addStudentCV.this, "Error!!, try again",
                            Toast.LENGTH_SHORT).show();
                }
                formEducation.setVisibility(View.GONE);
            }
        });
    }

    public void addExperience(){
        btnAddExperience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText title = findViewById(R.id.editExperienceTitle);
                EditText startDate = findViewById(R.id.editExperienceStart);
                EditText endDate = findViewById(R.id.editExperienceEnd);
                EditText description = findViewById(R.id.editExperienceDescription);

                boolean result = DB.insertExperience(
                        title.getText().toString(),
                        startDate.getText().toString(),
                        endDate.getText().toString(),
                        description.getText().toString(),
                        studentId);

                if(result){
                    Toast.makeText(addStudentCV.this, "Experience is Added Successfully",
                            Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(addStudentCV.this, "Error!!, try again",
                            Toast.LENGTH_SHORT).show();
                }
                formExperience.setVisibility(View.GONE);
            }
        });
    }
    public void addSkill(){
        btnAddSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = findViewById(R.id.editSkillName);
                EditText level = findViewById(R.id.editSkillLevel);

                boolean result = DB.insertSkill(
                        name.getText().toString(),
                        level.getText().toString(),
                        studentId);

                if(result){
                    Toast.makeText(addStudentCV.this, "Skill is Added Successfully",
                            Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(addStudentCV.this, "Error!!, try again",
                            Toast.LENGTH_SHORT).show();
                }
                formSkill.setVisibility(View.GONE);
            }
        });
    }
    public void addLanguage(){
        btnAddLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = findViewById(R.id.editLanguageName);
                EditText level = findViewById(R.id.editLanguageLevel);

                boolean result = DB.insertLanguage(
                        name.getText().toString(),
                        level.getText().toString(),
                        studentId);

                if(result){
                    Toast.makeText(addStudentCV.this, "Language is Added Successfully",
                            Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(addStudentCV.this, "Error!!, try again",
                            Toast.LENGTH_SHORT).show();
                }
                formLanguage.setVisibility(View.GONE);
            }
        });
    }
    public void addInterest(){
        btnAddInterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = findViewById(R.id.editInterestName);

                boolean result = DB.insertInterest(
                        name.getText().toString(),
                        studentId);

                if(result){
                    Toast.makeText(addStudentCV.this, "Interest is Added Successfully",
                            Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(addStudentCV.this, "Error!!, try again",
                            Toast.LENGTH_SHORT).show();
                }
                formInterest.setVisibility(View.GONE);
            }
        });
    }
}