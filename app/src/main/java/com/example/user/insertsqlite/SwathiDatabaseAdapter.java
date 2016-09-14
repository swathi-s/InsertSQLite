package com.example.user.insertsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.Contacts;
import android.widget.Toast;

/**
 * Created by user on 9/12/2016.
 */
public class SwathiDatabaseAdapter {


    SwathiHelper helper;
    public void insertData (Context context)
    {
        helper = new SwathiHelper(context);
    }

    public long insertData(String name, String password)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SwathiHelper.NAME,name);
        contentValues.put(SwathiHelper.PASSWORD,password);
        long id = db.insert(SwathiHelper.TABLE_NAME,null,contentValues);
        return id;
    }
    static class SwathiHelper  extends SQLiteOpenHelper{
        private static final String DATABASE_NAME = "myDatabase";
        private static final String TABLE_NAME = "myTable";
        private static final int DATABASE_VERSION = 1;
        private static final String UID = "_id";
        private static final String NAME = "Name";
        private static final String PASSWORD = "Password";
        private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " + UID + " INTEGER PRIMARY KEY AUTOINCREMENT " + NAME + " VARCHAR(255), " + PASSWORD + " VARCHAR(255))";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        private Context context;

        public SwathiHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
            Toast.makeText(context, "Constructor method is called", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            try {
                Toast.makeText(context, "onCreate method called", Toast.LENGTH_SHORT).show();
                db.execSQL(CREATE_TABLE);
            } catch (SQLException e) {
                Toast.makeText(context, "exception is " + e, Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Toast.makeText(context, "onUpdate method called", Toast.LENGTH_SHORT).show();
                db.execSQL(DROP_TABLE);
                onCreate(db);
            } catch (SQLException e) {
                Toast.makeText(context, "exception is " + e, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
