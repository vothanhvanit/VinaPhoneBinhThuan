package com.example.vinaphonebinhthuan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.vinaphonebinhthuan.R;
import com.example.vinaphonebinhthuan.model.KhachHangNgoaiMang;
import com.example.vinaphonebinhthuan.util.VanvtUtil;

import java.util.ArrayList;
import java.util.List;

public class KhachHangNgoaiMangAdapter extends ArrayAdapter<KhachHangNgoaiMang> {
    private Context context;
    private int resource;
    private ArrayList<KhachHangNgoaiMang> arrayListKHNM;

    public KhachHangNgoaiMangAdapter(@NonNull Context context, int resource, @NonNull ArrayList<KhachHangNgoaiMang> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource= resource;
        this.arrayListKHNM = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
     convertView = LayoutInflater.from(this.context).inflate(R.layout.item_khachangngoaimang, parent,false);

     //Khỏi tạo Textview
        TextView tv_stt = convertView.findViewById(R.id.tv_stt);
        TextView tv_name = convertView.findViewById(R.id.tv_name);
        TextView tv_mobile = convertView.findViewById(R.id.tv_mobile);
        TextView tv_nam_sinh = convertView.findViewById(R.id.tv_nam_sinh);
        TextView tv_nghe_nghiep = convertView.findViewById(R.id.tv_nghe_nghiep);
        TextView tv_diachi = convertView.findViewById(R.id.tv_diachi);
        TextView tv_nhom_thoi_luong = convertView.findViewById(R.id.tv_nhom_thoi_luong);

     //Map giá trị vào Textview
       KhachHangNgoaiMang iKhachHang =  arrayListKHNM.get(position);
       tv_stt.setText((position+1) +"");
       if(iKhachHang.getmTen()!=null) {
            tv_name.setText("Tên KH: " +iKhachHang.getmTen());
       } else {
           tv_name.setText("Tên KH: Chưa cập nhật" );

       }

       tv_mobile.setText("SĐT: "+ VanvtUtil.format_sdt(iKhachHang.getmDienthoai()));
       tv_nam_sinh.setText("Năm sinh: "+ iKhachHang.getmNamSinh() +"");
        if(iKhachHang.getmNgheNghiep()!=null) {
          tv_nghe_nghiep.setText("Nghề nghiệp: " + iKhachHang.getmNgheNghiep());
        } else {
            tv_nghe_nghiep.setText("Nghề nghiệp: chưa cập nhật" );
        }
        if(iKhachHang.getmDiaChi()!=null) {
            tv_diachi.setText("Địa chỉ: "+ iKhachHang.getmDiaChi());
        } else {
            tv_diachi.setText("Địa chỉ: Chưa cập nhật");
        }
        if(iKhachHang.getmNhomThoiLuong()!=null) {
            tv_nhom_thoi_luong.setText("Thời lượng: " + iKhachHang.getmNhomThoiLuong());
        } else {
            tv_nhom_thoi_luong.setText("Thời lượng: chưa cập nhật" );
        }

        return convertView;
    }
}
