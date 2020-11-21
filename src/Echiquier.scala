import java.util

import sun.security.util.Length

import scala.reflect.ClassTag

class Echiquier[P <: Piece: ClassTag](cote_ : Int){

  private var plateau:Array[Array[Option[P]]] =  Array.fill[Option[P]](cote_,cote_)(None);
  final var CONSTANT_SPACE:String="     ";


  def this() = {
    this(8);//un échiquier fait 8 cases de côté.
  }

  for( i <- 0 to cote_ -1 ; j <- 0 to cote_ -1) this.vider(i,j)

  def placerEn(piece_ :P,x_ : Int,y_ : Int): Unit ={
    plateau(x_)(y_)=Some(piece_);
  }

  def update(coupleXY:Tuple2[Int,Int],piece_ :Option[P]): Unit = {
    plateau(coupleXY._1)(coupleXY._2)=piece_;
  }
  def apply(coupleXY : Tuple2[Int,Int]): Option[P] ={
     plateau(coupleXY._1)(coupleXY._2)
  }

  def vider(x_ : Int, y_ : Int) :Unit={
    plateau(x_)(y_)=None;
  }


  override def toString :String   = {
    var place = lance()
    place +=draw_columns()
    trace(place)
  }
  def tab(): String ={
    " "
  }
  def lance():String={
    "    "+String.valueOf(0)
  }
  def trace(place_ : String):String={
    var place:String = place_
    for( i <- 0 to cote_ *2) {
      if(i%2==0){
        place += tab + Ansi.fBlue
        for(j <- 0 to cote_ -1) {
          place += CONSTANT_SPACE+tab()
        }
        place+= tab() + Ansi.reset + "\n"
      }
      else{
        place += i/2;
        for(j <- 0 to cote_ -1) {
          place += Ansi.fBlue + tab()+ Ansi.reset
          if( plateau(i/2)(j) != None){
            var piece = plateau(i/2)(j).get
            if(piece.length>5){
              place += piece.toString().slice(5,10)
            }else{
              place += piece
            }
            for(k<-1 to 5-plateau(i/2)(j).get.length)(place+=Ansi.fBlack+tab()+Ansi.reset)

          }
          else{
            place += CONSTANT_SPACE
          }
        }
        place += Ansi.fBlue + tab() + Ansi.reset + "\n"
      }
    }
    place
  }
  def draw_columns():String={
    var place:String=""
    for( i <- 1 to cote_ -1) {place += CONSTANT_SPACE + i}
    place+= "\n"

    place
  }


}

