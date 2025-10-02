package com.example.tpgrupallllllllllll

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ImageButton

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


        // CONFIGURAR TOOLBAR


        //TOOLBAR

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
                //IMPLEMENTACION BASE DE DATOS
                var nuevoUsuario = Usuario(nombre,email,password)
                AppDatabase.getDatabase(applicationContext).UsuarioDao().insert(nuevoUsuario)
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


            }



        }
    }

}