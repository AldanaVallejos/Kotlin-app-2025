package com.example.tpgrupallllllllllll
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuario_entity")
data class Usuario(
    @ColumnInfo("usuario") var usuario : String,
    @ColumnInfo("mail") var mail: String,
    @ColumnInfo("password")var password: String,
){
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}