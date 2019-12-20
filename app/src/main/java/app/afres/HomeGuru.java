package app.afres;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeGuru extends AppCompatActivity implements View.OnClickListener{
    private CardView buatcard,lihatCard,lihatsiswaCard,lihatnilaiCard;
    SharedPreferences sharedpreferences;
    Button btn_logout;
    TextView txt_username;
    String id, username;
    private TextView bs;
    private TextView lsoal;
    private TextView lsiswa;
    private TextView lnilai;
    private TextView binggris;
    private TextView ekonomi;
    public static final String TAG_USERNAME = "username";
    public static final String TAG_ID = "id";

    private static  final int TIME_INTERVAL=2000;
    private long mBackPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_guru);

        txt_username = (TextView) findViewById(R.id.txt_username);
        btn_logout = (Button) findViewById(R.id.btn_logout);


        id = getIntent().getStringExtra(TAG_ID);
        username = getIntent().getStringExtra(TAG_USERNAME);


        txt_username.setText("" + username);

        btn_logout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent intent = new Intent(HomeGuru.this, LoginActivityGuru.class);
                finish();
                startActivity(intent);
            }
        });


        //inisial card
        buatcard=(CardView)findViewById(R.id.Buat);
        lihatCard=(CardView)findViewById(R.id.Lihatsoal);
        lihatsiswaCard=(CardView)findViewById(R.id.Lihatsiswa);
        lihatnilaiCard=(CardView)findViewById(R.id.Lihatnilai);


        //menambah click listener
        buatcard.setOnClickListener(this);
        lihatCard.setOnClickListener(this);
        lihatsiswaCard.setOnClickListener(this);
        lihatnilaiCard.setOnClickListener(this);





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
        Intent i;
        switch (v.getId()){
            case R.id.Buat : i= new Intent(this,BuatSoal.class);
                i.putExtra(TAG_ID,id);
                i.putExtra(TAG_USERNAME,username);
            finish();startActivity(i);break;
          case R.id.Lihatsoal : i= new Intent(this,PilihTampilSoal.class);
              i.putExtra(TAG_ID,id);
              i.putExtra(TAG_USERNAME,username);
          finish();
          startActivity(i);break;
           case R.id.Lihatsiswa : i= new Intent(this,LihatSiswa.class);
               i.putExtra(TAG_ID,id);
               i.putExtra(TAG_USERNAME,username);
           finish();
           startActivity(i);break;
           case R.id.Lihatnilai : i= new Intent(this,LihatNilai.class);
               i.putExtra(TAG_ID,id);
               i.putExtra(TAG_USERNAME,username);
           finish();
           startActivity(i);break;

        }
    }
}
