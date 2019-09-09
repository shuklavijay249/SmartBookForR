package com.example.Rreader;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.Rreader.R;

public class OpenHtmlPage extends AppCompatActivity {
    private static final String TAG = "OpenHtmlPage";
    private Context mcontext;
    public Bundle url;
    private static WebView webView;
    public static String setclass = null;
    public SwipeRefreshLayout refreshpage;
    public SwipeRefreshLayout swipeLayout;
    public Class<?> classType;
    public String className;
    public LinearLayout linbck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_description1 );
        mcontext = OpenHtmlPage.this;
        webView = findViewById( R.id.simplerWebView1 );
        refreshpage = findViewById( R.id.refreshpage );
        linbck = findViewById( R.id.linbck );

        swipeLayout = (SwipeRefreshLayout) this.findViewById( R.id.refreshpage );


        linbck.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        } );

        webView.setWebViewClient( new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    view.loadUrl( request.getUrl().toString() );
                }
                return false;
            }
        } );








      /*  if (!isNetworkAvailable(mcontext)) {
            //uploadFileOffline(uploadFilePath, doctype, doctypeno, selectUrl);
            Toast.makeText(mcontext, "Please check your internet connection", Toast.LENGTH_SHORT).show();
        }
*/

        //   isOnline();


        url = getIntent().getExtras();
        if (!url.equals( null )) {
            try {
                String data = url.getString( "url" );

                className = data.substring( 0, 7 );


                Log.d( TAG, "onCreate: the coming data is " + data );
                // String Url="file:///android_asset/Introduction.html";
                // final String Url = "file:///android_asset/PythonHtmlFiles/" + data + ".html";
                final String Url = "file:///android_asset/RlanguageHtmlfiles/" + data + ".html";
                //  final String Url = "file:///android_asset/" + data + ".html";

                if (!isNetworkAvailable( mcontext )) {
                    //uploadFileOffline(uploadFilePath, doctype, doctypeno, selectUrl);
                    Toast.makeText( mcontext, "Please check your internet connection", Toast.LENGTH_SHORT ).show();

                    /*refreshpage.post(new Runnable() {
                        @Override public void run() {
                           refreshpage.setRefreshing(true);
                            loadURL( Url );


                        }
                    });*/


                    swipeLayout.setOnRefreshListener( new SwipeRefreshLayout.OnRefreshListener() {
                        @Override
                        public void onRefresh() {
                            webView.reload(); // refreshes the WebView

                            if (null != swipeLayout) {
                                swipeLayout.setRefreshing( false );
                            }
                        }
                    } );


                } else {
                    //  uploadFile(uploadFilePath, doctypeno, strapplicantType, strapplicantId);

                    /*refreshpage.post(new Runnable() {
                        @Override public void run() {
                            refreshpage.setRefreshing(true);
                            loadURL( Url );

                        }
                    });*/

                    swipeLayout.setOnRefreshListener( new SwipeRefreshLayout.OnRefreshListener() {
                        @Override
                        public void onRefresh() {
                            webView.reload(); // refreshes the WebView

                            if (null != swipeLayout) {
                                swipeLayout.setRefreshing( false );
                            }
                        }
                    } );

                    loadURL( Url );


                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }


    public void onBackPressed() {
        super.onBackPressed();


    }


    public void loadURL(String Url) {


        webView.loadUrl( Url );
        WebSettings webSettings = webView.getSettings();

/*
                webView.setPadding(2,30,2,30);
*/

        //below horizontal scroll line
        webView.setHorizontalScrollBarEnabled( true );
        webView.setInitialScale( 280 );


        //  webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls( false );
        webSettings.setJavaScriptEnabled( true );
    }

/*
    public boolean isOnline() {
        ConnectivityManager conMgr = (ConnectivityManager) mcontext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if(netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()){
            Toast.makeText(mcontext, "No Internet connection!", Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }
*/


    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService( Context.CONNECTIVITY_SERVICE );
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.isAvailable();
    }

/*
    private int getScale(){
        Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int width = display.getWidth();
        Double val = new Double(width)/new Double(300);
        val = val * 100d;
        return val.intValue();
    }
*/


}



