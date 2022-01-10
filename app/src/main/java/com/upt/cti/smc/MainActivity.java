package com.upt.cti.smc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private LinearLayout mDotLayout;
    private Button next;
    private Button back;
    private Button finish;
    private TextView[] mDots;

    private int myCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout =(LinearLayout) findViewById(R.id.dots);

        next = (Button) findViewById(R.id.next_btn);
        back=(Button) findViewById(R.id.back_btn);
        finish = (Button) findViewById(R.id.finish_btn);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(myCurrentPage+1);
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(myCurrentPage-1);
            }
        });
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // setContentView(R.layout.activity_log);
                Intent i = new Intent(MainActivity.this, LogActivity.class);
                startActivity(i);
            }
        });
       
        SliderAdapter sliderAdapter = new SliderAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);
        addDots(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);
    }

    public void addDots(int position){
        mDots=new TextView[3];
        mDotLayout.removeAllViews();

        for(int i=0; i<mDots.length; i++){
            mDots[i]= new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            mDotLayout.addView(mDots[i]);
        }

        if(mDots.length >0){
            mDots[position].setTextColor(getResources().getColor(R.color.white));
        }
    }

    ViewPager.OnPageChangeListener viewListener =new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int i, float v, int i1){

       }

        @Override
        public void onPageSelected(int position) {
            addDots(position);

            myCurrentPage = position;

            if(position == 0){
                next.setEnabled(true);
                back.setEnabled(false);
                finish.setEnabled(false);
                back.setVisibility(View.INVISIBLE);
                finish.setVisibility(View.INVISIBLE);
                next.setVisibility(View.VISIBLE);
                next.setText("Next");
                back.setText("");
            }
           else if(position == 1){
                next.setEnabled(true);
                back.setEnabled(true);
                finish.setEnabled(false);
                finish.setVisibility(View.INVISIBLE);
                back.setVisibility(View.VISIBLE);
                next.setVisibility(View.VISIBLE);
                next.setText("Next");
                back.setText("Back");
            }
           else if(position == 2){
                next.setEnabled(false);
                back.setEnabled(true);
                finish.setEnabled(true);
                next.setVisibility(View.INVISIBLE);
                finish.setEnabled(true);
                finish.setVisibility(View.VISIBLE);
                finish.setText("get started");
                back.setText("Back");
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }


    };
}