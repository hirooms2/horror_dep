package com.horrornumber1.horrordepartment.Module;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.horrornumber1.horrordepartment.DataModel.FavoriteModel;

import java.util.ArrayList;


public class DBManager extends SQLiteOpenHelper {

    String TAG = "DBManager";

    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

        SQLiteDatabase db = getWritableDatabase();

        Cursor c = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);

        if (c.moveToFirst()) {
            while ( !c.isAfterLast() ) {
                Log.d(TAG, "DBManager: " + c.getString(0));
                c.moveToNext();
            }
        }

        InitNotification();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d(TAG, "onCreate: ");
        sqLiteDatabase.execSQL("CREATE TABLE REGION2 ( _id INTEGER PRIMARY KEY AUTOINCREMENT, board TEXT, title INTEGER);");
        sqLiteDatabase.execSQL("CREATE TABLE MILLITARY2 ( _id INTEGER PRIMARY KEY AUTOINCREMENT, board TEXT, title INTEGER);");
        sqLiteDatabase.execSQL("CREATE TABLE REAL2 ( _id INTEGER PRIMARY KEY AUTOINCREMENT, board TEXT, title INTEGER);");
        sqLiteDatabase.execSQL("CREATE TABLE COLLEGE2 ( _id INTEGER PRIMARY KEY AUTOINCREMENT, board TEXT, title INTEGER);");
        sqLiteDatabase.execSQL("CREATE TABLE LORE2 ( _id INTEGER PRIMARY KEY AUTOINCREMENT, board TEXT, title INTEGER);");
        sqLiteDatabase.execSQL("CREATE TABLE UNDERSTAND2 ( _id INTEGER PRIMARY KEY AUTOINCREMENT, board TEXT, title INTEGER);");
        sqLiteDatabase.execSQL("CREATE TABLE CITY2 ( _id INTEGER PRIMARY KEY AUTOINCREMENT, board TEXT, title INTEGER);");



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d(TAG, "onUpgrade: ");
        sqLiteDatabase.execSQL("CREATE TABLE NOTIFICATION ( _id INTEGER PRIMARY KEY AUTOINCREMENT, ck INTEGER);");
    }

    public void insert(String _query) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(_query);
        db.close();
    }

    public void update(String _query) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(_query);
        db.close();
    }

    public void delete(String _query) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(_query);
        db.close();
    }

    public String PrintData(String board) {
        SQLiteDatabase db = getReadableDatabase();
        String str = "";

        Cursor cursor = db.rawQuery("select * from "+ board, null);
        Log.i("count: ", Integer.toString(cursor.getCount()));
        while(cursor.moveToNext()) {
            str += cursor.getInt(0)
                    + " : board "
                    + cursor.getString(1)
                    + ", title = "
                    + cursor.getString(2)
                    + "\n";
        }

        return str;
    }

    public boolean Notification(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from NOTIFICATION", null);

        if(cursor.moveToNext()) {
            if(cursor.getInt(1)==1)
                return true;
            else
                return false;
        }
        return false;
    }

    public void InitNotification(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from NOTIFICATION", null);

        if(cursor.getCount()==0) {
            insert("INSERT INTO NOTIFICATION values(null, 1)");
        }
    }

    public boolean FindData(String board, int position) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+ board + " where title=" +Integer.toString(position), null);

        if(cursor.getCount()==1)
            return true;
        else
            return false;
    }

    public ArrayList<FavoriteModel> PrintAll() {
        SQLiteDatabase db = getReadableDatabase();
        String str="";
        ArrayList<FavoriteModel> list = new ArrayList<>();
        for(int i=0; i<7 ; i++) {
            Cursor cursor = db.rawQuery("select * from " + whichTable(i), null);
            while(cursor.moveToNext()) {
                FavoriteModel data = new FavoriteModel();
                data.setBoard(cursor.getString(1));
                data.setTitle(cursor.getString(2));
                data.setDate(cursor.getString(3));
                list.add(data);
            }
        }
        return list;
    }

    private String whichTable(int i) {
        switch (i)
        {
            case 0:
                return "REGION";
            case 1:
                return "MILLITARY";
            case 2:
                return "REAL";
            case 3:
                return "COLLEGE";
            case 4:
                return "LORE";
            case 5:
                return "UNDERSTAND";
            case 6:
                return "CITY";
        }
        return null;
    }
}