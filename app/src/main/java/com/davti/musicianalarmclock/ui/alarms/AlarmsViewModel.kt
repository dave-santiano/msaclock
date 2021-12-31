package com.davti.musicianalarmclock.ui.alarms

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.davti.musicianalarmclock.database.AlarmDatabaseDao

class AlarmsViewModel(
    val database: AlarmDatabaseDao,
    application: Application
) : AndroidViewModel(application) {




}

//TODO implement alarms view model, this will watch for any event changes on the alarms settings side
