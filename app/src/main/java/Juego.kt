import java.io.Serializable

data class Juego(
    var juego: String,
    var lanzamiento: String,
    var genero: String,
    var precio: String,
    var valoracion: String,
    val id: Int,
    val imagen: Int,
) : Serializable
