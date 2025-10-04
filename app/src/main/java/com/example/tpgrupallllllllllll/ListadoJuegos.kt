package com.example.tpgrupallllllllllll

import Juego
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import android.widget.ImageButton

class ListadoJuegos : AppCompatActivity() {
    lateinit var rvJuegos: RecyclerView
    lateinit var juegosAdapter: JuegoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_listado_juegos)

        // Ajuste de paddings para edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // RecyclerView
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            return@setOnApplyWindowInsetsListener insets
        }

        rvJuegos = findViewById(R.id.rvJuegos)
        juegosAdapter = JuegoAdapter(getJuegos(), context = this)
        rvJuegos.adapter = juegosAdapter


        // TOOLBAR

        //TOOLBAR
        val toolbar: Toolbar = findViewById(R.id.myToolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

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

        }
    private fun getJuegos(): MutableList<Juego> {
        var juegos: MutableList<Juego> = ArrayList()
        juegos.add(Juego(
            id = 1,
            juego = "The Sims 4",
            lanzamiento = "2014-09-02",
            precio = "Gratuito",
            genero = "Simulacion",
            valoracion = "4/5",
            imagen = R.drawable.thesims))
        juegos.add(Juego(
            id = 2,
            juego = "Subnautica",
            lanzamiento = "2018-01-23",
            precio = "$20.99",
            genero = "Supervivencia",
            valoracion = "3/5",
            imagen = R.drawable.subnautica))
        juegos.add(Juego(
            id = 3,
            juego = "Monopoly",
            lanzamiento = "2024-09-26",
            precio = "$23.99",
            genero = "Estrategia",
            valoracion = "2/5",
            imagen = R.drawable.monopoly))
        juegos.add(Juego(
            id = 4,
            juego = "Hollow Knight",
            lanzamiento = "2017-02-24",
            precio = "$4.99",
            genero = "Plataformas",
            valoracion = "4/5",
            imagen = R.drawable.hollow))
        juegos.add(Juego(
            id = 5,
            juego = "Palia",
            lanzamiento = "2024-03-25",
            precio = "Gratuito",
            genero = "Multijugador",
            valoracion = "4/5",
            imagen = R.drawable.palia))
        juegos.add(Juego(
            id = 6,
            juego = "It Takes Two",
            lanzamiento = "2021-03-26",
            precio = "$39.99",
            genero = "Cooperativo",
            valoracion = "5/5",
            imagen = R.drawable.ittakes))
        juegos.add(Juego(
            id = 7,
            juego = "Undertale",
            lanzamiento = "2015-09-15",
            precio = "$1.49",
            genero = "Rol",
            valoracion = "4/5",
            imagen = R.drawable.undertale))
        return juegos
    }

