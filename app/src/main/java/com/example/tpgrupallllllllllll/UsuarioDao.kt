package com.example.tpgrupallllllllllll
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UsuarioDao {

    @Query(value = "SELECT * FROM usuario_entity")
    fun getAll(): List<Usuario>

    @Insert
    fun insert(usuario: Usuario)

    // Implementacion de la funcion para buscar un usuario por email y password
    @Query("SELECT * FROM usuario_entity WHERE mail = :email AND password = :password LIMIT 1")
    fun login(email: String, password: String): Usuario?
}