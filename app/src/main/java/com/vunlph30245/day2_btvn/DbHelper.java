package com.vunlph30245.day2_btvn;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "SanPhamDB";
    private static final int DATABASE_VERSION = 4;


    private static final String CREATE_TABLE_SANPHAM = "CREATE TABLE SanPham (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "TenSP TEXT, " +
            "Price INTEGER," +
            "LinkAnh TEXT)";


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_SANPHAM);

        String linkAnh1 = "https://i0.wp.com/crmviet.vn/wp-content/uploads/2019/05/phan-loai-san-pham-theo-thoi-gian-su-dung.jpg?resize=800%2C400&ssl=1";
        String linkAnh2 = "https://assets.unileversolutions.com/v1/63244081.png";
        String linkAnh3 = "https://bizweb.dktcdn.net/thumb/grande/100/324/808/products/z5348890183714-c15ddbd3d5eba9caade9530f12564513.jpg?v=1713148546573";
        String linkAnh4 = "https://vinpack.vn/uploads/images/2023/11/1700550312-multi_product11-intuinilongmangghep.jpg";

        db.execSQL("INSERT INTO SanPham (TenSP, Price, LinkAnh) VALUES ('Kem', 100.0,'" + linkAnh1 +"')");
        db.execSQL("INSERT INTO SanPham (TenSP, Price, LinkAnh) VALUES ('Xôi', 200.0,'" + linkAnh2 +"')");

        db.execSQL("INSERT INTO SanPham (TenSP, Price, LinkAnh) VALUES ('SP 3', 400.0,'" + linkAnh3 +"')");

        db.execSQL("INSERT INTO SanPham (TenSP, Price, LinkAnh) VALUES ('SP 4', 300.0,'" + linkAnh4 +"')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS SanPham");
        onCreate(db);
    }
}
