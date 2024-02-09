package com.demo.dates.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageButton
import androidx.fragment.app.Fragment
import com.demo.dates.R


const val FIRSTSCREENFRAGMENT = "FIRSTSCREENFRAGMENT"
class FragmentLogin : Fragment(){
    lateinit var newUserButton: ImageButton
    lateinit var loginButton: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_grey_dating, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newUserButton = view.findViewById(R.id.graydating_activity_new_user_button)
        loginButton = view.findViewById(R.id.graydating_activity_login_button)

        newUserButton.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.main_activity_fragment_container, FirstSettingScreenFragment.newInstance(), FIRSTSCREENFRAGMENT)
                .addToBackStack(FIRSTSCREENFRAGMENT)
                .commit()
        }

        loginButton.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.main_activity_fragment_container, LastPageFragment.newInstance(), LASTPAGEFRAGMENT )
                .addToBackStack(LASTPAGEFRAGMENT)
                .commit()


        }
    }

    companion object {
        fun newInstance():FragmentLogin = FragmentLogin()
    }
}