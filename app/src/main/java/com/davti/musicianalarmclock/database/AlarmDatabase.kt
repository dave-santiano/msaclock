package com.davti.musicianalarmclock.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


//Boiler plate code
@Database(entities = [Alarm::class], version = 1, exportSchema = false)
abstract class AlarmDatabase: RoomDatabase(){
    abstract val alarmDatabaseDao : AlarmDatabaseDao

    companion object{
        @Volatile
        private var INSTANCE: AlarmDatabase? = null

        fun getInstance(context: Context) : AlarmDatabase{
            //multiple threads can potentially ask for a
            //database instance at the same time, synchronized lock it
            //(only one thread of execution to access this at at time)
            synchronized(this){
                var instance = INSTANCE

                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AlarmDatabase::class.java,
                        "alarms_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }

                return instance
            }
        }

    }
}