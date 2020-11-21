object Cavalier {
  def apply():Option[PieceCol] = Some(new PieceCol("caval"))
}
object Dame {
  def apply(): Option[PieceCol] = {
    Some(PieceCol("dame",Ansi.red))
  }
}

object Fou {
  def apply(): Option[PieceCol] = {
    Some(PieceCol("fou",Ansi.green));
  }
}

object Pion {
  def apply():Option[PieceCol] = {
    Some( PieceCol("pion",Ansi.cyan));
  }
}

object Rien {
  def apply():Option[PieceCol] = {
   None ;
  }
}