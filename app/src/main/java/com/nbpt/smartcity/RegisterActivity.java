package com.nbpt.smartcity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity {
    EditText edtUsername,edtPassword,edtConPassword;
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        edtConPassword = findViewById(R.id.edt_con_password);

        btnSubmit = findViewById(R.id.btn_submit);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn_submit:
                        String username = edtUsername.getText().toString();
                        String password = edtPassword.getText().toString();
                        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase("/data/data/com.nbpt.smartcity/databases/user.db",null);;
                        //AccountDBHelper db = new AccountDBHelper(RegisterActivity.this, AccountDBHelper.VERSION_1);
                        String sql = "insert into tb_accounts (user,password) values('"+username+"','"+password+"')";
                        db.execSQL(sql);
                        Toast.makeText(RegisterActivity.this, "注册成功!", Toast.LENGTH_LONG).show();
                        finish();

                }
            }
        };

        btnSubmit.setOnClickListener(listener);
    }

}
