
// Request permission at run time.

package com.example.snippet.requestpermission;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final int SDCARD_REQUEST_CODE = 1;

    // control
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // reference control
        textView = findViewById(R.id.textView);

        // check if it has permission
        if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){

            // permission is not granted, request the permission
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, SDCARD_REQUEST_CODE);
        } else {

            // permission has already been granted
            textView.setText("PERMISSION HAS ALREADY BEEN GRANTED");
        }
    }

    // callback method that get the result of the request
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        // responds to same request code you pass in requestPermissions
        if(requestCode == SDCARD_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                textView.setText("PERMISSION GRANTED");
            else
                textView.setText("PERMISSION DENIED");
        }
    }
}
