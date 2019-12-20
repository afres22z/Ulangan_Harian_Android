package app.afres;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class SiswaLihatNilai extends AppCompatActivity implements View.OnClickListener {
    private String JSON_STRING;
    private ListView listView;
    String id, username;
    SharedPreferences sharedpreferences;
    public static final String TAG_USERNAME = "username";
    public static final String TAG_ID = "id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siswa_lihat_nilai);

        id = getIntent().getStringExtra(TAG_ID);
        username = getIntent().getStringExtra(TAG_USERNAME);
        listView = (ListView) findViewById(R.id.nilai);
       getJSON();
    }

    private void shownilai() {
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
                String inggris = jo.getString(Server.TAG_ING);
                String mtk = jo.getString(Server.TAG_MTK);
                String ipa = jo.getString(Server.TAG_IPA);
                String eko = jo.getString(Server.TAG_EKO);
                String ips = jo.getString(Server.TAG_IPS);





                HashMap<String, String> employees = new HashMap<>();
                employees.put(Server.TAG_NIS, nis);
                employees.put(Server.TAG_NAMA, nama);
                employees.put(Server.TAG_BAHASA, bahasa);
                employees.put(Server.TAG_ING ,inggris);
                employees.put(Server.TAG_MTK, mtk);
                employees.put(Server.TAG_IPA, ipa);
                employees.put(Server.TAG_EKO, eko);
                employees.put(Server.TAG_IPS, ips);

                list.add(employees);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                SiswaLihatNilai.this, list, R.layout.list_item_nilaisiswa,
                new String[]{Server.TAG_NIS, Server.TAG_NAMA, Server.TAG_BAHASA,Server.TAG_ING, Server.TAG_MTK, Server.TAG_IPA,Server.TAG_EKO, Server.TAG_IPS},
                new int[]{R.id.NIS, R.id.NAMA, R.id.BAHASA,R.id.INGGRIS, R.id.MTK, R.id.IPA,R.id.EKO, R.id.IPS});

        listView.setAdapter(adapter);
    }


    private void getJSON() {
        class GetJSON extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SiswaLihatNilai.this, "Mengambil Data", "Mohon Tunggu...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                shownilai();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(Server.URL_GET_NILAISISWA, id);
                return s;

            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(TAG_ID,id);
        intent.putExtra(TAG_USERNAME,username);
        finish();
        startActivity(intent);}
    @Override
    public void onClick(View v) {

    }
}