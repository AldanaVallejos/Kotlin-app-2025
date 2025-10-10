package com.example.tpgrupallllllllllll

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Usuario::class], version = 1)

abstract class AppDatabase: RoomDatabase()  {
    abstract fun UsuarioDao(): UsuarioDao

    companion object{
        private var INSTANCIA: AppDatabase? = null
        //llamo a la variable
        fun getDatabase(context: Context): AppDatabase {
            //si es nulo, creo la instancia de la base de datos, sino retorno la instancia que ya existe.
            //SINGLETON
            if(INSTANCIA == null){
                synchronized(this){
                    INSTANCIA = Room.databaseBuilder(
                        context,
                        AppDatabase::class.java, "usuarios_database")
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCIA!!
        }
    }

}