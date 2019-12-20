package app.afres;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class PilihTampilSoal  extends AppCompatActivity implements View.OnClickListener{
    private CardView ekonomiCard,ipsard,ipaCard,inggrisCard,mtkCard,bahasaCard;

    SharedPreferences sharedpreferences;
    public final static String TAG_pelajaran = "mapel";
    String pelajaran;
    private TextView mtk;
    private TextView ipa;
    private TextView ips;
    private TextView bahasa;
    private TextView binggris;
    private TextView ekonomi;
    String tempjenis,id,username;
    public static final String TAG_USERNAME = "username";
    public static final String TAG_ID = "id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_tampil_soal);

        mtk = (TextView) findViewById(R.id.mtk);
        ipa = (TextView) findViewById(R.id.ipa);
        ips = (TextView) findViewById(R.id.ips);
        bahasa = (TextView) findViewById(R.id.bahasa);
        binggris = (TextView) findViewById(R.id.binggris);
        ekonomi = (TextView) findViewById(R.id.ekonomi);


        id = getIntent().getStringExtra(TAG_ID);
        username = getIntent().getStringExtra(TAG_USERNAME);




        //inisial card
        ekonomiCard=(CardView)findViewById(R.id.ekonomicard);
        ipsard=(CardView)findViewById(R.id.ips_card);
        ipaCard=(CardView)findViewById(R.id.ipa_card);
        inggrisCard=(CardView)findViewById(R.id.bi_card);
        mtkCard=(CardView)findViewById(R.id.mtk_card);
        bahasaCard=(CardView)findViewById(R.id.bahasa_card);

        //menambah click listener
        ekonomiCard.setOnClickListener(this);
        ipsard.setOnClickListener(this);
        ipaCard.setOnClickListener(this);
        inggrisCard.setOnClickListener(this);
        mtkCard.setOnClickListener(this);
        bahasaCard.setOnClickListener(this);




    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, HomeGuru.class);
        intent.putExtra(TAG_ID,id);
        intent.putExtra(TAG_USERNAME,username);
        startActivity(intent);}
    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.bahasa_card :
            {

                i= new Intent(this,TampilSoal.class);
                i.putExtra(TAG_pelajaran, bahasa.getText().toString());
                i.putExtra(TAG_ID,id);
                i.putExtra(TAG_USERNAME,username);
            }
            finish();startActivity(i);break;

            case R.id.mtk_card :
            {

                i= new Intent(this,TampilSoal.class);
                i.putExtra(TAG_pelajaran, mtk.getText().toString());
                i.putExtra(TAG_ID,id);
                i.putExtra(TAG_USERNAME,username);
            } finish();startActivity(i);break;

            case R.id.bi_card :
            {

                i= new Intent(this,TampilSoal.class);
                i.putExtra(TAG_pelajaran, binggris.getText().toString());
                i.putExtra(TAG_ID,id);
                i.putExtra(TAG_USERNAME,username);
            } finish();startActivity(i);break;

            case R.id.ipa_card :
            {

                i= new Intent(this,TampilSoal.class);
                i.putExtra(TAG_pelajaran, ipa.getText().toString());
                i.putExtra(TAG_ID,id);
                i.putExtra(TAG_USERNAME,username);
            } finish();startActivity(i);break;
            case R.id.ips_card :
            {

                i= new Intent(this,TampilSoal.class);
                i.putExtra(TAG_pelajaran,ips.getText().toString());
                i.putExtra(TAG_ID,id);
                i.putExtra(TAG_USERNAME,username);
            } finish();startActivity(i);break;
            case R.id.ekonomicard :
            {

                i= new Intent(this,TampilSoal.class);
                i.putExtra(TAG_pelajaran, ekonomi.getText().toString());
                i.putExtra(TAG_ID,id);
                i.putExtra(TAG_USERNAME,username);
            } finish();startActivity(i);break;
        }
    }
}
