package com.example.tpgrupallllllllllll

import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.PopupMenu
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.tpgrupallllllllllll.dtos.GameDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ApiRestActivity : AppCompatActivity() {

    private lateinit var tvServicioRest: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_api_rest)

        //Inicializar para mostrar los datos
        tvServicioRest = findViewById(R.id.tvServicioRest)
        tvServicioRest.text = "Cargando datos..."

        // 1. Iniciar la llamada API usando corrutinas
        fetchGamesWithCoroutines()

        //TOOLBAR
        setupToolbar()
    }
    private fun setupToolbar() {
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
    }

    // Nueva funcion para manejar corrutinas
    private fun fetchGamesWithCoroutines() {
        // lifecycleScope.launch para iniciar la corrutina en el hilo principal
        lifecycleScope.launch {
            try {
                // Mover la ejecucion al hilo
                val games: List<GameDTO> = withContext(Dispatchers.IO) {
                    val api = RetrofitClient.retrofit.create(ApiEndpoints::class.java)
                    // Llamada a la funcion 'suspend' de Retrofit
                    api.getDetails()
                }

                if (games.isNotEmpty()) {
                    // Mostrar la lista de juegos
                    val gameListText = games.joinToString(separator = "\n\n") {     game ->
                        "Titulo: ${game.title ?: "N/A"}\n" +
                                "Descripcion: ${game.short_description ?: "N/A"}\n" +
                                "Lanzamiento: ${game.release_date ?: "N/A"}\n" +
                                "Desarrollador: ${game.developer ?: "N/A"}\n" +
                                "Genero: ${game.genre ?: "N/A"}\n" +
                                "Plataforma: ${game.platform ?: "N/A"}"
                    }
                    tvServicioRest.text = gameListText
                    Log.d("API_Coroutines", "Datos cargados correctamente.")
                } else {
                    tvServicioRest.text = "La lista de juegos está vacía."
                }

            } catch (e: Exception) {
                Log.e("API_Coroutines", "Fallo al obtener datos")
            }
        }
    }
}