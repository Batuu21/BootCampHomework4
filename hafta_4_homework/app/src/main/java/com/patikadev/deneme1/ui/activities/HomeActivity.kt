package com.patikadev.deneme1.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.patikadev.deneme1.R
import com.patikadev.deneme1.utils.gone
import com.patikadev.deneme1.utils.visible
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val state = intent.getStringExtra("state").toString()
        val navHost = nav_host_fragment_container as NavHostFragment
        val  graph = navHost.navController.navInflater.inflate(R.navigation.navigation)

        if(state=="logged") graph.startDestination = R.id.homeFragment
        else graph.startDestination = R.id.loginfragment
        navHost.navController.graph = graph






    }





}