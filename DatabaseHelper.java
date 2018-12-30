package com.example.personal.diary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Diary.db";
    public static final String TABLE_NAME = "diary" ;
    public static final String TABLE_1 = "id_remember";
    public static int id = 1;
    public static final String col1 = "HEADING";
    public static final String col2 = "DESCRIPTION";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(" CREATE TABLE " + TABLE_NAME + " (heading TEXT , description TEXT) ");
        db.execSQL("create table " + TABLE_1+ "(ID INTEGER)");
        db.execSQL("insert into " + TABLE_1 + " values " + "( " + id + " )" );
        id++;
        Log.d("INSIDE" , "CREATE TABLE");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("drop table if exists " +TABLE_1);
        Log.d("INSIDE" , "ONUPGRADE");
        onCreate(db);
    }

    public boolean insert(String heading , String description)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col1 , heading);
        contentValues.put(col2,description);
        long result = db.insert(TABLE_NAME , null , contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }

    public boolean deleteEntry(String heading){
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(TABLE_NAME , " HEADING = ? " , new String[]{heading});
        if(result>0)
            return true;
        else
            return false;
    }

    public Cursor getId()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT ID from " + TABLE_1 , null);

        return cursor ;
    }


    public Cursor getData(int id){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(" select * from " +TABLE_NAME + " where ID = ? "  , new String[] {String.valueOf(id)});
        return cursor;
    }

    public String[] getDescription(String heading )
    {
        String actual_heading, description_database;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME + " where lower(heading) like ? " , new String[]{ '%' + heading.toLowerCase() + '%'});
        if (cursor != null && cursor.moveToFirst()){

            actual_heading = cursor.getString(0);
            description_database = cursor.getString(1);
            String[] result = new String[]{actual_heading , description_database};
            return result;
        }
        else{

            description_database = null;
            return null;
        }

    }

    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME , null);
        return cursor;
    }
}
