class PieceCol(etiquette_ : String,codeAnsi_ : String) extends Piece {

   var etiquette : String = etiquette_;
   var codeAnsi : String = codeAnsi_ ;

   def this(etiquette_ : String)={
     this(etiquette_,Ansi.code("Normal"));
   }



  override def toString = s"${Ansi.fBlack}$codeAnsi${etiquette}${Ansi.reset}"

  override def length: Int = etiquette_.length;
}
object PieceCol {

  def apply(etiquette_ : String): PieceCol = {
      new PieceCol(etiquette_)
  }
  def apply(etiquette_ : String,codeAnsi_ : String): PieceCol = {
     new PieceCol(etiquette_,codeAnsi_)
  }

}
