package com.davti.musicianalarmclock.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalTime
import java.time.LocalDateTime

@Entity(tableName = "alarm_table")
data class Alarm(

    @PrimaryKey(autoGenerate = true)
    val alarmId: Long = 0L,

    @ColumnInfo(name="start_time")
    var startTime: Long = 0L,

    @ColumnInfo(name="end_time")
    var endTime: Long = 0L,

    @ColumnInfo(name="formatted_time")
    var formattedTime: LocalTime
)
//TODO figure out more alarm related data for database