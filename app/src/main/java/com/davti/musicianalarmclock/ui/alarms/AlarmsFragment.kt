package com.davti.musicianalarmclock.ui.alarms

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.davti.musicianalarmclock.R
import com.davti.musicianalarmclock.database.AlarmDatabase
import com.davti.musicianalarmclock.databinding.AlarmsFragmentBinding


class AlarmsFragment : Fragment() {

    companion object {
        fun newInstance() = AlarmsFragment()
    }

    private lateinit var alarmsViewModel: AlarmsViewModel

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
        return binding.root
    }
}

//TODO check for navigation away from main Alarms view