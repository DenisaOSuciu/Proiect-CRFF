package com.upt.cti.smc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.upt.cti.smc.model.People;

import java.util.List;

import io.realm.Realm;

public class LogActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button login_btn;
    TextView signUpButton;
    Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        realm=Realm.getDefaultInstance();
        login_btn =findViewById(R.id.login_bt);
        signUpButton=findViewById(R.id.bt_signUp);
        username=findViewById(R.id.username_log);
        password=findViewById(R.id.password_log);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<People> users = realm.where(People.class).findAll();

                for(int i=0; i<users.size(); i++ ){
                    if(username.getText().toString().equals(users.get(i).getUser_name()) &&
                            password.getText().toString().equals(users.get(i).getUser_password())){
                       // Intent in = new Intent(LogActivity.this, SignUpActivity.class);
                       // startActivity(in);
                        Toast.makeText(LogActivity.this, "Autentification succed!", Toast.LENGTH_LONG).show();
                        //setContentView(R.layout.profile_layout);
                        //
                        Intent in = new Intent(LogActivity.this, MainPageActivity.class);
                         startActivity(in);
                    }

                    else if(!username.getText().toString().equals(users.get(i).getUser_name())){
                        Toast.makeText(LogActivity.this, "fail!", Toast.LENGTH_LONG).show();}

                }



               // Intent in = new Intent(LogActivity.this, SignUpActivity.class);
               // startActivity(in);

            }
        });
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LogActivity.this, SignUpActivity.class);
                startActivity(i);
            }
        });
    }
}