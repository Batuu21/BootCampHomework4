package com.patikadev.deneme1.service


import com.patikadev.deneme1.ui.activities.RegisterResponse
import com.patikadev.deneme1.ui.activities.TaskResponse
import com.patikadev.deneme1.ui.activities.User
import retrofit2.Call
import retrofit2.http.*

interface TodoAPI {

    @POST("user/login")
    fun login(@Body params : MutableMap<String, Any>) : Call<RegisterResponse>


    @GET("user/me")
    fun getMe() : Call<User>

    @GET("task")
    fun getTasks() : Call<TaskResponse>

}