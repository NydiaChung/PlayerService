package com.example.playerservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button_play;
    private Button button_stop;
    private Button button_pause;
    private Button button_exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_play=findViewById(R.id.button_play);
        button_stop=findViewById(R.id.button_stop);
        button_pause=findViewById(R.id.button_pause);
        button_exit=findViewById(R.id.button_exit);
    }

    public void onClick(View v){
        Intent intent=new Intent(this,MusicService.class);
        if (button_play==v){
            intent.putExtra("action","play");
            startService(intent);
        }else if(button_stop==v){
            intent.putExtra("action","stop");
            startService(intent);
        }else if(button_pause==v){
            intent.putExtra("action","pause");
            startService(intent);
        }else if(button_exit==v){
            intent.putExtra("action","exit");
            startService(intent);
        }
    }
}
