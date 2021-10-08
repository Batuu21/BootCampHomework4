package com.patikadev.deneme1

import android.app.Application
import com.patikadev.deneme1.service.ServiceConnector

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        ServiceConnector.init()
    }
}