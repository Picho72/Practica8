package com.example.practicaorm

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contacto(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo() val nombre:String,
    @ColumnInfo() val telefono:String
)
