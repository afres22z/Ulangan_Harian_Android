package app.afres;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class LihatSiswa extends AppCompatActivity implements ListView.OnItemClickListener {

    private ListView listView;
    private String JSON_STRING;
    String id, username;
    public static final String TAG_USERNAME = "username";
    public static final String TAG_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_siswa);
        listView = (ListView) findViewById(R.id.listSiswa);
        listView.setOnItemClickListener(this);
        id = getIntent().getStringExtra(TAG_ID);
        username = getIntent().getStringExtra(TAG_USERNAME);
        getJSON();
    }


    private void showEmployee() {
        JSONObject jsonObject = null;
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Server.TAG_JSON_ARRAY);

            for (int i = 0; i < result.length(); i++) {
                JSONObject jo = result.getJSONObject(i);
                String nis = jo.getString(Server.TAG_NIS);
                String nama = jo.getString(Server.TAG_NAMA);
                String kelas = jo.getString(Server.TAG_KELAS);


                HashMap<String, String> employees = new HashMap<>();
                employees.put(Server.TAG_NIS, nis);
                employees.put(Server.TAG_NAMA, nama);
                employees.put(Server.TAG_KELAS, kelas);

                list.add(employees);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                LihatSiswa.this, list, R.layout.list_item_siswa,
                new String[]{Server.TAG_NIS, Server.TAG_NAMA, Server.TAG_KELAS},
                new int[]{R.id.nis, R.id.nama, R.id.kelas});

        listView.setAdapter(adapter);
    }

    private void getJSON() {
        class GetJSON extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LihatSiswa.this, "Mengambil Data", "Mohon Tunggu...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showEmployee();
            }

            @Override
            protected String doInBackground(Void... params) {


                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(Server.URL_GET_ALL_SISWA);
                return s;

            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, HomeGuru.class);
        intent.putExtra(TAG_ID,id);
        intent.putExtra(TAG_USERNAME,username);
        finish();
        startActivity(intent);}
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}