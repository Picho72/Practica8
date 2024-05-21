package com.example.practica8

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface IContacto {
    companion object {
        const val url: String = "http://192.168.97.47:4567"
    }

    @GET("/contactos")
    fun getContactos(): Call<List<Contacto>>

    @PUT("/contacto/agregar")
    fun agregar(@Body contacto: Contacto): Call<Boolean>

    @PUT("/contacto/modificar")
    fun modificar(@Body contacto: Contacto): Call<Boolean>

    @DELETE("/contacto/borrar/{id}")
    fun eliminar(@Path("id") id: Int): Call<Boolean>
}
