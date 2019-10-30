package com.example.assigment;

public class Courses {

    private String tenKhoaHoc, thoiGian;

    public Courses() {
    }

    public Courses(String tenKhoaHoc, String thoiGian) {
        this.tenKhoaHoc = tenKhoaHoc;
        this.thoiGian = thoiGian;
    }

    public String getTenKhoaHoc() {
        return tenKhoaHoc;
    }

    public void setTenKhoaHoc(String tenKhoaHoc) {
        this.tenKhoaHoc = tenKhoaHoc;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }
}
