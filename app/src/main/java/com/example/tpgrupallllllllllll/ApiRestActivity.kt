package com.example.tpgrupallllllllllll

import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.PopupMenu
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tpgrupallllllllllll.dtos.GameDTO
import retrofit2.Call
import retrofit2.Response

class ApiRestActivity : AppCompatActivity() {

    private lateinit var tvServicioRest: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_api_rest)

        // inicializar el TextView
        tvServicioRest = findViewById(R.id.tvServicioRest)
        tvServicioRest.text = "Cargando datos..." // Mensaje de carga inicial

        // Ejecutar la llamada API
        val api = RetrofitClient.retrofit.create(ApiEndpoints::class.java)
        val callGetDetails = api.getDetails()

        callGetDetails.enqueue(object : retrofit2.Callback<List<GameDTO>> {
            override fun onResponse(call: Call<List<GameDTO>>, response: Response<List<GameDTO>>) {
                if (response.isSuccessful) {
                    val games = response.body()

                    if (games != null && games.isNotEmpty()) {
                        // Mostrar la lista de juegos
                        val gameListText = games.joinToString(separator = "\n\n") { game ->
                            "Titulo: ${game.title}\n" +
                                    "Descripcion: ${game.short_description}\n" +
                                    "Lanzamiento: ${game.release_date}\n" +
                                    "Desarrollador: ${game.developer}\n" +
                                    "Genero: ${game.genre}\n" +
                                    "Plataforma: ${game.platform}"
                        }
                        tvServicioRest.text = gameListText // Actualiza el TextView con los datos
                    }
                }
            }

            override fun onFailure(call: Call<List<GameDTO>>, t: Throwable) {
                Log.e("Error", t.message ?:"Error.")
            }
        })
        // TOOLBAR

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
}