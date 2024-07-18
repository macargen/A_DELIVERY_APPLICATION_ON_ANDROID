package com.example.expressage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class register extends AppCompatActivity {
    UserDao userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

//        userDao = new UserDao(this, "login.db", null, 1);
        userDao = new UserDao(this);

        Button btn_back=findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button btn_save=findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText password = findViewById(R.id.Gpassword_content);
                EditText confirm = findViewById(R.id.confirm_content);
                EditText num = findViewById(R.id.Gnum_content);
                EditText name = findViewById(R.id.Gname_content);
                EditText gender = findViewById(R.id.Ggender_content);
                EditText phone = findViewById(R.id.Gphone_content);
                EditText address = findViewById(R.id.Gaddress_content);

//                Toast.makeText(register.this, password.getText().getClass().toString(), Toast.LENGTH_SHORT).show();
                if(password.getText().toString().equals(confirm.getText().toString())){
                    boolean result = userDao.insertUser(num.getText().toString(), password.getText().toString(), name.getText().toString(), gender.getText().toString(), phone.getText().toString(), address.getText().toString());
                    if(result == false){
                        Toast.makeText(register.this, "false", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(register.this, "true", Toast.LENGTH_SHORT).show();
                    }

                }
                else{
//                if(password.getText() != confirm.getText()){
                    Toast.makeText(register.this, "密码与确认密码的内容不同 请重新输入:>", Toast.LENGTH_SHORT).show();
                }
//
            }
        });
    }

}
