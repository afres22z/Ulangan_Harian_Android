package app.afres;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class SiswaLihatProfil extends AppCompatActivity implements View.OnClickListener {

    private String id,username;
    private EditText nis;
    private EditText nama;
    private EditText tempat;
    private EditText tgl;
    private EditText alamat;
    SharedPreferences sharedpreferences;
    public static final String TAG_USERNAME = "username";
    public static final String TAG_ID = "id";
    private EditText kelas;
    private EditText usern;
    private Button buttonEdit;
    private Button buttonSimpan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siswa_lihat_profil);
        Intent intent = getIntent();
        id = getIntent().getStringExtra(TAG_ID);
        username = getIntent().getStringExtra(TAG_USERNAME);

        nis = (EditText) findViewById(R.id.nis);
        nama = (EditText) findViewById(R.id.nama);
        tempat = (EditText) findViewById(R.id.tempat);
        tgl = (EditText) findViewById(R.id.tgl);
        alamat = (EditText) findViewById(R.id.alamat);
        kelas = (EditText) findViewById(R.id.kelas);
        usern = (EditText) findViewById(R.id.user);
        buttonEdit = (Button) findViewById(R.id.buttonEdit);
        buttonEdit.setOnClickListener(this);
        nis.setText(id);
        getEmployee();

        nis.setEnabled(false);
        nama.setEnabled(false);
        tempat.setEnabled(false);
        tgl.setEnabled(false);
       alamat.setEnabled(false);
        kelas.setEnabled(false);
        usern.setEnabled(false);
    }


    private void getEmployee(){
        class GetEmployee extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SiswaLihatProfil.this,"Fetching...","Wait...",false,false);
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
                String s = rh.sendGetRequestParam(Server.URL_GET_ALL_LIHATSISWA, id);
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

            String j = c.getString(Server.TAG_NAMA);
            String j2 = c.getString(Server.TAG_TEMPAT);
            String j3 = c.getString(Server.TAG_TGL);
            String ben = c.getString(Server.TAG_ALAMAT);
            String kel = c.getString(Server.TAG_KELAS);
            String user = c.getString(Server.TAG_USER);


             nama.setText(j);
            tempat.setText(j2);
            tgl.setText(j3);
            alamat.setText(ben);
            kelas.setText(kel);
            usern.setText(user);


        } catch (JSONException e) {
            e.printStackTrace();
        }
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


        if(v == buttonEdit){

            Intent intent = new Intent(this, EditUser.class);
            intent.putExtra(TAG_ID,id);
            intent.putExtra(TAG_USERNAME,username);
            finish();
            startActivity(intent);

        }
    }
}
