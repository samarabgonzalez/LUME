package com.samara.lume.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PrendaEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun prendaDao(): PrendaDao
    companion object {
        // @Volatile: todos los hilos ven siempre el valor actualizado de INSTANCE.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        // Si la base de datos ya existe, la devuelve. Si no, la crea, pero solo
        // un hilo a la vez gracias a synchronized (así no se crean dos).
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "lume_room.db"
                    ).build()
                    INSTANCE = instance
                    instance
                }
            }
        }
    }