package com.example.myaudio;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;
    private MediaPlayer mediaPlayer;
    private EditText webUrl;
    private Button resAudioButton, sdAudioButton, webAudioButton, stopAudioButton;
    public static String[] storge_permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};

//    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
//    public static String[] storge_permissions_33 = {
//            Manifest.permission.READ_MEDIA_AUDIO,
//            Manifest.permission.READ_MEDIA_VIDEO
//    };

//    public static String[] permissions() {
//        String[] p;
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//            p = storge_permissions_33;
//        } else {
//            p = storge_permissions;
//        }
//        return p;
//    }

    public static String[] permissions() {
        String[] p;
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.) {
//            p = storge_permissions_33;
//        } else {
//            p = storge_permissions;
//        }
        p = storge_permissions;
        return p;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(MainActivity.this, permissions(), REQUEST_CODE);
        resAudioButton = (Button) findViewById(R.id.button1);
        sdAudioButton = (Button) findViewById(R.id.button2);
        webAudioButton = (Button) findViewById(R.id.button3);
        stopAudioButton = (Button) findViewById(R.id.button4);
        webUrl = (EditText) findViewById(R.id.editText1);
        resAudioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.audio);
                mediaPlayer = MediaPlayer.create(getApplicationContext(), uri);
                mediaPlayer.start();
            }
        });

        sdAudioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Log.i("Path", "Path = " + Environment.getExternalStorageDirectory());
//                File file = new File(Environment.getExternalStorageDirectory(), "audioSD.mp3");

                Log.i("Path", "/storage/emulated/0/Download/audioSD.mp3");
                File file = new File("/storage/emulated/0/Download/audioSD.mp3");

                Uri uri = Uri.fromFile(file);
                mediaPlayer = MediaPlayer.create(getApplicationContext(), uri);
                mediaPlayer.start();
            }
        });

        webAudioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse(webUrl.getText().toString());
                mediaPlayer = MediaPlayer.create(getApplicationContext(), uri);
                mediaPlayer.start();
            }
        });

        stopAudioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mediaPlayer.stop();
            }
        });
    }
}