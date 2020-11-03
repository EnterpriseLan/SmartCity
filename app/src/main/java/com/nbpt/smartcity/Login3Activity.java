package com.nbpt.smartcity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.database.Cursor;

public class Login3Activity extends Activity {
    private EditText edtUsername,edtPassword;
    private Button btnSubmit,btnRegister;
    private SharedPreferences sp;
    private CheckBox checkbox,checkAuto;
    private boolean isCheck = false,isAuto = false;
    private String sUsername,sPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login3);

        sp = Login3Activity.this.getSharedPreferences("user_info", Context.MODE_PRIVATE);

        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        btnSubmit = findViewById(R.id.btn_submit);
        btnRegister = findViewById(R.id.btn_register);
        checkbox = findViewById(R.id.is_check);
        checkAuto = findViewById(R.id.check_auto);

        edtUsername.setHint("请输入用户名");
        edtPassword.setHint("请输入密码");

        sUsername = sp.getString("username","");
        sPassword = sp.getString("password","");


        if(sp.getBoolean("isAuto",false))
        {
            if(!sp.getString("username","").isEmpty())
            {
                finish();
                Intent intent = new Intent(Login3Activity.this,IndexActivity.class);
                startActivity(intent);
            }
        }

        if(sp.getBoolean("isCheck",false))
        {
            edtUsername.setText(sUsername);
            edtPassword.setText(sPassword);
            checkbox.setChecked(true);

        }
        if(sp.getBoolean("isAuto",false))
            checkAuto.setChecked(true);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn_submit:
                        String username =edtUsername.getText().toString();
                        String password =edtPassword.getText().toString();
                        if((!username.isEmpty())&&(!password.isEmpty())) {
                            if(isCheck)
                            {
                                SharedPreferences.Editor editor = sp.edit();
                                editor.putString("username",username);
                                editor.putString("password",password);
                                editor.putBoolean("ischeck",isCheck);
                                editor.putBoolean("isAuto",isAuto);
                                editor.commit();
                            }else{
                                SharedPreferences.Editor editor = sp.edit();
                                editor.clear();
                            }
                            AccountDBHelper db = new AccountDBHelper(Login3Activity.this, AccountDBHelper.VERSION_1);
                            Cursor cursor = db.select(null, null);
                            if (cursor.getCount() != 0) {
                                cursor.moveToFirst();
                                do {
                                    if (username.equals(db.getUsername(cursor)) && password.equals(db.getPassword(cursor))) {

                                        if (password.equals(db.getPassword(cursor)))
                                        {
                                            finish();
                                            Intent intent = new Intent(Login3Activity.this,IndexActivity.class);
                                            startActivity(intent);
                                        }
                                        else
                                            Toast.makeText(Login3Activity.this, "登录失败！", Toast.LENGTH_LONG).show();
                                    }
                                } while (cursor.moveToNext());
                                cursor.close();
                                break;
                            }
                        }else{
                            Toast.makeText(Login3Activity.this, "请输入用户名密码!", Toast.LENGTH_LONG).show();
                            break;
                        }

                    case R.id.btn_register:
                        Intent intent = new Intent(Login3Activity.this,RegisterActivity.class);
                        startActivity(intent);
                }
            }
        };
        btnSubmit.setOnClickListener(listener);
        btnRegister.setOnClickListener(listener);

        CompoundButton.OnCheckedChangeListener listener_checkbox = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                sp.edit().putBoolean("isCheck",b).commit();isCheck= b; //更新CheckBox勾选状态到变量中
            }
        };
        CompoundButton.OnCheckedChangeListener listener_auto = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                sp.edit().putBoolean("isAuto",b).commit();isAuto = b; //更新CheckBox勾选状态到变量中
            }
        };
        checkbox.setOnCheckedChangeListener(listener_checkbox);
        checkAuto.setOnCheckedChangeListener(listener_auto);
    }

}
