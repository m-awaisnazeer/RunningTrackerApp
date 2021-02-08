package com.communisolve.runningtrackerapp.Database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RunDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run: Run)

    @Delete
    suspend fun deleteRun(run: Run)

    @Query("SELECT * FROM RUNNING_TABLE ORDER BY timestamp DESC")
    fun getAllRunSortByDate():LiveData<List<Run>> //

    @Query("SELECT * FROM RUNNING_TABLE ORDER BY timeInMillis DESC")
    fun getAllRunSortByTimrInMillis():LiveData<List<Run>>

    @Query("SELECT * FROM RUNNING_TABLE ORDER BY caloriesBurned DESC")
    fun getAllRunSortByCaloriesBurned():LiveData<List<Run>>

    @Query("SELECT * FROM RUNNING_TABLE ORDER BY avgSpeedInKMH DESC")
    fun getAllRunSortByAvgSpeed():LiveData<List<Run>>

    @Query("SELECT * FROM RUNNING_TABLE ORDER BY distanceInMeters DESC")
    fun getAllRunSortByDistance():LiveData<List<Run>>

    @Query("SELECT SUM(timeInMillis) FROM running_table")
    fun getTotalTimeInMillis():LiveData<Long>

    @Query("SELECT SUM(caloriesBurned) FROM running_table")
    fun getTotalCaloriesBurned():LiveData<Int>

    @Query("SELECT SUM(distanceInMeters) FROM running_table")
    fun getTotalTotalDistance():LiveData<Int>

    @Query("SELECT SUM(avgSpeedInKMH) FROM running_table")
    fun getTotalTotalAvgSpeed():LiveData<Float>


}