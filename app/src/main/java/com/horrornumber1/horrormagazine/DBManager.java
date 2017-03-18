package com.horrornumber1.horrormagazine;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.horrornumber1.horrormagazine.DataModel.FavoriteModel;

import java.util.ArrayList;

/**
 * Created by 김태호 on 2017-03-03.
 */

public class DBManager extends SQLiteOpenHelper {

    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE REGION ( _id INTEGER PRIMARY KEY AUTOINCREMENT, board TEXT, title TEXT, date TEXT);");
        sqLiteDatabase.execSQL("CREATE TABLE MILLITARY ( _id INTEGER PRIMARY KEY AUTOINCREMENT, board TEXT, title TEXT, date TEXT);");
        sqLiteDatabase.execSQL("CREATE TABLE REAL ( _id INTEGER PRIMARY KEY AUTOINCREMENT, board TEXT, title TEXT, date TEXT);");
        sqLiteDatabase.execSQL("CREATE TABLE COLLEGE ( _id INTEGER PRIMARY KEY AUTOINCREMENT, board TEXT, title TEXT, date TEXT);");
        sqLiteDatabase.execSQL("CREATE TABLE LORE ( _id INTEGER PRIMARY KEY AUTOINCREMENT, board TEXT, title TEXT, date TEXT);");
        sqLiteDatabase.execSQL("CREATE TABLE UNDERSTAND ( _id INTEGER PRIMARY KEY AUTOINCREMENT, board TEXT, title TEXT, date TEXT);");
        sqLiteDatabase.execSQL("CREATE TABLE CITY ( _id INTEGER PRIMARY KEY AUTOINCREMENT, board TEXT, title TEXT, date TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
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
