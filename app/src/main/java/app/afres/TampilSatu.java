package app.afres;


import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
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


public class TampilSatu extends AppCompatActivity implements View.OnClickListener {

    private EditText idno;
    private EditText pertanyaan;
    private EditText pil1;
    private EditText pil2;
    private EditText pil3;
    private EditText jwb;
    public final static String TAG_pelajaran = "mapel";
    private Button buttonUpdate;
    private Button buttonEdit;
    String matapel;

    TextView soal;
    String id, username,ids;
    public static final String TAG_USERNAME = "username";
    public static final String TAG_ID = "id";
    public final static String TAG_IDS = "ids";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_satu);

        Intent intent = getIntent();
        ids=getIntent().getStringExtra(TAG_IDS);
        id = getIntent().getStringExtra(TAG_ID);
        username = getIntent().getStringExtra(TAG_USERNAME);
        idno = (EditText) findViewById(R.id.TextId);
        pertanyaan = (EditText) findViewById(R.id.pert);
        pil1 = (EditText) findViewById(R.id.pillihan1);
        pil2 = (EditText) findViewById(R.id.pillihan2);
        pil3 = (EditText) findViewById(R.id.pillihan3);
        jwb = (EditText) findViewById(R.id.jwb);
        soal=(TextView) findViewById(R.id.mapel);


        Bundle extras=getIntent().getExtras();
        matapel=extras.getString(TAG_pelajaran);

        soal.setText(matapel);
        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);
        buttonEdit = (Button) findViewById(R.id.buttonEdit);

        buttonUpdate.setOnClickListener(this);
        buttonEdit.setOnClickListener(this);

        idno.setText(ids);
        buttonUpdate.setEnabled(false);
        pertanyaan.setEnabled(false);
        idno.setEnabled(false);
        pil1.setEnabled(false);
        pil2.setEnabled(false);
        pil3.setEnabled(false);
        jwb.setEnabled(false);
        getEmployee();
    }

    private void getEmployee(){
        class GetEmployee extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TampilSatu.this,"Fetching...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showEmployee(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                if(matapel.equals("Ekonomi")) {
                    RequestHandler rh = new RequestHandler();
                    String s = rh.sendGetRequestParam(Server.URL_GET_EMP_E, ids);
                    return s;
                }else  if(matapel.equals("IPS")){
                    RequestHandler rh = new RequestHandler();
                    String s = rh.sendGetRequestParam(Server.URL_GET_EMP_Ips, ids);
                    return s;
                }else  if(matapel.equals("IPA")){
                    RequestHandler rh = new RequestHandler();
                    String s = rh.sendGetRequestParam(Server.URL_GET_EMP_Ipa, ids);
                    return s;
                }else  if(matapel.equals("Bahasa Inggris")){
                    RequestHandler rh = new RequestHandler();
                    String s = rh.sendGetRequestParam(Server.URL_GET_EMP_BI, ids);
                    return s;
                }else  if(matapel.equals("Matematika")){
                    RequestHandler rh = new RequestHandler();
                    String s = rh.sendGetRequestParam(Server.URL_GET_EMP_M, ids);
                    return s;
                }else  if(matapel.equals("Bahasa Indonesia")){
                    RequestHandler rh = new RequestHandler();
                    String s = rh.sendGetRequestParam(Server.URL_GET_EMP_B, ids);
                    return s;
                }


               return null;
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
            String t = c.getString(Server.TAG_PERTANYAAN);
            String j = c.getString(Server.TAG_JAWABAN1);
            String j2 = c.getString(Server.TAG_JAWABAN2);
            String j3 = c.getString(Server.TAG_JAWABAN3);
            String ben = c.getString(Server.TAG_JAWABANBENAR);

            pertanyaan.setText(t);
            pil1.setText(j);
            pil2.setText(j2);
            pil3.setText(j3);
            jwb.setText(ben);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    protected void edit(){

        pertanyaan.setEnabled(true);
        pil1.setEnabled(true);
        pil2.setEnabled(true);
       pil3.setEnabled(true);
        jwb.setEnabled(true);
    }

    private void updateEmployee(){
        final String tanya = pertanyaan.getText().toString().trim();
        final String jawab = pil1.getText().toString().trim();
        final String jawab2 = pil2.getText().toString().trim();
        final String jawab3 = pil3.getText().toString().trim();
        final String jb = jwb.getText().toString().trim();
        final String soal2 = soal.getText().toString();
        class UpdateEmployee extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TampilSatu.this,"Updating...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(TampilSatu.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... params) {


                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put(Server.TAG_IDS,ids);
                hashMap.put(Server.KEY_EMP_PERTANYAAN,tanya);
                hashMap.put(Server.KEY_EMP_JAWABAN1,jawab);
                hashMap.put(Server.KEY_EMP_JAWABAN2,jawab2);
                hashMap.put(Server.KEY_EMP_JAWABAN3,jawab3);
                hashMap.put(Server.KEY_EMP_JAWABANBENAR,jb);

                if(soal2.equalsIgnoreCase("Bahasa Indonesia")) {
                    RequestHandler rh = new RequestHandler();
                    String s = rh.sendPostRequest(Server.URL_UPDATE_EMP_B,hashMap);
                    return s;
                } else  if(soal2.equalsIgnoreCase("IPS")){
                    RequestHandler rh = new RequestHandler();
                    String s = rh.sendPostRequest(Server.URL_UPDATE_EMP_Ips,hashMap);
                    return s;
                }else  if(soal2.equalsIgnoreCase("IPA")){
                    RequestHandler rh = new RequestHandler();
                    String s = rh.sendPostRequest(Server.URL_UPDATE_EMP_Ipa,hashMap);
                    return s;
                }else  if(soal2.equalsIgnoreCase("Bahasa Inggris")){
                    RequestHandler rh = new RequestHandler();
                    String s = rh.sendPostRequest(Server.URL_UPDATE_EMP_BI,hashMap);
                    return s;
                }else  if(soal2.equalsIgnoreCase("Matematika")){
                    RequestHandler rh = new RequestHandler();
                    String s = rh.sendPostRequest(Server.URL_UPDATE_EMP_M,hashMap);
                    return s;
                }else  if(soal2.equalsIgnoreCase("Ekonomi")){
                    RequestHandler rh = new RequestHandler();
                    String s = rh.sendPostRequest(Server.URL_UPDATE_EMP_E,hashMap);
                    return s;
            }

                return null;

            }
        }

        UpdateEmployee ue = new UpdateEmployee();
        ue.execute();
    }




    @Override
    public void onClick(View v) {
        if(v == buttonUpdate){
            updateEmployee();
            Intent intent = new Intent(this, PilihTampilSoal.class);
            intent.putExtra(TAG_ID,id);
            intent.putExtra(TAG_USERNAME,username);
            startActivity(intent);
        }

        if(v == buttonEdit){
        edit();
        buttonEdit.setEnabled(false);
        buttonUpdate.setEnabled(true);
        }
    }
}