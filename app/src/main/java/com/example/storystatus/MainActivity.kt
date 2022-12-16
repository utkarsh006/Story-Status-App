package com.example.storystatus

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import omari.hamza.storyview.StoryView
import omari.hamza.storyview.callback.StoryClickListeners
import omari.hamza.storyview.model.MyStory
import java.text.SimpleDateFormat


class MainActivity : AppCompatActivity() {

    lateinit var btn_story : Button
    var listStories : ArrayList<MyStory> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialise the button created in xml file
        btn_story = findViewById(R.id.button2)
        btn_story.setOnClickListener{
            //adding stories to the list which we wanna show
            val currStory1 = MyStory(
                "https://www.pinkvilla.com/files/styles/amp_metadata_content_image/public/raftaar_2.jpg",
                 SimpleDateFormat("dd/mm/yyyy").parse("16/12/2022"),
            "RAFTAAR"
            )

            val currStory2  = MyStory(
                "https://images.indulgexpress.com/uploads/user/imagelibrary/2022/12/12/original/RapperKING.png",
                SimpleDateFormat("dd/mm/yyyy").parse("16/12/2022"),
                "KING"
            )

            val currStory3  = MyStory(
                "https://i.scdn.co/image/ab6761610000e5ebd005ab4b5b3eb67b48ed82a6",
                SimpleDateFormat("dd/mm/yyyy").parse("16/12/2022"),
                "BADSHAH"
            )

            val currStory4 = MyStory(
                "https://c.saavncdn.com/artists/M_Zee_Bella_000_20220311034527_500x500.jpg",
                SimpleDateFormat("dd/mm/yyyy").parse("16/12/2022"),
                "BELLA"
            )

            val currStory5 = MyStory(
                "https://i.scdn.co/image/ab6761610000e5eb276369b9195d6f67470fd51a",
                SimpleDateFormat("dd/mm/yyyy").parse("16/12/2022"),
                "TALHA ANJUM"
            )

            listStories.add(currStory1)
            listStories.add(currStory2)
            listStories.add(currStory3)
            listStories.add(currStory4)
            listStories.add(currStory5)

            //build stories

            StoryView.Builder(supportFragmentManager)
                .setStoriesList(listStories) // Required
                .setStoryDuration(3000) // Default is 2000 Millis (2 Seconds)
                .setTitleText("Utkarsh Saxena") // Default is Hidden
                .setSubtitleText("STAR THE REPO OF THIS PROJECT") // Default is Hidden
                .setTitleLogoUrl("https://img.freepik.com/premium-vector/hand-holding-hiphop-microphone_56972-295.jpg?w=2000") // Default is Hidden
                .setStoryClickListeners(object : StoryClickListeners {
                    override fun onDescriptionClickListener(position: Int) {
                        //your action
                    }

                    override fun onTitleIconClickListener(position: Int) {
                        //your action
                    }
                }) // Optional Listeners
                .build() // Must be called before calling show method
                .show()

        }
    }
}