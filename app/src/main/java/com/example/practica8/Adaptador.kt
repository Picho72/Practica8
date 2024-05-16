package com.example.practica8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practicaorm.Contacto

class Adaptador(private val mainActivity: MainActivity) : RecyclerView.Adapter<Adaptador.ViewHolderContactos>() {

    private var contactos: List<Contacto> = emptyList() // Lista de contactos actualizada desde la base de datos

    // ViewHolder interno para mantener las vistas de cada elemento de la lista
    class ViewHolderContactos(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtNombre: TextView = itemView.findViewById(R.id.txtNombre)
        var txtTelefono: TextView = itemView.findViewById(R.id.txtTelefono)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderContactos {
        val layoutItem = LayoutInflater.from(parent.context).inflate(R.layout.contacto_item, parent, false)
        return ViewHolderContactos(layoutItem)
    }

    override fun getItemCount(): Int = contactos.size

    override fun onBindViewHolder(holder: ViewHolderContactos, position: Int) {
        val contacto = contactos[position]
        holder.txtNombre.text = contacto.nombre
        holder.txtTelefono.text = contacto.telefono
        holder.itemView.setOnClickListener {
            mainActivity.clickItem(position)
        }
    }

    // Método para actualizar la lista de contactos del adaptador
    fun actualizarContactos(nuevosContactos: List<Contacto>) {
        contactos = nuevosContactos
        notifyDataSetChanged()
    }
}