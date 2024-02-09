package com.demo.dates.presentation.ui

import android.graphics.Color
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.demo.dates.R


const val LASTPAGEFRAGMENT = "LASTPAGEFRAGMENT"

class LastPageFragment: Fragment() {
    lateinit var facebookButton: Button
    lateinit var smsButton: Button
    lateinit var checkBox: CheckBox
    lateinit var lastTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       return inflater.inflate(R.layout.fragment_grey_dating_last, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        facebookButton = view.findViewById(R.id.last_activity_facebook_button)
        smsButton = view.findViewById(R.id.last_activity_sms_button)
        checkBox = view.findViewById(R.id.imageView)
        lastTextView = view.findViewById(R.id.last_activity_textView)

        facebookButton.setOnClickListener {}

        smsButton.setOnClickListener {}

        lastTextView.movementMethod = LinkMovementMethod.getInstance()
        lastTextView.setLinkTextColor(Color.WHITE)

    }



    companion object {
        fun newInstance(): LastPageFragment{
          return LastPageFragment()
        }
    }
}