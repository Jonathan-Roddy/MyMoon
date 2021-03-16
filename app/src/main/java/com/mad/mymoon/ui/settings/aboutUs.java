package com.mad.mymoon.ui.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.mad.mymoon.R;

public class aboutUs extends Fragment implements View.OnCreateContextMenuListener{
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    TextView tvTitle,tvAboutUs;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        View root = inflater.inflate(R.layout.fragment_aboutus, container, false);

        tvTitle = (TextView) root.findViewById(R.id.tvTitle);
        tvAboutUs= (TextView) root.findViewById(R.id.tvAboutUs);
        tvAboutUs.setText("\n\nThank you again for downloading this application \n\n" +
                "I have been developing this application for a few months now and have enjoyed doing do" +
                "This application is part of my Final year project in Software Development " +
                "in Limerick Institute of Technology\n\n" +
                "Being able to develop this application has allowed me to share my interest about the moon onto others.\n\n" +
                "There is much more I could add to this butu for now I hope you enjoy using this Moon app");


        return root;
    }

    @Override
    public void onPause() {
        // save the instance variables

//        SharedPreferences.Editor editor = savedValues.edit();
//        editor.putInt("roundCount", roundCount);
//        editor.putInt("player1Points", player1Points);
//        editor.putInt("player2Points", player2Points);
//        editor.putBoolean("player1Turn", player1Turn);
//        editor.commit();
        super.onPause();
    }

    @Override
    public void onResume() {

        super.onResume();
//        new MainActivity();
//        getView().setFocusableInTouchMode(true);
//        getView().requestFocus();
//        getView().setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//
//                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK){
//                    if(getFragmentManager().getBackStackEntryCount() > 0) {
//                        getFragmentManager().popBackStack();
//                    }
//
//                    return true;
//
//                }
//
//                return false;
//            }
//        });
    }

    // create menu items
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        menu.clear();
        //inflater.inflate(R.menu.fragment_menu,menu);
    }




}

