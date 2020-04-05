package com.example.vinaphonebinhthuan.model;

public class KhachHangNgoaiMang {
    private String mTen;
    private int mNamSinh;
    private String mDienthoai;
    private String mNhomThoiLuong;
    private String mDiaChi;
    private String mNgheNghiep;

    public KhachHangNgoaiMang(String mTen, int mNamSinh, String mDienthoai, String mNhomThoiLuong, String mDiaChi, String mNgheNghiep) {
        this.mTen = mTen;
        this.mNamSinh = mNamSinh;
        this.mDienthoai = mDienthoai;
        this.mNhomThoiLuong = mNhomThoiLuong;
        this.mDiaChi = mDiaChi;
        this.mNgheNghiep = mNgheNghiep;
    }

    public String getmTen() {
        return mTen;
    }

    public void setmTen(String mTen) {
        this.mTen = mTen;
    }

    public int getmNamSinh() {
        return mNamSinh;
    }

    public void setmNamSinh(int mNamSinh) {
        this.mNamSinh = mNamSinh;
    }

    public String getmDienthoai() {
        return mDienthoai;
    }

    public void setmDienthoai(String mDienthoai) {
        this.mDienthoai = mDienthoai;
    }

    public String getmNhomThoiLuong() {
        return mNhomThoiLuong;
    }

    public void setmNhomThoiLuong(String mNhomThoiLuong) {
        this.mNhomThoiLuong = mNhomThoiLuong;
    }

    public String getmDiaChi() {
        return mDiaChi;
    }

    public void setmDiaChi(String mDiaChi) {
        this.mDiaChi = mDiaChi;
    }

    public String getmNgheNghiep() {
        return mNgheNghiep;
    }

    public void setmNgheNghiep(String mNgheNghiep) {
        this.mNgheNghiep = mNgheNghiep;
    }
}
