package com.patikadev.deneme1.ui.activities

import com.google.gson.annotations.SerializedName


data class TaskResponse(val data: List<Task>, val count : Int)


data class Task(val description: String,val completed: Boolean)