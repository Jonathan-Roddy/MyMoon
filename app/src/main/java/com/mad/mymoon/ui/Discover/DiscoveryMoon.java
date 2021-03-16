package com.mad.mymoon.ui.Discover;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mad.mymoon.ui.Discover.Options.FactAdapter;
import com.mad.mymoon.ui.Discover.Options.FactModel;
import com.mad.mymoon.R;

import java.util.ArrayList;

public class DiscoveryMoon extends AppCompatActivity implements View.OnCreateContextMenuListener {

    private RecyclerView factRV;
    Button idBTNVoice;
    private TextToSpeech textToSpeech;
    String dataFromAdapter;

    // Arraylist for storing data
    private ArrayList<FactModel> factModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_discover_moon);

        factRV = findViewById(R.id.idRVFact);
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
        factModelArrayList = new ArrayList<>();
        factModelArrayList.add(new FactModel("Most of the people think that the Moon is round in shape, but it’s not.  The Moon is shaped like an egg."));
        factModelArrayList.add(new FactModel("The Moon is approximately 238, 750 miles (384, 400 kilometers) from earth.  The distance changes depending on the position of the Moon, whether it is at its apogee(far away) or perigee(nearby).  At apogee distance is 363, 295 km and at perigee it is  405, 503 km."));
        factModelArrayList.add(new FactModel("According to scientists, the Moon was formed as a result of a giant impact or giant whack of Earth with mars sized planet, which resulted in the Moon."));
        factModelArrayList.add(new FactModel("The Moon’s size varies depends upon its position, whether it is at perigee or apogee.  Generally the Moon is 14% bigger in its size, when it is at its perigee."));
        factModelArrayList.add(new FactModel("The Moon can influence Earth by gravity.  When the Moon is at its perigee, the weather and tides tend to be unstable  and create larger tides due to gravitational pull and when the Moon is at its apogee, the weather and tides tend to be more predictable."));
        factModelArrayList.add(new FactModel("The Moon’s core is light,  it’s core is 2-4% of its mass, whereas Earth’s core is about 30% of its mass."));
        factModelArrayList.add(new FactModel("Temperatures on the Moon vary drastically, as there is no atmosphere on the Moon.  The temperature ranges from temperatures -200°F to more than 200 °F."));
        factModelArrayList.add(new FactModel("Scientists believe that, Moon quakes  originate below the Moon’s surface due to the Earth’s gravitational pull."));
        factModelArrayList.add(new FactModel("2, 159 miles (3, 475 km) is the diameter of the Moon, which is roughly four times smaller than Earth."));
        factModelArrayList.add(new FactModel("Do you know that Earth’s rotation has slowed down due to the Moon’s gravity, long ago –  days were much shorter and rotation was faster."));
        factModelArrayList.add(new FactModel("850 pounds (385 kg) of the Moon were  taken by six Apollo crews that came back to Earth."));
        factModelArrayList.add(new FactModel("From Earth, both the Sun and the Moon look about same size, this is because, the Moon is 400 times smaller than the Sun, but also 400 times closer to Earth."));
        factModelArrayList.add(new FactModel("The Moon’s entire surface is covered with a layer of crushed and powdered rocks called regolith, which is due to the bombardment in space of many tiny micrometeorites."));
        factModelArrayList.add(new FactModel("An astronaut’s footprint could last for millions of years, as there is no wind or water on the surface of the Moon."));
        factModelArrayList.add(new FactModel("A lunar eclipse, lasts longer than a solar eclipse because Earth’s shadow is so much longer.  In lunar eclipse, earth passes between Sun and the Moon."));
        factModelArrayList.add(new FactModel("A full day on the Moon, lasts about 29 Earth days on an average, from one sunrise to next."));
        factModelArrayList.add(new FactModel("From the Moon, Earth never moves across the Moon’s sky."));
        factModelArrayList.add(new FactModel("There is no twilight before nightfall, because on the Moon there is no atmosphere."));
        factModelArrayList.add(new FactModel("In ancient days,during solar eclipses, Chinese used to make as much noise as possible, as they thought that Sun was swallowed by enormous dragon and making such sounds would scare that dragon."));
        factModelArrayList.add(new FactModel("Thomas Harriot (c. 1560-1621), a British astronomer, was the first person who drew a map of the Moon as it appears thorough telescope."));
        factModelArrayList.add(new FactModel("The Moon is 81 times lighter than Earth."));
        factModelArrayList.add(new FactModel("About 5,000 years old, a map was carved into a rock in a prehistoric tomb at Knowth, County Meath, Ireland, which is the oldest known map of the Moon.  Before this, the oldest known lunar map was drawn by Leonardo da Vinci."));
        factModelArrayList.add(new FactModel("Soviet space probe Luna 2 was the first probe to reach the Moon, in 1959, which crash-landed on the Moon.  The first probe, missed the Moon by 3,000 miles, which is Luna 1."));
        factModelArrayList.add(new FactModel("The Soviet Luna 9 was the first soft landing probe on the lunar surface.  Earlier, astronomers were worried, that probes might sink into the lunar surface."));
        factModelArrayList.add(new FactModel("The Soviet robot Lunokhod 1, was the first vehicle to travel on the Moon, on November 17, 1970."));
        factModelArrayList.add(new FactModel("Neil Armstrong was the first person to set foot on the Moon on July 20, 1969.  Eugene Cernan was the last person to stand on moon’s surface in 1972."));
        factModelArrayList.add(new FactModel("27.3 Earth days is the length of the Moon’s orbit."));
        factModelArrayList.add(new FactModel("We can see only one side of the Moon, and believe that there is a dark side of the Moon.  But this is a myth because the Moon rotates around on its own axis in exactly the same time it takes to orbit the Earth."));
        factModelArrayList.add(new FactModel("The Moon has weaker gravitational force than earth, it has only one sixth of Earth’s gravitational force, that is why astronauts can jump so high."));
        factModelArrayList.add(new FactModel("12 people set their foot on the Moon, and the interesting part is all are American males."));

        // we are initializing our adapter class and passing our arraylist to it.
        FactAdapter factAdapter = new FactAdapter(this, factModelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        factRV.setLayoutManager(linearLayoutManager);
        factRV.setAdapter(factAdapter);

    }


}