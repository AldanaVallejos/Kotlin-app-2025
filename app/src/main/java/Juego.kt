import java.io.Serializable

data class Juego(
    var id: Int,
    var juego: String,
    var lanzamiento: String,
    var genero: String,
    var precio: String,
    var valoracion: String
) : Serializable
