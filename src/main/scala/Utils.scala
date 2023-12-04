import scala.io.Source

case object Utils {

    def readInput(fName: String): Seq[String] = {
        Source
          .fromResource(fName)
          .mkString
          .split("\n")
          .toSeq
    }



    def sumWinningScores(input: Iterable[String]): Double = {
        Card.getCards(
            input
        ).map(_.getWinningScore)
          .sum
    }

}
