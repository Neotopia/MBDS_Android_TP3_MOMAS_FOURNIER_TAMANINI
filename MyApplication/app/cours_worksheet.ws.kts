data class Neighbor(
    val firstName: String,
    val lastName: String
)

// On ajoute une extension sur la classe String
fun String.concat(text: String){
    println("$this $text")
}

val maString = "Ma string"
maString.concat("Hello")


fun Neighbor.fullname() = "$firstName $lastName"

val neighbor = Neighbor("Kostas", "Mitroglou")

println(neighbor.fullname())


