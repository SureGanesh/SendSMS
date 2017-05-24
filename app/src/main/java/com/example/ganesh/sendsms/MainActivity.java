package com.example.ganesh.sendsms;

import android.os.Bundle;
import android.app.Activity;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText txtPhoneNo;
    EditText txtMessage;
    Button btnSend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtPhoneNo = (EditText) this.findViewById(R.id.txtPhoneNo);
        txtMessage = (EditText) this.findViewById(R.id.txtMessage);
        btnSend = (Button) this.findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                // Get phone number & message sms
                String phoneNo = txtPhoneNo.getText().toString();
                String message = txtMessage.getText().toString();

                // If phone number & message is not empty
                if (phoneNo.length()>0 && message.length()>0){
                    sendMessage(phoneNo, message);
                    // If phone number or message not empty
                }else{
                    Toast.makeText(getBaseContext(), "Please enter both phone number and message.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    // Function send message sms
    private void sendMessage(String phoneNo, String message){
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null);
            Toast.makeText(getApplicationContext(), "SMS Sent.", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS Fail. Please try again!", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
