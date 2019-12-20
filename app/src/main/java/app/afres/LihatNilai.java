package app.afres;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class LihatNilai extends AppCompatActivity implements ListView.OnItemClickListener {
    private ListView listView;
    private String JSON_STRING;
    String[] item={"Pilih Pelajaran","Bahasa Inggris","Bahasa Indonesia","Matematika","Ekonomi","Ipa","Ips"};
    public Spinner sp;
    String tempjenis,id,username;
    public static final String TAG_USERNAME = "username";
    public static final String TAG_ID = "id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_nilai);
        listView = (ListView) findViewById(R.id.listNilai);
        listView.setOnItemClickListener(this);
        sp=(Spinner)findViewById(R.id.Spin);
        id = getIntent().getStringExtra(TAG_ID);
        username = getIntent().getStringExtra(TAG_USERNAME);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(LihatNilai.this,android.R.layout.simple_spinner_dropdown_item,item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tempjenis=item[position];
                if(tempjenis=="Bahasa Indonesia"){
                    getJSONbahasa();

                }else if(tempjenis=="Matematika"){
                    getJSONmtk();
                }else if(tempjenis=="Ekonomi"){
                    getJSONeko();
                }else if(tempjenis=="Ipa"){
                    getJSONipa();
                }else if(tempjenis=="Bahasa Inggris"){
                    getJSONing();
                }else if(tempjenis=="Ips"){
                    getJSONips();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, HomeGuru.class);
        intent.putExtra(TAG_ID,id);
        intent.putExtra(TAG_USERNAME,username);
        finish();
        startActivity(intent);}
    private void showbahasa() {
        JSONObject jsonObject = null;
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Server.TAG_JSON_ARRAY);

            for (int i = 0; i < result.length(); i++) {
                JSONObject jo = result.getJSONObject(i);
                String nis = jo.getString(Server.TAG_NIS);
                String nama = jo.getString(Server.TAG_NAMA);
                String bahasa = jo.getString(Server.TAG_BAHASA);
                HashMap<String, String> employees = new HashMap<>();
                employees.put(Server.TAG_NIS, nis);
                employees.put(Server.TAG_NAMA, nama);
                employees.put(Server.TAG_BAHASA, bahasa);

                list.add(employees);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                LihatNilai.this, list, R.layout.list_item_nilai_bahasa,
                new String[]{Server.TAG_NIS, Server.TAG_NAMA, Server.TAG_BAHASA},
                new int[]{R.id.nis, R.id.nama, R.id.bahasa});

        listView.setAdapter(adapter);
    }


    private void getJSONbahasa() {
        class GetJSON extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LihatNilai.this, "Mengambil Data", "Mohon Tunggu...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showbahasa();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(Server.URL_GET_ALL_NILAI_B);
                return s;

            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }



    private void showmtk() {
        JSONObject jsonObject = null;
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Server.TAG_JSON_ARRAY);

            for (int i = 0; i < result.length(); i++) {
                JSONObject jo = result.getJSONObject(i);
                String nis = jo.getString(Server.TAG_NIS);
                String nama = jo.getString(Server.TAG_NAMA);
                String mtk = jo.getString(Server.TAG_MTK);
                HashMap<String, String> employees = new HashMap<>();
                employees.put(Server.TAG_NIS, nis);
                employees.put(Server.TAG_NAMA, nama);
                employees.put(Server.TAG_MTK, mtk);

                list.add(employees);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                LihatNilai.this, list, R.layout.list_item_nilai_mtk,
                new String[]{Server.TAG_NIS, Server.TAG_NAMA, Server.TAG_MTK},
                new int[]{R.id.nis, R.id.nama, R.id.mtk});

        listView.setAdapter(adapter);
    }


    private void getJSONmtk() {
        class GetJSON extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LihatNilai.this, "Mengambil Data", "Mohon Tunggu...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showmtk();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(Server.URL_GET_ALL_NILAI_M);
                return s;

            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }


    private void showeko() {
        JSONObject jsonObject = null;
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Server.TAG_JSON_ARRAY);

            for (int i = 0; i < result.length(); i++) {
                JSONObject jo = result.getJSONObject(i);
                String nis = jo.getString(Server.TAG_NIS);
                String nama = jo.getString(Server.TAG_NAMA);
                String eko = jo.getString(Server.TAG_EKO);
                HashMap<String, String> employees = new HashMap<>();
                employees.put(Server.TAG_NIS, nis);
                employees.put(Server.TAG_NAMA, nama);
                employees.put(Server.TAG_EKO, eko);

                list.add(employees);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                LihatNilai.this, list, R.layout.list_item_nilai_ekonomi,
                new String[]{Server.TAG_NIS, Server.TAG_NAMA, Server.TAG_EKO},
                new int[]{R.id.nis, R.id.nama, R.id.ekonomi});

        listView.setAdapter(adapter);
    }


    private void getJSONeko() {
        class GetJSON extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LihatNilai.this, "Mengambil Data", "Mohon Tunggu...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showeko();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(Server.URL_GET_ALL_NILAI_E);
                return s;

            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }


    private void showing() {
        JSONObject jsonObject = null;
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Server.TAG_JSON_ARRAY);

            for (int i = 0; i < result.length(); i++) {
                JSONObject jo = result.getJSONObject(i);
                String nis = jo.getString(Server.TAG_NIS);
                String nama = jo.getString(Server.TAG_NAMA);
                String ing = jo.getString(Server.TAG_ING);
                HashMap<String, String> employees = new HashMap<>();
                employees.put(Server.TAG_NIS, nis);
                employees.put(Server.TAG_NAMA, nama);
                employees.put(Server.TAG_ING, ing);

                list.add(employees);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                LihatNilai.this, list, R.layout.list_item_nilai_inggris,
                new String[]{Server.TAG_NIS, Server.TAG_NAMA, Server.TAG_ING},
                new int[]{R.id.nis, R.id.nama, R.id.inggris});

        listView.setAdapter(adapter);
    }


    private void getJSONing() {
        class GetJSON extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LihatNilai.this, "Mengambil Data", "Mohon Tunggu...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showing();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(Server.URL_GET_ALL_NILAI_ing);
                return s;

            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }


    private void showipa() {
        JSONObject jsonObject = null;
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Server.TAG_JSON_ARRAY);

            for (int i = 0; i < result.length(); i++) {
                JSONObject jo = result.getJSONObject(i);
                String nis = jo.getString(Server.TAG_NIS);
                String nama = jo.getString(Server.TAG_NAMA);
                String ipa= jo.getString(Server.TAG_IPA);
                HashMap<String, String> employees = new HashMap<>();
                employees.put(Server.TAG_NIS, nis);
                employees.put(Server.TAG_NAMA, nama);
                employees.put(Server.TAG_IPA, ipa);

                list.add(employees);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                LihatNilai.this, list, R.layout.list_item_nilai_ipa,
                new String[]{Server.TAG_NIS, Server.TAG_NAMA, Server.TAG_IPA},
                new int[]{R.id.nis, R.id.nama, R.id.ipa});

        listView.setAdapter(adapter);
    }


    private void getJSONipa() {
        class GetJSON extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LihatNilai.this, "Mengambil Data", "Mohon Tunggu...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showipa();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(Server.URL_GET_ALL_NILAI_I);
                return s;

            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }



    private void showips() {
        JSONObject jsonObject = null;
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Server.TAG_JSON_ARRAY);

            for (int i = 0; i < result.length(); i++) {
                JSONObject jo = result.getJSONObject(i);
                String nis = jo.getString(Server.TAG_NIS);
                String nama = jo.getString(Server.TAG_NAMA);
                String ips = jo.getString(Server.TAG_IPS);
                HashMap<String, String> employees = new HashMap<>();
                employees.put(Server.TAG_NIS, nis);
                employees.put(Server.TAG_NAMA, nama);
                employees.put(Server.TAG_IPS, ips);

                list.add(employees);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                LihatNilai.this, list, R.layout.list_item_nilai_ips,
                new String[]{Server.TAG_NIS, Server.TAG_NAMA, Server.TAG_IPS},
                new int[]{R.id.nis, R.id.nama, R.id.ips});

        listView.setAdapter(adapter);
    }


    private void getJSONips() {
        class GetJSON extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LihatNilai.this, "Mengambil Data", "Mohon Tunggu...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showips();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(Server.URL_GET_ALL_NILAI_IPS);
                return s;

            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }














    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        // Intent intent = new Intent(this, TampilSatu.class);
        //HashMap<String,String> map =(HashMap)parent.getItemAtPosition(position);
        //String empId = map.get(Server.TAG_NIS).toString();
        //  intent.putExtra(Server.EMP_ID,empId);
        //  startActivity(intent);
    }
}