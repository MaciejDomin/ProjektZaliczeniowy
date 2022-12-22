package com.example.projektzaliczeniowy;

import android.Manifest;
import android.app.PendingIntent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Sms extends AppCompatActivity {

    private static final String TAG = "SMS111";
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;
    private static final int MY_PERMISSIONS_REQUEST_RECIVE_SMS = 2;
    SmsManager smsManager;
    String destinationAddress = "";
    String scAddress = null;
    String text ="";
    PendingIntent sentIntent = null;
    PendingIntent deliveryIntent = null;
    long messageId = 0;
    EditText phoneNumber;
    EditText smsMessage;
    Button sendSms;
    Button sendMail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sms);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        phoneNumber = findViewById(R.id.numertelefonu);
        smsMessage = findViewById(R.id.wiadomosc);
        sendSms = findViewById(R.id.button);
        sendMail = findViewById(R.id.button2);

        sendSms.setOnClickListener(view -> sendWithSmsManager());
        sendMail.setOnClickListener(view -> sendMail());
    }

    private void sendMail() {
    }

    private ActivityResultLauncher<String> requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    Toast.makeText(this, "SMS permission granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "SMS permission not granted", Toast.LENGTH_SHORT).show();
                }
            });


    private void sendWithSmsManager() {


        if (ContextCompat.checkSelfPermission(
                this, Manifest.permission.SEND_SMS) ==
                PackageManager.PERMISSION_GRANTED) {

            destinationAddress = phoneNumber.getText().toString();
            text = smsMessage.getText().toString();
            if (!destinationAddress.equals("") && !text.equals("")) {
                smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(
                        destinationAddress,
                        null,
                        text,
                        null,
                        null

                );
                Toast.makeText(Sms.this, "SMS send", Toast.LENGTH_SHORT).show();
                Log.v(TAG, "Sms send");
            } else
                Toast.makeText(Sms.this, "Permission denied", Toast.LENGTH_SHORT).show();
            Log.v(TAG, "Permission denied");

        } else {
            requestPermissionLauncher.launch(
                    Manifest.permission.SEND_SMS);
        }


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
