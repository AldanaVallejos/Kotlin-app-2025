package com.example.tpgrupallllllllllll

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast
import androidx.core.app.ActivityCompat

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

        //  CHECKBOX (PERMISOS de NOTIFICACIÓN y Servicio)
        cbRecordarUsuario.setOnClickListener {
            val activar = cbRecordarUsuario.isChecked

            // Verificar permisos de notificación
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
                ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.POST_NOTIFICATIONS // GARANTIZA LOS PERMISOS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.POST_NOTIFICATIONS), // RE-PREGUNTA
                    101
                )
            } else {
                // Crear Intent con extra "activar"
                val intent = Intent(this, ServicioRecordarUsuario::class.java)
                intent.putExtra("activar", activar)
                startService(intent)
            }
        }


// INCORPORACION DEL FUNCIONAMIENTO LOGIN
        btnIrListadoJuegos.setOnClickListener {
            val usuarioIngresado = etUsuario.text.toString().trim()
            val passwordIngresado = etPassword.text.toString().trim()

            if (usuarioIngresado.isEmpty() || passwordIngresado.isEmpty()) {
                Toast.makeText(this, "Ingresa tu usuario y contraseña", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // OBTENGO LA BASE DE DATOS PARA CONSULTAR
            val db = AppDatabase.getDatabase(this)

            // Llamo a la función login del DAO
            val usuarioEncontrado = db.UsuarioDao().login(usuarioIngresado, passwordIngresado)

            if(usuarioEncontrado != null){
                // SHARED PREFERENCES PARA EL CHECKBOX
                val prefsRecordar = getSharedPreferences("cb_usuario", MODE_PRIVATE)
                val editorRecordar = prefsRecordar.edit()

                if(cbRecordarUsuario.isChecked){
                    // Guardar usuario si se marco recordar
                    editorRecordar.putString("usuario", usuarioIngresado)
                    editorRecordar.putBoolean("recordar", true)
                } else {
                    // No guardo el usuario
                    editorRecordar.putString("usuario", "")
                    editorRecordar.putBoolean("recordar", false)
                }
                editorRecordar.apply()

                // El login es correcto
                val intent = Intent(this, ListadoJuegos::class.java)
                startActivity(intent)

            } else {
                // El login es incorrecto
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
