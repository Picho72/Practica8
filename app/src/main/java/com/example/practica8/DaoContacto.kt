package com.example.practicaorm

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DaoContacto {
    @Query("SELECT * FROM Contacto")
    fun obtenerContactos(): List<Contacto>

    @Insert
    fun agregar(vararg contacto: Contacto)

    @Update
    fun modificar(contacto: Contacto)

    @Delete
    fun eliminar(contacto: Contacto)
}
