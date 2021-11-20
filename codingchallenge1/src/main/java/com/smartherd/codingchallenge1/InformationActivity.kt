package com.smartherd.codingchallenge1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_information.*

class InformationActivity  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)

        val bundle: Bundle? = intent.extras
        bundle?.let {
            val msg = bundle!!.getString("Details")
            txvUserMessage.text = msg
        }
    }
}