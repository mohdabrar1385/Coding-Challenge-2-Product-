package com.smartherd.viewpagerwithnavigation.onboarding.screens

import com.smartherd.viewpagerwithnavigation.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2



class FirstScreen : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first_screen, container, false)


 view.findViewById<TextView>(R.id.next).setOnClickListener {

     Toast.makeText(context, "Clicked !!", Toast.LENGTH_SHORT).show()

     val viewPager =  activity?.findViewById<ViewPager2>(R.id.viewPager2)
     viewPager?.currentItem = 1
        }

        return view
    }

}