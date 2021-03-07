package com.communisolve.runningtrackerapp.repositories

import com.communisolve.runningtrackerapp.Database.Run
import com.communisolve.runningtrackerapp.Database.RunDao
import javax.inject.Inject

class MainRepository @Inject constructor(
    val runDao: RunDao
) {
    suspend fun insertRun(run: Run) = runDao.insertRun(run)

    suspend fun deleteRun(run: Run) = runDao.deleteRun(run)

     fun getAllRunsShortedByDate() = runDao.getAllRunSortByDate()

    fun getAllRunSortByDistance() = runDao.getAllRunSortByDistance()

    fun getAllRunSortByTimrInMillis() = runDao.getAllRunSortByTimrInMillis()

    fun getAllRunSortByAvgSpeed() = runDao.getAllRunSortByAvgSpeed()

    fun getAllRunSortByCaloriesBurned() = runDao.getAllRunSortByCaloriesBurned()


    fun getTotalTotalDistance() = runDao.getTotalTotalDistance()

    fun getTotalCaloriesBurned() = runDao.getTotalCaloriesBurned()

    fun getTotalTotalAvgSpeed() = runDao.getTotalTotalAvgSpeed()

    fun getTotalTimeInMillis() = runDao.getTotalTimeInMillis()


}