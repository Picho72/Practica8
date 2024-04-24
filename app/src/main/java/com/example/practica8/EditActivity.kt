package com.example.practica8

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson

class EditActivity : AppCompatActivity() {
    var position : Int = 0
    lateinit var txtNombre: EditText
    lateinit var txtTelefono: EditText

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar)
        val txtTitulo = findViewById<TextView>(R.id.txtTitulo)
        txtTitulo.text = "Modificar Contacto"
        position = intent.getIntExtra("position", -1)
        Log.e("Contacto", "Se recibio un ${position}")
        txtNombre = findViewById(R.id.txtNombre)
        txtTelefono = findViewById(R.id.txtTelefono)

        val contacto = ControlArchivos.listaContactos[position]
        txtNombre.setText(contacto.nombre)
        txtTelefono.setText(contacto.telefono)
    }

    fun guardar(v:View){
        val contacto = Contacto(txtNombre.text.toString(), txtTelefono.text.toString())
        ControlArchivos.listaContactos.set(position, contacto)
        val gson = Gson()
        val control = ControlArchivos(this)
        val contenido = gson.toJson(ControlArchivos.listaContactos)
        val res = control.guardar(contenido)
        val msg = if(res) "Se modificó correctamente" else "Ocurrió un error al modificar"
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
        finish()
    }

}