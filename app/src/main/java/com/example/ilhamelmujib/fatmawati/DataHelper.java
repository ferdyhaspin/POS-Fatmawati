package com.example.ilhamelmujib.fatmawati;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilhamelmujib on 7/29/17.
 */

public class DataHelper extends SQLiteOpenHelper{

    public static final String db = "db_fatmawati.db";
    public static final String tb_user = "tb_user";
    public static final String tb_menu = "tb_menu";
    public static final String tb_jm = "tb_jenis_menu";
    public static final String tb_tmp = "tb_temporary";

    public static final List<String> create = new ArrayList<String>(){{
        add("create table " + tb_user + " (id_user integer PRIMARY KEY  , nama text)");
        add("create table " + tb_menu + " (id_menu integer auto_increament PRIMARY KEY, nama text, id_jenis integer, harga text)");
        add("create table " + tb_jm + " (id_jenis integer auto_increament PRIMARY KEY, nama text)");
        add("create table " + tb_tmp + " (id_menu integer PRIMARY KEY, qty, subtotal)");
    }};

    public static final List<String> table = new ArrayList<String>(){{
        add(tb_user);
        add(tb_menu);
        add(tb_jm);
        add(tb_tmp);
    }};



    public DataHelper(Context context) {
        super(context, db, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        for (int i = 0; i < create.size(); i++){
            sqLiteDatabase.execSQL(create.get(i));
        }
        try {
            String sql = "INSERT INTO tb_user (id_user, nama) VALUES ('1234', 'Muhamad Ilham');";
            sqLiteDatabase.execSQL(sql);
        }catch (SQLException e){
            System.out.print(e.toString());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        for (int j = 0; j < table.size(); j++){
            sqLiteDatabase.execSQL(table.get(j));
        }
    }
}
