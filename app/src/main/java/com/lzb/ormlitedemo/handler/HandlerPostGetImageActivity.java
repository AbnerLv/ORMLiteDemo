package com.lzb.ormlitedemo.handler;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.lzb.ormlitedemo.R;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;


public class HandlerPostGetImageActivity extends Activity {

    private static final String logStr = "GetImageActivity";
    private Button btnLoadImage;
    private ImageView imageView;
    private static String image_path = "http://ww4.sinaimg.cn/bmiddle/786013a5jw1e7akotp4bcj20c80i3aao.jpg";
    private ProgressDialog progressDialog;
    private static Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_post_image);
        btnLoadImage = (Button) findViewById(R.id.btnGetImage);
        imageView = (ImageView) findViewById(R.id.ivShowImage);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("提示");
        progressDialog.setMessage("正在下载中...");
        progressDialog.setCancelable(false);
        btnLoadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(logStr,"是什么错");
                progressDialog.show();
                new Thread(new MyThread()).start();
            }
        });
    }

    class MyThread implements Runnable {

        @Override
        public void run() {
            //下载一个照片
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(image_path);
            HttpResponse httpResponse = null;

            try {
                httpResponse = httpClient.execute(httpGet);

                if (httpResponse.getStatusLine().getStatusCode() == 200) {
                    byte[] data = EntityUtils.toByteArray(httpResponse.getEntity());
                    //得到一个Bitmap对象，并且使在post内部可以访问，必须声明final
                    final Bitmap bmp = BitmapFactory.decodeByteArray(data, 0, data.length);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            imageView.setImageBitmap(bmp);
                        }
                    });
                    progressDialog.dismiss();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }

}
