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

public class arInfo extends Fragment implements View.OnCreateContextMenuListener{
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    TextView test;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        View root = inflater.inflate(R.layout.fragment_ar_info, container, false);

        test = (TextView) root.findViewById(R.id.tvTitle);


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

