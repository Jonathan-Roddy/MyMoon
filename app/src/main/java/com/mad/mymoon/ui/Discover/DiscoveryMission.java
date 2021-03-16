package com.mad.mymoon.ui.Discover;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mad.mymoon.R;
import com.mad.mymoon.ui.Discover.Options.MissionAdapter;
import com.mad.mymoon.ui.Discover.Options.MissionModel;

import java.util.ArrayList;

public class DiscoveryMission extends AppCompatActivity implements View.OnCreateContextMenuListener {


    private RecyclerView missionRV;
    Button idBTNVoice;
    private TextToSpeech textToSpeech;
    String dataFromAdapter;

    // Arraylist for storing data
    private ArrayList<MissionModel> missionModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_discover_mission);

        missionRV = findViewById(R.id.idRVMission);
        idBTNVoice = findViewById(R.id.idBTNVoice);

//        idBTNVoice.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View arg0) {
//                System.out.println("///////// Discovery : " + idBTNVoice.getText().toString());
//
//            }
//
//            @NotNull
//            private View.OnClickListener getOnClickListener() {
//                return this;
//            }
//        });

        createCardView();


    }

    private void createCardView() {

        // here we have created new array list and added data to it.
        missionModelArrayList = new ArrayList<>();
        missionModelArrayList.add(new MissionModel("The moon is 238,855 miles away from Earth. Even whizzing through space at super-high speed, it takes more than three days to get there."));
        missionModelArrayList.add(new MissionModel("Out in space, away from Earth, there is no gravity holding astronauts down, so they float around in their spaceships. Sometimes called zero-g."));
        missionModelArrayList.add(new MissionModel("The lunar module, Eagle, was so small that there was no room for seats. While Eagle dropped 60 miles to the moon’s surface, Neil Armstrong and Buzz Aldrin had to stand up."));
        missionModelArrayList.add(new MissionModel("The landing site that Apollo 11 crew had chosen was an area called the Sea of Tranquillity, which looked smooth and safe for landing. This isn’t a sea as we know it. It’s a lunar mare – a large plain formed long ago by a volcanic eruption."));
        missionModelArrayList.add(new MissionModel("When Neil Armstrong landed the lunar module, there were only 30 seconds of fuel left. "));
        missionModelArrayList.add(new MissionModel("Neil Armstrong was supposed to say ‘That’s one small step for a man’, but he forgot to say ‘a’. Instead, he said the now-famous words, ‘One small step for man, one giant leap for mankind’."));
        missionModelArrayList.add(new MissionModel("Gravity on the moon is only one-sixth as strong as gravity on Earth. If you jumped on the moon, you’d go six times higher."));
        missionModelArrayList.add(new MissionModel("While Neil Armstrong may have been the first man to set foot on the moon, Buzz Aldrin was the first man to go to the toilet there, using a special tube in his spacesuit!"));
        missionModelArrayList.add(new MissionModel("An amazing woman called Katherine Johnson carried out the calculations that made the mission to the moon possible and got the astronauts home again. Katherine’s incredible achievement made it possible for other women and people of colour to follow in her footsteps, breaking down barriers of race and gender."));
        missionModelArrayList.add(new MissionModel("While he was still working for NASA after returning from the moon, Neil Armstrong helped invent computer navigation technology called ‘fly-by-wire’, which is still used in spacecraft and aeroplanes today."));
        missionModelArrayList.add(new MissionModel("Neil Armstong carried a piece of wood and a piece of fabric from the Wright Brothers’ airplane with him when he went on the Apollo mission. He kept them in his PPK (personal preference kit). The Wright Brothers had the first record flight in 1903. The pieces that Armstrong took with him are in the Smithsonian Museum in Washington, D.C."));
        missionModelArrayList.add(new MissionModel("The Apollo 11 space mission was the single mission that everyone at NASA, the country, and in Washington, D.C. was counting on. This was the mission that would put the first human beings on the moon. However, if the mission had failed, President Nixon had a speech all prepared."));
        missionModelArrayList.add(new MissionModel("An “EVA” on a space mission is the “extravehicular activity,” and is the amount of time the astronauts spend outside of the probe. Both Armstrong and Aldrin had almost a full day of EVA to accomplish the many experiments that they had to perform and to place the various instruments."));
        missionModelArrayList.add(new MissionModel("During the first moon space missions, all astronauts were placed in quarantine for 21 days. This was a requirement because no one knew if there was any type of contamination that they might have been exposed to in space as well as being unsure if the surface of the moon was sterile or contained contaminants that could harm life on our planet."));
        missionModelArrayList.add(new MissionModel("During the lunar visits, astronauts left a number of things behind including pictures of human beings and audio recordings in several languages to represent the global importance of the mission. Other pictures of significance that were left included the three American astronauts that died in Apollo 1 and the two Russian cosmonauts that perished in an accident."));
        missionModelArrayList.add(new MissionModel("When the astronauts returned from the moon mission they had to declare the moon rocks and moon dust collected to customs authorities."));
        missionModelArrayList.add(new MissionModel("During the Apollo 11 mission to the moon, the site that was selected for landing wasn’t acceptable due to too many boulders. Neil Armstrong took manual control of the lander, skimming over the surface of the moon looking for a good spot. He finally found one and they had only 25 seconds of fuel to spare. Had Armstrong used more fuel than that, they wouldn’t have had enough to return home."));
        missionModelArrayList.add(new MissionModel("Due to rather poor communications, the exact phrase spoken by Neil Armstrong as he stepped onto the moon’s surface has been in debate. Armstrong indicated that he actually said “that’s one small step for “a” man, one giant leap for mankind.”  The quote that everyone knows doesn’t include the “a.”  Since that time, publications typically include the “a” in brackets."));
        missionModelArrayList.add(new MissionModel("The landing on the moon by the American astronauts was an event that was being broadcast all over the world. It’s estimated that 53 million families watched in the U.S. and it was viewed by around 600 million people globally."));
        missionModelArrayList.add(new MissionModel("Of the three astronauts that were sent to the moon for the first lunar mission, only two of the astronauts actually set foot on the surface of the moon. Michael Collins was the astronaut left in the module that was orbiting the moon."));
        missionModelArrayList.add(new MissionModel("The footprints left by the Apollo astronauts will probably remain visible for around 100 million years. The moon doesn’t have any atmosphere or weathering conditions that will wash or erode them away. Their footprints, spaceship prints, and the rover prints will remain. The only way that they might be affected is if they are disturbed by a meteorite. There are also micrometeorites that bombard the moon’s surface and, over time, they may cause an erosion."));

        // we are initializing our adapter class and passing our arraylist to it.
        MissionAdapter missionAdapter = new MissionAdapter(this, missionModelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        missionRV.setLayoutManager(linearLayoutManager);
        missionRV.setAdapter(missionAdapter);

    }
}