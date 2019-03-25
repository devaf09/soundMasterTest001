package com.websarva.wings.android.soundmastertest001;

import android.content.Context;
import android.media.AudioManager;
//import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button001 = findViewById(R.id.button001);

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
                case R.id.button001:
//                    Toast.makeText(getApplicationContext(), "button", Toast.LENGTH_LONG).show();
                    AudioManager audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);             // オーディオマネージャをインスタンス
                    int alarm_volume    = audioManager.getStreamVolume(AudioManager.STREAM_DTMF);                  // ダイヤル音量取得
                    int music_volume    = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);                 // 音楽再生音量取得
                    int notice_volume   = audioManager.getStreamVolume(AudioManager.STREAM_NOTIFICATION);          // 通知音量取得
                    int ring_volume     = audioManager.getStreamVolume(AudioManager.STREAM_RING);                  // 着信音量取得
                    int sysmesg_volume  = audioManager.getStreamVolume(AudioManager.STREAM_SYSTEM);                // システムメッセージ音量取得
                    int voice_volume    = audioManager.getStreamVolume(AudioManager.STREAM_VOICE_CALL);            // 通話音量取得
                    int get_manner_mode = audioManager.getRingerMode();

                    TextView TV_alarm_volume    = findViewById(R.id.alarm_volume);
                    TextView TV_music_volume   = findViewById(R.id.music_volume);
                    TextView TV_notice_volume   = findViewById(R.id.notice_volume);
                    TextView TV_ring_volume     = findViewById(R.id.ring_volume);
                    TextView TV_sysmesg_volume  = findViewById(R.id.sysmesg_volume);
                    TextView TV_voice_volume    = findViewById(R.id.voice_volume);
                    TextView TV_manner_mode    = findViewById(R.id.manner_mode);

                    TV_alarm_volume.setText(String.valueOf(alarm_volume) + "");
                    TV_music_volume.setText(String.valueOf(music_volume) + "");
                    TV_notice_volume.setText(String.valueOf(notice_volume) + "");
                    TV_ring_volume.setText(String.valueOf(ring_volume) + "");
                    TV_sysmesg_volume.setText(String.valueOf(sysmesg_volume) + "");
                    TV_voice_volume.setText(String.valueOf(voice_volume) + "");

                    // マナーモード判定
                    if(get_manner_mode == 2){
                        TV_manner_mode.setText("通常モード");
                    }else if(get_manner_mode == 1){
                        TV_manner_mode.setText("マナーモード（バイブ）");
                    }else{
                        TV_manner_mode.setText("マナーモード（バイブ無し）");
                    }
                    break;

                default:
                    String mesg = "認識されないオブジェクトがクリックされました。:" + String.valueOf(objID);
                    Toast.makeText(getApplicationContext(), mesg, Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }
}


