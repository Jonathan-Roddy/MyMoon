package com.mad.mymoon.ui.Discover;

import android.os.Bundle;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mad.mymoon.R;
import com.mad.mymoon.ui.Discover.Options.GalleryImageAdapter;

public class DiscoveryImage extends AppCompatActivity implements View.OnCreateContextMenuListener {
    ImageView selectedImage;
    private ScaleGestureDetector scaleGestureDetector;
    private float mScaleFactor = 1.0f;
    TextView txtImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_discover_image);

        Gallery gallery = (Gallery) findViewById(R.id.gallery);

        selectedImage=findViewById(R.id.imageView);
        txtImage=findViewById(R.id.txtImage);

        gallery.setSpacing(1);

        final GalleryImageAdapter galleryImageAdapter= new GalleryImageAdapter(this);
        gallery.setAdapter(galleryImageAdapter);


        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                // show the selected Image
                selectedImage.setImageResource(galleryImageAdapter.mImageIds[position]);
                switch(position){
                    case 0:
                        txtImage.setText("Atlas of the Lunar Surface: Earth Side");
                        System.out.println("////////// TEST : " + position );
                        break;
                    case 1:
                        txtImage.setText("Atlas of the Lunar Surface: Far Side");
                        System.out.println("////////// TEST : " + position );
                        break;
                    case 2:
                        txtImage.setText("Atlas of the Lunar Surface: Polar Caps");
                        System.out.println("////////// TEST : " + position );
                        break;
                    case 3:
                        txtImage.setText("Red Moon");
                        System.out.println("////////// TEST : " + position );
                        break;
                    case 4:
                        txtImage.setText("How a Red Moon accurs");
                        System.out.println("////////// TEST : " + position );
                        break;
                    case 5:txtImage.setText("How a solar Eclipse works");
                        System.out.println("////////// TEST : " + position );
                        break;
                    case 6:
                        txtImage.setText("How the Moon and Sun alters Earths tides");
                        System.out.println("////////// TEST : " + position );
                        break;
                    case 7:
                        txtImage.setText("Astronaut Placing American Flag");
                        System.out.println("////////// TEST : " + position );
                        break;
                    case 8:
                        txtImage.setText("Astronaut Placing American Flag");
                        System.out.println("////////// TEST : " + position );
                        break;
                    case 9:
                        txtImage.setText("How the Moon looks depending on what hemisphere you are on Earth.");
                        System.out.println("////////// TEST : " + position );
                        break;
                    case 10:
                        txtImage.setText("Moons Topography");
                        System.out.println("////////// TEST : " + position );
                        break;

                    default:
                        txtImage.setText("Atlas of the Lunar Surface: Earth Side");
                        System.out.println("////////// TEST : ");
                        break;
                }

            }
        });
    }

}