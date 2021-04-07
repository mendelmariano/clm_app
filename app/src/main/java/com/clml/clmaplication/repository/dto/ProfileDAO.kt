package com.clml.clmaplication.repository.dto

import androidx.room.*
import com.clml.clmaplication.domain.Profile

@Dao
interface ProfileDAO {

    @Query("Select * from Profile")
    suspend fun getProfile():Profile



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProfile(p: Profile)

    @Update
    suspend fun updateProfile(p: Profile)

    @Delete
    suspend fun deleteProfile(p: Profile)
}

@Database(entities = [Profile::class], version = 1)
abstract  class AppDatabase: RoomDatabase(){
    abstract fun getProfileDao():ProfileDAO
}