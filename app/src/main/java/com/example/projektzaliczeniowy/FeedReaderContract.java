package com.example.projektzaliczeniowy;

import android.provider.BaseColumns;

public class FeedReaderContract {

    public static class komputer implements BaseColumns {
        public static final String TABLE_KOMPUTER = "komputer";
        public static final String COLUMN_KOMPUTER_ID = "komputer_id"; //integer
        public static final String COLUMN_KOMPUTER_NAME = "komputer_name"; //text unique
        public static final String COLUMN_KOMPUTER_PRICE = "komputer_price";
    }




    public static final String CREATE_KOMPUTER_TABLE =
            "CREATE TABLE "
                    + komputer.TABLE_KOMPUTER + "("
                    + komputer.COLUMN_KOMPUTER_ID + " INTEGER PRIMARY KEY,"
                    + komputer.COLUMN_KOMPUTER_NAME + " TEXT NOT NULL,"
                    + komputer.COLUMN_KOMPUTER_PRICE + " INT NOT NULL"
                    + ")";


    public static final String DELETE_KOMPUTER =
            "DROP TABLE IF EXISTS "
                    + komputer.TABLE_KOMPUTER;
}

