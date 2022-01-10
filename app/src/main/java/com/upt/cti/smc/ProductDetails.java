package com.upt.cti.smc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetails extends AppCompatActivity {

    TextView name, price;
    ImageView image,back;
    //Integer n;
    Products n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_deltails);

        name=findViewById(R.id.prd_name);
        image=findViewById(R.id.prd_image);
        price =findViewById(R.id.prd_price);
        back=findViewById(R.id.back_btn);


        name.setText(MainPageActivity.productsList.get(0).getProductName());
        image.setImageResource(MainPageActivity.productsList.get(0).getImageUrl());
        price.setText(MainPageActivity.productsList.get(0).getProductPrice());


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(ProductDetails.this, MainPageActivity.class);
                startActivity(i);

            }
        });


    }
}