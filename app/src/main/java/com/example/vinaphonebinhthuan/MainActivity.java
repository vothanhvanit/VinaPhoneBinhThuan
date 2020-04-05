package com.example.vinaphonebinhthuan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.vinaphonebinhthuan.adapter.KhachHangNgoaiMangAdapter;
import com.example.vinaphonebinhthuan.dao.KhacHangNgoaiMangDao;
import com.example.vinaphonebinhthuan.model.KhachHangNgoaiMang;

import java.sql.SQLException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv ;
    Button btn_search;
    EditText edit_sdt;
    ArrayList<KhachHangNgoaiMang> arrayList;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView)findViewById(R.id.lv_khachhang);
        btn_search = (Button)findViewById(R.id.btn_search);
        edit_sdt =   (EditText) findViewById(R.id.edt_sodt);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sdt = edit_sdt.getText().toString();
                KhacHangNgoaiMangDao abc = new KhacHangNgoaiMangDao();
                KhacHangNgoaiMangDao abc1 = new KhacHangNgoaiMangDao();
                try {
                    arrayList = (ArrayList<KhachHangNgoaiMang>) abc.getuserlist(sdt);
                    //Chèn dữ liệu tìm kiếm
                    Intent intent = getIntent();
                    Bundle bundle = intent.getBundleExtra(LoginActivity.USER_BUNDLE);
                    username = bundle.getString(LoginActivity.USER_NAME);
                    abc1.Insert(username,sdt);

                } catch (SQLException e) {
                    e.printStackTrace();
                }

                KhachHangNgoaiMangAdapter adapterkh = new KhachHangNgoaiMangAdapter(getApplicationContext(),  R.layout.item_khachangngoaimang, arrayList);
                lv.setAdapter(adapterkh);
            }
        });
       // KhachHangNgoaiMang vtv = new KhachHangNgoaiMang("Võ Thành Văn", 1983, "0916487007", "Tren 500" , "Đia chỉ: Khu phố 1, Phường Phú tài, TP. Phan Thiết, Bình Thuận","Nông dân");
        //KhachHangNgoaiMang vtv2 = new KhachHangNgoaiMang("Võ Thành Văn 2", 1983, "0916487007", "Tren 500" , "Đia chỉ: Khu phố 1, Phường Phú tài, TP. Phan Thiết, Bình Thuận","Nông dân");
        //KhachHangNgoaiMang vtv3 = new KhachHangNgoaiMang("Võ Thành Văn 2", 1983, "0916487007", "Tren 500" , "Đia chỉ: Khu phố 1, Phường Phú tài, TP. Phan Thiết, Bình Thuận","Nông dân");
        //KhachHangNgoaiMang vtv4 = new KhachHangNgoaiMang("Võ Thành Văn 2", 1983, "0916487007", "Tren 500" , "Đia chỉ: Khu phố 1, Phường Phú tài, TP. Phan Thiết, Bình Thuận","Nông dân");
        //KhachHangNgoaiMang vtv5 = new KhachHangNgoaiMang("Võ Thành Văn 2", 1983, "0916487007", "Tren 500" , "Đia chỉ: Khu phố 1, Phường Phú tài, TP. Phan Thiết, Bình Thuận","Nông dân");
        //KhachHangNgoaiMang vtv6 = new KhachHangNgoaiMang("Võ Thành Văn 2", 1983, "0916487007", "Tren 500" , "Đia chỉ: Khu phố 1, Phường Phú tài, TP. Phan Thiết, Bình Thuận","Nông dân");
        //KhachHangNgoaiMang vtv7 = new KhachHangNgoaiMang("Võ Thành Văn 2", 1983, "0916487007", "Tren 500" , "Đia chỉ: Khu phố 1, Phường Phú tài, TP. Phan Thiết, Bình Thuận","Nông dân");
        //KhachHangNgoaiMang vtv8 = new KhachHangNgoaiMang("Võ Thành Văn 2", 1983, "0916487007", "Tren 500" , "Đia chỉ: Khu phố 1, Phường Phú tài, TP. Phan Thiết, Bình Thuận","Nông dân");
        //KhachHangNgoaiMang vtv9 = new KhachHangNgoaiMang("Võ Thành Văn 2", 1983, "0916487007", "Tren 500" , "Đia chỉ: Khu phố 1, Phường Phú tài, TP. Phan Thiết, Bình Thuận","Nông dân");
        //KhachHangNgoaiMang vtv10 = new KhachHangNgoaiMang("Võ Thành Văn 2", 1983, "0916487007", "Tren 500" , "Đia chỉ: Khu phố 1, Phường Phú tài, TP. Phan Thiết, Bình Thuận","Nông dân");
        //arrayList.add(vtv)  ;
        //arrayList.add(vtv2)  ;
        //arrayList.add(vtv3)  ;
        //arrayList.add(vtv4)  ;
        //arrayList.add(vtv5)  ;
        //arrayList.add(vtv6)  ;
        //arrayList.add(vtv7)  ;
        //arrayList.add(vtv8)  ;
        //arrayList.add(vtv9)  ;
        //arrayList.add(vtv10)  ;



    }
}
