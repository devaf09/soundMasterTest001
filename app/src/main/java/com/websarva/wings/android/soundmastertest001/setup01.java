package com.websarva.wings.android.soundmastertest001;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class setup01 extends Activity {

    int alarm_volume;           // ダイヤル音量取得
    int music_volume;           // 音楽再生音量取得
    int notice_volume;          // 通知音量取得
    int ring_volume;            // 着信音量取得
    int sysmesg_volume;         // システムメッセージ音量取得
    int voice_volume;           // 通話音量取得
    int get_manner_mode;        // マナーモード判定

    // テキストの定義
    TextView TV_alarm_volume;
    TextView TV_music_volume;
    TextView TV_notice_volume;
    TextView TV_ring_volume;
    TextView TV_sysmesg_volume;
    TextView TV_voice_volume;
    TextView TV_manner_mode;

    // シークバー定義
    SeekBar SB_alarm_volume;
    SeekBar SB_music_volume;
    SeekBar SB_notice_volume;
    SeekBar SB_ring_volume;
    SeekBar SB_sysmesg_volume;
    SeekBar SB_voice_volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup01);

        Button button001 = findViewById(R.id.onryousettei);
        Button BT_returnMain = findViewById(R.id.BT_returnMain);
        // テキストの定義 これ前にもってけないかなぁ
        TV_alarm_volume    = findViewById(R.id.alarm_volume);
        TV_music_volume    = findViewById(R.id.music_volume);
        TV_notice_volume   = findViewById(R.id.notice_volume);
        TV_ring_volume     = findViewById(R.id.ring_volume);
        TV_sysmesg_volume  = findViewById(R.id.sysmesg_volume);
        TV_voice_volume    = findViewById(R.id.voice_volume);
        TV_manner_mode     = findViewById(R.id.manner_mode);

        // シークバー定義
        SB_alarm_volume     = findViewById(R.id.seekbar_alarm_volume);
        SB_music_volume     = findViewById(R.id.seekbar_music_volume);
        SB_notice_volume    = findViewById(R.id.seekbar_notice_volume);
        SB_ring_volume      = findViewById(R.id.seekbar_ring_volume);
        SB_sysmesg_volume   = findViewById(R.id.seekbar_sysmesg_volume);
        SB_voice_volume     = findViewById(R.id.seekbar_voice_volume);

        // シークバー割り込み設定 ここに書いていいのだろうか？
        SB_alarm_volume.setOnSeekBarChangeListener(
            new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    alarm_volume = SB_alarm_volume.getProgress();
//                    TV_alarm_volume.setText(alarm_volume);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
//                    TV_alarm_volume.setText(alarm_volume);
                }
            }
        );


        getSoundStatus();                                                                           // 音量の設定関係を読込む

        setup01.MainListener mainListener = new setup01.MainListener();                             // リスナ開始
        button001.setOnClickListener(mainListener);                                                 // ボタンをリスナに登録
        BT_returnMain.setOnClickListener(mainListener);                                             // ボタンをリスナに登録
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
                case R.id.onryousettei:
                    setSoundStatus();
                    break;

                case R.id.BT_returnMain:
                    finish();
                    break;

                default:
                    String mesg = "認識されないオブジェクトがクリックされました。:" + String.valueOf(objID);
                    Toast.makeText(getApplicationContext(), mesg, Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }

    public void getSoundStatus(){
        Toast.makeText(getApplicationContext(), "現在の音量の設定値を読み込みました。", Toast.LENGTH_SHORT).show();
        AudioManager audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);          // オーディオマネージャをインスタンス
        alarm_volume    = audioManager.getStreamVolume(AudioManager.STREAM_DTMF);                   // ダイヤル音量取得
        music_volume    = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);                  // 音楽再生音量取得
        notice_volume   = audioManager.getStreamVolume(AudioManager.STREAM_NOTIFICATION);           // 通知音量取得
        ring_volume     = audioManager.getStreamVolume(AudioManager.STREAM_RING);                   // 着信音量取得
        sysmesg_volume  = audioManager.getStreamVolume(AudioManager.STREAM_SYSTEM);                 // システムメッセージ音量取得
        voice_volume    = audioManager.getStreamVolume(AudioManager.STREAM_VOICE_CALL);             // 通話音量取得
        get_manner_mode = audioManager.getRingerMode();                                             // マナーモードの判定


        // 現在の値とか表示
        TV_alarm_volume.setText(String.valueOf(alarm_volume));
        TV_music_volume.setText(String.valueOf(music_volume));
        TV_notice_volume.setText(String.valueOf(notice_volume));
        TV_ring_volume.setText(String.valueOf(ring_volume));
        TV_sysmesg_volume.setText(String.valueOf(sysmesg_volume));
        TV_voice_volume.setText(String.valueOf(voice_volume));

        // シークバーテスト 表示だけ　本来は OnSeekBarChangeListener を使う 最初に音量の最大値を取得するのを忘れないこと　AudioManager.getStreamMaxVolume
        SB_alarm_volume.setProgress(alarm_volume);
        SB_music_volume.setProgress(alarm_volume);
        SB_notice_volume.setProgress(alarm_volume);
        SB_ring_volume.setProgress(alarm_volume);
        SB_sysmesg_volume.setProgress(alarm_volume);
        SB_voice_volume.setProgress(alarm_volume);

        // サイレントモード判定
        switch (get_manner_mode){
            case 2:
                TV_manner_mode.setText("通常（サイレントモードではありません）");
                break;
            case 1:
                TV_manner_mode.setText("サイレントモード（バイブ）");
                break;
            case 0:
                TV_manner_mode.setText("サイレントモード（バイブ無し）");
                break;
            default:
                TV_manner_mode.setText("サイレントモードの状態は不明");
                break;
        }

    }

    public void setSoundStatus(){
        // テキストの定義
        TextView TV_alarm_volume    = findViewById(R.id.alarm_volume);
        TextView TV_music_volume    = findViewById(R.id.music_volume);
        TextView TV_notice_volume   = findViewById(R.id.notice_volume);
        TextView TV_ring_volume     = findViewById(R.id.ring_volume);
        TextView TV_sysmesg_volume  = findViewById(R.id.sysmesg_volume);
        TextView TV_voice_volume    = findViewById(R.id.voice_volume);
        TextView TV_manner_mode     = findViewById(R.id.manner_mode);

        // シークバー定義
        SeekBar SB_alarm_volume     = findViewById(R.id.seekbar_alarm_volume);
        SeekBar SB_music_volume     = findViewById(R.id.seekbar_music_volume);
        SeekBar SB_notice_volume    = findViewById(R.id.seekbar_notice_volume);
        SeekBar SB_ring_volume      = findViewById(R.id.seekbar_ring_volume);
        SeekBar SB_sysmesg_volume   = findViewById(R.id.seekbar_sysmesg_volume);
        SeekBar SB_voice_volume     = findViewById(R.id.seekbar_voice_volume);





    }
}
