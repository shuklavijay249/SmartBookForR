package com.example.Rreader;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.example.Rreader.R;

public class Chapter5 extends AppCompatActivity {
    private Context mcontext;
    public ImageView title_img_pt1, title_img_pt2, title_img_pt3;
    private static final String TAG = "Chapter5";
    public String clickePageName = null;
    LinearLayout linbck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter5);

        mcontext = Chapter5.this;
        title_img_pt1 = findViewById(R.id.title_img_pt1);
        title_img_pt2 = findViewById(R.id.title_img_pt2);
        title_img_pt3 = findViewById(R.id.title_img_pt3);
        linbck = findViewById(R.id.linbck);
        //onback click

        linbck.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        } );


        //click 1 Arrow

        title_img_pt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clickePageName = "chapt5pt1";


                Intent loadurl = new Intent(getApplicationContext(), OpenHtmlPage.class);
                //pass click page name
                loadurl.putExtra("url", clickePageName);
                startActivity(loadurl);

            }
        });

        //click 2

        title_img_pt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clickePageName = "chapt5pt2";


                Intent loadurl = new Intent(getApplicationContext(), OpenHtmlPage.class);
                //pass click page name
                loadurl.putExtra("url", clickePageName);
                startActivity(loadurl);

            }
        });

        title_img_pt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clickePageName = "chapt5pt3";


                Intent loadurl = new Intent(getApplicationContext(), OpenHtmlPage.class);
                //pass click page name
                loadurl.putExtra("url", clickePageName);
                startActivity(loadurl);

            }
        });

        // textView=findViewById(R.id.chapter1text);
        // webView=findViewById(R.id.simplerWebView);



/*
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadurl();
}


});
*/
    }
    public void onBackPressed() {
        super.onBackPressed();
        try {
            Intent backpagecall=new Intent(mcontext,MainActivity.class);
            startActivity(backpagecall);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
