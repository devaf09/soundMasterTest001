package com.websarva.wings.android.soundmastertest001;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
//import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button001 = findViewById(R.id.ToSetingMune);

        MainListener mainListener = new MainListener();                                             // リスナ開始
        button001.setOnClickListener(mainListener);                                                 // ボタンをリスナに登録

    }

    @Override
    public void onDestroy() {    // アプリが終了した場合
        super.onDestroy();

    }

    // クリック ～ ビュー関係 オーバーライド
    private class MainListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int objID = view.getId();

            switch (objID) {
                case R.id.ToSetingMune:

                    Intent setup01_activityIntent = new Intent(getApplication(), setup01.class);
                    startActivity(setup01_activityIntent);
//                    https://akira-watson.com/android/activity-2.html
                    break;


                default:
                    String mesg = "認識されないオブジェクトがクリックされました。:" + String.valueOf(objID);
                    Toast.makeText(getApplicationContext(), mesg, Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }
}


