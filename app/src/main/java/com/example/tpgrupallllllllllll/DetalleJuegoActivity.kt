package com.example.tpgrupallllllllllll

import  Juego
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalleJuegoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_juego)

        // Ajuste de paddings para edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // TOOLBAR
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
                }
                true
            }
            popupMenu.show()
        }

        // Mostrar datos del juego
        val juego = intent.getSerializableExtra("juego") as Juego

        //agrego la imagen
        val imagenView = findViewById<ImageView>(R.id.ivDetalleJuegoImagen)
        imagenView.setImageResource(juego.imagen)

        findViewById<TextView>(R.id.tvDetalleNombre).text = juego.juego
        findViewById<TextView>(R.id.tvDetalleFecha).text = juego.lanzamiento
        findViewById<TextView>(R.id.tvDetallePrecio).text = juego.precio
        findViewById<TextView>(R.id.tvDetalleGenero).text = juego.genero
        findViewById<TextView>(R.id.tvDetalleValoracion).text = juego.valoracion
    }

    //IMPLEMENTACIÓN DEL FRAGMENT
    class DetalleJuegoActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_detalle_juego)

            if (savedInstanceState == null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentDetalleJuegoContainer, DetalleJuegoFragment())
                    .commit()
            }
        }
    }
}
