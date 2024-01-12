package com.example.studentcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addStudent extends AppCompatActivity {

    private DatabaseHelper DB;
    private EditText firstName;
    private EditText lastName;
    private EditText age;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        DB=new DatabaseHelper(this);

        firstName = findViewById(R.id.edtLastName);
        lastName = findViewById(R.id.edtFirstName);
        age = findViewById(R.id.edtAge);
        btnAdd = findViewById(R.id.AddData);
        Button homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to MainActivity
                Intent intent = new Intent(addStudent.this, MainActivity.class);

                // Start the MainActivity
                startActivity(intent);
            }
        });
        create();
    }

    public void create() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long studentId = DB.insertStudent(firstName.getText().toString(),lastName.getText().toString(),Integer.parseInt(age.getText().toString()));
                if(studentId != -1){
                    Intent MyIntent1 = new
                            Intent(addStudent.this, addStudentCV.class);
                    MyIntent1.putExtra("Message", "Student is Added successfully");
                    MyIntent1.putExtra("studentId", studentId);
                    startActivity(MyIntent1);
                }else{
                    Toast.makeText(addStudent.this, "Error!!, try again",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}