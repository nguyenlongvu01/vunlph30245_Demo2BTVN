package com.vunlph30245.day2_btvn;

import android.os.Bundle;
import android.view.MotionEvent;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerDanhSach;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerDanhSach = findViewById(R.id.recyclerDanhSach);
        SanPhamDAO sanPhamDAO = new SanPhamDAO(MainActivity.this);
        ArrayList<SanPham> list = sanPhamDAO.getDS();

        // Thiết lập LayoutManager cho RecyclerView
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerDanhSach.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerHorizontal = new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
//        dividerHorizontal.setDrawable(ContextCompat.getDrawable(this, android.R.drawable.divider_horizontal_bright));

        recyclerDanhSach.addItemDecoration(dividerHorizontal);

        // Khởi tạo Adapter và gán cho RecyclerView
        SanPhamAdapter adapter = new SanPhamAdapter(this,list);
        recyclerDanhSach.setAdapter(adapter);



    }
}