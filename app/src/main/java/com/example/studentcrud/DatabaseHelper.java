package com.example.studentcrud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Student.db";
    public static final String col_ID = "ID";

    public static final String col_studentId = "studentId";

    /*===========Student TABLE===========*/
    public static final String TABLE_STUDENT = "Student";
    public static final String col_2_student = "firstName";
    public static final String col_3_student = "lastName";
    public static final String col_4_student = "age";

    /*===========Eduction TABLE===========*/
    public static final String TABLE_EDUCATION = "Eduction";
    public static final String col_2_education = "title";
    public static final String col_3_education = "startDate";
    public static final String col_4_education = "endDate";
    public static final String col_5_education = "description";

    /*===========Experience TABLE===========*/
    public static final String TABLE_EXPERIENCE = "Experience";
    public static final String col_2_experience = "title";
    public static final String col_3_experience = "startDate";
    public static final String col_4_experience = "endDate";
    public static final String col_5_experience = "description";

    /*===========SKILL TABLE===========*/
    public static final String TABLE_SKILL = "Skill";
    public static final String col_2_skill = "name";
    public static final String col_3_skill = "level";

    /*===========LANGUAGE TABLE===========*/
    public static final String TABLE_LANGUAGE = "Language";
    public static final String col_2_language = "name";
    public static final String col_3_language = "level";

    /*===========INTEREST TABLE===========*/
    public static final String TABLE_INTEREST = "Interest";
    public static final String col_2_interest = "name";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE "+TABLE_STUDENT+" ("+
                        col_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                        col_2_student+" TEXT,"+
                        col_3_student+" TEXT,"+
                        col_4_student+" INTEGER);"
        );
        db.execSQL(
                "CREATE TABLE "+TABLE_EDUCATION+" ("+
                        col_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                        col_2_education+" TEXT,"+
                        col_3_education+" TEXT,"+
                        col_4_education+" TEXT, "+
                        col_5_education+" TEXT,"+
                        col_studentId+" INTEGER, FOREIGN KEY("+col_studentId+") REFERENCES "+
                        TABLE_STUDENT+");"
        );
        db.execSQL(
                "CREATE TABLE "+TABLE_EXPERIENCE+" ("+
                        col_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                        col_2_experience+" TEXT,"+
                        col_3_experience+" TEXT,"+
                        col_4_experience+" TEXT, "+
                        col_5_experience+" TEXT,"+
                        col_studentId+" INTEGER, FOREIGN KEY("+col_studentId+") REFERENCES "+
                        TABLE_STUDENT+");"
        );
        db.execSQL(
                "CREATE TABLE "+TABLE_SKILL+" ("+
                        col_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                        col_2_skill+" TEXT,"+
                        col_3_skill+" TEXT,"+
                        col_studentId+" INTEGER, FOREIGN KEY("+col_studentId+") REFERENCES "+
                        TABLE_STUDENT+");"
        );
        db.execSQL(
                "CREATE TABLE "+TABLE_LANGUAGE+" ("+
                        col_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                        col_2_language+" TEXT,"+
                        col_3_language+" TEXT,"+
                        col_studentId+" INTEGER, FOREIGN KEY("+col_studentId+") REFERENCES "+
                        TABLE_STUDENT+");"
        );
        db.execSQL(
                "CREATE TABLE "+TABLE_INTEREST+" ("+
                        col_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                        col_2_interest+" TEXT,"+
                        col_studentId+" INTEGER, FOREIGN KEY("+col_studentId+") REFERENCES "+
                        TABLE_STUDENT+");"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_STUDENT);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_EDUCATION);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_EXPERIENCE);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_SKILL);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_LANGUAGE);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_INTEREST);
        onCreate(db);
    }

    public long insertStudent(String firstName,String lastName ,Integer age){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put(col_2_student,firstName);
        contentValues.put(col_3_student,lastName);
        contentValues.put(col_4_student,age);
        return db.insert(TABLE_STUDENT,null,contentValues);
    }
    public boolean insertEducation(String title,String startDate,String endDate ,String description,long studentId){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put(col_2_education,title);
        contentValues.put(col_3_education,startDate);
        contentValues.put(col_4_education,endDate);
        contentValues.put(col_5_education,description);
        contentValues.put(col_studentId,studentId);
        long res= db.insert(TABLE_EDUCATION,null,contentValues);
        return res != -1;
    }
    public boolean insertExperience(String title,String startDate,String endDate ,String description,long studentId){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put(col_2_experience,title);
        contentValues.put(col_3_experience,startDate);
        contentValues.put(col_4_experience,endDate);
        contentValues.put(col_5_experience,description);
        contentValues.put(col_studentId,studentId);
        long res= db.insert(TABLE_EXPERIENCE,null,contentValues);
        return res != -1;
    }
    public boolean insertSkill(String name,String level,long studentId){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put(col_2_skill,name);
        contentValues.put(col_3_skill,level);
        contentValues.put(col_studentId,studentId);
        long res= db.insert(TABLE_SKILL,null,contentValues);
        return res != -1;
    }
    public boolean insertLanguage(String name,String level,long studentId){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put(col_2_language,name);
        contentValues.put(col_3_language,level);
        contentValues.put(col_studentId,studentId);
        long res= db.insert(TABLE_LANGUAGE,null,contentValues);
        return res != -1;
    }
    public boolean insertInterest(String name,long studentId){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put(col_2_interest,name);
        contentValues.put(col_studentId,studentId);
        long res= db.insert(TABLE_INTEREST,null,contentValues);
        return res != -1;
    }

    public Cursor getAllStudents(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("select * from "+TABLE_STUDENT,null);
    }

}
