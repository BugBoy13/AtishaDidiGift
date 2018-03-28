package com.vardaan.atishadidi;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button surpriseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        surpriseButton = findViewById(R.id.supriseButton);

        surpriseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                showImage();
            }
        });
    }

    private void showImage() {

        Random random = new Random();
        int n = random.nextInt(9) + 1;

        final Dialog builder = new Dialog(MainActivity.this);
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
        builder.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));

        String imageName = "image" + Integer.toString(n);

        Uri uri = Uri.parse("android.resource://com.vardaan.atishadidi/drawable/" + imageName);

        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setImageURI(uri);
        builder.addContentView(imageView, new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        builder.show();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                builder.dismiss();
            }
        }, 3000);


    }
}
