package com.example.vinaphonebinhthuan.controller;

import com.example.vinaphonebinhthuan.model.JDBCModel;
import java.sql.Connection;

public class JDBCController {
    JDBCModel JdbcModel = new JDBCModel();

    public Connection ConnnectionData() {
        return JdbcModel.getConnectionOf();
    }
}
