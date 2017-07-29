package com.example.ilhamelmujib.fatmawati;


import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dataHelper;
    EditText pass;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dataHelper = new DataHelper(this);

         pass = (EditText) findViewById(R.id.password);
         btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View arg0) {
                try {
                    SQLiteDatabase db = dataHelper.getReadableDatabase();
                    cursor = db.rawQuery("SELECT * FROM tb_user WHERE id_user = '" + pass.getText().toString() + "'", null);
                    if(cursor.getCount() > 0){
                        cursor.moveToFirst();
                        Toast.makeText(getApplicationContext(), "Selamat datang " + cursor.getString(1).toString(), Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(), "Tidak Cocok!", Toast.LENGTH_LONG).show();
                        pass.setText("");
                    }
                } catch (SQLException e) {
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }
            }

        });
    }
}

