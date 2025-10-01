package com.example.tpgrupallllllllllll
import Juego
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.core.content.ContextCompat.startActivity

class JuegoAdapter (var juego: MutableList<Juego>, var context: Context) : RecyclerView.Adapter<JuegoAdapter.JuegoViewHolder>(){

    class JuegoViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val txtJuego: TextView
        val txtLanzamiento: TextView
        val txtGenero: TextView
        val txtValoracion: TextView
        val txtPrecio: TextView
        val tituloNombre: TextView
        val tituloLanzamiento: TextView
        val tituloGenero: TextView
        val tituloValoracion: TextView
        val tituloPrecio: TextView

        init{
            txtJuego = view.findViewById(R.id.tv_juego)
            txtLanzamiento = view.findViewById(R.id.tv_lanzamiento)
            txtGenero = view.findViewById(R.id.tv_genero)
            txtValoracion = view.findViewById(R.id.tv_valoracion)
            txtPrecio = view.findViewById(R.id.tv_precio)

            tituloGenero = view.findViewById(R.id.tvLabelGenero)
            tituloNombre = view.findViewById(R.id.tvLabelNombre)
            tituloValoracion = view.findViewById(R.id.tvLabelValoracion)
            tituloPrecio = view.findViewById(R.id.tvLabelPrecio)
            tituloLanzamiento = view.findViewById(R.id.tvLabelLanzamiento)
        }
    }

    override fun getItemCount() = juego.size

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): JuegoViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_juegos,viewGroup,false)

        return JuegoViewHolder(view)
    }

    override fun onBindViewHolder(holder: JuegoViewHolder, position: Int) {
        val item = juego.get(position)
        holder.txtJuego.text = item.juego
        holder.txtJuego.text = item.juego
        holder.txtLanzamiento.text = item.lanzamiento
        holder.txtLanzamiento.text = item.lanzamiento
        holder.txtValoracion.text = item.valoracion
        holder.txtValoracion.text = item.valoracion
        holder.txtPrecio.text = item.precio
        holder.txtPrecio.text = item.precio
        holder.txtGenero.text = item.genero
        holder.txtGenero.text = item.genero

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetalleJuegoActivity::class.java)
            intent.putExtra("juego", item)
            holder.itemView.context.startActivity(intent)
        }
    }

}