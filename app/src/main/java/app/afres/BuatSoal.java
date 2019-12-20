package app.afres;

import android.app.AlertDialog;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.HashMap;


public class BuatSoal extends AppCompatActivity implements View.OnClickListener {


    Button btnSelesai, btnNext;
    String id, username;
    private EditText editTextID;
    private EditText editTextpertanyaan;
    private EditText editTextjawaban1;
    private EditText editTextjawaban2;
    private EditText editTextjawaban3;
    public Spinner sp;
    String tempjenis;
    String[] item={"Pilih Pelajaran","Bahasa Inggris","Bahasa Indonesia","Matematika","Ekonomi","Ipa","Ips"};
    private EditText editTextjawabanbenar;
    ConnectivityManager conMgr;
    public static final String TAG_USERNAME = "username";
    public static final String TAG_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_soal);

        id = getIntent().getStringExtra(TAG_ID);
        username = getIntent().getStringExtra(TAG_USERNAME);
        conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        //Inisialisasi dari View
        editTextID = (EditText) findViewById(R.id.idsoal);
        editTextpertanyaan = (EditText) findViewById(R.id.pertanyaan);
        editTextjawaban1 = (EditText) findViewById(R.id.jawaban1);
        editTextjawaban2 = (EditText) findViewById(R.id.jawaban2);
        editTextjawaban3 = (EditText) findViewById(R.id.jawaban3);
        editTextjawabanbenar = (EditText) findViewById(R.id.jawabanbenar);
        editTextID.setEnabled(false);
        editTextpertanyaan.setEnabled(false);
        editTextjawaban1.setEnabled(false);
        editTextjawaban2.setEnabled(false);
        editTextjawaban3.setEnabled(false);
        editTextjawabanbenar.setEnabled(false);
        sp=(Spinner)findViewById(R.id.Spinner);

        btnSelesai = (Button) findViewById(R.id.buttonSelesai);
        btnNext = (Button) findViewById(R.id.buttonNext);

        editTextID.setText("1");
        btnNext.setOnClickListener(this);
        btnSelesai.setOnClickListener(this);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(BuatSoal.this,android.R.layout.simple_spinner_dropdown_item,item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tempjenis=item[position];
                if(tempjenis=="Bahasa Indonesia"){
                    confirmDeleteEmployee();

                    tampil();
                }else if(tempjenis=="Matematika"){
                    confirmDeleteEmployee();
                    tampil();
                }else if(tempjenis=="Ekonomi"){
                    confirmDeleteEmployee();

                    tampil();
                }else if(tempjenis=="Ipa"){
                    confirmDeleteEmployee();

                    tampil();
                }else if(tempjenis=="Bahasa Inggris"){
                    confirmDeleteEmployee();

                    tampil();
                }else if(tempjenis=="Ips"){
                    confirmDeleteEmployee();

                    tampil();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }









    //Dibawah ini merupakan perintah untuk Menambahkan Pegawai (CREATE)
    private void addEmployee(){

        final String id = editTextID.getText().toString().trim();
        final String tanya = editTextpertanyaan.getText().toString().trim();
        final String jawab1 = editTextjawaban1.getText().toString().trim();
        final String jawab2 = editTextjawaban2.getText().toString().trim();
        final String jawab3 = editTextjawaban3.getText().toString().trim();
        final String benar = editTextjawabanbenar.getText().toString().trim();

        final  Integer a=Integer.parseInt(String.valueOf(editTextID.getText()));
        if (a==9){
            btnSelesai.setEnabled(true);
            btnNext.setEnabled(false);

        }


        class AddEmployee extends AsyncTask<Void,Void,String> {



            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(BuatSoal.this,"Menambahkan...","Tunggu...",false,false);
            }

            protected void nomer(){
                int no, nomor;
                no=Integer.parseInt(editTextID.getText().toString());
                nomor=no+1;

                editTextID.setText(String.valueOf(nomor));
            }



            protected void bersih(){
                nomer();
                editTextpertanyaan.setText("");
                editTextjawaban1.setText("");
                editTextjawaban2.setText("");
                editTextjawaban3.setText("");
                editTextjawabanbenar.setText("");
            }
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(BuatSoal.this,s,Toast.LENGTH_LONG).show();
                bersih();
            }

            @Override

            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(Server.KEY_EMP_ID,id);
                params.put(Server.KEY_EMP_PERTANYAAN,tanya);
                params.put(Server.KEY_EMP_JAWABAN1,jawab1);
                params.put(Server.KEY_EMP_JAWABAN2,jawab2);
                params.put(Server.KEY_EMP_JAWABAN3,jawab3);
                params.put(Server.KEY_EMP_JAWABANBENAR,benar);

                if(tempjenis=="Bahasa Indonesia"){
                    RequestHandler rh = new RequestHandler();
                    String res = rh.sendPostRequest(Server.URL_ADD_B, params);
                    return res;
                }else if(tempjenis=="Matematika"){
                    RequestHandler rh = new RequestHandler();
                    String res = rh.sendPostRequest(Server.URL_ADD_M, params);
                    return res;
                }else if(tempjenis=="Ekonomi"){
                    RequestHandler rh = new RequestHandler();
                    String res = rh.sendPostRequest(Server.URL_ADD_E, params);
                    return res;
                }else if(tempjenis=="Ipa"){
                    RequestHandler rh = new RequestHandler();
                    String res = rh.sendPostRequest(Server.URL_ADD_Ipa, params);
                    return res;
                }else if(tempjenis=="Bahasa Inggris"){
                    RequestHandler rh = new RequestHandler();
                    String res = rh.sendPostRequest(Server.URL_ADD_BI, params);
                    return res;
                }else if(tempjenis=="Ips"){
                    RequestHandler rh = new RequestHandler();
                    String res = rh.sendPostRequest(Server.URL_ADD_Ips, params);
                    return res;
                }else{
                    hilang();

                }


                return null;
            }
        }


        AddEmployee ae = new AddEmployee();
        ae.execute();
    }

    @Override
    public void onClick(View v) {
        if(v == btnNext){
            String t = editTextpertanyaan.getText().toString();
            String j1 = editTextjawaban1.getText().toString();
            String j2 = editTextjawaban2.getText().toString();
            String j3 = editTextjawaban3.getText().toString();
            String b = editTextjawabanbenar.getText().toString();

            if (t.trim().length() > 0 && j1.trim().length() > 0 && j2.trim().length() > 0&& j3.trim().length() > 0 && b.trim().length() > 0) {
                if (conMgr.getActiveNetworkInfo() != null
                        && conMgr.getActiveNetworkInfo().isAvailable()
                        && conMgr.getActiveNetworkInfo().isConnected()) {
                    addEmployee();
                    editTextpertanyaan.requestFocus();
                } else {
                    Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
                }
            } else {
                // Prompt user to enter credentials
                Toast.makeText(getApplicationContext(), "Kolom tidak boleh kosong", Toast.LENGTH_LONG).show();
            }


            }


        if(v == btnSelesai){
            String t = editTextpertanyaan.getText().toString();
            String j1 = editTextjawaban1.getText().toString();
            String j2 = editTextjawaban2.getText().toString();
            String j3 = editTextjawaban3.getText().toString();
            String b = editTextjawabanbenar.getText().toString();

            if (t.trim().length() > 0 && j1.trim().length() > 0 && j2.trim().length() > 0 && j3.trim().length() > 0 && b.trim().length() > 0) {
                if (conMgr.getActiveNetworkInfo() != null
                        && conMgr.getActiveNetworkInfo().isAvailable()
                        && conMgr.getActiveNetworkInfo().isConnected()) {
                    addEmployee();
                } else {
                    Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
                }
            } else {
                // Prompt user to enter credentials
                Toast.makeText(getApplicationContext(), "Kolom tidak boleh kosong", Toast.LENGTH_LONG).show();
            }
            Intent intent = new Intent(this, HomeGuru.class);
            intent.putExtra(TAG_ID,id);
            intent.putExtra(TAG_USERNAME,username);
            finish();
            startActivity(intent);

        }


    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    private void deleteEmployee(){
        class DeleteEmployee extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(BuatSoal.this, "Menghapus...", "Tunggu...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();

            }

            @Override
            protected String doInBackground(Void... params) {
                if(tempjenis=="Bahasa Indonesia"){
                    String url="http://192.168.173.1/kuis/bahasa/delete.php";
                    FetchDataTask task=new FetchDataTask();
                    task.execute(url);
                    return url;
                }else if(tempjenis=="Matematika"){
                    String url="http://192.168.173.1/kuis/mtk/delete.php";
                    FetchDataTask task=new FetchDataTask();
                    task.execute(url);
                    return url;
                }else if(tempjenis=="Ekonomi"){
                    String url="http://192.168.173.1/kuis/ekonomi/delete.php";
                    FetchDataTask task=new FetchDataTask();
                    task.execute(url);
                    return url;
                }else if(tempjenis=="Ipa"){
                    String url="http://192.168.173.1/kuis/ipa/delete.php";
                    FetchDataTask task=new FetchDataTask();
                    task.execute(url);
                    return url;
                }else if(tempjenis=="Bahasa Inggris"){
                    String url="http://192.168.173.1/kuis/binggris/delete.php";
                    FetchDataTask task=new FetchDataTask();
                    task.execute(url);
                    return url;
                }else if(tempjenis=="Ips"){
                    String url="http://192.168.173.1/kuis/ips/delete.php";
                    FetchDataTask task=new FetchDataTask();
                    task.execute(url);
                    return url;
                }else{
                    hilang();

                }

                return null;
            }
        }

        DeleteEmployee de = new DeleteEmployee();
        de.execute();
    }

    private void deletenilai(){
        class Delete extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                 }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);


            }

            @Override
            protected String doInBackground(Void... params) {
                if(tempjenis=="Bahasa Indonesia"){
                    String url="http://192.168.173.1/kuis/bahasa/deleten.php";
                    FetchDataTask task=new FetchDataTask();
                    task.execute(url);
                    return url;
                }else if(tempjenis=="Matematika"){
                    String url="http://192.168.173.1/kuis/mtk/deleten.php";
                    FetchDataTask task=new FetchDataTask();
                    task.execute(url);
                    return url;
                }else if(tempjenis=="Ekonomi"){
                    String url="http://192.168.173.1/kuis/ekonomi/deleten.php";
                    FetchDataTask task=new FetchDataTask();
                    task.execute(url);
                    return url;
                }else if(tempjenis=="Ipa"){
                    String url="http://192.168.173.1/kuis/ipa/deleten.php";
                    FetchDataTask task=new FetchDataTask();
                    task.execute(url);
                    return url;
                }else if(tempjenis=="Bahasa Inggris"){
                    String url="http://192.168.173.1/kuis/binggris/deleten.php";
                    FetchDataTask task=new FetchDataTask();
                    task.execute(url);
                    return url;
                }else if(tempjenis=="Ips"){
                    String url="http://192.168.173.1/kuis/ips/deleten.php";
                    FetchDataTask task=new FetchDataTask();
                    task.execute(url);
                    return url;
                }else{
                    hilang();

                }

                return null;
            }
        }

        Delete de = new Delete();
        de.execute();
    }



   @Override
    public void onBackPressed() {
       Toast.makeText(this,"selesaikan dahulu sampai 10 soal",Toast.LENGTH_LONG).show();

    }
    protected void tampil(){
        sp.setEnabled(false);
        editTextpertanyaan.setEnabled(true);
        editTextjawaban1.setEnabled(true);
        editTextjawaban2.setEnabled(true);
        editTextjawaban3.setEnabled(true);
        editTextjawabanbenar.setEnabled(true);
    }
    protected void hilang(){

        editTextpertanyaan.setEnabled(false);
        editTextjawaban1.setEnabled(false);
        editTextjawaban2.setEnabled(false);
        editTextjawaban3.setEnabled(false);
        editTextjawabanbenar.setEnabled(false);
    }
    private void confirmDeleteEmployee(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("dengan menekan tombol 'Ya' anda akan menghapus seluruh data pertanyaan yang sudah ada sebelumnya?");

        alertDialogBuilder.setPositiveButton("Ya",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        deleteEmployee();
                        deletenilai();
                        arg0.dismiss();
                    }
                });

        alertDialogBuilder.setNegativeButton("Tidak",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                        Intent intent = new Intent(BuatSoal.this, HomeGuru.class);
                        intent.putExtra(TAG_ID,id);
                        intent.putExtra(TAG_USERNAME,username);
                        finish();
                        startActivity(intent);

                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
