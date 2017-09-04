package com.example.junior.practica;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private VideoView videoView;

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = (VideoView) findViewById(R.id.videoview);
        videoView.setMediaController(new MediaController(this));
//        videoView.setVideoURI(Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"));
        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.demo));
        videoView.start();
        btn = (Button)findViewById(R.id.btnPedido);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pedido = new Intent(MainActivity.this,PedidoActivity.class);
                startActivity(pedido);
            }
        });

    }
}
