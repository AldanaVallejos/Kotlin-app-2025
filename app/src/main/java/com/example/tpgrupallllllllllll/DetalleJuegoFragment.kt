package com.example.tpgrupallllllllllll

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment



class DetalleJuegoFragment : Fragment(R.layout.fragment_detalle_juego) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnFavorito = view.findViewById<ImageButton>(R.id.btnFavorito)
        val btnComentario = view.findViewById<ImageButton>(R.id.btnComentario)
        val btnBloquear = view.findViewById<ImageButton>(R.id.btnBloquear)

        //OPCIOENS DE BOTONES
        btnFavorito.setOnClickListener {
            Toast.makeText(requireContext(), "Haz apretado 'Agregar como Favorito'", Toast.LENGTH_SHORT).show()
        }

        btnComentario.setOnClickListener {
            Toast.makeText(requireContext(), "Haz apretado 'Agregar un Comentario'", Toast.LENGTH_SHORT).show()
        }

        btnBloquear.setOnClickListener {
            Toast.makeText(requireContext(), "Haz apretado 'Bloquear Juego'", Toast.LENGTH_SHORT).show()
        }
    }
}