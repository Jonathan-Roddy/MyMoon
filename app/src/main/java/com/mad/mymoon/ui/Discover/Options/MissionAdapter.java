package com.mad.mymoon.ui.Discover.Options;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mad.mymoon.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Locale;

public class MissionAdapter extends RecyclerView.Adapter<MissionAdapter.Viewholder> {

    private Context context;
    private ArrayList<MissionModel> missionModelArrayList;

    // Constructor
    public MissionAdapter(Context context, ArrayList<MissionModel> factModelArrayList) {
        this.context = context;
        this.missionModelArrayList = factModelArrayList;
    }

    @NonNull
    @Override
    public MissionAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.discover_layout, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MissionAdapter.Viewholder holder, int position) {
        // to set data to textview and imageview of each card layout
        MissionModel model = missionModelArrayList.get(position);
        holder.factNameTV.setText(model.getFact());
//        holder.voiceBtn.setBackground(Drawable.createFromPath("@drawable/ic_newgame"));
    }

    @Override
    public int getItemCount() {
        // this method is used for showing number
        // of card items in recycler view.
        return missionModelArrayList.size();
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public class Viewholder extends RecyclerView.ViewHolder {

        private TextView factNameTV;
        private Button voiceBtn;
        private TextToSpeech textToSpeech;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            factNameTV = itemView.findViewById(R.id.idFactName);
            voiceBtn = itemView.findViewById(R.id.idBTNVoice);

            textToSpeech = new TextToSpeech(context.getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    if (status == TextToSpeech.SUCCESS) {
                        int ttsLang = textToSpeech.setLanguage(Locale.UK);

                        if (ttsLang == TextToSpeech.LANG_MISSING_DATA
                                || ttsLang == TextToSpeech.LANG_NOT_SUPPORTED) {
                            Log.e("TTS", "The Language is not supported!");
                        } else {
                            Log.i("TTS", "Language Supported.");
                        }
                        Log.i("TTS", "Initialization success.");
                    } else {
//                        Toast.makeText(context.getApplicationContext(), "TTS Initialization failed!", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            voiceBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    System.out.println("///// Inside Adapter - " + factNameTV.getText().toString());

                    String data = factNameTV.getText().toString();
                    Log.i("TTS", "button clicked: " + data);
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);

                    if (speechStatus == TextToSpeech.ERROR) {
                        Log.e("TTS", "Error in converting Text to Speech!");
                    }

                }

                @NotNull
                private View.OnClickListener getOnClickListener() {
                    return this;
                }
            });



        }
    }
}
