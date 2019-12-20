package app.afres;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
private CardView ekonomiCard,ipsard,ipaCard,inggrisCard,mtkCard,bahasaCard, menuCard;
    Button btn_logout;
    TextView txt_username;
    String id, username,eko;
    SharedPreferences sharedpreferences;
    private String JSON_STRING;

    private static  final int TIME_INTERVAL=2000;
    private long mBackPressed;

    public static final String TAG_USERNAME = "username";

    public static final String TAG_ID = "id";
    public static final String TAG_EKO= "eko";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        txt_username = (TextView) findViewById(R.id.txt_username);
        btn_logout = (Button) findViewById(R.id.btn_logout);


        id = getIntent().getStringExtra(TAG_ID);
        username = getIntent().getStringExtra(TAG_USERNAME);


        txt_username.setText("" + username);

        btn_logout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // update login session ke FALSE dan mengosongkan nilai id dan username


                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                finish();
                startActivity(intent);
            }
        });

        //inisial card
        ekonomiCard=(CardView)findViewById(R.id.ekonomicard);
        ipsard=(CardView)findViewById(R.id.ips_card);
        ipaCard=(CardView)findViewById(R.id.ipa_card);
        inggrisCard=(CardView)findViewById(R.id.bi_card);
        mtkCard=(CardView)findViewById(R.id.mtk_card);
        bahasaCard=(CardView)findViewById(R.id.bahasa_card);
        menuCard=(CardView)findViewById(R.id.menucard);

        //menambah click listener
        ekonomiCard.setOnClickListener(this);
        ipsard.setOnClickListener(this);
        ipaCard.setOnClickListener(this);
        inggrisCard.setOnClickListener(this);
        mtkCard.setOnClickListener(this);
        bahasaCard.setOnClickListener(this);
        menuCard.setOnClickListener(this);




    }

    @Override
    public void onBackPressed() {

        if (mBackPressed + TIME_INTERVAL>System.currentTimeMillis()){
            super.onBackPressed();
            return;
        }else {
            Toast.makeText(getBaseContext(), "Tekan Back Sekali Lagi Untuk Keluar", Toast.LENGTH_SHORT).show();}
        mBackPressed=System.currentTimeMillis();

    }

    @Override
    public void onClick(View v) {
    Intent intent;

        if(v == ekonomiCard){

            geteko();

        }
        if(v == ipaCard){

            getipa();

        }
        if(v == ipsard){

            getips();

        }
        if(v == bahasaCard){

            getbahasa();

        }
        if(v == inggrisCard){

            getinggris();

        }
        if(v == mtkCard){

            getmtk();

        }
        if(v == menuCard){

            Intent i= new Intent(this,Menu.class);
            i.putExtra(TAG_ID,id);
            i.putExtra(TAG_USERNAME,username);
            startActivity(i);}


    }


    public void pesan_toast ( final String pesan){
        Toast.makeText(getApplicationContext(), pesan, Toast.LENGTH_LONG).show();
    }

    private void geteko(){
        class GetEmployee extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(MainActivity.this,"Mengambil data...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showEmployee(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(Server.URL_GET_Nilaie,id);
                return s;
            }
        }
        GetEmployee ge = new GetEmployee();
        ge.execute();
    }

    private void showEmployee(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(Server.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            String eko = c.getString(Server.TAG_EKO);
            int z=Integer.parseInt(eko);
            if(z==0){
                Intent intent= new Intent(this,ekonomi.class);
                intent.putExtra(TAG_ID,id);
                startActivity(intent);}
            else{
                Toast.makeText(MainActivity.this,"anda sudah mengerjakan soal ini", Toast.LENGTH_SHORT).show();

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }




    private void getmtk(){
        class GetEmployee extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(MainActivity.this,"Mengambil data...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showmtk(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(Server.URL_GET_Nilaim,id);
                return s;
            }
        }
        GetEmployee ge = new GetEmployee();
        ge.execute();
    }

    private void showmtk(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(Server.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            String mtk = c.getString(Server.TAG_MTK);
            int z=Integer.parseInt(mtk);
            if(z==0){
                Intent intent= new Intent(this,Mtk.class);
                intent.putExtra(TAG_ID,id);
                startActivity(intent);}
            else{
                Toast.makeText(MainActivity.this,"anda sudah mengerjakan soal ini", Toast.LENGTH_SHORT).show();

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getbahasa(){
        class GetEmployee extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(MainActivity.this,"Mengambil data...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showbahasa(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(Server.URL_GET_Nilaib,id);
                return s;
            }
        }
        GetEmployee ge = new GetEmployee();
        ge.execute();
    }

    private void showbahasa(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(Server.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            String bahasa = c.getString(Server.TAG_BAHASA);
            int z=Integer.parseInt(bahasa);
            if(z==0){
                Intent intent= new Intent(this,Bahasa.class);
                intent.putExtra(TAG_ID,id);
                startActivity(intent);}
            else{
                Toast.makeText(MainActivity.this,"anda sudah mengerjakan soal ini", Toast.LENGTH_SHORT).show();

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void getipa(){
        class GetEmployee extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(MainActivity.this,"Mengambil data...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showipa(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(Server.URL_GET_Nilaiia,id);
                return s;
            }
        }
        GetEmployee ge = new GetEmployee();
        ge.execute();
    }

    private void showipa(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(Server.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            String ipa = c.getString(Server.TAG_IPA);
            int z=Integer.parseInt(ipa);
            if(z==0){
                Intent intent= new Intent(this,Ipa.class);
                intent.putExtra(TAG_ID,id);
                startActivity(intent);}
            else{
                Toast.makeText(MainActivity.this,"anda sudah mengerjakan soal ini", Toast.LENGTH_SHORT).show();

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void getips(){
        class GetEmployee extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(MainActivity.this,"Mengambil data...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showips(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(Server.URL_GET_Nilaiis,id);
                return s;
            }
        }
        GetEmployee ge = new GetEmployee();
        ge.execute();
    }

    private void showips(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(Server.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            String ips = c.getString(Server.TAG_IPS);
            int z=Integer.parseInt(ips);
            if(z==0){
                Intent intent= new Intent(this,Ips.class);
                intent.putExtra(TAG_ID,id);
                startActivity(intent);}
            else{
                Toast.makeText(MainActivity.this,"anda sudah mengerjakan soal ini", Toast.LENGTH_SHORT).show();

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getinggris(){
        class GetEmployee extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(MainActivity.this,"Mengambil data...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showinggris(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(Server.URL_GET_Nilaibi,id);
                return s;
            }
        }
        GetEmployee ge = new GetEmployee();
        ge.execute();
    }

    private void showinggris(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(Server.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            String inggris = c.getString(Server.TAG_ING);
            int z=Integer.parseInt(inggris);
            if(z==0){
                Intent intent= new Intent(this,inggris.class);
                intent.putExtra(TAG_ID,id);
                startActivity(intent);}
            else{
                Toast.makeText(MainActivity.this,"anda sudah mengerjakan soal ini", Toast.LENGTH_SHORT).show();

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



}a
