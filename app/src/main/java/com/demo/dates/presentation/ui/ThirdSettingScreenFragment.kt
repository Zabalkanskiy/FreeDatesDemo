package com.demo.dates.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.demo.dates.R

const val FOURSETTINGSCREENFRAGMENT = "FOURSETTINGSCREENFRAGMENT"


class ThirdSettingScreenFragment : Fragment() {

    lateinit var rigthArrowImageButton: ImageButton
    lateinit var heightTextView: TextView
    lateinit var seekBar: SeekBar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      return inflater.inflate(R.layout.fragment_grey_third_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rigthArrowImageButton = view.findViewById(R.id.third_dialog_right_arrow)
        heightTextView = view.findViewById(R.id.third_dialog_height_text_imperial)
        seekBar = view.findViewById(R.id.seekBar)

        val stringText = "5\"3'"

        heightTextView.text = stringText

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

                if(p2){
                    var feet: Int = 0
                    var dim: Int = 0
                    var txt: String = ""
                    feet = (56 + p1)/12
                    dim = (56+p1)%12
                    txt = "${feet}\"${dim}'"
                    heightTextView.text = txt
                }


            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })

        rigthArrowImageButton.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.main_activity_fragment_container, FourSettingScreenFragment.newInstance(), FOURSETTINGSCREENFRAGMENT)
                .addToBackStack(FOURSETTINGSCREENFRAGMENT)
                .commit()
        }
    }

    companion object {
        fun newInstance(): ThirdSettingScreenFragment = ThirdSettingScreenFragment()
    }
}