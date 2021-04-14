package com.mad.mymoon.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.mad.mymoon.R;
import com.mad.mymoon.ui.AR.AugmentedEarth;
import com.mad.mymoon.ui.AR.AugmentedMoon;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    TextView txtWhatsNew;
    TextView txtWelcomeList;
    Button toMoon, toEarth;

    ListView lvWhatsNew;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        // Display Whats new in TextView List
        txtWelcomeList = (TextView) root.findViewById(R.id.txtListWelcome);
        //txtWhatsNew = (TextView) root.findViewById(R.id.txtListWhatsNew);

        lvWhatsNew = (ListView) root.findViewById(R.id.listViewHome);

        toMoon = (Button) root.findViewById(R.id.btnMoon);
        toMoon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AugmentedMoon.class);
                startActivity(intent);
            }
        });

        toEarth = (Button) root.findViewById(R.id.btnEarth);
        toEarth.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AugmentedEarth.class);
                startActivity(intent);
            }
        });



        txtWelcomeList.setText("Welcome to MyMoon! \n" +
                "Thank you for downloading this application! \n\n " +
                "If you were ever curious or wanted to learn about our friend the Moon, here is the perfect place to do it. \n" +
                "Here you will be able to learn and interact with 3D models of both the Moon and the Earth.\n \n" +
                "Please feel free to rate the application and give any feedback for any future improvements.");

        List<String> arrayList = new ArrayList<String>();
        arrayList.add("*\t New Accurate 3D Models\n");
        arrayList.add(" -> The Moon\n");
        arrayList.add(" -> The Earth\n");
        arrayList.add("* Text-to-Speech implementation\n");
        arrayList.add("* Exciting new Library of facts\n");
        arrayList.add("* Videos\n");
        arrayList.add("* Different Languages\n");

//                System.out.println("///////////////////////////" + arrayList);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, arrayList);


        lvWhatsNew.setAdapter(arrayAdapter);
//                System.out.println(arrayList);

        return root;



    }


}