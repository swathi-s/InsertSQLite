package com.example.user.insertsqlite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userName, password;
    SwathiDatabaseAdapter swathiHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
    }

    public void addUser(View view) {

        String user = userName.getText().toString();
        String pass = password.getText().toString();

        long id = swathiHelper.insertData(user,pass);

        if(id < 0)
        {
            Toast.makeText(this,"unsuccessfull",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"Successfully added the user to db with id "+id,Toast.LENGTH_SHORT).show();
        }
    }
}
