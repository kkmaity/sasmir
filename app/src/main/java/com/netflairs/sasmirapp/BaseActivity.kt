package com.netflairs.sasmirapp

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.location.LocationManager
import android.net.ConnectivityManager
import com.netflairs.sasmirapp.constants.Preference


open class BaseActivity : AppCompatActivity(){
    protected var locationManager: LocationManager? = null
    protected var locationListener: LocationListener? = null
    var preference: Preference? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preference = Preference(this@BaseActivity)

    }

    fun isNetworkConnected(): Boolean {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        @SuppressLint("MissingPermission") val activeNetwork = cm.activeNetworkInfo
        val isConnected = activeNetwork != null && activeNetwork.isConnected
        if (isConnected) {
            Log.d("Network", "Connected")
            return true
        } else {

            Log.d("Network", "Not Connected")
            return false
        }
    }

}




