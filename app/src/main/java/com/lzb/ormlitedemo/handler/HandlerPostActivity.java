package com.lzb.ormlitedemo.handler;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.lzb.ormlitedemo.R;

public class HandlerPostActivity extends Activity {

    private Button btnMes1, btnMes2;
    private TextView tvMessage;

    private static Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_post);
        btnMes1 = (Button)findViewById(R.id.btnMes1);
        btnMes2 = (Button)findViewById(R.id.btnMes2);
        tvMessage = (TextView)findViewById(R.id.tvMessage);

        btnMes1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //新启动一个子线程
                new Thread(new Runnable() {
                    @Override
                    public void run() {
handler.post(new Runnable() {
    @Override
    public void run() {
        tvMessage.setText("使用Handler.post在工作线程中发送一段执行到消息队列中，在主线程中执行。");
    }
});
                    }
                }).start();
            }
        });

        btnMes2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                      handler.postDelayed(new Runnable() {
                          @Override
                          public void run() {
                              tvMessage.setText("使用Handler.postDelayed在工作线程中发送一段执行到消息队列中，在主线程中延迟3S执行。");
                          }
                      }, 3000);
                    }
                }).start();;
            }
        });


    }


}
