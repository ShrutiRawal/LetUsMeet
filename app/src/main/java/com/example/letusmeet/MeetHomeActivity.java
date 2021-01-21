package com.example.letusmeet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.jitsi.meet.sdk.JitsiMeet;
import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;

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

        URL serverUrl;

        try {
            serverUrl = new URL("https://meet.jit.si");
            JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder().setServerURL(serverUrl).setWelcomePageEnabled(false).build();
            JitsiMeet.setDefaultConferenceOptions(options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        btnjoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code = txtCode.getText().toString();
                if(validateCode(code)){
                    joinCall(code);
                }
            }
        });

        btncreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code = txtCode.getText().toString();
                if(validateCode(code)){
                    joinCall(code);
                }
            }
        });


    }

    public void joinCall(String code){
        JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder().setRoom(code).setWelcomePageEnabled(false).build();
        JitsiMeetActivity.launch(MeetHomeActivity.this,options);
    }

    private boolean validateCode(String code) {
        if(code == null || code.trim().length() == 0){
            Toast.makeText(this, "Code is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
