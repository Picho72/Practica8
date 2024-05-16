package com.example.practicaorm

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Contacto::class], version=1)
abstract class AppDataBase : RoomDatabase(){
    abstract fun contactoDao():DaoContacto
}