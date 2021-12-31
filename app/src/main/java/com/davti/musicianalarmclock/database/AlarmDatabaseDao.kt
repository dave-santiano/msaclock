package com.davti.musicianalarmclock.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface AlarmDatabaseDao {

    @Insert
    fun insert(alarm: Alarm)

    @Update
    fun update(alarm: Alarm)

    @Query("SELECT * from alarm_table WHERE alarmId = :key")
    fun get(key: Long): Alarm

    @Query("DELETE FROM alarm_table")
    fun clear()

    @Query("SELECT * FROM alarm_table ORDER BY alarmId DESC")
    fun getAllAlarms(): LiveData<List<Alarm>>
}