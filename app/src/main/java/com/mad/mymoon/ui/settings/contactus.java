package com.mad.mymoon.ui.settings;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.mad.mymoon.R;

public class contactus extends Fragment implements View.OnCreateContextMenuListener {
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    TextView tvEnterDetails;
    EditText etvContactName, etvSubject, etvmEmailBody;
    Button btnClear, btnSendEmail;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        View root = inflater.inflate(R.layout.fragment_contactus, container, false);

        tvEnterDetails = (TextView) root.findViewById(R.id.tvEnterDetails);

        etvContactName = (EditText) root.findViewById(R.id.etvContactName);
        etvSubject = (EditText) root.findViewById(R.id.etvSubject);
        etvmEmailBody = (EditText) root.findViewById(R.id.etvmEmailBody);


        btnClear = (Button) root.findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                etvContactName.setText("");
                etvSubject.setText("");
                etvmEmailBody.setText("");
            }
        });


        btnSendEmail = (Button) root.findViewById(R.id.btnSendEmail);
        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//
                System.out.println("/////////////////// " + etvContactName.getText().toString() + " " + etvSubject.getText().toString() + " " + etvmEmailBody.getText().toString());

                if (TextUtils.isEmpty(etvContactName.getText().toString()) && TextUtils.isEmpty(etvSubject.getText().toString()) && TextUtils.isEmpty(etvmEmailBody.getText().toString())) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                    builder.setMessage("Please enter some text")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                    Log.d("Dialog, clicked", "OK");
                                }
                            })
                            .show();
                }
                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage("Please confirm your email: "
                            + "\n Contact Name : " + etvContactName.getText().toString()
                            + "\n Your email : " + etvSubject.getText().toString()
                            + "\n Email body : " + etvmEmailBody.getText().toString())
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @SuppressLint("LongLogTag")
                                @Override
                                public void onClick(DialogInterface dialog, int id) {

                                    Log.i("Send email", "");
                                    String[] TO = {"mymoonjonathan@gmail.com"};
                                    String[] CC = {""};
                                    Intent emailIntent = new Intent(Intent.ACTION_SEND);

                                    emailIntent.setData(Uri.parse("mailto:"));
                                    emailIntent.setType("text/plain");
                                    emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                                    emailIntent.putExtra(Intent.EXTRA_CC, CC);
                                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, etvSubject.getText().toString());
                                    emailIntent.putExtra(Intent.EXTRA_TEXT,
                                            "Contact Name: " + etvContactName.getText().toString() +
                                                    "\n Email Body: "+ etvmEmailBody.getText().toString()

                                    );

                                    try {
                                        startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                                        getActivity().finish();
                                        Log.i("Finished sending email...", "");
                                    } catch (android.content.ActivityNotFoundException ex) {
                                        Toast.makeText(getActivity(), "There is no email client installed.", Toast.LENGTH_SHORT).show();
                                    }

                                    Log.d("Dialog, clicked", "OK");
                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                    Log.d("Dialog, clicked", "Cancel");
                                    dialog.cancel();
                                }
                            })
                            .show();
                }
            }

        });

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
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        //inflater.inflate(R.menu.fragment_menu,menu);
    }


}

