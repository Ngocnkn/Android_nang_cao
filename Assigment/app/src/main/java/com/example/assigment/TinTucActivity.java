package com.example.assigment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class TinTucActivity extends AppCompatActivity {
    private ArrayList<TinTuc> tinTucs;
    RecyclerView rvData;

    private TextView tvKetqua;
    private TinTucAdapter tinTucAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tin_tuc);
        tinTucs = new ArrayList<>();


        tvKetqua = findViewById(R.id.tvKetqua);
        rvData = findViewById(R.id.rvData);


    }



    public void btnAnninh(View view){
        String url = "https://www.24h.com.vn/upload/rss/kinhdoanh.rss";
        GetData getData = new GetData();
        getData.execute(url);

    }

    public void btnTheThao(View view){
        String url = "https://www.24h.com.vn/upload/rss/bongda.rss";
        GetData getData = new GetData();
        getData.execute(url);

    }

    class GetData extends AsyncTask<String, Long, ArrayList<TinTuc>> {

        @Override
        protected ArrayList<TinTuc> doInBackground(String... strings) {
            String link = strings[0];
            try {
                URL url = new URL(link);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                InputStream inputStream = httpURLConnection.getInputStream();

                //Khoi tao doi tuong
                XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();

                XmlPullParser xmlPullParser = xmlPullParserFactory.newPullParser();

                xmlPullParser.setInput(inputStream, "utf-8");

                int eventType = xmlPullParser.getEventType();
                TinTuc tinTuc = null;
                String text = "";
                while (eventType != XmlPullParser.END_DOCUMENT) {
                    eventType = xmlPullParser.getEventType();
                    String tag = xmlPullParser.getName();
                    switch (eventType) {
                        case XmlPullParser.START_TAG:
                            if (tag.equalsIgnoreCase("item")) {
                                tinTuc = new TinTuc();
                            }
                            break;
                        case XmlPullParser.TEXT:
                            text = xmlPullParser.getText();
                            Log.e("text", "text" + text);
                            break;
                        case XmlPullParser.END_TAG:
                            if (tinTuc != null) {
                                if (tag.equalsIgnoreCase("title")) {
                                    tinTuc.title = text;
                                } else if (tag.equalsIgnoreCase("description")) {
                                    tinTuc.description = text;
                                } else if (tag.equalsIgnoreCase("pubDate")) {
                                    tinTuc.pubDate = text;
                                } else if (tag.equalsIgnoreCase("image")) {
                                    tinTuc.image = text;
                                } else if (tag.equalsIgnoreCase("link")) {
                                    tinTuc.links = text;
                                } else if (tag.equalsIgnoreCase("item")) {
                                    tinTucs.add(tinTuc);
                                }
                                break;
                            }
                    }

                    xmlPullParser.next();
                }
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return tinTucs;
        }

        @Override
        protected void onPostExecute(ArrayList<TinTuc> tinTucs) {
            super.onPostExecute(tinTucs);
            tinTucAdapter = new TinTucAdapter(tinTucs, TinTucActivity.this);
            rvData.setAdapter(tinTucAdapter);

            LinearLayoutManager linearLayout = new LinearLayoutManager(TinTucActivity.this);
            rvData.setLayoutManager(linearLayout);
            if (tinTucs.size() > 0) {
                tvKetqua.setText("Load dữ liệu thành công!");

            } else {
                tvKetqua.setText("Load dữ liệu thất bại");
            }
        }
    }
}
