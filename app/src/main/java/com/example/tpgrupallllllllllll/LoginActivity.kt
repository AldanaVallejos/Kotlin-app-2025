package com.example.tpgrupallllllllllll

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    //variables
    lateinit var etUsuario: EditText
    lateinit var etPassword: EditText
    lateinit var cbRecordarUsuario: CheckBox
    lateinit var bntIrRegistro: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etUsuario = findViewById<EditText>(R.id.etUsuario)
        val etPassword= findViewById<EditText>(R.id.etPassword)
        val cbRecordarUsuario=findViewById<CheckBox>(R.id.cbRecordarUsuario)
        val btnIrRegistro = findViewById<Button>(R.id.btnIrRegistro)
        val btnIrListadoJuegos=findViewById<Button>(R.id.btnIrListadoJuegos)

        val prefs = getSharedPreferences("cb_usuario", MODE_PRIVATE)
        val usuarioGuardado = prefs.getString("usuario", "")
        val recordar = prefs.getBoolean("recordar", false)

        if (recordar) {
            etUsuario.setText(usuarioGuardado)
            cbRecordarUsuario.isChecked = true
        }

        btnIrListadoJuegos.setOnClickListener {
            val usuario = etUsuario.text.toString()
            val editor = prefs.edit()

            if (cbRecordarUsuario.isChecked) {
                // guardo usuario
                editor.putString("usuario", usuario)
                editor.putBoolean("recordar", true)
            } else {
                // elimino el usuario
                editor.putString("usuario", "")
                editor.putBoolean("recordar", false)
            }
            editor.apply()

            // INTENT para pasar a ListadoJuegos
            val intent = Intent(this, ListadoJuegos::class.java)
            startActivity(intent)
        }

        btnIrRegistro.setOnClickListener {
            // INTENT para pasar al registro
            val intent2 = Intent(this, RegistroActivity::class.java)
            startActivity(intent2)
        }


    }
}