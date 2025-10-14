package com.example.tpgrupallllllllllll

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // TOOLBAR

        // Botón atrás
        val backButton = findViewById<ImageButton>(R.id.btn_ToolBar_Volver)
        backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }


        // OCULTAR BOTÓN DE MENÚ
        val menuButton = findViewById<ImageButton>(R.id.btn_ToolBar_Menu)
        menuButton.visibility = View.GONE





        // Referencias
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
                // Guardar usuario en SharedPreferences FUNCIONAMIENTO REGISTRO
                val prefs = getSharedPreferences("usuariosApp", MODE_PRIVATE)
                val editor = prefs.edit()
                editor.putString(email, password) // clave = email, valor = password
                editor.apply()
                startActivity(intent)

            }

        }
    }

}
