package com.smartherd.msgshareapp.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.smartherd.msgshareapp.Constants
import com.smartherd.msgshareapp.databinding.ActivityMainBinding
import com.smartherd.msgshareapp.foregroundservice.ForegroundActivity
import com.smartherd.msgshareapp.intentservices.IntentServicesActivity
import com.smartherd.msgshareapp.jobintentservices.JobIntentServicesActivity
import com.smartherd.msgshareapp.jobscheduler.JobSchedulerActivity
import com.smartherd.msgshareapp.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        btnShowToast.setOnClickListener {
            // Code
            Log.i(TAG, "Button was clicked !")

            showToast("Button was clicked !", Toast.LENGTH_LONG)
        }

        btnSendMsgToNextActivity.setOnClickListener{
            val message: String = etUserMessage.text.toString()
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(Constants.USER_MSG_KEY, message)
            startActivity(intent)
        }

        btnShareToOtherApps.setOnClickListener {

            val message: String = etUserMessage.text.toString()

            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent, "Please select app: "))
        }

        btnRecyclerViewDemo.setOnClickListener {

            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }

        btnJobScheduler.setOnClickListener{
            val intent = Intent(this, JobSchedulerActivity::class.java)
            startActivity(intent)
        }

        btnForeGround.setOnClickListener{
            val intent = Intent(this, ForegroundActivity::class.java)
            startActivity(intent)
        }

        btnIntentServices.setOnClickListener{
            val intent = Intent(this, IntentServicesActivity::class.java)
            startActivity(intent)
        }

        btnJobIntentServices.setOnClickListener{
            val intent = Intent(this, JobIntentServicesActivity::class.java)
            startActivity(intent)
        }

    }
}