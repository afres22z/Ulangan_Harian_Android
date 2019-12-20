package app.afres;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class EditUser  extends AppCompatActivity implements View.OnClickListener {
    private String id,username;
    private EditText nis;
    private EditText usern;
    private EditText paslama;
    private EditText pasbaru;
    private EditText confirm;
    private Button buttonSimpan,buttonEdit;
    public static final String TAG_USERNAME = "username";
    public static final String TAG_ID = "id";
    SharedPreferences sharedpreferences;

    String n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        Intent intent = getIntent();

        id = getIntent().getStringExtra(TAG_ID);
        username = getIntent().getStringExtra(TAG_USERNAME);
        nis = (EditText) findViewById(R.id.nis);

        usern = (EditText) findViewById(R.id.user);
        paslama = (EditText) findViewById(R.id.paslama);
        pasbaru = (EditText) findViewById(R.id.pasbaru);
        confirm = (EditText) findViewById(R.id.confirm);
        buttonSimpan= (Button) findViewById(R.id.buttonSimpan);
        buttonEdit= (Button) findViewById(R.id.buttonEdit);

        buttonSimpan.setOnClickListener(this);
        buttonEdit.setOnClickListener(this);
        buttonSimpan.setEnabled(false);
        nis.setText(id);
        usern.setText(username);
        usern.setEnabled(false);
        nis.setEnabled(false);
        pasbaru.setEnabled(false);
        paslama.setEnabled(false);
        confirm.setEnabled(false);


    }




    private void updateEmployee(){

        final String un = usern.getText().toString().trim();
        final String pl = paslama.getText().toString().trim();
        final String pb = pasbaru.getText().toString().trim();
        final String c = confirm.getText().toString().trim();

        class UpdateEmployee extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(EditUser.this,"Updating...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(EditUser.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... params) {


                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put(Server.KEY_EMP_ID,id);
                hashMap.put(Server.KEY_EMP_user,un);
                hashMap.put(Server.KEY_EMP_paslam,pl);
                hashMap.put(Server.KEY_EMP_pasbar,pb);
                hashMap.put(Server.KEY_EMP_confirm,c);


                    RequestHandler rh = new RequestHandler();
                    String s = rh.sendPostRequest(Server.URL_UPDATE_user,hashMap);
                    return s;


            }
        }

        UpdateEmployee ue = new UpdateEmployee();
        ue.execute();
    }
    @Override
    public void onBackPressed() {

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(TAG_ID,id);
        intent.putExtra(TAG_USERNAME,username);

        startActivity(intent);}


    @Override
    public void onClick(View v) {
        if(v == buttonSimpan){
            buttonSimpan.setEnabled(false);
            updateEmployee();

        }
        if(v == buttonEdit){
            usern.setEnabled(true);
            pasbaru.setEnabled(true);
            paslama.setEnabled(true);
            confirm.setEnabled(true);
            buttonSimpan.setEnabled(true);
        }
    }
}
