package com.davti.musicianalarmclock.alarmsettings

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.davti.musicianalarmclock.database.AlarmDatabaseDao

class AlarmSettingsViewModel(
    val database: AlarmDatabaseDao,
    application: Application
) : AndroidViewModel(application){


}

//TODO this will handle all the data changes that enable alarms to be set