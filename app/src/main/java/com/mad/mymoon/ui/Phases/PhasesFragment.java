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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PhasesFragment extends Fragment {

    private PhasesViewModel phasesViewModel;

    // Variables
    Button chosenDate;
    static TextView todaysDate;
    static TextView todaysDate2;
    static TextView moonPhaseText;
    static Date Date = new Date();

    static int year;
    static int month;
    static int day;
    static int chosenDay;
    static int chosenMonth;
    static int chosenYear;
    static double newPercantage2;


    static List<String> moonPhase = new ArrayList<String>(){{
        add("New Moon");
        add("Waning Crescent");
        add("Last Quarter");
        add("Waning Gibbous");
        add("Full Moon");
        add("Waxing Gibbous");
        add("First Quarter");
        add("Waxing Crescent");
    }};
    static String test;

    private static double currentPercentage = 0.0;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        phasesViewModel = new ViewModelProvider(this).get(PhasesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_phases, container, false);


        // Display Today's Date
        todaysDate = (TextView) root.findViewById(R.id.txtTodaysDate);
        todaysDate2 = (TextView) root.findViewById(R.id.txtTodaysDate2);
        moonPhaseText = (TextView) root.findViewById(R.id.txtMoonPhase);

        todaysDate.setText("Choose a date");
        todaysDate2.setVisibility(View.INVISIBLE);
        moonPhaseText.setVisibility(View.INVISIBLE);

//        getTodaysDate();

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

    // Display Today's Date
//    private static void getTodaysDate() {
//        // Set percentage for tonights Moon
//        Date today = new Date();
//        year = today.getYear();
//        month = today.getMonth();
//        day = today.getDay();
//
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//        String formattedDate = formatter.format(Date);
//        todaysDate.setText("Date: " + formattedDate);
//    }
//
//    private static void updatetodaydate2() {
////        todaysDate2.setText("Percentage this night is : " + currentPercantage +"%");
//        System.out.println("/////////////// updatetodaydate2 " + currentPercentage);
//        newPercantage2 = currentPercentage;
//        todaysDate2.setText("Percentage this night is : " + newPercantage2 +"%");
//    }

    @Override
    public void onResume() {
        super.onResume();
    }


    // Update Percentage
    public static final void updatePercentageBasedOnDays(int day) {
        int days = 30;
        double p = (double)day * 100.0D / (double)days;
        currentPercentage = Math.rint(p);
    }

    // Calculate Algorithm for Lunar Phases
//    public static final void calculateBasedOnAlgorithmToday(int year, int month, int day) {
////        int days = 0;
////        days = Conway(year, month, day);
////        updatePercentageBasedOnDays(days);
////        updatetodaydate2();
////        setPhotoBasedOnPercentage();
//    }

    // Calculate Algorithm for Lunar Phases
    public static final void calculateBasedOnAlgorithm(int year, int month, int day) {
        int days = 0;
        days = Conway(year, month, day);
        updatePercentageBasedOnDays(days);
        System.out.println("/////////////// Chosen " + currentPercentage);

        currentPercentage+=currentPercentage;
        todaysDate2.setVisibility(View.VISIBLE);
        if(currentPercentage<=50)
            todaysDate2.setText("Percentage this night is : " + currentPercentage+"%");
        else {
            double test = currentPercentage -100;
            double a = 100-test;
            todaysDate2.setText("Percentage this night is : " + a +"%");
        }
//        updatetodaydate2();
//        setPhotoBasedOnPercentage();

        moonPhaseText.setVisibility(View.VISIBLE);
        switch((int) currentPercentage){
                // New Moon
            case 0: moonPhaseText.setText(moonPhase.get(0));
                break;

                // Waning Crescent
            case 3: moonPhaseText.setText(moonPhase.get(1));
                break;
            case 7: moonPhaseText.setText(moonPhase.get(1));
                break;
            case 10: moonPhaseText.setText(moonPhase.get(1));
                break;
            case 13: moonPhaseText.setText(moonPhase.get(1));
                break;
            case 17: moonPhaseText.setText(moonPhase.get(1));
                break;
            case 20: moonPhaseText.setText(moonPhase.get(1));
                break;

                // Last Quarter
            case 23: moonPhaseText.setText(moonPhase.get(2));
                break;
            case 27: moonPhaseText.setText(moonPhase.get(2));
                break;

                // Waning Gibbous
            case 30: moonPhaseText.setText(moonPhase.get(3));
                break;
            case 33: moonPhaseText.setText(moonPhase.get(3));
                break;
            case 37: moonPhaseText.setText(moonPhase.get(3));
                break;
            case 40: moonPhaseText.setText(moonPhase.get(3));
                break;
            case 43: moonPhaseText.setText(moonPhase.get(3));
                break;
            case 47: moonPhaseText.setText(moonPhase.get(3));
                break;

                // Full Moon
            case 50: moonPhaseText.setText(moonPhase.get(4));
                break;

                //Waxing Gibbous
            case 53: moonPhaseText.setText(moonPhase.get(5));
                break;
            case 57: moonPhaseText.setText(moonPhase.get(5));
                break;
            case 60: moonPhaseText.setText(moonPhase.get(5));
                break;
            case 63: moonPhaseText.setText(moonPhase.get(5));
                break;
            case 67: moonPhaseText.setText(moonPhase.get(5));
                break;
            case 70: moonPhaseText.setText(moonPhase.get(5));
                break;

                // First Quarter
            case 73: moonPhaseText.setText(moonPhase.get(6));
                break;
            case 77: moonPhaseText.setText(moonPhase.get(6));
                break;

                //Waxing Crescent
            case 80: moonPhaseText.setText(moonPhase.get(7));
                break;
            case 83: moonPhaseText.setText(moonPhase.get(7));
                break;
            case 87: moonPhaseText.setText(moonPhase.get(7));
                break;
            case 90: moonPhaseText.setText(moonPhase.get(7));
                break;
            case 93: moonPhaseText.setText(moonPhase.get(7));
                break;
            case 97: moonPhaseText.setText(moonPhase.get(7));
                break;
        }

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

        r = ((r * (double)11) % (double)30) + (double)month + (double)day;
        if (month < 3) {
            r += (double)2;
        }

        if (year < 2000) {
            r -= (double)4;
        } else {
            r -= 8.3D;
        }

        double var6 = r + 0.5;
        boolean var8 = false;
        r = Math.floor(var6) % (double)30;
        return r < (double)0 ? (int)(r + (double)30) : (int)r;

//        var r = year % 100;
//        r %= 19;
//        if (r>9){ r -= 19;}
//        r = ((r * 11) % 30) + parseInt(month) + parseInt(day);
//        if (month<3){r += 2;}
//        r -= ((year<2000) ? 4 : 8.3);
//        r = Math.floor(r+0.5)%30;
//        return (r < 0) ? r+30 : r;
    }

    public static void getDates(int dayOfMonth, int month, int year) {
        chosenDay = dayOfMonth;
        chosenMonth = month;
        chosenYear = year;
        System.out.println("//////////////// getDates  " + chosenDay + chosenMonth + chosenYear);
        calculateBasedOnAlgorithm(chosenYear, chosenMonth, chosenDay);
    }

//    public final void setPhotoBasedOnPercentage() {
//        String[] files = (String[])null;
//        String bestPhotoPath = "";
//        double distance = 9999.0D;
//        String choiceHemi = "";
////        if (Intrinsics.areEqual(this.currentHemisphere, this.NORTH_BUTTON)) {
////            files = this.getAssets().list("north");
////            choiceHemi = "north";
////        } else if (Intrinsics.areEqual(this.currentHemisphere, this.SOUTH_BUTTON)) {
////            files = this.getAssets().list("south");
////            choiceHemi = "south";
////        }
//        files = this.getAssets().list("north");
//        choiceHemi = "north";
//
//        if (files != null) {
//            String[] var8 = files;
//            int var9 = files.length;
//
//            for(int var7 = 0; var7 < var9; ++var7) {
//                String i = var8[var7];
//                double dist = 9999.0D;
//                Regex regex;
//                String var13;
//                boolean var14;
//                String var16;
//                boolean var17;
//                MatchResult match;
//                double photoValue;
//                if (this.currentPercantage <= 50.0D) {
//                    if (i.charAt(i.length() - 5) == '_') {
//                        continue;
//                    }
//
//                    var13 = "[0-9]+_?[0-9]*";
//                    var14 = false;
//                    regex = new Regex(var13);
//                    match = regex.find((CharSequence)i, 0);
//                    if (match == null) {
//                        Intrinsics.throwNpe();
//                    }
//
//                    var16 = StringsKt.replace$default(match.getValue(), "_", ".", false, 4, (Object)null);
//                    var17 = false;
//                    photoValue = Double.parseDouble(var16);
//                    dist = Math.abs(this.currentPercantage - photoValue / (double)2);
//                } else {
//                    if (i.charAt(i.length() - 5) != '_') {
//                        continue;
//                    }
//
//                    var13 = "[0-9]+_?[0-9]*_";
//                    var14 = false;
//                    regex = new Regex(var13);
//                    match = regex.find((CharSequence)i, 0);
//                    if (match == null) {
//                        Intrinsics.throwNpe();
//                    }
//
//                    var16 = StringsKt.replace$default(StringsKt.dropLast(match.getValue(), 1), "_", ".", false, 4, (Object)null);
//                    var17 = false;
//                    photoValue = Double.parseDouble(var16);
//                    dist = Math.abs(this.currentPercantage - ((double)100 - photoValue));
//                }
//
//                if (dist < distance) {
//                    distance = dist;
//                    bestPhotoPath = i;
//                    Log.i("distancePath", dist + " " + i);
//                }
//            }
//
//            InputStream var10000 = this.getAssets().open(choiceHemi + File.separator + bestPhotoPath);
//            Intrinsics.checkExpressionValueIsNotNull(var10000, "assets.open(choiceHemi +…eparator + bestPhotoPath)");
//            InputStream inputStream = var10000;
//            Bitmap var22 = BitmapFactory.decodeStream(inputStream);
//            Intrinsics.checkExpressionValueIsNotNull(var22, "BitmapFactory.decodeStream(inputStream)");
//            Bitmap bitMap = var22;
//            ((ImageView)this._$_findCachedViewById(id.moonImageView)).setImageBitmap(bitMap);
//        }
//
//    }
}