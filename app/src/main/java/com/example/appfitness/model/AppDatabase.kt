package com.example.appfitness.model

import androidx.room.RoomDatabase

abstract class AppDatabase : RoomDatabase() {
    abstract fun calcDao(): CalcDao
}