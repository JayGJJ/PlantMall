package com.gjj033.plantmall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.gjj033.plantmall.db.UserDbHelper;

public class RegisterActivity extends AppCompatActivity {

    private EditText et_username,et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //初始化控件
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);

        //返回
        findViewById(R.id.toolbar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //点击注册
        findViewById(R.id.register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取用户名和密码
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();

                //判断用户名和密码是否为空
                if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
                    //提示用户
                    Toast.makeText(RegisterActivity.this,"用户名或密码不能为空",Toast.LENGTH_SHORT).show();
                }else {
                    int row = UserDbHelper.getInstance(RegisterActivity.this).register(username, password, "暂无~~~");
                    if (row > 0) {
                        //提示用户
                        Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                        //返回
                        finish();
                    }
                }

            }
        });
    }
}