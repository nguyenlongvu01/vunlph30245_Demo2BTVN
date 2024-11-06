package com.vunlph30245.day2_btvn;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "SanPhamDB";
    private static final int DATABASE_VERSION = 1;


    private static final String CREATE_TABLE_SANPHAM = "CREATE TABLE SanPham (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "TenSP TEXT, " +
            "Price INTEGER)";


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_SANPHAM);

        db.execSQL("INSERT INTO SanPham (TenSP, Price) VALUES ('Kem', 100.0)");
        db.execSQL("INSERT INTO SanPham (TenSP, Price) VALUES ('Xôi', 200.0)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS SanPham");
        onCreate(db);
    }
}
