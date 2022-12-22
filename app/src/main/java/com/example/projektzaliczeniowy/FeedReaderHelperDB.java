package com.example.projektzaliczeniowy;

import static com.example.projektzaliczeniowy.FeedReaderContract.DELETE_KOMPUTER;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class FeedReaderHelperDB extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Sklep.db";
    String TAG = "BAZA";



    public FeedReaderHelperDB(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        Log.v(TAG,"Create działa");
        sqLiteDatabase.execSQL(FeedReaderContract.CREATE_KOMPUTER_TABLE);
//        sqLiteDatabase.execSQL(CREATE_MOUSE);
//        sqLiteDatabase.execSQL(CREATE_KEYBOARD);
//        sqLiteDatabase.execSQL(CREATE_CAMERA);
//        sqLiteDatabase.execSQL(CREATE_SET);
//        sqLiteDatabase.execSQL(CREATE_ORDER);

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.v(TAG,"Działa");

//        sqLiteDatabase.execSQL(DROP_USER_TABLE);
        sqLiteDatabase.execSQL(DELETE_KOMPUTER);
//        sqLiteDatabase.execSQL(DELETE_KEYBOARD);
//        sqLiteDatabase.execSQL(DELETE_CAMERA);
//        sqLiteDatabase.execSQL(DELETE_SET);
//        sqLiteDatabase.execSQL(DROP_ORDER);
//        onCreate(sqLiteDatabase);
    }

}
