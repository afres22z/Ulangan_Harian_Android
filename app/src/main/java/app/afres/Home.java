package app.afres;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    Button logout;
    TextView txt_username;
    String username;
    SharedPreferences sharedpreferences;


    public static final String TAG_USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        txt_username = (TextView) findViewById(R.id.txt_username);
        logout = (Button) findViewById(R.id.logout);



        username = getIntent().getStringExtra(TAG_USERNAME);


        txt_username.setText("USERNAME : " + username);

        logout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // update login session ke FALSE dan mengosongkan nilai id dan username


                Intent intent = new Intent(Home.this, LoginActivity.class);
                finish();
                startActivity(intent);
            }
        });

    }
}
