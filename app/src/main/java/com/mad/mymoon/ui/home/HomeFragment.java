package com.mad.mymoon.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mad.mymoon.R;

import static android.content.ContentValues.TAG;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    TextView txtWhatsNew;
    TextView txtWelcomeList;
    Button ToMoon;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        // Display Whats new in TextView List
        txtWelcomeList = (TextView) root.findViewById(R.id.txtListWelcome);
        txtWhatsNew = (TextView) root.findViewById(R.id.txtListWhatsNew);
        ToMoon= (Button) root.findViewById(R.id.btnMoon);
        ToMoon.setOnClickListener(v -> {

            System.out.println("///////////////// To Firebase");
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            /////////////////////////////////////////////////////////////////
            System.out.println("///////////////// To database" + database);
            /////////////////////////////////////////////////////////////////
            DatabaseReference myRef = database.getReference("Peter");
            System.out.println("///////////////// To myRef" + myRef);
////        /////////////////////////////////////////////////////////////
            myRef.setValue("He32132132131321321321352");


        });


        FirebaseDatabase database2 = FirebaseDatabase.getInstance();
        DatabaseReference myRef2 = database2.getReference("NewUpdate");

        // Read from the database
        myRef2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                System.out.println("///////////////////////////" + value);
                txtWelcomeList.setText(value);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

//        txtWelcomeList.setText("Welcome to MyMoon! \n" +
//                "Thank you for downloading this application! \n\n " +
//                "If you were ever curious or wanted to learn about our friend the Moon, here is the perfect place to do it. \n" +
//                "Here you will be able to learn and interact with 3D models of both the Moon and the Earth.\n \n" +
//                "Please feel free to rate the application and give any feedback for any future improvements.");

        txtWhatsNew.setText("*\tNew Accurate 3D Models\n" +
                "\t\t->\t The Moon\n" +
                "\t\t->\t The Earth\n" +
                "*\tText-to-Speech implementation\n" +
                "*\tExciting new Library of facts\n" +
                "*\tVideos\n" +
                "*\tDifferent Languages\n");

//        prepareFirebase();

        return root;
    }

    private void prepareFirebase() {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Peyer");

        myRef.setValue("Hello, World!");
    }


}