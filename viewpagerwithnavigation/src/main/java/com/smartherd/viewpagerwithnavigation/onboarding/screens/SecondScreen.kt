package com.smartherd.viewpagerwithnavigation.onboarding.screens
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.smartherd.viewpagerwithnavigation.R
import com.smartherd.viewpagerwithnavigation.databinding.FragmentViewPagerBinding


class SecondScreen : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_second_screen, container, false)


        view.findViewById<TextView>(R.id.next2).setOnClickListener {
            val viewPager =  activity?.findViewById<ViewPager2>(R.id.viewPager2)
            viewPager?.currentItem = 2
        }

        return view
    }


}