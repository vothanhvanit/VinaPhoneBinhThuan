package com.example.vinaphonebinhthuan.dao;

import com.example.vinaphonebinhthuan.controller.JDBCController;
import com.example.vinaphonebinhthuan.model.KhachHangNgoaiMang;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class KhacHangNgoaiMangDao {
    private JDBCController jdbcController = new JDBCController();
    private Connection connection;

    public KhacHangNgoaiMangDao() {
        connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
    }


    public List<KhachHangNgoaiMang> getuserlist(String sdtCuoicung ) throws SQLException {
        List<KhachHangNgoaiMang> list = new ArrayList<KhachHangNgoaiMang>();
        //Check từ 4 số điện thoại trở lên mới thực hiện cho tìm kiếm
          if(sdtCuoicung.trim().length()>=4) {
              Statement statement = connection.createStatement();// Tạo đối tượng Statement.
              String sql = "select * from khach_hang_ngoai_mang where subcriber like '%" + sdtCuoicung + "' order by diachi desc ";
              // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
              ResultSet rs = statement.executeQuery(sql);
              while (rs.next()) {
                  KhachHangNgoaiMang iKH = new KhachHangNgoaiMang(rs.getString("ho_ten"),
                          rs.getInt("nam_sinh"),
                          rs.getString("subcriber"),
                          rs.getString("nhom_thoi_luong"),
                          rs.getString("diachi")
                          , rs.getString("nghe_nghiep")
                  );
                  list.add(iKH);// Đọc dữ liệu từ ResultSet
              }
              connection.close();// Đóng kết nối
          }
        return list;
    }

    public boolean Insert(String username, String cum_so_giong) throws SQLException {
        //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        DateFormat dateFormat= DateFormat.getDateInstance(DateFormat.LONG,
                Locale.US);
        java.util.Date utilDate = new java.util.Date();
        Statement statement = connection.createStatement();// Tạo đối tượng Statement.
        String sql = "insert into history_search_sdt_giong(username, cum_so_giong, thoi_diem) values('" + username + "','"+ cum_so_giong +"','" + dateFormat.format(new Date()) +"')";
        if (statement.executeUpdate(sql) > 0) { // Dùng lệnh executeUpdate cho các lệnh CRUD
            connection.close();
            return true;
        } else {
            connection.close();
            return false;
        }
    }

}
