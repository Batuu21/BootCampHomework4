package com.patikadev.deneme1.ui.activities

import android.os.Bundle
import com.patikadev.deneme1.R

import kotlinx.android.synthetic.main.fragment_login.*

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.patikadev.deneme1.service.ServiceConnector
import com.patikadev.deneme1.ui.activities.User.Companion.getCurrentInstance
import com.patikadev.deneme1.utils.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var regsiter: Button = view.findViewById(R.id.button_registerr)
        regsiter.setOnClickListener {
            hitRegisterEndpoint()
        }

    }
    private fun hitRegisterEndpoint() {

        val email = emailET.getString()
        val password = password.getString()


            progressbar.visible()

            val params = mutableMapOf<String, Any>().apply {
                put("email", email)
                put("password", password)

            }

            ServiceConnector.restInterface.login(params).enqueue(object : Callback<RegisterResponse>{
                override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                   if(response.isSuccessful){
                       progressbar.gone()
                       toast("basarılı bir sekilde login oldunuz")
                       response.body()?.token?.let { saveDataAsString(USER_TOKEN, it) }
                       val user =getCurrentInstance()
                       response.body()?.let { user.setUser(it.user) }
                       user.token= response.body()?.token
                       navigateToNextFragment(R.id.action_loginfragment_to_homeFragment)

                   }
                    else{
                       progressbar.gone()
                       toast("login olamadınız")
                   }
                }

                override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                    toast("hata olustu")
                }

            })


    }


}