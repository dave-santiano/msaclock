package com.davti.musicianalarmclock.alarmsettings

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.davti.musicianalarmclock.R
import com.davti.musicianalarmclock.database.AlarmDatabase
import com.davti.musicianalarmclock.databinding.AlarmSettingsFragmentBinding


class AlarmSettingsFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : AlarmSettingsFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.alarm_settings_fragment, container, false)

        val application = requireNotNull(this.activity).application

        val dataSource = AlarmDatabase.getInstance(application).alarmDatabaseDao

        val viewModelFactory = AlarmSettingsViewModelFactory(dataSource, application)

        val alarmSettingsViewModel = ViewModelProvider(this, viewModelFactory).get(AlarmSettingsViewModel::class.java)

        binding.alarmSettingsViewModel = alarmSettingsViewModel
        binding.lifecycleOwner = this

        return binding.root
    }
}

//TODO this needs to obtain data from the alarm clicked on in Alarms view