package com.example.camera;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    private static final int CAMERA_REQUEST=123;
    Button butn;
    ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butn=findViewById(R.id.btn);
        imageview=findViewById(R.id.image);


    }

    public void btnClick(View v){
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        startActivityForResult(intent,CAMERA_REQUEST);

    }

    public void onActivityResult(int requestCode,int resultCode,Intent data){

        if(requestCode==CAMERA_REQUEST && resultCode== Activity.RESULT_OK){

            Bitmap photo=(Bitmap) data.getExtras().get("data");

            imageview.setImageBitmap(photo);
        }

    }
}