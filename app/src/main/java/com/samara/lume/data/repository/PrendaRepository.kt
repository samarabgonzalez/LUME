package com.samara.lume.data.repository

import com.samara.lume.data.local.PrendaDao
import com.samara.lume.data.local.PrendaEntity
import kotlinx.coroutines.flow.Flow

//Es el punto de acceso entre la base de datos y el viewmodel
//El viewmodel contacta con el repositorio para acceder a los datos
class PrendaRepository (private val dao: PrendaDao) {
    // Flujo con todas las prendas. Se actualiza solo cuando cambia la tabla.
    val prendas: Flow<List<PrendaEntity>> = dao.obtenerTodas()

    suspend fun insertar(prenda: PrendaEntity) = dao.insertar(prenda)

    suspend fun actualizar(prenda: PrendaEntity) = dao.actualizar(prenda)

    suspend fun eliminar(prenda: PrendaEntity) = dao.eliminar(prenda)
}