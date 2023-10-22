package com.example.busschedule.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BusScheduleDao {
    @Query("SELECT * FROM bus_schedule ORDER BY arrival_time")
    fun getFullSchedule(): Flow<List<BusSchedule>>

    @Query("SELECT * FROM bus_schedule WHERE stop_name = :stopName ORDER BY arrival_time")
    fun getScheduleForStop(stopName: String): Flow<List<BusSchedule>>
}