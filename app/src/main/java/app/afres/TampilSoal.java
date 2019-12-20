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
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class TampilSoal extends AppCompatActivity implements ListView.OnItemClickListener{
    private ListView listView;
    String matapel;
    public final static String TAG_pelajaran = "mapel";

    private String JSON_STRING;
    EditText pelajaran;
    String id, username;
    public static final String TAG_USERNAME = "username";
    public static final String TAG_ID = "id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_soal);
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
        Intent intent = getIntent();
        pelajaran= (EditText) findViewById(R.id.pelajaran);

        id = getIntent().getStringExtra(TAG_ID);
        username = getIntent().getStringExtra(TAG_USERNAME);
        Bundle extras=getIntent().getExtras();
        matapel=extras.getString(TAG_pelajaran);
        pelajaran.setText(matapel);
        pelajaran.setEnabled(false);


        getJSON();
    }


    private void showEmployee(){
        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Server.TAG_JSON_ARRAY);

            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                String id = jo.getString(Server.TAG_ID);
                String tanya = jo.getString(Server.TAG_PERTANYAAN);
                String jawab1 = jo.getString(Server.TAG_JAWABAN1);
                String jawab2 = jo.getString(Server.TAG_JAWABAN2);
                String jawab3 = jo.getString(Server.TAG_JAWABAN3);
                String benar = jo.getString(Server.TAG_JAWABANBENAR);

                HashMap<String,String> employees = new HashMap<>();
                employees.put(Server.TAG_ID,id);
                employees.put(Server.TAG_PERTANYAAN,tanya);
                employees.put(Server.TAG_JAWABAN1,jawab1);
                employees.put(Server.TAG_JAWABAN2,jawab2);
                employees.put(Server.TAG_JAWABAN3,jawab3);
                employees.put(Server.TAG_JAWABANBENAR,benar);
                list.add(employees);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                TampilSoal.this, list, R.layout.list_item,
                new String[]{Server.TAG_ID,Server.TAG_PERTANYAAN,Server.KEY_EMP_JAWABAN1,Server.KEY_EMP_JAWABAN2,Server.KEY_EMP_JAWABAN3,Server.KEY_EMP_JAWABANBENAR},
                new int[]{R.id.idsoal, R.id.pertanyaan, R.id.jawaban1, R.id.jawaban2, R.id.jawaban3, R.id.jawabanbenar});

        listView.setAdapter(adapter);
    }

    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TampilSoal.this,"Mengambil Data","Mohon Tunggu...",false,false);
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
                String matap;
                Bundle extras=getIntent().getExtras();
                matap=extras.getString(TAG_pelajaran);

                if(matap.equals("Ekonomi")){
                    RequestHandler rh = new RequestHandler();
                    String s = rh.sendGetRequest(Server.URL_GET_ALL_E);
                    return s;
                }else if(matap.equals("IPS")){
                    RequestHandler rh = new RequestHandler();
                    String s = rh.sendGetRequest(Server.URL_GET_ALL_Ips);
                    return s;
                }else if(matap.equals("IPA")){
                    RequestHandler rh = new RequestHandler();
                    String s = rh.sendGetRequest(Server.URL_GET_ALL_Ipa);
                    return s;
                }else if(matap.equals("Bahasa Inggris")){
                    RequestHandler rh = new RequestHandler();
                    String s = rh.sendGetRequest(Server.URL_GET_ALL_BI);
                    return s;
                }else if(matap.equals("Matematika")){
                    RequestHandler rh = new RequestHandler();
                    String s = rh.sendGetRequest(Server.URL_GET_ALL_M);
                    return s;
                }else if(matap.equals("Bahasa Indonesia")){
                    RequestHandler rh = new RequestHandler();
                    String s = rh.sendGetRequest(Server.URL_GET_ALL_B);
                    return s;}


                return null;
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

        Intent intent = new Intent(this, TampilSatu.class);
        HashMap<String,String> map =(HashMap)parent.getItemAtPosition(position);
        String ids = map.get(Server.TAG_ID).toString();
        intent.putExtra(Server.TAG_IDS,ids);
        intent.putExtra(TAG_ID,id);
        intent.putExtra(TAG_USERNAME,username);
        intent.putExtra(TAG_pelajaran, pelajaran.getText().toString());
        startActivity(intent);
    }
}