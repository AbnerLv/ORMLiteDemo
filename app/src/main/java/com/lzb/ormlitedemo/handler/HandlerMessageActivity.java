package com.lzb.ormlitedemo.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lzb.ormlitedemo.R;

public class HandlerMessageActivity extends AppCompatActivity {

    private Button btn1, btn2, btn3, btn4, btn5;
    private static TextView tv_show_message;

    private static Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 3 || msg.what == 5) {
                tv_show_message.setText("what=" + msg.what + "，这是一个空消息");
            } else {
                tv_show_message.setText("what=" + msg.what + "," + msg.obj.toString());
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_message);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        tv_show_message = (TextView) findViewById(R.id.tv_show_message);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = Message.obtain();
                        message.what = 1;
                        message.obj = "使用Message.Obtain+Hander.sendMessage()发送消息";
                        handler.sendMessage(message);
                    }
                }).start();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = Message.obtain(handler);
                        message.what = 2;
                        message.obj = "使用Message.sendToTarget发送消息";
                        message.sendToTarget();
                    }
                }).start();


            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        handler.sendEmptyMessage(3);
                    }
                }).start();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message msg = Message.obtain();
                        msg.obj = "使用Message.Obtain+Hander.sendMessage()发送延迟消息";
                        handler.sendMessageDelayed(msg, 3000);
                    }
                }).start();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        handler.sendEmptyMessageDelayed(5, 3000);
                    }
                }).start();
            }
        });

    }

}
