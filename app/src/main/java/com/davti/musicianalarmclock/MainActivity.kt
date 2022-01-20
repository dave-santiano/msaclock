package com.davti.musicianalarmclock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.davti.musicianalarmclock.ui.alarms.AlarmsFragment

class MainActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var navController: NavController
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        navController = findNavController(R.id.nav_host_fragment)
        setupActionBarWithNavController(navController)
    }
}