package com.example.controllibros_;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {

    Producto campohelp = new Producto();
    static final String DB_NAME = "Libros.db";
    static final int DB_VERSION = 1;
    private  final String CREATE_TABLE = "create table if not exists "
            + campohelp.getTabla() + "(" + campohelp.getCampos() + " );";

    public DBhelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + campohelp.getTabla());

        onCreate(sqLiteDatabase);
    }
}
