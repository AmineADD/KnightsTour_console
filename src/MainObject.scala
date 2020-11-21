

object MainObject {


  def main(args: Array[String]) {

    val startTimeMillis = System.currentTimeMillis()

    /* Traitement */
    val euler = new CavalierEuler(10)
    euler.controleur(0,0)
    println(euler)

    /* Temps */
    val endTimeMillis = System.currentTimeMillis()
    val durationSeconds = (endTimeMillis - startTimeMillis)

    println(durationSeconds+" TimeMillis")

  }
}
