package com.netflairs.sasmirapp

import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.netflairs.sasmirapp.model.LoginResponse
import com.netflairs.sasmirapp.restService.RestService
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_login.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : BaseActivity() {

    var progress: ProgressDialog? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        cardLogin.setOnClickListener(clickListener)
        progress=ProgressDialog(this);
        progress!!.setMessage("Loading...")
    }

    private val clickListener: View.OnClickListener = View.OnClickListener { view ->
        when (view.id) {

            cardLogin.id -> {
                login()

            }
        }
    }

    fun login() {
        if (validate()) {
            if (isNetworkConnected())
            doWebServiceCall()
            else
                Toast.makeText(this, "No Internet connection", Toast.LENGTH_LONG).show()
        }
    }

    private fun validate(): Boolean {
        if (editTextName.text.toString().isEmpty()) {
            Toast.makeText(this, "Enter username", Toast.LENGTH_LONG).show()
            return false
        }else if(editTextPassword.text.toString().isEmpty()){
            Toast.makeText(this, "Enter password", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }
    fun doWebServiceCall() {
        progress!!.show()
        val getDepartment = RestService.instance.restInterface.login(editTextName.text.toString(), editTextPassword.text.toString())

        getDepartment.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>?) {
                if (response!!.body() != null)
                    if (response != null && response.code() == 200) {

                        var abc = response.body() as LoginResponse
                        preference!!.email=abc.email
                        callNextScreen()
                    } else {
                        showError();
                    }
                progress!!.dismiss()
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                showError();
                progress!!.dismiss()
            }
        })


    }
     fun showError() {
        Toast.makeText(this, "Something went wrong!", Toast.LENGTH_LONG).show()
    }
    fun callNextScreen(){
        val mainIntent = Intent(this, DashboardActivity::class.java)
        startActivity(mainIntent)
        finish()
    }
}
