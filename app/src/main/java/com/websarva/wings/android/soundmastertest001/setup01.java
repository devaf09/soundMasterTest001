package com.websarva.wings.android.soundmastertest001;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class setup01 extends Activity {

    // 各音量の値入れ用
    int alarm_volume;           // アラーム音量取得
    int dial_volume;            // ダイヤル音量
    int music_volume;           // 音楽再生音量取得
    int notice_volume;          // 通知音量取得
    int ring_volume;            // 着信音量取得
    int sysmesg_volume;         // システムメッセージ音量取得
    int voice_volume;           // 通話音量取得
    int get_manner_mode;        // マナーモード判定

    // 各音量の最大値
    int alarm_volumeMAX;        // アラーム音量の最大値
    int dial_volumeMAX;         // ダイヤル音量の最大値
    int music_volumeMAX;        // 音楽再生音量の最大値
    int notice_volumeMAX;       // 通知音量の最大値
    int ring_volumeMAX;         // 着信音量の最大値
    int sysmesg_volumeMAX;      // システムメッセージ音量の最大値
    int voice_volumeMAX;        // 通話音量の最大値

    final int seekbar_max_num = 100;         // シークバーの最大値計算用

    // テキストの定義
    TextView TV_alarm_volume;
    TextView TV_dial_volume;
    TextView TV_music_volume;
    TextView TV_notice_volume;
    TextView TV_ring_volume;
    TextView TV_sysmesg_volume;
    TextView TV_voice_volume;
    TextView TV_manner_mode;

    // シークバー定義
    SeekBar SB_alarm_volume;
    SeekBar SB_dial_volume;
    SeekBar SB_music_volume;
    SeekBar SB_notice_volume;
    SeekBar SB_ring_volume;
    SeekBar SB_sysmesg_volume;
    SeekBar SB_voice_volume;

    AudioManager audioManager;          // オーディオマネージャをインスタンス

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup01);

        Button button001 = findViewById(R.id.BT_onryousettei);
        Button BT_returnMain = findViewById(R.id.BT_returnMain);

        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);          // オーディオマネージャをインスタンス

        // テキストの定義 これ前にもってけないかなぁ
        TV_alarm_volume    = findViewById(R.id.alarm_volume);
        TV_dial_volume     = findViewById(R.id.dial_volume);
        TV_music_volume    = findViewById(R.id.music_volume);
        TV_notice_volume   = findViewById(R.id.notice_volume);
        TV_ring_volume     = findViewById(R.id.ring_volume);
        TV_sysmesg_volume  = findViewById(R.id.sysmesg_volume);
        TV_voice_volume    = findViewById(R.id.voice_volume);
        TV_manner_mode     = findViewById(R.id.manner_mode);

        // シークバー定義
        SB_alarm_volume     = findViewById(R.id.seekbar_alarm_volume);
        SB_dial_volume      = findViewById(R.id.seekbar_dial_volume);
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
                    alarm_volume = pToiSb(SB_alarm_volume.getProgress(), alarm_volumeMAX);
                    TV_alarm_volume.setText(String.valueOf(SB_alarm_volume.getProgress()));
                }
                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }
                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            }
        );

        SB_dial_volume.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        dial_volume = pToiSb(SB_dial_volume.getProgress(), dial_volumeMAX);
                        TV_dial_volume.setText(String.valueOf(SB_dial_volume.getProgress()));
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                }
        );

        SB_music_volume.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        music_volume = pToiSb(SB_music_volume.getProgress(), music_volumeMAX);
                        TV_music_volume.setText(String.valueOf(SB_music_volume.getProgress()));
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                }
        );

        SB_notice_volume.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        notice_volume = pToiSb(SB_notice_volume.getProgress(), notice_volumeMAX);
                        TV_notice_volume.setText(String.valueOf(SB_notice_volume.getProgress()));
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                }
        );

        SB_ring_volume.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        ring_volume = pToiSb(SB_ring_volume.getProgress(), ring_volumeMAX);
                        TV_ring_volume.setText(String.valueOf(SB_ring_volume.getProgress()));
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                }
        );

        SB_sysmesg_volume.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        sysmesg_volume = pToiSb(SB_sysmesg_volume.getProgress(),sysmesg_volumeMAX);
                        TV_sysmesg_volume.setText(String.valueOf(SB_sysmesg_volume.getProgress()));
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                }
        );

        SB_voice_volume.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        voice_volume = pToiSb(SB_voice_volume.getProgress(), voice_volumeMAX);
                        TV_voice_volume.setText(String.valueOf(SB_voice_volume.getProgress()));
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
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
                case R.id.BT_onryousettei:
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

        alarm_volume    = audioManager.getStreamVolume(AudioManager.STREAM_ALARM);                  // アラーム音量取得
        dial_volume     = audioManager.getStreamVolume(AudioManager.STREAM_DTMF);                   // ダイヤル音量取得
        music_volume    = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);                  // 音楽再生音量取得
        notice_volume   = audioManager.getStreamVolume(AudioManager.STREAM_NOTIFICATION);           // 通知音量取得
        ring_volume     = audioManager.getStreamVolume(AudioManager.STREAM_RING);                   // 着信音量取得
        sysmesg_volume  = audioManager.getStreamVolume(AudioManager.STREAM_SYSTEM);                 // システムメッセージ音量取得
        voice_volume    = audioManager.getStreamVolume(AudioManager.STREAM_VOICE_CALL);             // 通話音量取得

        alarm_volumeMAX     = audioManager.getStreamMaxVolume(AudioManager.STREAM_ALARM);           // ダイヤル音量の最大値取得
        dial_volumeMAX      = audioManager.getStreamMaxVolume(AudioManager.STREAM_DTMF);            // ダイヤル音量の最大値取得
        music_volumeMAX     = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);           // 音楽再生音量の最大値取得
        notice_volumeMAX    = audioManager.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION);    // 通知音量の最大値取得
        ring_volumeMAX      = audioManager.getStreamMaxVolume(AudioManager.STREAM_RING);            // 着信音量の最大値取得
        sysmesg_volumeMAX   = audioManager.getStreamMaxVolume(AudioManager.STREAM_SYSTEM);          // システムメッセージ音量の最大値取得
        voice_volumeMAX     = audioManager.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL);      // 通話音量の最大値取得

        get_manner_mode = audioManager.getRingerMode();                                             // マナーモードの判定

        // 現在の値とか表示（パーセント表示にした）（この手のオブジェクトってテーブルにできないのかな？　あとで調べる）
        TV_alarm_volume.setText(String.valueOf(iTopSb(alarm_volume , alarm_volumeMAX)));
        TV_dial_volume.setText(String.valueOf(iTopSb(dial_volume , dial_volumeMAX)));
        TV_music_volume.setText(String.valueOf(iTopSb(music_volume , music_volumeMAX)));
        TV_notice_volume.setText(String.valueOf(iTopSb(notice_volume , notice_volumeMAX)));
        TV_ring_volume.setText(String.valueOf(iTopSb(ring_volume , ring_volumeMAX)));
        TV_sysmesg_volume.setText(String.valueOf(iTopSb(sysmesg_volume , sysmesg_volumeMAX)));
        TV_voice_volume.setText(String.valueOf(iTopSb(voice_volume , voice_volumeMAX)));

        // シークバーの最大値を設定（最小値の設定も必要かも？

        // シークバー 表示だけ
        SB_alarm_volume.setProgress(iTopSb(alarm_volume , alarm_volumeMAX));
        SB_dial_volume.setProgress(iTopSb(dial_volume,dial_volumeMAX));
        SB_music_volume.setProgress(iTopSb(music_volume , music_volumeMAX));
        SB_notice_volume.setProgress(iTopSb(notice_volume , notice_volumeMAX));
        SB_ring_volume.setProgress(iTopSb(ring_volume , ring_volumeMAX));
        SB_sysmesg_volume.setProgress(iTopSb(sysmesg_volume , sysmesg_volumeMAX));
        SB_voice_volume.setProgress(iTopSb(voice_volume , voice_volumeMAX));

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
        // 各音量を設定する
        audioManager.setStreamVolume(AudioManager.STREAM_DTMF, alarm_volume,0);
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, music_volume, 0);
        audioManager.setStreamVolume(AudioManager.STREAM_NOTIFICATION, notice_volume, 0);
        audioManager.setStreamVolume(AudioManager.STREAM_RING, ring_volume, 0);
        audioManager.setStreamVolume(AudioManager.STREAM_SYSTEM, sysmesg_volume, 0);
        audioManager.setStreamVolume(AudioManager.STREAM_VOICE_CALL, voice_volume ,0);
        Toast.makeText(getApplicationContext(), "各音量を設定しました。", Toast.LENGTH_SHORT).show();
    }

    public void CallDefaultMode(){

    }

    // なんかもう、めんどい計算式をまとめる。　本来はオブジェクト指向ぽい纏め方あるんだろうけどー
    // シークバーの音量をintから％へ変更する。
    public int iTopSb(int sound_level , int sound_level_Max){
        int a =  ((sound_level * seekbar_max_num) / sound_level_Max);
        return a;
    }

    // シークバーの音量を％からintへ変更する。
    public int pToiSb(int percent , int sound_level_Max){
        int a = (percent * sound_level_Max) / 100;
//        Toast.makeText(getApplicationContext(), "Now:" + String.valueOf(a) + " / Max:"+ String.valueOf(sound_level_Max), Toast.LENGTH_SHORT).show();
        return a;
    }
    
    
}
