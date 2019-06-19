package com.netflairs.sasmirapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.View
import android.widget.Toast



class SplashActivity : BaseActivity(){
    private val TAG = "MainActivity"
    private val REQUEST_PERMISSIONS_REQUEST_CODE = 34

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        if (!checkAndRequestPermissions()) {
            RequestMultiplePermission()
        } else {
            Handler().postDelayed({
                /* Create an Intent that will start the Menu-Activity. */

                if (preference!!.email.isEmpty()){
                    val mainIntent = Intent(this, LoginActivity::class.java)
                    startActivity(mainIntent)
                    finish()
                }else{
                    val mainIntent = Intent(this, DashboardActivity::class.java)
                    startActivity(mainIntent)
                    finish()
                }

            }, 3000)
        }
    }


    private fun RequestMultiplePermission() {

        ActivityCompat.requestPermissions(
            this@SplashActivity,
            arrayOf(
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION

            ),
            REQUEST_PERMISSIONS_REQUEST_CODE
        )

    }


    private fun checkAndRequestPermissions(): Boolean {


        val FirstPermissionResult =
            ContextCompat.checkSelfPermission(applicationContext, android.Manifest.permission.ACCESS_FINE_LOCATION)
        val SecondPermissionResult =
            ContextCompat.checkSelfPermission(applicationContext, Manifest.permission.ACCESS_COARSE_LOCATION)


        return FirstPermissionResult == PackageManager.PERMISSION_GRANTED &&
                SecondPermissionResult == PackageManager.PERMISSION_GRANTED

    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {

            REQUEST_PERMISSIONS_REQUEST_CODE ->

                if (grantResults.size > 0) {

                    val CameraPermission = grantResults[0] == PackageManager.PERMISSION_GRANTED
                    val WriteExternalPermission = grantResults[1] == PackageManager.PERMISSION_GRANTED



                    if (CameraPermission && WriteExternalPermission ) {
                        Handler().postDelayed({
                            /* Create an Intent that will start the Menu-Activity. */
                            val mainIntent = Intent(this, LoginActivity::class.java)
                            startActivity(mainIntent)
                            finish()
                        }, 3000)
                        Toast.makeText(this@SplashActivity, "Permission Granted", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this@SplashActivity, "Permission Denied", Toast.LENGTH_LONG).show()

                    }
                }
        }
    }
}
