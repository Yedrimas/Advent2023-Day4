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

    def sumWinningCards(input: Iterable[String]): Int = {
        val cards = Card.getCards(
            input
        )
        cards.flatMap(c => getWinningCardsFrom(c, cards)).toSeq.length
    }

    def getWinningCardsFrom(card: Card, cards: Iterable[Card]): Seq[Card] = {
        val winners = card.getWinningNumber.length
        val winnerCardsNo = (card.cardNumber until card.cardNumber + winners).map(_ + 1)
        val winnerCards = cards.filter(c => winnerCardsNo.contains(c.cardNumber))
        Seq(card) ++ winnerCards.flatMap(c => getWinningCardsFrom(c, cards))
    }

}
