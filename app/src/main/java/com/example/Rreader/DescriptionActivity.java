package com.example.Rreader;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;


import com.example.Rreader.R;

public class DescriptionActivity extends AppCompatActivity {
    private static final String TAG = "DescriptionActivity";
    public static String setclass = null;
    private static WebView webView;
    public Bundle extras, url;
    private Context mcontext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        mcontext = DescriptionActivity.this;
        webView = findViewById(R.id.simplerWebView);
        extras = getIntent().getExtras();


        if (!extras.equals(null)) {
            try {
                String data = extras.getString("titles");


                switch (data) {
                    case "Chapter 1":
                        Intent chapter = new Intent(mcontext, Chapter.class);
                        setclass = data;

                        startActivity(chapter);

                        break;

                    case "Chapter 2":
                        Intent chapter2 = new Intent(mcontext, Chapter2.class);
                        setclass = data;

                        startActivity(chapter2);

                        break;

                    case "Chapter 3":
                        Intent chapter3 = new Intent(mcontext, Chapter3.class);
                        setclass = data;

                        startActivity(chapter3);

                        break;

                        case "Chapter 4":
                        Intent chapter4 = new Intent(mcontext, Chapter4.class);
                        setclass = data;

                        startActivity(chapter4);

                        break;

                    case "Chapter 5":
                        Intent chapter5 = new Intent(mcontext, Chapter5.class);
                        setclass = data;

                        startActivity(chapter5);

                        break;

                    case "Chapter 6":
                        Intent chapter6 = new Intent(mcontext, Chapter6.class);
                        setclass = data;

                        startActivity(chapter6);

                        break;

                    case "Chapter 7":
                        Intent chapter7 = new Intent(mcontext, Chapter7.class);
                        setclass = data;

                        startActivity(chapter7);

                        break;


                    case "Chapter 8":
                        Intent chapter8= new Intent(mcontext, Chapter8.class);
                        setclass = data;

                        startActivity(chapter8);

                        break;


                    case "Chapter 9":
                        Intent chapter9= new Intent(mcontext, Chapter9.class);
                        setclass = data;

                        startActivity(chapter9);

                        break;

                    case "Chapter 10":
                        Intent chapter10= new Intent(mcontext, Chapter10.class);
                        setclass = data;

                        startActivity(chapter10);

                        break;

                        default:
                            break;




                }

               /* if (data.equals("Chapter1")) {
                    Intent delaIntent = new Intent(mcontext, Chapter.class);
                    setclass = data;

                    startActivity(delaIntent);

                }

                else  if (data.equals("Chapter2")) {
                    Intent delaIntent = new Intent(mcontext, Chapter2.class);
                    setclass = data;

                    startActivity(delaIntent);

                }*/


             /* //  data= data.replace("1.","");
                Log.d(TAG,"onCreate: the coming data is "+data);
                String Url="file:///android_asset/"+data+".html";
               // String Url="file:///android_asset/Introduction.html";
                webView.loadUrl(Url);*/
            } catch (Exception e) {
                e.printStackTrace();
            }


          /*  //below code for zoom
            WebSettings webSettings=webView.getSettings();
            webSettings.setBuiltInZoomControls(true);
            webSettings.setDisplayZoomControls(false);
            webSettings.setJavaScriptEnabled(true);*/
        }
    }

    public DescriptionActivity loadurl() {

        try {
            //below code for zoom
            url = getIntent().getExtras();
            if (!url.equals(null)) {
                try {
                    String data = url.getString("url");
                    Log.d(TAG, "onCreate: the coming data is " + data);


                    String Url = "file:///android_asset/Introduction.html";
                    webView.loadUrl(Url);
                    WebSettings webSettings = webView.getSettings();
                    webSettings.setBuiltInZoomControls(true);
                    webSettings.setDisplayZoomControls(false);
                    webSettings.setJavaScriptEnabled(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception exeception) {
            exeception.printStackTrace();
        }

        return null;
    }
}
