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
            // sharedpreferences
            val prefs = getSharedPreferences("usuariosApp", MODE_PRIVATE)
            val usuarioIngresado = etUsuario.text.toString().trim()
            val passwordIngresado = etPassword.text.toString().trim()

            //INCORPORACION DEL FUNCIONAMIENTO REGISTRO
            // Verificar si existe en SharedPreferences
            val passwordGuardado = prefs.getString(usuarioIngresado, null)

            if(passwordGuardado != null && passwordGuardado == passwordIngresado){
                // Guardar usuario si se marcó "recordar"
                val editor = prefs.edit()
                if(cbRecordarUsuario.isChecked){
                    editor.putString("usuario", usuarioIngresado)
                    editor.putBoolean("recordar", true)
                } else {
                    editor.putString("usuario", "")
                    editor.putBoolean("recordar", false)
                }
                editor.apply()

                // Login correcto
                val intent = Intent(this, ListadoJuegos::class.java)
                startActivity(intent)

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
