package com.example.Rreader;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.Rreader.R;

public class Chapter extends AppCompatActivity {
    private Context mcontext;
    public ImageView title_img_pt1, title_img_pt2, title_img_pt3;
    private static final String TAG = "Chapter";
    public String clickePageName = null;
    public Toolbar toolbar;
    TextView back;
    LinearLayout linbck;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter1);

        mcontext = Chapter.this;
        title_img_pt1 = findViewById(R.id.title_img_pt1);
        title_img_pt2 = findViewById(R.id.title_img_pt2);
        title_img_pt3 = findViewById(R.id.title_img_pt3);
        linbck = findViewById(R.id.linbck);


        //back btn click

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

               clickePageName = "Chapter1pt1";
               // clickePageName = "image";


                Intent loadurl = new Intent(getApplicationContext(), com.example.Rreader.OpenHtmlPage.class);
                //pass click page name
                loadurl.putExtra("url", clickePageName);
                startActivity(loadurl);

            }
        });

        //click 2

        title_img_pt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clickePageName = "chapt1pt2";

                Intent loadurl = new Intent(getApplicationContext(), com.example.Rreader.OpenHtmlPage.class);
                //pass click page name
               loadurl.putExtra("url", clickePageName);
                startActivity(loadurl);


            }
        });

        title_img_pt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clickePageName = "chapt1pt3";


                Intent loadurl = new Intent(getApplicationContext(), com.example.Rreader.OpenHtmlPage.class);
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
            Intent backpagecall=new Intent(mcontext, com.example.Rreader.MainActivity.class);
            startActivity(backpagecall);

        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
