package com.example.tpgrupallllllllllll

import Juego
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class DetalleJuegoActivity : AppCompatActivity() {
    lateinit var myToolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_juego)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar: Toolbar = findViewById(R.id.myToolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        lateinit var toolbarBackButton: Button
        toolbarBackButton = findViewById(R.id.btn_ToolBar)
        toolbarBackButton.setOnClickListener {
            onBackPressed()
        }

        val juego = intent.getSerializableExtra("juego") as Juego

        findViewById<TextView>(R.id.tvDetalleNombre).text = juego.juego
        findViewById<TextView>(R.id.tvDetalleFecha).text = juego.lanzamiento
        findViewById<TextView>(R.id.tvDetallePrecio).text = juego.precio
        findViewById<TextView>(R.id.tvDetalleGenero).text = juego.genero
        findViewById<TextView>(R.id.tvDetalleValoracion).text = juego.valoracion
    }
}