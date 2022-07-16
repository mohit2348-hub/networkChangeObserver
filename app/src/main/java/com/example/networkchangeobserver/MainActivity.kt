package com.example.networkchangeobserver

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.networkchangeobserver.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    var connectionLiveData = ConnectionLiveData(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        connectionLiveData.observe(this) {
            if (it!!.isConnected) {
                if (it.type == 1) {
                    binding?.connected?.setText("WIFI")
                    Log.d("no", "onCreate:" + "yes")
                } else if (it.type == 2) {
                    binding?.connected?.setText("Mobile")
                    Log.d("no", "onCreate:" + "no")
                }

            }
        }
    }

}