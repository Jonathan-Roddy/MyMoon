package com.mad.mymoon.ui.Discover;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.mad.mymoon.R;

public class DiscoverFragment extends Fragment {

    private DiscoverViewModel discoverViewModel;
    RelativeLayout relativeLayout;
    GridLayout gridLayout;
    CardView menu_moon, menu_mission, menu_videos, menu_images;
    ImageView ivMoon, ivMission, ivVideo, ivImage;
    TextView tvDiscoverTitle, moon, mission, video, image;
    LinearLayout lyMoon, lyMission, lvVideos, lvImage;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        discoverViewModel =
                new ViewModelProvider(this).get(DiscoverViewModel.class);
        View root = inflater.inflate(R.layout.fragment_discover, container, false);

        relativeLayout = (RelativeLayout) root.findViewById(R.id.relativeLayout);
        gridLayout = (GridLayout) root.findViewById(R.id.gridLayout);

        tvDiscoverTitle = (TextView) root.findViewById(R.id.tvDiscoverTitle);

        menu_moon = (CardView) root.findViewById(R.id.menu_moon);
        menu_moon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), DiscoveryMoon.class);
//                Intent intent = new Intent(MainActivity.this, AugmentedMoon.class);
                startActivity(intent);

            }
        });

        menu_mission = (CardView) root.findViewById(R.id.menu_mission);
        menu_mission.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DiscoveryMission.class);
//                Intent intent = new Intent(MainActivity.this, AugmentedMoon.class);
                startActivity(intent);
            }
        });
        menu_videos = (CardView) root.findViewById(R.id.menu_videos);
        menu_videos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DiscoveryVideo.class);
//                Intent intent = new Intent(MainActivity.this, AugmentedMoon.class);
                startActivity(intent);
            }
        });
        menu_images = (CardView) root.findViewById(R.id.menu_images);
        menu_images.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DiscoveryImage.class);
//                Intent intent = new Intent(MainActivity.this, AugmentedMoon.class);
                startActivity(intent);
            }
        });

        ivMoon = (ImageView) root.findViewById(R.id.ivMoon);
        ivMission = (ImageView) root.findViewById(R.id.ivMission);
        ivVideo = (ImageView) root.findViewById(R.id.ivVideo);
        ivImage = (ImageView) root.findViewById(R.id.ivImage);

        moon = (TextView) root.findViewById(R.id.tvMoon);
        mission = (TextView) root.findViewById(R.id.tvMission);
        video = (TextView) root.findViewById(R.id.tvVideo);
        image = (TextView) root.findViewById(R.id.tvImage);

        lyMoon = (LinearLayout) root.findViewById(R.id.lyMoon);
        lyMission = (LinearLayout) root.findViewById(R.id.lyMission);
        lvVideos = (LinearLayout) root.findViewById(R.id.lvVideos);
        lvImage = (LinearLayout) root.findViewById(R.id.lvImage);


        return root;
    }
}