package com.mad.mymoon.ui.AR;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.mad.mymoon.AugmentedEarth;
import com.mad.mymoon.AugmentedMoon;
import com.mad.mymoon.AugmentedPortal;
import com.mad.mymoon.Dashboard;
import com.mad.mymoon.R;

public class ARFragment extends Fragment {

    private ARViewModel ARViewModel;

    // Variables
    Button ARMoon;
    Button ARPortal;
    Button AREarth;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ARViewModel = new ViewModelProvider(this).get(ARViewModel.class);
        View root = inflater.inflate(R.layout.fragment_ar, container, false);
        //final TextView textView = root.findViewById(R.id.text_phases);
//        ARViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        // Button to call the AR Scene for the Moon
        ARMoon = (Button)root.findViewById(R.id.btnARMoon);
        ARMoon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AugmentedMoon.class);
                startActivity(intent);
            }
        });

        // Button to call the AR Scene for the Portal
        ARPortal = (Button)root.findViewById(R.id.btnARPortal);
        ARPortal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AugmentedPortal.class);
                startActivity(intent);
            }
        });

        // Button to call the AR Scene for the Earth
        AREarth = (Button)root.findViewById(R.id.btnAREarth);
        AREarth.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AugmentedEarth.class);
                startActivity(intent);
            }
        });


        return root;

    }

}