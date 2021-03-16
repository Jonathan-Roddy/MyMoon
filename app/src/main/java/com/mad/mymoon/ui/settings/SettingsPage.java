package com.mad.mymoon.ui.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.mad.mymoon.CustomAdapter;
import com.mad.mymoon.Dashboard;
import com.mad.mymoon.R;

public class SettingsPage extends Fragment implements View.OnCreateContextMenuListener {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    ListView settingsList;
    Button back2;

    private static final String BACK_STACK_ROOT_TAG = "root_fragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        View root = inflater.inflate(R.layout.fragment_settings, container, false);

        settingsList = (ListView) root.findViewById(R.id.lvSettings);

        String setList[] = {"Langauge", "Contact Us", "About"};

//        ArrayAdapter<String> arrayAdapter123 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, setList);
//        settingsList.setAdapter(arrayAdapter123);

        ////////////////////////////////////////////////////////////////////
        CustomAdapter customAdapter = new CustomAdapter(getActivity(), setList);
        settingsList.setAdapter(customAdapter);


        settingsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Integer selectedItem = (Integer) parent.getItemAtPosition(position);

//                if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
//
//                    //( "stackzeo");
//                } else {
//                    getSupportFragmentManager().popBackStack();
//                    removeCurrentFragment();
//                    //("stacknotzeo");
//                }



                switch (selectedItem){
                    case 0:
                        language lang= new language();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, lang, "languageFragment")
                                .addToBackStack(null)
                                .commit();
                        break;
                    case 1:
                        contactus credfrag= new contactus();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, credfrag, "creditsFragment")
                                .addToBackStack(null)
                                .commit();
                        break;
                    case 2:
                        aboutUs aboutUsFragment= new aboutUs();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, aboutUsFragment, "aboutUsFragment")
                                .addToBackStack(null)
                                .commit();
                        break;
                    default:
                        break;
                }

                System.out.println("/////////" + selectedItem);
            }
        });
//
//        View v = inflater.inflate(R.layout.xyz, container, false);
        //Back pressed Logic for fragment
        ////////////////////////////////////////////////////////////////////
        root.setFocusableInTouchMode(true);
        root.requestFocus();
        root.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK) {

                        return true;
                    }
                }
                return false;
            }
        });

        ////////////////////////////////////////////////////////////////////
        back2 = (Button) root.findViewById(R.id.button2);

        back2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i=new Intent(getActivity(), Dashboard.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
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
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        menu.clear();
        //inflater.inflate(R.menu.fragment_menu,menu);
    }




}
