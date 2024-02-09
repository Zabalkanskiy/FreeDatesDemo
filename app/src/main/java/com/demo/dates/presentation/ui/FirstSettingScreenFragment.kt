package com.demo.dates.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.fragment.app.Fragment
import com.demo.dates.R

const val SECONDSETTINGSCREENFRAGMENT = "SECONDSETTINGSCREENFRAGMENT"

class FirstSettingScreenFragment : Fragment() {
    lateinit var maleButton: Button
    lateinit var femaleButton: Button
    lateinit var nextButton: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       return inflater.inflate(R.layout.fragment_gray_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        maleButton = view.findViewById(R.id.four_screen_facebook_button)
        femaleButton = view.findViewById(R.id.four_screen_camera_button)
        nextButton = view.findViewById(R.id.first_dialog_right_arrow)

        maleButton.setOnClickListener {
            maleButton.background = getDrawable(requireContext(), R.drawable.button_left_shape_fill)
            femaleButton.background = getDrawable(requireContext(), R.drawable.button_rigth_shape_out)

        }

        femaleButton.setOnClickListener {
            maleButton.background = getDrawable(requireContext(), R.drawable.button_left_shape_out)
            femaleButton.background = getDrawable(requireContext(), R.drawable.button_rigth_shape_fill)
        }

        nextButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_activity_fragment_container, SecondSettingScreenFragment.newInstance(), SECONDSETTINGSCREENFRAGMENT)
                .addToBackStack(SECONDSETTINGSCREENFRAGMENT)
                .commit()
        }
    }

    companion object {
        fun newInstance(): FirstSettingScreenFragment = FirstSettingScreenFragment()
    }
}