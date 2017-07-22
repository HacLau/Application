package com.qingcheng.application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText user;
    private EditText password;
    Button login;
    Button forget;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initData();
    }

    private void initView() {
        user = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        forget = (Button) findViewById(R.id.forget);
        register = (Button) findViewById(R.id.register);
    }

    private void initData() {
        register.setOnClickListener(this);
        login.setOnClickListener(this);
        forget.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                verification();
                break;
            case R.id.forget:
                startActivity(new Intent(LoginActivity.this, ForgetPasswordActivity.class));
                break;
            case R.id.register:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                //finish();
                break;
        }
    }

    private void verification() {
        String userName = user.getText().toString().trim();
        String Password = password.getText().toString().trim();
       /* if(TextUtils.isEmpty(userName) || TextUtils.isEmpty(userName)){
            Toast.makeText(LoginActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
            return ;
        }
        if(Password.length() < 6){
            Toast.makeText(LoginActivity.this, "密码太短，请重新输入", Toast.LENGTH_SHORT).show();
            return ;
        }
        if(Password.length() > 20){
            Toast.makeText(LoginActivity.this, "密码太长，请重新输入", Toast.LENGTH_SHORT).show();
            return ;
        }*/
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }
}
