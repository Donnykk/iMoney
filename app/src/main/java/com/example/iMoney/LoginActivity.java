package com.example.iMoney;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    private EditText phone;     //输入手机号
    private EditText password;      //密码
    private static final String ipAddress = "172.25.41.21";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        Objects.requireNonNull(this.getSupportActionBar()).hide();
        //获取变量值
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);
        //登录按钮
        Button btn1 = findViewById(R.id.btn_login);
        btn1.setOnClickListener(new myClick());
    }

    class myClick implements View.OnClickListener {
        @SuppressLint("NonConstantResourceId")
        public void onClick(View v) {
            // TODO Auto-generated method stub
            if (v.getId() == R.id.btn_login) {
                try {
                    //管理员账号直接登录
                    if (phone.getText().toString().equals("root")
                            && password.getText().toString().equals("root")) {
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                    } else {
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                                .detectDiskReads().detectDiskWrites()
                                .detectNetwork().penaltyLog().build());
                        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                                .detectLeakedSqlLiteObjects().penaltyLog()
                                .penaltyDeath().build());
                        Socket s1 = new Socket(ipAddress, 6666);
                        OutputStream os = s1.getOutputStream();
                        DataOutputStream dos = new DataOutputStream(os);
                        dos.writeUTF(phone.getText().toString() + " " + password.getText().toString() + " " + "Login"); // 向服务器传送登录账号和密码
                        //等一秒钟
                        new Handler().postDelayed(new Runnable() {
                            public void run() {
                            }
                        }, 1000);
                        InputStream is = s1.getInputStream();
                        DataInputStream dis = new DataInputStream(is);
                        String getStr = dis.readUTF(); //YES或者NO
                        if (getStr.equals("YES")) {
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            finish();
                        } else if (getStr.equals("NO")) {
                            Toast.makeText(getApplicationContext(), "登录失败", Toast.LENGTH_SHORT).show();
                        }
                        dis.close();
                        dos.close();
                        s1.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}