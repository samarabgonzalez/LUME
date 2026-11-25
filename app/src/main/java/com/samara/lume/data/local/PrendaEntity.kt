package com.samara.lume.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
// Entidad para que Room reconozca la tabla, convierte todos los tipos a String e Integer
@Entity(tableName="Prendas")
data class PrendaEntity(
    //id = 0 le indica a Room que el id lo genera SQLITE al insertar
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String,
    val categoria: String,
    val color: String,
    val talla: String,
    val marca: String = "",
    val temporada: String,
    // La foto NO se guarda dentro de la base de datos: se guarda su dirección
    // en el móvil (content: / .). null = la prenda todavía no tiene foto.
    val fotoUri : String? = null,
    // Corazón de la lista y Checkbox "Favorita": empieza sin marcar.
    val favorita: Boolean = false,
    val fechaAlta: Long
)