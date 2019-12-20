package app.afres;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Menu extends AppCompatActivity implements View.OnClickListener{
    private CardView lihatnilai,profil;
    SharedPreferences sharedpreferences;
    String id, username;
    TextView txt_username;
    Button btn_logout;
    public static final String TAG_USERNAME = "username";
    public static final String TAG_ID = "id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);




        btn_logout = (Button) findViewById(R.id.btn_logout);
        id = getIntent().getStringExtra(TAG_ID);
        username = getIntent().getStringExtra(TAG_USERNAME);

        txt_username = (TextView) findViewById(R.id.txt_username);

        txt_username.setText("" + username);

        btn_logout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // update login session ke FALSE dan mengosongkan nilai id dan username


                Intent intent = new Intent(Menu.this, LoginActivity.class);
                finish();
                startActivity(intent);
            }
        });


        //inisial card
       lihatnilai=(CardView)findViewById(R.id.Lihatnilai);
        profil=(CardView)findViewById(R.id.profil);



        //menambah click listener
       lihatnilai.setOnClickListener(this);
        profil.setOnClickListener(this);






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
        Intent i;
        switch (v.getId()){
            case R.id.profil :  {
                i= new Intent(this,SiswaLihatProfil.class);
                i.putExtra(TAG_ID,id);
                i.putExtra(TAG_USERNAME,username);}
                finish();
            startActivity(i);break;
         case R.id.Lihatnilai : i= new Intent(this,SiswaLihatNilai.class);
         i.putExtra(TAG_ID,id);
         i.putExtra(TAG_USERNAME,username);
         finish();
         startActivity(i);break;


        }
    }
}
