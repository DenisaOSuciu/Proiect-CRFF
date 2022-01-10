package com.upt.cti.smc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.upt.cti.smc.adapter.ProductAdapter;
import com.upt.cti.smc.adapter.ProductCategoryAdapter;
import com.upt.cti.smc.model.ProductCategory;

import java.util.ArrayList;
import java.util.List;

public class MainPageActivity extends AppCompatActivity {
    ProductCategoryAdapter productCategoryAdapter;
    RecyclerView productCatRecycler, prodItemRecycler;
   public static List<Products> productsList = new ArrayList<>();
    ImageView profile, cart, home;
    ProductAdapter productAdapter;
    public static int id_produs;
    Products p1,p2,p3,p4,p5,p6,p7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        profile=findViewById(R.id.profile_btn);
        cart=findViewById(R.id.home_btn);
        home=findViewById(R.id.cart_btn);


        List<ProductCategory> productCategoryList = new ArrayList<>();
        productCategoryList.add(new ProductCategory(1, "Trending"));
        productCategoryList.add(new ProductCategory(2, "Most Popular"));
        productCategoryList.add(new ProductCategory(3, "Jeans"));
        productCategoryList.add(new ProductCategory(4, "T-shirts"));
        productCategoryList.add(new ProductCategory(5, "Jackets"));
        productCategoryList.add(new ProductCategory(6, "Shorts"));
        productCategoryList.add(new ProductCategory(7, "Sweaters"));

        setProductRecycler(productCategoryList);



        productsList.add(new Products(1, "Compleu maro alcatuit din fusta si sacou scurt", "S", "150 LEI", R.drawable.prod7));
        productsList.add(new Products(2, "Compleu negru cu dungi fine", "XS", "120 LEI", R.drawable.prod5));
        productsList.add(new Products(3, "Hanorac Adidas", "M", "50 LEI", R.drawable.prod4));
        productsList.add(new Products(4, "Hanorac cu fermoar The North Face", "M", "50 LEI", R.drawable.prod6));
        productsList.add(new Products(5, "Blugi mom-jeans", "M", "65 LEI", R.drawable.prod3));
        productsList.add(new Products(6, "Crop top Calvin Klein", "S", "30 LEI", R.drawable.prod2));
        productsList.add(new Products(7, "Pulover Tommy Hilfiger", "M", "45 LEI", R.drawable.prod1));
        setProdItemRecycler(productsList);
    }

    public void homeClicked(android.view.View view){
        Intent i = new Intent(MainPageActivity.this, MainPageActivity.class);
        startActivity(i);
    }

    public void cartClicked(android.view.View view){
        Intent i = new Intent(MainPageActivity.this, CartActivity.class);
        startActivity(i);
    }

    public void profileClicked(android.view.View view){
        Intent i = new Intent(MainPageActivity.this, EditProfileActivity.class);
        startActivity(i);
    }
    public void favoriteClicked(android.view.View view){
        Intent i = new Intent(MainPageActivity.this, EditProfileActivity.class);
        startActivity(i);
    }


    private void setProductRecycler(List<ProductCategory> productCategoryList){

        productCatRecycler = findViewById(R.id.cat_recycler);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        productCatRecycler.setLayoutManager(layoutManager);
        productCategoryAdapter = new ProductCategoryAdapter(this, productCategoryList);
        productCatRecycler.setAdapter(productCategoryAdapter);

    }

    private void setProdItemRecycler(List<Products> productsList){

        prodItemRecycler = findViewById(R.id.product_recycler);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        prodItemRecycler.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(this, productsList);
        prodItemRecycler.setAdapter(productAdapter);

    }
}