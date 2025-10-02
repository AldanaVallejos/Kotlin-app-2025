package com.example.tpgrupallllllllllll

import Juego
import android.content.Intent
import android.os.Bundle
<<<<<<< HEAD
import android.widget.ImageButton
import android.widget.PopupMenu
=======
import android.widget.Button
>>>>>>> ec4c174befe31234fd1ce89225824396ff981ce9
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

<<<<<<< HEAD
=======

>>>>>>> ec4c174befe31234fd1ce89225824396ff981ce9
class ListadoJuegos : AppCompatActivity() {
    lateinit var rvJuegos: RecyclerView
    lateinit var juegosAdapter: JuegoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_listado_juegos)
<<<<<<< HEAD

        // Ajuste de paddings para edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // RecyclerView
=======
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            return@setOnApplyWindowInsetsListener insets
        }

>>>>>>> ec4c174befe31234fd1ce89225824396ff981ce9
        rvJuegos = findViewById(R.id.rvJuegos)
        juegosAdapter = JuegoAdapter(getJuegos(), context = this)
        rvJuegos.adapter = juegosAdapter

<<<<<<< HEAD

        // TOOLBAR
=======
>>>>>>> ec4c174befe31234fd1ce89225824396ff981ce9
        val toolbar: Toolbar = findViewById(R.id.myToolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

<<<<<<< HEAD
        // Botón atrás
        val backButton = findViewById<ImageButton>(R.id.btn_ToolBar_Volver)
        backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // Botón menú desplegable
        val menuButton = findViewById<ImageButton>(R.id.btn_ToolBar_Menu)
        menuButton.setOnClickListener { view ->
            val popupMenu = PopupMenu(this, view)
            popupMenu.menu.add("Cerrar sesión")
            popupMenu.setOnMenuItemClickListener { item ->
                if (item.title == "Cerrar sesión") {
                    val prefs = getSharedPreferences("myPrefs", MODE_PRIVATE)
                    prefs.edit().putString("user", "").apply()
                    finishAffinity()
                   //  startActivity(Intent(this, MainActivity::class.java)) -> VOLVER A LA PANTALLA INICIAL
                }
                true
            }
            popupMenu.show()
        }
    }

    private fun getJuegos(): MutableList<Juego> {
        val juegos: MutableList<Juego> = ArrayList()
        juegos.add(Juego(id = 1, juego = "The Sims 4", lanzamiento = "2014-09-02", precio = "Gratuito", genero = "Simulacion", valoracion = "4/5"))
        juegos.add(Juego(id = 2, juego = "Subnautica", lanzamiento = "2018-01-23", precio = "$20.99", genero = "Supervivencia", valoracion = "3/5"))
        juegos.add(Juego(id = 3, juego = "Monopoly", lanzamiento = "2024-09-26", precio = "$23.99", genero = "Estrategia", valoracion = "2/5"))
        juegos.add(Juego(id = 4, juego = "Hollow Knight", lanzamiento = "2017-02-24", precio = "$4.99", genero = "Plataformas", valoracion = "4/5"))
=======
        lateinit var toolbarBackButton: Button
        toolbarBackButton = findViewById(R.id.btn_ToolBar)
        toolbarBackButton.setOnClickListener {
            onBackPressed()
        }


        }
    private fun getJuegos(): MutableList<Juego> {
        var juegos: MutableList<Juego> = ArrayList()
        juegos.add(Juego(id = 1, juego = "The Sims 4", lanzamiento = "2014-09-02", precio = "Gratuito", genero = "Simulacion", valoracion = "4/5"))
        juegos.add(Juego(id = 2, juego = "Subnautica", lanzamiento = "2018-01-23", precio = "$20.99", genero = "Supervivencia", valoracion = "3/5"))
        juegos.add(Juego(id = 3, juego = "Monopoly", lanzamiento = "2024-09-26", precio = "$23.99", genero = "Estrategia", valoracion = "2/5"))
        juegos.add(Juego(id = 4, juego = "Hollow Knight", lanzamiento = "2017-02-24", precio = "%4.99", genero = "Plataformas", valoracion = "4/5"))
>>>>>>> ec4c174befe31234fd1ce89225824396ff981ce9
        juegos.add(Juego(id = 5, juego = "Palia", lanzamiento = "2024-03-25", precio = "Gratuito", genero = "Multijugador", valoracion = "4/5"))
        juegos.add(Juego(id = 6, juego = "It Takes Two", lanzamiento = "2021-03-26", precio = "$39.99", genero = "Cooperativo", valoracion = "5/5"))
        juegos.add(Juego(id = 7, juego = "Undertale", lanzamiento = "2015-09-15", precio = "$1.49", genero = "Rol", valoracion = "4/5"))
        return juegos
    }
<<<<<<< HEAD
}
=======
    }
>>>>>>> ec4c174befe31234fd1ce89225824396ff981ce9
