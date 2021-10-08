package com.patikadev.deneme1.ui.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.patikadev.deneme1.R
import com.patikadev.deneme1.service.ServiceConnector
import com.patikadev.deneme1.utils.toast
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ServiceConnector.restInterface.getTasks().enqueue(object : Callback<TaskResponse> {
            override fun onResponse(call: Call<TaskResponse>, response: Response<TaskResponse>) {
                if(response.isSuccessful){

                    toast("taskler geldi")
                    recyclerviewtasks.adapter= response.body()?.let { Adapter(it.data) }

                    response.body()?.data?.get(0)?.description?.let { toast(it) }
                    print(response.body()?.data?.get(0))

                }
                else{

                    toast("tasklar gelmedi")
                }
            }
            override fun onFailure(call: Call<TaskResponse>, t: Throwable) {
                toast("hata olustu")
            }

        })
    }

}