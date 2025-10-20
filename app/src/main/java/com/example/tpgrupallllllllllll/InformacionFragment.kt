package com.example.tpgrupallllllllllll

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class InformacionFragment : Fragment(R.layout.fragment_informacion) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvSoporte = view.findViewById<TextView>(R.id.tvSoporte)
        val tvTerminosyCondiciones = view.findViewById<TextView>(R.id.tvTerminosyCondiciones)

        tvSoporte.setOnClickListener {
            Toast.makeText(requireContext(), "Haz apretado 'Ir a Soporte'", Toast.LENGTH_SHORT).show()
        }

        tvTerminosyCondiciones.setOnClickListener {
            Toast.makeText(requireContext(), "Haz apretado 'Ir a Términos y Condiciones'", Toast.LENGTH_SHORT).show()
        }
    }
}
