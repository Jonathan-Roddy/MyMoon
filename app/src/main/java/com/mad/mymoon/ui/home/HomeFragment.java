package com.mad.mymoon.ui.home;

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

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    TextView txtWhatsNew;
    TextView txtWelcomeList;
    Button toMoon, toEarth, contactUs, rateUs;

    ListView lvWhatsNew;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        // Display Whats new in TextView List
        txtWelcomeList = (TextView) root.findViewById(R.id.txtListWelcome);
        //txtWhatsNew = (TextView) root.findViewById(R.id.txtListWhatsNew);

        lvWhatsNew = (ListView) root.findViewById(R.id.listViewHome);

        toMoon = (Button) root.findViewById(R.id.btnMoon);
        toEarth = (Button) root.findViewById(R.id.btnEarth);
        contactUs = (Button) root.findViewById(R.id.btnContactUs);
        rateUs = (Button) root.findViewById(R.id.btnRateUs);
//        ToMoon.setOnClickListener(v -> {
//
//            System.out.println("///////////////// To Firebase");
//            FirebaseDatabase database = FirebaseDatabase.getInstance();
//            /////////////////////////////////////////////////////////////////
//            System.out.println("///////////////// To database" + database);
//            /////////////////////////////////////////////////////////////////
//            DatabaseReference myRef = database.getReference("Peter");
//            System.out.println("///////////////// To myRef" + myRef);
//////        /////////////////////////////////////////////////////////////
//            myRef.setValue("He32132132131321321321352");
//
//
//        });

        /// Testing

        // Write a message to the database

//        prepareFirebase();

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

    private void prepareFirebase() {
//        // Write a message to the database
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("WhatsNew");
//
//        // Read from the database
//        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                String value = dataSnapshot.getValue(String.class);
//                System.out.println("/////////////////////////// VALUE" + value);
////                txtWelcomeList.setText(value);
//                Log.d(TAG, "Value is: " + value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });

//        FirebaseDatabase database2 = FirebaseDatabase.getInstance();
//        DatabaseReference myRef2 = database2.getReference("WhatsNew/0/");
//        myRef2.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
////                System.out.println(arrayList);
////                for (DataSnapshot datas : dataSnapshot.getChildren()) {
////                    String a = (String) dataSnapshot.getValue();
//////                    arrayList.add(datas.getValue(String.class));
//////                    arrayList.add(a);
////                    System.out.println("///////////////////////////" + a);
////                }
////                List<String> arrayList = new ArrayList<String>();
////                arrayList.add("ANDROID");
////                arrayList.add("C Language");
////                arrayList.add("CPP Language");
////                arrayList.add("Go Language");
////                arrayList.add("AVN SYSTEMS");
////
////                //        lvWhatsNew.set("*\tNew Accurate 3D Models\n" +
//////                "\t\t->\t The Moon\n" +
//////                "\t\t->\t The Earth\n" +
//////                "*\tText-to-Speech implementation\n" +
//////                "*\tExciting new Library of facts\n" +
//////                "*\tVideos\n" +
//////                "*\tDifferent Languages\n");
////
////                System.out.println("///////////////////////////" + arrayList);
//
////                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, arrayList);
////
////                lvWhatsNew.setAdapter(arrayAdapter);
////                System.out.println(arrayList);
//
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("WhatsNew");
//
//        // Read from the database
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    String num=snapshot.child("0").getValue().toString();
////                    String twos=snapshot.child("2").getValue().toString();
////                    String threes=snapshot.child("3").getValue().toString();
////                    String four=snapshot.child("4").getValue().toString();
//                    System.out.println("/////////////////////// "+ num);
////                    System.out.println("/////////////////////// "+ twos);
////                    System.out.println("/////////////////////// "+ threes);
////                    System.out.println("/////////////////////// "+ four);
//                    //so on
//                }
////                for(int i =0; i<7; i++)
////                {
////
////
////                }
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });

    }


}