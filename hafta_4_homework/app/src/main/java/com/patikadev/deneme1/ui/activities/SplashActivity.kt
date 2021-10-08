package com.patikadev.deneme1.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.patikadev.deneme1.R
import com.patikadev.deneme1.service.ServiceConnector

import com.patikadev.deneme1.utils.USER_TOKEN
import com.patikadev.deneme1.utils.gone
import com.patikadev.deneme1.utils.toast
import kotlinx.android.synthetic.main.fragment_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SplashActivity : AppCompatActivity() {

    private var token : String?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        if(isLoggedIn()){

            User.getCurrentInstance().token = token
            ServiceConnector.restInterface.getMe().enqueue(object : Callback<User>{
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if(response.isSuccessful){
                        progressbar.gone()
                        toast("kullanıcı loginli")
                        response.body()?.userName?.let { toast(it) }

                    }
                    else{
                        progressbar.gone()
                        toast("login hatası")
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
            startActivity(Intent(this, HomeActivity::class.java).putExtra("state","logged"))

        }else{

            //REGISTER SCREEN SHOULD BE SEEN
            progressbar.gone()
            startActivity(Intent(this, HomeActivity::class.java).putExtra("state","unlogged"))
        }
    }


    private fun isLoggedIn() : Boolean{
        val token = getToken()
        return if(token.isEmpty()) false else true
    }

    private fun getToken() : String{
        val sh = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        token = sh.getString(USER_TOKEN, "")!!


        return token!!
    }

}