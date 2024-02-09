package com.demo.dates.presentation.ui

import android.content.Intent
import android.icu.text.NumberFormat
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.demo.dates.R
import com.google.android.material.slider.RangeSlider

const val FIVESETTINGSCREEN = "FIVESETTINGSCREEN"

class FourSettingScreenFragment : Fragment() {
    lateinit var textViewRangeSlider: TextView
    lateinit var textRange: TextView

    lateinit var rangeSliderAge: RangeSlider

    lateinit var textHeight: TextView
    lateinit var rangeSliderHeight: RangeSlider
    lateinit var arrowNext: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       return inflater.inflate(R.layout.fragment_gray_four_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arrowNext = view.findViewById(R.id.third_dialog_right_arrow)
        textViewRangeSlider = view.findViewById(R.id.third_dialog_height_text_age_range)
        rangeSliderAge = view.findViewById(R.id.four_dialog_age_range_slider)
        textHeight = view.findViewById(R.id.third_dialog_height_text_imperial)
        rangeSliderHeight  = view.findViewById(R.id.four_dialog_heigth_range_slider)


        textViewRangeSlider.text = "from 18 to 40"
        rangeSliderAge.setLabelFormatter{
                value: Float ->
            val format = NumberFormat.INTEGERSTYLE
            value.toInt().toString()
        }

        rangeSliderAge.addOnChangeListener { slider, value, fromUser ->
            val values =   rangeSliderAge.values
            val textAge: String = "from ${values[0].toInt()} to ${values[1].toInt()}"
            textViewRangeSlider.text = textAge
        }

        rangeSliderHeight.setLabelFormatter { value: Float ->
            val vat = value.toInt()
            var feet: Int = 0
            var dim: Int = 0
            var txt: String = ""
            feet = (56 + vat)/12
            dim = (56+vat)%12
            txt = "${feet}\"${dim}'"
            return@setLabelFormatter txt
        }

        textHeight.text = "from 4\"11' to 5\"6'"

        rangeSliderHeight.addOnChangeListener { slider, value, fromUser ->
            val values = rangeSliderHeight.values

            var feet1: Int = 0
            var dim1: Int = 0
            var feet2: Int = 0
            var dim2: Int = 0

            feet1 = (56 + values[0].toInt())/12
            dim1 = (56 + values[0].toInt())%12

            feet2 = (56 + values[1].toInt())/12
            dim2 = (56 + values[1].toInt())%12
            var txt: String = "from ${feet1}\"${dim1}' to ${feet2}\"${dim2}'"
            textHeight.text = txt

        }


        arrowNext.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.main_activity_fragment_container, FiveSettingScreenFragmnet.newInstance(), FIVESETTINGSCREEN)
                .addToBackStack(FIVESETTINGSCREEN)
                .commit()
        }
    }

    companion object {
        fun newInstance(): FourSettingScreenFragment = FourSettingScreenFragment()
    }
}