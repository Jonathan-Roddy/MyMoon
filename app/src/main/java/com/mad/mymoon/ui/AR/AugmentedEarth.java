package com.mad.mymoon.ui.AR;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.ar.core.Anchor;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.assets.RenderableSource;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;
import com.google.ar.sceneform.ux.TransformationSystem;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.mad.mymoon.MainActivity;
import com.mad.mymoon.R;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class AugmentedEarth extends AppCompatActivity {

    private ModelRenderable renderable;
    private TransformationSystem transformationSystem;
    private static final double MIN_OPENGL_VERSION = 3.0;
    private static final String TAG = MainActivity.class.getSimpleName();
    private Anchor currentAnchor = null;

    PopupWindow popUp;
    boolean click = true;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Check to see if Device is supported with Scenefrom
        if (!checkIsSupportedDeviceOrFinish(this)) {
            Toast.makeText(getApplicationContext(), "Device not supported", Toast.LENGTH_LONG).show();
        }

        // Display Pop up dialog

        // Call layout
        setContentView(R.layout.activity_main);

        // Initialise connection with Firebase
        FirebaseApp.initializeApp(this);

        // Grabbing Moon object from FirebaseStorage
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference modelRef = storage.getReference().child("Earth2.glb");

        ArFragment arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);


        // Download button action
        findViewById(R.id.downloadBtn)
                .setOnClickListener(v -> {

                    try {
                        File file = File.createTempFile("Earth2", "glb");
                        buildModel(file);

                        modelRef.getFile(file).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {

                                buildModel(file);

                            }
                        });

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                });



        arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {

            // Creating an anchor for the 3D model to stay on
            AnchorNode anchorNode = new AnchorNode(hitResult.createAnchor());
            anchorNode.setRenderable(renderable);
            arFragment.getArSceneView().getScene().addChild(anchorNode);

            // Ability to scale AR model
            TransformableNode scale = new TransformableNode(arFragment.getTransformationSystem());
            scale.getRotationController().setEnabled(true);
            scale.setParent(anchorNode);
            scale.setRenderable(renderable);
            scale.select();

        });

    }

    // Code to check if device can be used
    public boolean checkIsSupportedDeviceOrFinish(final Activity activity) {

        String openGlVersionString =
                ((ActivityManager) Objects.requireNonNull(activity.getSystemService(Context.ACTIVITY_SERVICE)))
                        .getDeviceConfigurationInfo()
                        .getGlEsVersion();
        if (Double.parseDouble(openGlVersionString) < MIN_OPENGL_VERSION) {
            Log.e(TAG, "Sceneform requires OpenGL ES 3.0 later");
            Toast.makeText(activity, "Sceneform requires OpenGL ES 3.0 or later", Toast.LENGTH_LONG)
                    .show();
            activity.finish();
            return false;
        }
        return true;
    }


    // Build and Render Model
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void buildModel(File file) {
        RenderableSource renderableSource = RenderableSource
                .builder()
                .setSource(this, Uri.parse(file.getPath()), RenderableSource.SourceType.GLB)
                .setRecenterMode(RenderableSource.RecenterMode.ROOT)
                .build();

        ModelRenderable
                .builder()
                .setSource(this, renderableSource)
                .setRegistryId(file.getPath())
                .build()
                .thenAccept(modelRenderable -> {
                    Toast.makeText(this, "Model Build", Toast.LENGTH_SHORT).show();
                    renderable = modelRenderable;
                });


    }


}

