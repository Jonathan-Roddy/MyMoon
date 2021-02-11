package com.mad.mymoon;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    private static int splash_screen = 4000;

    // Variables
    Animation topAnim, bottomAnim;
    ImageView image;
    TextView logo, slogan;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.splash_screen);

        System.out.println("///////////////// To Firebase");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        /////////////////////////////////////////////////////////////////
        System.out.println("///////////////// To database" + database);
        /////////////////////////////////////////////////////////////////
        DatabaseReference myRef = database.getReference("Peter");
        System.out.println("///////////////// To myRef" + myRef);
////        /////////////////////////////////////////////////////////////
        myRef.setValue("Hey PEter");

        // Animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        // Hooks
        image = findViewById(R.id.LogoImage);
        logo = findViewById(R.id.MyMoonLogo);
        slogan = findViewById(R.id.MyMoonSlogan);


        image.setAnimation(topAnim);
        logo.setAnimation(bottomAnim);
        slogan.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Dashboard.class);
//                Intent intent = new Intent(MainActivity.this, AugmentedMoon.class);
                startActivity(intent);
                finish();
            }
        }, splash_screen);





    }


}