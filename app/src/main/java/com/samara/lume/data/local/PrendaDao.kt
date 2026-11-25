package com.samara.lume.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

// Acciones sobre la base de datos pero sin escribir la implementación
@Dao
interface PrendaDao {

    // Devuelve un Flow porque es como una tubería que detecta los cambios que haces en la lista
    @Query("SELECT * FROM prendas ORDER BY fechaAlta DESC")
    fun obtenerTodas(): Flow<List<PrendaEntity>>

    @Insert
    suspend fun insertar(prenda: PrendaEntity)

    // Room busca la fila por su clave primaria (id) y actualiza el resto de columnas.
    @Update
    suspend fun actualizar(prenda: PrendaEntity)

    // Borra la fila cuyo id coincide.
    @Delete
    suspend fun eliminar(prenda: PrendaEntity)

}