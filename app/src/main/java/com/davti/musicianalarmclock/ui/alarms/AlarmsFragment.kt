package com.davti.musicianalarmclock.ui.alarms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.davti.musicianalarmclock.R
import com.davti.musicianalarmclock.database.AlarmDatabase
import com.davti.musicianalarmclock.databinding.AlarmsFragmentBinding


class AlarmsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding : AlarmsFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.alarms_fragment, container, false)

        val application = requireNotNull(this.activity).application

        val dataSource = AlarmDatabase.getInstance(application).alarmDatabaseDao

        val viewModelFactory = AlarmsViewModelFactory(dataSource, application)

        val alarmsViewModel =
            ViewModelProvider(this, viewModelFactory).get(AlarmsViewModel::class.java)

        binding.alarmsViewModel = alarmsViewModel
        binding.lifecycleOwner = this

        alarmsViewModel.navigateToAlarmSetting.observe(viewLifecycleOwner, Observer {
            if( it == true){
                this.findNavController().navigate(
                    AlarmsFragmentDirections.actionAlarmsFragmentToAlarmSettingsFragment()
                )
                alarmsViewModel.doneNavigating()
            }
        })

        return binding.root
    }
}