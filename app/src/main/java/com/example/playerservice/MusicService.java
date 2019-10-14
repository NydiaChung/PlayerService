package com.example.playerservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    public MediaPlayer player;

    public int onStartCommand(Intent intent,int flags,int startId){
        String action = intent.getStringExtra("action");
        if ("play".equals(action)){
            playOnClick();
        }else if ("stop".equals(action)){
            stopOnClick();
        }else if ("pause".equals(action)){
            pauseOnClick();
        }else if ("exit".equals(action)){
            exitOnClick();
        }

        return super.onStartCommand(intent,flags,startId);

    }

    public void playOnClick(){

        try {
            if (player == null) {
                player = MediaPlayer.create(this, R.raw.nanjing);
            }
            player.start();
        }catch (Exception e){

        }
    }

    public void stopOnClick(){
        if (player!=null){
            player.stop();
            player.reset();//重置
            player.release();//释放资源
            player=null;
        }

    }

    public void pauseOnClick(){

        if (player!=null&&player.isPlaying()){
            player.pause();
        }
    }

    public void exitOnClick(){

        stopOnClick();
    }

    public void onDestory(){
        super.onDestroy();
        //再死亡之前停止音乐
        stopOnClick();
    }
}
