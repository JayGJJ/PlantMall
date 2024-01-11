package com.gjj033.plantmall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.gjj033.plantmall.db.UserDbHelper;
import com.gjj033.plantmall.entity.UserInfo;

public class LoginActivity extends AppCompatActivity {
    private EditText et_username,et_password;
    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //获取mSharedPreferences
        mSharedPreferences = getSharedPreferences("user",MODE_PRIVATE);

        //初始化控件
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);

//        点击注册
        findViewById(R.id.register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到注册页面
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        //登录
        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取用户名和密码
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                //判断用户名和密码是否为空
                if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
                    //提示用户
                    Toast.makeText(LoginActivity.this,"请输入用户名和密码",Toast.LENGTH_SHORT).show();
                }else {
                    UserInfo login = UserDbHelper.getInstance(LoginActivity.this).login(username);
                    if (login!=null){
                        if(username.equals(login.getUsername()) && password.equals(login.getPassword())){
                            //保存用户信息
                            UserInfo.setsUserInfo(login);

                            //登陆成功
                            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                            startActivity(intent);
                        }else {
                            //提示用户
                            Toast.makeText(LoginActivity.this,"用户名或密码错误",Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        //提示用户
                        Toast.makeText(LoginActivity.this,"该账号未注册",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}