package com.example.vinaphonebinhthuan;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.vinaphonebinhthuan.dao.UserDao;

import java.sql.SQLException;

public class LoginActivity extends AppCompatActivity {
    public static final String  USER_NAME = "USER_NAME";
    public static final String  PASSWORD = "PASSWORD";
    public static final String  USER_BUNDLE = "USER_BUNDLE";

    private EditText edt_username;
    private EditText edt_password;
    private UserDao userDao = new UserDao();


    private Button btnLogin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edt_username = (EditText)findViewById(R.id.edt_username);
        edt_password = (EditText)findViewById(R.id.edt_password);
        btnLogin =  (Button)findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username =edt_username.getText().toString();
                String password = edt_password.getText().toString();
                try {
                    boolean checkLogin = userDao.checkLogin(username, password);
                    if(checkLogin==true) {
                        sendDataByBundle(username , password);
                    } else {
                        Toast.makeText(LoginActivity.this,"Xin vui lòng kiểm tra lại User", Toast.LENGTH_LONG ).show();
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });


    }

    private void sendDataByBundle(String username, String password) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        Bundle user_bundle = new Bundle();
        user_bundle.putString(USER_NAME, username);
        user_bundle.putString(PASSWORD, password);
        intent.putExtra(USER_BUNDLE, user_bundle);
        startActivity(intent);

    }
}
