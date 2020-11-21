object Ansi {
    val black = "\u001B[30m"
    val red = "\u001B[31m"
    val green = "\u001B[32m"
    val yellow = "\u001B[33m"
    val blue = "\u001B[34m"
    val cyan = "\u001B[36m"
    val white = "\u001B[37m"
    val fBlack = "\u001B[40m"
    val fRed = "\u001B[41m"
    val fGreen = "\u001B[42m"
    val fYellow = "\u001B[43m"
    val fBlue = "\u001B[44m"
    val fCyan = "\u001B[46m"
    val fWhite = "\u001B[47m"
    val reset = "\u001B[0m"

  def code(code_ : String) :String ={
    code_ match {
      case "Normal" => return this.fBlack+this.white;
    }
  }
}
