package com.example.siddhesh.m_mechanic;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class FetchData extends AppCompatActivity {

    String myJSON;

    private static final String TAG_RESULTS = "result";
    private static final String TAG_ID = "id";
    private static final String TAG_NAME = "name";
    private static final String TAG_ADD = "address";

    JSONArray peoples = null;

    ArrayList<HashMap<String, String>> personList;
    TextView tvresult;
    Button btnSearch;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_data);

        // list = (ListView) findViewById(R.id.listView);
        //personList = new ArrayList<HashMap<String, String>>();
        //getData();

//        tvresult= (TextView) findViewById(R.id.tvresult);
//        btnSearch= (Button) findViewById(R.id.btnSearch);


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Task1 t1=new Task1();
                t1.execute("192.168.0.5/MMech/1.php");
            }
        });

    }
    class Task1 extends AsyncTask<String,Void,String>
    {
        String jsonStr="";
        String line ="";
        String searchResult ="";

        @Override
        protected String doInBackground(String... params) {
            try {
                URL url=new URL(params[0]);
                HttpURLConnection conn=(HttpURLConnection) url.openConnection();
                conn.connect();

                InputStream is=conn.getInputStream();
                BufferedReader reader=new BufferedReader(new InputStreamReader(is));

                while((line=reader.readLine())!=null){
                    jsonStr+=line + "\n";
                }
            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            if(jsonStr !=null) {
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(jsonStr);
                    JSONArray movieArray = jsonObject.getJSONArray("temp");
                    for (int i = 0; i < movieArray.length(); i++) {
                        JSONObject movie = movieArray.getJSONObject(i);
                        String id = movie.getString("id");
                        String name = movie.getString("name");
                        String loc = movie.getString("loc");
                        searchResult += id + " " + name + " " + loc + "\n";
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return searchResult;
        }
        protected  void onPostExecute(String s){
            super.onPostExecute(s);
            tvresult.setText(s);
        }
    }
}

/*
    public void getData(){
        class GetDataJSON extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... params) {
                DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
                HttpPost httppost = new HttpPost("http://simplifiedcoding.16mb.com/get-data.php");

                // Depends on your web service
                httppost.setHeader("Content-type", "application/json");

                InputStream inputStream = null;
                String result = null;
                try {
                    HttpResponse response = httpclient.execute(httppost);
                    HttpEntity entity = response.getEntity();

                    inputStream = entity.getContent();
                    // json is UTF-8 by default
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
                    StringBuilder sb = new StringBuilder();

                    String line = null;
                    while ((line = reader.readLine()) != null)
                    {
                        sb.append(line + "\n");
                    }
                    result = sb.toString();
                } catch (Exception e) 
                }
                finally {
                    try{if(inputStream != null)inputStream.close();}catch(Exception squish){}
                }
                return result;
            }

            @Override
            protected void onPostExecute(String result){
                myJSON=result;
                showList();
            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute();
    }
}
*/
package com.example.siddhesh.m_mechanic;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class FetchData extends AppCompatActivity {

    String myJSON;

    private static final String TAG_RESULTS = "result";
    private static final String TAG_ID = "id";
    private static final String TAG_NAME = "name";
    private static final String TAG_ADD = "address";

    JSONArray peoples = null;

    ArrayList<HashMap<String, String>> personList;
    TextView tvresult;
    Button btnSearch;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_data);

        // list = (ListView) findViewById(R.id.listView);
        //personList = new ArrayList<HashMap<String, String>>();
        //getData();

//        tvresult= (TextView) findViewById(R.id.tvresult);
//        btnSearch= (Button) findViewById(R.id.btnSearch);


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Task1 t1=new Task1();
                t1.execute("192.168.0.5/MMech/1.php");
            }
        });

    }
    class Task1 extends AsyncTask<String,Void,String>
    {
        String jsonStr="";
        String line ="";
        String searchResult ="";

        @Override
        protected String doInBackground(String... params) {
            try {
                URL url=new URL(params[0]);
                HttpURLConnection conn=(HttpURLConnection) url.openConnection();
                conn.connect();

                InputStream is=conn.getInputStream();
                BufferedReader reader=new BufferedReader(new InputStreamReader(is));

                while((line=reader.readLine())!=null){
                    jsonStr+=line + "\n";
                }
            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            if(jsonStr !=null) {
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(jsonStr);
                    JSONArray movieArray = jsonObject.getJSONArray("temp");
                    for (int i = 0; i < movieArray.length(); i++) {
                        JSONObject movie = movieArray.getJSONObject(i);
                        String id = movie.getString("id");
                        String name = movie.getString("name");
                        String loc = movie.getString("loc");
                        searchResult += id + " " + name + " " + loc + "\n";
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return searchResult;
        }
        protected  void onPostExecute(String s){
            super.onPostExecute(s);
            tvresult.setText(s);
        }
    }
}

/*
    public void getData(){
        class GetDataJSON extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... params) {
                DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
                HttpPost httppost = new HttpPost("http://simplifiedcoding.16mb.com/get-data.php");

                // Depends on your web service
                httppost.setHeader("Content-type", "application/json");

                InputStream inputStream = null;
                String result = null;
                try {
                    HttpResponse response = httpclient.execute(httppost);
                    HttpEntity entity = response.getEntity();

                    inputStream = entity.getContent();
                    // json is UTF-8 by default
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
                    StringBuilder sb = new StringBuilder();

                    String line = null;
                    while ((line = reader.readLine()) != null)
                    {
                        sb.append(line + "\n");
                    }
                    result = sb.toString();
                } catch (Exception e) {
                    // Oops
                }
                finally {
                    try{if(inputStream != null)inputStream.close();}catch(Exception squish){}
                }
                return result;
            }

            @Override
            protected void onPostExecute(String result){
                myJSON=result;
                showList();
            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute();
    }
}
*/
