package com.nbpt.smartcity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
    private EditText edtName,edtPassword;
    private Button btnClear,btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edtName = findViewById(R.id.text_username);
        //edtName.setText("admin");

        edtPassword = findViewById(R.id.text_password);
        String password = edtPassword.getText().toString();

        //Log.d("TGA","密码："+password);

        btnClear = findViewById(R.id.btn_clear);
        btnSubmit = findViewById(R.id.btn_submit);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               switch (view.getId()) {
                   case R.id.btn_clear:
                       edtName.setText("");
                       edtPassword.setText("");
                       break;
                   case R.id.btn_submit:
                       String username = edtName.getText().toString();
                       String password = edtPassword.getText().toString();
                       if((username.equals("admin"))&&(password.equals("123456"))) {
                           Toast.makeText(LoginActivity.this,"登录成功！",Toast.LENGTH_LONG).show();
                           setContentView(R.layout.activity_main);
                       }else {
                           Toast.makeText(LoginActivity.this,"用户名密码错误！",Toast.LENGTH_LONG).show();
                       }
                       break;
               }
            }
        };
        btnClear.setOnClickListener(listener);
        btnSubmit.setOnClickListener(listener);





    }
}
