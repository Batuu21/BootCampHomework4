package com.patikadev.deneme1.ui.activities

import com.google.gson.annotations.SerializedName


data class RegisterResponse(@SerializedName("user") val user: User, val token : String)