import scala.util.Random

class CavalierEuler(cote_ : Int) {
    var vue:Echiquier[PieceCol] = new Echiquier[PieceCol](cote_);
    var modele : Array[Array[Int]]  = Array.fill(cote_,cote_)(0);
    var START = 1;
    val heuristique = Array.fill(cote_, cote_)(0)



  /*2. Scala nous permet de fairel’économie d’une classe supplémentaire : une méthode,*/
  def controleur(xy_ : Tuple2[Int, Int]){
    trouvePositions(xy_,START);
     synchroniseVueAuModele();

    /*3. Fabriquez la fonction locale def trouveDeplacementsCavalier*/
      def trouveDeplacementsCavalier(xy_ : Tuple2[Int, Int]): List[Tuple2[Int, Int]] ={
        var list:List[Tuple2[Int,Int]] = List[Tuple2[Int,Int]]()
        // X et Y peut jamais etre hors de ces valeurs
        val Posiblities:Array[Tuple2[Int, Int]]  = Array(

          Tuple2(1,2), Tuple2(1,-2),  Tuple2(2,1), Tuple2(2,-1), Tuple2(-1,2),Tuple2(-1,-2), Tuple2(-2,1), Tuple2(-2,-1));

        Posiblities.foreach((p:Tuple2[Int, Int])=>{
          try{
            list = list:+Tuple2((xy_._1+p._1),(xy_._2+p._2));
          }catch {
            case e:Exception=>
          }
        });
        //Filter
        list.filter{entry:Tuple2[Int,Int]=>(entry._1<cote_ && entry._2<cote_ && entry._1>=0 && entry._2>=0 )}
      }

    /*4. Fabriquez la fonction locale def trouvePositions*/
    def trouvePositions(xy_ :(Int, Int), etape_ :Int) :Boolean = {
      var resultat = false
      this.modele(xy_._1)(xy_._2) = etape_
      if(etape_ == (cote_ * cote_)) {
        resultat = true
      }
      else {
        /*la recherche en utilisant une heuristique*/
        trouveDeplacementsCavalier(xy_).sortWith(trouveDeplacementsCavalier(_).length < trouveDeplacementsCavalier(_).length).foreach { xy =>
          heuristique(xy._1)(xy._2)=trouveDeplacementsCavalier(xy).length;
          if(this.modele(xy._1)(xy._2) == 0) {
            resultat = trouvePositions(xy, etape_ + 1)
            if(!resultat) {
              this.modele(xy._1)(xy._2) = 0
            }
          }
        }
        if(!resultat) this.modele(xy_._1)(xy_._2) = 0
      }
      resultat
    }


    def synchroniseVueAuModele(){
        for( i <- 0 to cote_ -1 ; j <- 0 to cote_ -1) vue((i,j))=Option[PieceCol](PieceCol(String.valueOf(modele(i)(j))));
      }

    }


  override def toString = s"$vue"
}
