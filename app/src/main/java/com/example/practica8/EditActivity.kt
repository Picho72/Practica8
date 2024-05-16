package com.example.practica8

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.practicaorm.AppDataBase
import com.example.practicaorm.Contacto

class EditActivity : AppCompatActivity() {
    private var position: Int = 0
    private lateinit var txtNombre: EditText
    private lateinit var txtTelefono: EditText
    private lateinit var bd: AppDataBase

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar)
        val txtTitulo = findViewById<TextView>(R.id.txtTitulo)
        txtTitulo.text = "Modificar Contacto"
        position = intent.getIntExtra("position", -1)
        Log.e("Contacto", "Se recibió un ${position}")

        txtNombre = findViewById(R.id.txtNombre)
        txtTelefono = findViewById(R.id.txtTelefono)

        bd = Room.databaseBuilder(applicationContext, AppDataBase::class.java, "contactosbd")
            .allowMainThreadQueries()
            .build()


        if (position != -1) { // Verificar si se está editando un contacto existente
            val contacto = bd.contactoDao().obtenerContactos()[position]
            txtNombre.setText(contacto.nombre)
            txtTelefono.setText(contacto.telefono)

            // Mostrar el botón "Eliminar" solo si se está editando un contacto existente
            findViewById<Button>(R.id.btnEliminar).visibility = View.VISIBLE

            // Asociar el método eliminarContacto al botón de eliminar
            findViewById<Button>(R.id.btnEliminar).setOnClickListener {
                eliminarContacto()
            }
        }
    }

    fun guardar(v:View){
        val nombre = txtNombre.text.toString()
        val telefono = txtTelefono.text.toString()
        val contacto = bd.contactoDao().obtenerContactos()[position]
        val contactoActualizado = Contacto(contacto.id, nombre, telefono)
        bd.contactoDao().modificar(contactoActualizado)
        Toast.makeText(this, "Se modificó correctamente", Toast.LENGTH_LONG).show()
        finish()
    }
    private fun eliminarContacto() {
        val contacto = bd.contactoDao().obtenerContactos()[position]
        bd.contactoDao().eliminar(contacto)
        Toast.makeText(this, "Contacto eliminado", Toast.LENGTH_LONG).show()
        finish()
    }

}