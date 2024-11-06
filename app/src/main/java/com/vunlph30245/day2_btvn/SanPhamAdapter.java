package com.vunlph30245.day2_btvn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.SanPhamViewHolder> {

    private ArrayList<SanPham> sanPhamList;

    // Constructor nhận danh sách sản phẩm
    public SanPhamAdapter(ArrayList<SanPham> sanPhamList) {
        this.sanPhamList = sanPhamList;
    }

    // ViewHolder chứa các thành phần của item_san_pham
    public static class SanPhamViewHolder extends RecyclerView.ViewHolder {
        public TextView txtTenSP, txtPrice;

        public SanPhamViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTenSP = itemView.findViewById(R.id.txtTenSP);
            txtPrice = itemView.findViewById(R.id.txtPrice);

        }
    }

    @NonNull
    @Override
    public SanPhamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view, parent, false);
        return new SanPhamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SanPhamViewHolder holder, int position) {
        SanPham sanPham = sanPhamList.get(position);
        holder.txtTenSP.setText(sanPham.getTensp());
        holder.txtPrice.setText(String.valueOf(sanPham.getPrice())); // Chuyển giá trị price thành String
    }


    @Override
    public int getItemCount() {
        return sanPhamList.size();
    }
}
