package com.smartherd.viewpagerwithnavigation.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.viewpager2.widget.ViewPager2
import com.smartherd.viewpagerwithnavigation.R

import com.smartherd.viewpagerwithnavigation.onboarding.screens.FirstScreen
import com.smartherd.viewpagerwithnavigation.onboarding.screens.SecondScreen
import com.smartherd.viewpagerwithnavigation.onboarding.screens.ThirdScreen


class ViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)

        val fragmentList = arrayListOf(
            FirstScreen(),
            SecondScreen(),
            ThirdScreen()
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )
       view.findViewById<ViewPager2>(R.id.viewPager2)?.adapter = adapter

        return view
    }

}