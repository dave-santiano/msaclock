package com.davti.musicianalarmclock.alarmsettings

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.davti.musicianalarmclock.database.AlarmDatabaseDao
import com.davti.musicianalarmclock.ui.alarms.AlarmsViewModel
import java.lang.IllegalArgumentException

class AlarmSettingsViewModelFactory(
    private val dataSource: AlarmDatabaseDao,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AlarmSettingsViewModel::class.java)) {
            return AlarmSettingsViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}