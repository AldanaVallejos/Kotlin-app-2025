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
import android.widget.Toast

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

        // INCORPORACION DEL FUNCIONAMIENTO LOGIN
        btnIrListadoJuegos.setOnClickListener {
            val usuarioIngresado = etUsuario.text.toString().trim()
            val passwordIngresado = etPassword.text.toString().trim()
            val editor = prefs.edit()

            // Ejemplo de usuarios momentaneamente
            val usuarios = hashMapOf(
                "usuario1" to "123",
                "usuario2" to "123",
                "admin" to "1234"
            )

            // Validación
            if(usuarios.containsKey(usuarioIngresado) && usuarios[usuarioIngresado] == passwordIngresado) {
                // Guardar usuario si se marcó "recordar"
                if(cbRecordarUsuario.isChecked){
                    editor.putString("usuario", usuarioIngresado)
                    editor.putBoolean("recordar", true)
                } else {
                    editor.putString("usuario", "")
                    editor.putBoolean("recordar", false)
                }
                editor.apply()

                // Si el login es correcto, va al listado
                val intent = Intent(this, ListadoJuegos::class.java)
                startActivity(intent)
                finish() // se cierra el login
            } else {
                // Login incorrecto
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }

        btnIrRegistro.setOnClickListener {
            // INTENT para pasar al registro
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }


    }
}