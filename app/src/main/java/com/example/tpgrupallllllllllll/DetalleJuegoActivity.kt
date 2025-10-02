package com.example.tpgrupallllllllllll

import Juego
<<<<<<< HEAD
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.PopupMenu
=======
import android.os.Bundle
import android.widget.Button
>>>>>>> ec4c174befe31234fd1ce89225824396ff981ce9
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
<<<<<<< HEAD

class DetalleJuegoActivity : AppCompatActivity() {
=======
import androidx.recyclerview.widget.RecyclerView

class DetalleJuegoActivity : AppCompatActivity() {
    lateinit var myToolbar: Toolbar
>>>>>>> ec4c174befe31234fd1ce89225824396ff981ce9
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_juego)

<<<<<<< HEAD
        // Ajuste de paddings para edge-to-edge
=======
>>>>>>> ec4c174befe31234fd1ce89225824396ff981ce9
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

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
                   // startActivity(Intent(this, loginActivity::class.java)) -> VOLVER A LA PANTALLA INICIAL
                }
                true
            }
            popupMenu.show()
        }

        // Mostrar datos del juego
        val juego = intent.getSerializableExtra("juego") as Juego
=======
        lateinit var toolbarBackButton: Button
        toolbarBackButton = findViewById(R.id.btn_ToolBar)
        toolbarBackButton.setOnClickListener {
            onBackPressed()
        }

        val juego = intent.getSerializableExtra("juego") as Juego

>>>>>>> ec4c174befe31234fd1ce89225824396ff981ce9
        findViewById<TextView>(R.id.tvDetalleNombre).text = juego.juego
        findViewById<TextView>(R.id.tvDetalleFecha).text = juego.lanzamiento
        findViewById<TextView>(R.id.tvDetallePrecio).text = juego.precio
        findViewById<TextView>(R.id.tvDetalleGenero).text = juego.genero
        findViewById<TextView>(R.id.tvDetalleValoracion).text = juego.valoracion
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> ec4c174befe31234fd1ce89225824396ff981ce9
