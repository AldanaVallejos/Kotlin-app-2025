package com.example.tpgrupallllllllllll

import android.content.Intent
import android.os.Bundle
<<<<<<< HEAD
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
=======
import android.widget.Button
import android.widget.EditText
>>>>>>> ec4c174befe31234fd1ce89225824396ff981ce9
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registro)
<<<<<<< HEAD

=======
>>>>>>> ec4c174befe31234fd1ce89225824396ff981ce9
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

<<<<<<< HEAD
        // CONFIGURAR TOOLBAR
        val toolbar: Toolbar = findViewById(R.id.myToolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val backButton = findViewById<ImageButton>(R.id.btn_ToolBar_Volver)
        backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // OCULTAR BOTÓN DE MENÚ
        val menuButton = findViewById<ImageButton>(R.id.btn_ToolBar_Menu)
        menuButton.visibility = View.GONE

        // REFERENCIAS DEL FORMULARIO
=======
        // Referencias
>>>>>>> ec4c174befe31234fd1ce89225824396ff981ce9
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)

        btnRegistrar.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (nombre.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(this, "Usuario $nombre registrado correctamente", Toast.LENGTH_LONG)
                    .show()
                val intent = Intent(this, ListadoJuegos::class.java)
                startActivity(intent)
<<<<<<< HEAD
            }
        }
    }
}

=======

            }

            val toolbar: Toolbar = findViewById(R.id.myToolbar)
            setSupportActionBar(toolbar)
            supportActionBar?.setDisplayShowTitleEnabled(false)

            lateinit var toolbarBackButton: Button
            toolbarBackButton = findViewById(R.id.btn_ToolBar)
            toolbarBackButton.setOnClickListener {
                onBackPressed()
            }


        }
    }

}
>>>>>>> ec4c174befe31234fd1ce89225824396ff981ce9
