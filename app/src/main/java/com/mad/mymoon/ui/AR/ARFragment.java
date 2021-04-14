package com.mad.mymoon.ui.AR;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.mad.mymoon.R;

public class ARFragment extends Fragment {

    private ARViewModel ARViewModel;

    // Variables
    Button btnDemo,ARMoon, ARMoon2, AREarth;

    TextView tvInfoAR,tvInfoImport, tvMoonAR,tvEarthAR, tvMoon2AR;
    // Below edittext and button are all exist in the popup dialog view.
    private View popupInputDialogView = null;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ARViewModel = new ViewModelProvider(this).get(ARViewModel.class);
        View root = inflater.inflate(R.layout.fragment_ar, container, false);


        tvInfoAR = (TextView)root.findViewById(R.id.tvInfoAR);
        tvInfoAR.setText("Here you will be able to see a 3D Model of our Moon and the Earth");

        tvInfoImport = (TextView)root.findViewById(R.id.tvInfoImport);
        tvInfoImport.setText("It is important that your device is connected to the Wifi or has Data enabled to be able to download the recently model I have online.");



        btnDemo = (Button)root.findViewById(R.id.btnDemo);
        btnDemo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Create a AlertDialog Builder.
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                // Set title, icon, can not cancel properties.
                alertDialogBuilder.setCancelable(true);

                // Init popup dialog view and it's ui controls.
                initPopupViewControls();

                // Set the inflated layout view object to the AlertDialog builder.
                alertDialogBuilder.setView(popupInputDialogView);

                // Create AlertDialog and show.
                final AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

                // Set the inflated layout view object to the AlertDialog builder.
                alertDialogBuilder.setView(popupInputDialogView);

            }
        });


        tvMoonAR = (TextView)root.findViewById(R.id.tvMoonAR);
        tvMoonAR.setText("Have the ability to place a realistic 3D model of the Moon on any flat service. " +
                "\nSimple place the model on a floor and enjoy\n");
        // Button to call the AR Scene for the Moon
        ARMoon = (Button)root.findViewById(R.id.btnARMoon);
        ARMoon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AugmentedMoon.class);
                startActivity(intent);
            }
        });

        tvMoon2AR = (TextView)root.findViewById(R.id.tvMoon2AR);
        tvMoon2AR.setText("See the Moon now without any flags in your way.");
        // Button to call the AR Scene for the Portal
        ARMoon2 = (Button)root.findViewById(R.id.btnARMoon2);
        ARMoon2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AugmentedMoon_NoFlags.class);
                startActivity(intent);
            }
        });

        tvEarthAR = (TextView)root.findViewById(R.id.tvEarthAR);
        tvEarthAR.setText("Have a look at the Earth and see what places you recognise\n");
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

    /* Initialize popup dialog view and ui controls in the popup dialog. */
    private void initPopupViewControls()
    {
        // Get layout inflater object.
        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

        // Inflate the popup dialog from a layout xml file.
        popupInputDialogView = layoutInflater.inflate(R.layout.fragment_ar_info, null);

//        // Get user input edittext and button ui controls in the popup dialog.
//        userNameEditText = (EditText) popupInputDialogView.findViewById(R.id.userName);
//        passwordEditText = (EditText) popupInputDialogView.findViewById(R.id.password);
//        emailEditText = (EditText) popupInputDialogView.findViewById(R.id.email);
//        saveUserDataButton = popupInputDialogView.findViewById(R.id.button_save_user_data);
//        cancelUserDataButton = popupInputDialogView.findViewById(R.id.button_cancel_user_data);
//
//        // Display values from the main activity list view in user input edittext.
//        initEditTextUserDataInPopupDialog();
    }

}