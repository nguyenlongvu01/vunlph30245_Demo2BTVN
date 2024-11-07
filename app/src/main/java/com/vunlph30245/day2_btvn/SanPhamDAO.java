package com.vunlph30245.day2_btvn;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

public class SanPhamDAO {
    private SQLiteDatabase db;

    public SanPhamDAO(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public ArrayList<SanPham> getDS() {
        ArrayList<SanPham> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT TenSP, Price, LinkAnh FROM SanPham", null);
        while (cursor.moveToNext()) {
            String tenSP = cursor.getString(0);
            int price = cursor.getInt(1);
            String linkAnh = cursor.getString(2);
            list.add(new SanPham(tenSP, price, linkAnh)); // Khởi tạo SanPham với 3 tham số
        }
        cursor.close();
        return list;
    }

}

