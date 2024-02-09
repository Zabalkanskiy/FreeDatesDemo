package com.demo.dates.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.demo.dates.R

const val LOGIN_FRAGMENT = "LOGIN_FRAGMENT"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.main_activity_fragment_container, FragmentLogin.newInstance(), LOGIN_FRAGMENT)
            .commit()
    }
}