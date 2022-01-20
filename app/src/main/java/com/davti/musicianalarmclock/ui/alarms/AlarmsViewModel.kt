package com.davti.musicianalarmclock.ui.alarms

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.davti.musicianalarmclock.database.AlarmDatabaseDao

class AlarmsViewModel(
    val database: AlarmDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

    private var _navigateToAlarmSetting = MutableLiveData<Boolean>()
    val navigateToAlarmSetting : LiveData<Boolean>
        get() = _navigateToAlarmSetting


    fun getAlarmsFromDatabase(){

    }

    fun onSetAlarm(){
        _navigateToAlarmSetting.value = true
    }

    fun doneNavigating(){
        _navigateToAlarmSetting.value = false
    }

}

//TODO implement alarms view model, this will watch for any event changes on the alarms settings side
