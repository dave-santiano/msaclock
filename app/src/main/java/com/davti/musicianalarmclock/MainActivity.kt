package com.davti.musicianalarmclock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.davti.musicianalarmclock.ui.alarms.AlarmsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, AlarmsFragment.newInstance())
                .commitNow()
        }
    }
}