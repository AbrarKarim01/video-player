package com.example.video_player

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.video_player.databinding.ActivityMainBinding
import android.net.Uri // access to file path (particular file) reference to the file in you application folder (resources; displaying a video file in application)
import android.net.Uri.*
import android.widget.MediaController //access the playback controls of media player (PlaybackControls: play,pause,backward and forward control)
import android.widget.VideoView //renders the video files


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Find the VideoView Class by it's id

        val videoView = findViewById<VideoView>(binding.testView.id) // making a reference to the testView in xml (android:id="@+id/testView");
        // Variable using videoView = viewGroup (findViewById), have testView property (findViewById<VideoView>); retrieving and storing in the temporary variable (testView)

        // Creating MediaController

        val mediaController = MediaController(this)
        // Variable using mediaController to create instance of MediaController
        mediaController.setAnchorView(videoView) // making reference to the location of the file
        //

        // specify the location of media file

        val uri:Uri = parse(
            "android.resource://$packageName/raw/test"
        )

     // setting MediaController and URi, then starting the videoView

        videoView.setMediaController(mediaController) // videoView have control the mediaController; the controller is specifically for the video view
        videoView.setVideoURI(uri) // Set the location of the video I want to play; variable uri, type Uri and value parse("android.location://"packageName/new_AndroidResource Directory/fileName)
        videoView.requestFocus() // function to reference to start the video immediately and then focus on the controller that is start()
        videoView.start() // starting on opening
    }
}