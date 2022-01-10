package com.upt.cti.smc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.upt.cti.smc.model.People;

public class EditProfileActivity extends AppCompatActivity {

    TextView profile_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        profile_name = findViewById(R.id.name_text);


    }
}