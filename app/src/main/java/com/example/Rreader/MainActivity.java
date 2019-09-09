package com.example.Rreader;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.example.Rreader.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Context mcontext;
    ArrayList<String> titleArrayList;
    ArrayList<String> sbtitleArrayList;
    ArrayList<Integer> imgTitleList;
    RecyclerView mRecyclerView;

    public static int splashTimeOut = 5000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mcontext = MainActivity.this;

        //call splash screen

       /* new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent  splashscreencall = new Intent(MainActivity.this,SplashScreen.class);
                startActivity(splashscreencall);
                finish();

            }
        },splashTimeOut);*/

        mRecyclerView = findViewById(R.id.title_layout_recyclerview);
        mRecyclerView.setHasFixedSize(true);

        //  mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        //title
        titleArrayList = new ArrayList<String>();
      //  titleArrayList.add(Constant.INTRODUCTION);
        titleArrayList.add(Constant.CHAPTER1);
        titleArrayList.add(Constant.CHAPTER2);
        titleArrayList.add(Constant.CHAPTER3);
        titleArrayList.add(Constant.CHAPTER4);
        titleArrayList.add(Constant.CHAPTER5);
        titleArrayList.add(Constant.CHAPTER6);
        titleArrayList.add(Constant.CHAPTER7);
        titleArrayList.add(Constant.CHAPTER8);
        //titleArrayList.add(Constant.CHAPTER9);
       // titleArrayList.add(Constant.CHAPTER10);


        //sbtitle
        sbtitleArrayList = new ArrayList<String>();
        //sbtitleArrayList.add(Constant.INTRODUCTION_SubTitle);

        sbtitleArrayList.add(Constant.CHAPTER1_SubTitle);
        sbtitleArrayList.add(Constant.CHAPTER2_SubTitle);
        sbtitleArrayList.add(Constant.CHAPTER3_SubTitle);
        sbtitleArrayList.add(Constant.CHAPTER4_SubTitle);
        sbtitleArrayList.add(Constant.CHAPTER5_SubTitle);
        sbtitleArrayList.add(Constant.CHAPTER6_SubTitle);
        sbtitleArrayList.add(Constant.CHAPTER7_SubTitle);
        sbtitleArrayList.add(Constant.CHAPTER8_SubTitle);

        imgTitleList=new ArrayList<Integer>();
        imgTitleList.add(R.drawable.ic_introduction);
        imgTitleList.add(R.drawable.ic_squarematrix);
        imgTitleList.add(R.drawable.ic_gripvertical);
        imgTitleList.add(R.drawable.ic_datamerge);
        imgTitleList.add(R.drawable.filechartline);
        imgTitleList.add(R.drawable.ic_vial);
        imgTitleList.add(R.drawable.ic_laptopcode);
        imgTitleList.add(R.drawable.ic_drawsquare);

        //sbtitleArrayList.add(Constant.CHAPTER9_SubTitle);
        //sbtitleArrayList.add(Constant.CHAPTER10_SubTitle);
        //add Value here
        try {

            com.example.Rreader.TitleAdapter adapter1 = new TitleAdapter(mcontext, titleArrayList, sbtitleArrayList, imgTitleList,new CustomItemClickListner() {
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onItemClick(View v, int position) {
                    Intent delaIntent = new Intent(mcontext, DescriptionActivity.class);
                    delaIntent.putExtra("titles", titleArrayList.get(position).replace("_", " "));
                    startActivity(delaIntent);
                  //  Toast.makeText(mcontext, "Clicked " + titleArrayList.get(position), Toast.LENGTH_LONG).show();
                }
            });

            mRecyclerView.setAdapter(adapter1);


        } catch (Exception e) {
            e.printStackTrace();
        }


        // titleArrayList.add(Constant.HISTORY_OF_JAVA);


    }

    @Override
    public void onBackPressed() {
       // super.onBackPressed();



        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                       // MainActivity.super.onBackPressed();
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            finishAffinity();
                        }
                    }
                })
                .setNegativeButton("No", null)
                .show();

       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle(R.string.app_name);
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setMessage("Do you want to exit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                        public void onClick(DialogInterface dialog, int id) {
                            finishAffinity();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

            //finishAffinity();
        }*/

    }
}
