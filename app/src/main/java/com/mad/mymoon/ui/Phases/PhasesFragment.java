package com.mad.mymoon.ui.Phases;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.mad.mymoon.DatePickerFragment;
import com.mad.mymoon.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PhasesFragment extends Fragment {

    private PhasesViewModel phasesViewModel;

    // Variables
    Button chosenDate;
    TextView todaysDate;
    static TextView todaysDate2;
    Date Date = new Date();

    static int chosenDay;
    static int chosenMonth;
    static int chosenYear;

    String test;

    private static double currentPercantage;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        phasesViewModel = new ViewModelProvider(this).get(PhasesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_phases, container, false);


        // Display Today's Date
        todaysDate = (TextView) root.findViewById(R.id.txtTodaysDate);
        getTodaysDate();

        todaysDate2 = (TextView) root.findViewById(R.id.txtTodaysDate2);
        todaysDate2.setText("Percentage this night is : " + currentPercantage +"%");

        // Button to get chosen date
        chosenDate = (Button) root.findViewById(R.id.btnDate);
        chosenDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getParentFragmentManager() , "date picker");

            }

        });

        return root;
    }

    private static void updatetodaydate2() {
//        todaysDate2.setText("Percentage this night is : " + currentPercantage +"%");
        System.out.println("/////////////// updatetodaydate2 " + currentPercantage);
        double newPercantage = currentPercantage;
        todaysDate2.setText("Percentage this night is : " + newPercantage +"%");
    }


    @Override
    public void onResume() {
        super.onResume();
    }


    // Display Today's Date
    private void getTodaysDate() {
        // Set percentage for tonights Moon
        Date today = new Date();
        int year, month, day;
        year = today.getYear();
        month = today.getMonth();
        day = today.getDay();
        calculateBasedOnAlgorithm(year, month, day);

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = formatter.format(Date);
        todaysDate.setText("Date: " + formattedDate);
    }

    // Calculate Algorithm for Lunar Phases
    public static final void calculateBasedOnAlgorithm(int year, int month, int day) {
        int days = 0;
        days = Conway(year, month, day);
        updatePercentageBasedOnDays(days);
        System.out.println("/////////////// " + currentPercantage);
        updatetodaydate2();
    }


    // John Horton Conways algorithm to find lunar phases

    // In the 20th century, calculate the remainder upon dividing the
    // last two digits of the year by 19; if greater than 9, subtract
    // 19 from this to get a number between -9 and 9.
    //
    // Multiply the result by 11 and reduce modulo 30 to obtain a
    // number between -29 and +29.
    //
    // Add the day of the month and the number of the month (except
    // for Jan and Feb use 3 and 4 for the month number instead of 1 and 2).
    //
    // Subtract 4.
    //
    // Reduce modulo 30 to get a number between 0 and 29. This is
    // the age of the Moon.
    //
    //Example: What was the phase of the Moon on D-Day (June 6, 1944)?
    //
    // Answer: 44/19=2 remainder 6.
    //
    // 6*11=66, reduce modulo 30 to get 6.
    //
    // Add 6+6 to this and subtract 4: 6+6+6-4=14; the Moon was (nearly)
    // full. I understand that the planners of D-day did care about the phase
    // of the Moon, either because of illumination or because of tides. I
    // think that Don Olsen recently discussed this in _Sky and Telescope_
    // (within the past several years).
    //
    // In the 21st century use -8.3 days instead of -4 for the last number.
    //
    // Conway also gives refinements for the leap year cycle and also
    // for the slight variations in the lengths of months; what I have
    // given should be good to +/- a day or so.
    public static final int Conway(int year, int month, int day) {
        double r = (double)(year % 100);
        r %= (double)19;
        if (r > (double)9) {
            r -= (double)19;
        }

        r = r * (double)11 % (double)30 + (double)month + (double)day;
        if (month < 3) {
            r += (double)2;
        }

        if (year < 2000) {
            r -= (double)4;
        } else {
            r -= 8.3D;
        }

        double var6 = r + 0.5D;
        boolean var8 = false;
        r = Math.floor(var6) % (double)30;
        return r < (double)0 ? (int)(r + (double)30) : (int)r;
    }

    // Update Percentage
    public static final void updatePercentageBasedOnDays(int day) {
        int days = 30;
        double p = (double)day * 100.0D / (double)days;
        boolean var5 = false;
        currentPercantage = Math.rint(p);
    }


    public static void getDates(int dayOfMonth, int month, int year) {
        chosenDay = dayOfMonth;
        chosenMonth = month;
        chosenYear = year;
        System.out.println("//////////////// SUPERMASSIVE " + chosenDay + chosenMonth + chosenYear);
        calculateBasedOnAlgorithm(chosenYear, chosenMonth, chosenDay);
    }
}