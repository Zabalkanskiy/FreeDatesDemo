package com.demo.dates.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.fragment.app.Fragment
import com.demo.dates.R

const val THIRDSETTINGSCREENFRAGMENT = "THIRDSETTINGSCREENFRAGMENT"

class SecondSettingScreenFragment: Fragment() {

    lateinit var nextButton : ImageButton
    lateinit var femaleButton: Button
    lateinit var maleButton: Button
    lateinit var bothButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gray_second_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        femaleButton = view.findViewById(R.id.four_screen_camera_button)
        maleButton = view.findViewById(R.id.four_screen_facebook_button)
        bothButton = view.findViewById(R.id.four_screen_instagram)
        nextButton = view.findViewById(R.id.four_screen_right_arrow)


        femaleButton.setOnClickListener {
            femaleButton.background = getDrawable(requireContext(),R.drawable.button_left_shape_fill)
            maleButton.background = getDrawable(requireContext(),R.drawable.button_mid_shape_out)
            bothButton.background =  getDrawable(requireContext(),R.drawable.button_rigth_shape_out)
        }

        maleButton.setOnClickListener {
            femaleButton.background = getDrawable(requireContext(),R.drawable.button_left_shape_out)
            maleButton.background  =getDrawable(requireContext(),R.drawable.button_mid_shape_fill)

            bothButton.background = getDrawable(requireContext(),R.drawable.button_rigth_shape_out)

        }

        bothButton.setOnClickListener {
            femaleButton.background = getDrawable(requireContext(),R.drawable.button_left_shape_out)

            maleButton.background = getDrawable(requireContext(),R.drawable.button_mid_shape_out)

            bothButton.background = getDrawable(requireContext(),R.drawable.button_rigth_shape_fill)

        }

        nextButton.setOnClickListener {
          parentFragmentManager.beginTransaction().replace(R.id.main_activity_fragment_container, ThirdSettingScreenFragment.newInstance(), THIRDSETTINGSCREENFRAGMENT)
              .addToBackStack(THIRDSETTINGSCREENFRAGMENT)
              .commit()
        }
    }

    companion object {
        fun newInstance(): SecondSettingScreenFragment = SecondSettingScreenFragment()
    }
}