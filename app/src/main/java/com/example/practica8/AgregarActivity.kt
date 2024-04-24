package com.example.practica8

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.Gson

class AgregarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_agregar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun guardar(v: View){
        val nombre = findViewById<EditText>(R.id.txtNombre)
        val telefono = findViewById<EditText>(R.id.txtTelefono)
        val contacto = Contacto(nombre.text.toString(), telefono.text.toString())
        ControlArchivos.listaContactos.add(contacto)
        val gson = Gson()
        val control = ControlArchivos(this)
        val contenido = gson.toJson(ControlArchivos.listaContactos)
        val res = control.guardar(contenido)
        val msg = if(res) "Se guardo correctamente"
        else "Ocurrio un error"
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
        val archivo = control.leerArchivo()
        Log.v("Contenido Archivo", archivo)

        finish()
    }
}