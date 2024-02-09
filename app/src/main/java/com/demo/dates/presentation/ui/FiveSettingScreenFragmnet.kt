package com.demo.dates.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.demo.dates.R

class FiveSettingScreenFragmnet : Fragment() {

    lateinit var facebookButton: ImageButton
    lateinit var instagrammButton: ImageButton
    lateinit var cameraButton: ImageButton
    lateinit var nextButton: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_grey_five_screen,container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        facebookButton  = view.findViewById(R.id.four_screen_facebook_button)
        instagrammButton = view.findViewById(R.id.four_screen_instagram)
        cameraButton = view.findViewById(R.id.four_screen_camera_button)

        nextButton = view.findViewById(R.id.four_screen_right_arrow)

        facebookButton.setOnClickListener {


        }

        instagrammButton.setOnClickListener {


        }

        cameraButton.setOnClickListener {


        }

        nextButton.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.main_activity_fragment_container, LastPageFragment.newInstance(), LASTPAGEFRAGMENT)
                .addToBackStack(LASTPAGEFRAGMENT)
                .commit()
        }
    }

    companion object {
        fun newInstance(): FiveSettingScreenFragmnet = FiveSettingScreenFragmnet()
    }
}