package com.example.letusmeet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MeetHomeActivity extends AppCompatActivity {

    EditText txtCode;
    Button btnjoin,btncreate;
    Toolbar toolbar;
    TextView txtName;
    ImageView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meet_home);

        txtCode = (EditText)findViewById(R.id.txtCode);
        btnjoin = (Button)findViewById(R.id.btnJoin);
        btncreate = (Button)findViewById(R.id.btnCreate);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        txtName = (TextView)findViewById(R.id.txtName);
        logout = (ImageView)findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MeetHomeActivity.this, LoginActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                finish();
            }
        });

    }
}
