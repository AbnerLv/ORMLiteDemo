package com.lzb.ormlitedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lzb.ormlitedemo.handler.HandlerMessageActivity;
import com.lzb.ormlitedemo.handler.HandlerPostActivity;
import com.lzb.ormlitedemo.handler.HandlerPostGetImageActivity;

public class MainActivity extends Activity {

    private Button btnHandler;
    private Button btnHandlerImages, btnHandlerMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnHandler = (Button)findViewById(R.id.btnHandler);
        btnHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,HandlerPostActivity.class);
                startActivity(intent);
            }
        });

        btnHandlerImages = (Button)findViewById(R.id.btnHandlerImage);
        btnHandlerImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,HandlerPostGetImageActivity.class);
                startActivity(intent);
            }
        });

        btnHandlerMessage = (Button)findViewById(R.id.btnHandlerMessage);
        btnHandlerMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,HandlerMessageActivity.class);
                startActivity(intent);
            }
        });

    }


}
