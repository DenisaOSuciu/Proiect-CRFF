package com.upt.cti.smc;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.upt.cti.smc.model.People;

import io.realm.Realm;

public class SignUpActivity extends AppCompatActivity {

   // public static String nume;
    Realm realm;
   public static EditText name;
   private EditText username;
   private EditText password;
   private Button register;
    public static People user=new People();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        realm=Realm.getDefaultInstance();
        name =findViewById(R.id.name_reg);
        username =findViewById(R.id.username_reg);
        password =findViewById(R.id.password_reg);
        register= findViewById(R.id.register_btn);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(SignUpActivity.this, "succesfull!", Toast.LENGTH_LONG).show();

              //  saveData();
                Intent i = new Intent(SignUpActivity.this, LogActivity.class);
                startActivity(i);

                Number maxID= realm.where(People.class).max("user_id");
                int nextID;
                if(maxID==null){
                    nextID=1;
                }
                else{
                    nextID=maxID.intValue()+1;
                }

                user.setUser_id(nextID);
                user.setUser_name(name.getText().toString());
                user.setUser_username(username.getText().toString());
                user.setUser_password(password.getText().toString());

                realm.executeTransactionAsync(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.copyToRealm(user);
                    }
                });

            }
        });


    }



    private void saveData(){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                Number maxID= bgRealm.where(People.class).max("users_id");

               int newKey = (maxID == null ) ? 1 : maxID.intValue()+1;

                People user = bgRealm.createObject(People.class, newKey);
                user.setUser_name(name.getText().toString());
                user.setUser_username(username.getText().toString());
                user.setUser_password(password.getText().toString());
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Toast.makeText(SignUpActivity.this, "succesfull!", Toast.LENGTH_LONG).show();
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Toast.makeText(SignUpActivity.this, "failed!", Toast.LENGTH_LONG).show();
            }
        });
    }
}