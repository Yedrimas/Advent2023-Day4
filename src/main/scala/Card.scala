case class Card(
                 cardNumber: Int,
                 winningNumbers: Iterable[Int],
                 ourNumbers: Iterable[Int],
               ) {

    def getWinningNumber: Seq[Int] = {
        winningNumbers.toSeq.intersect(ourNumbers.toSeq)
    }

    def getWinningScore: Double = if (getWinningNumber.nonEmpty) Math.pow(2, getWinningNumber.length - 1) else 0
}

case object Card {

    def getCards(input: Iterable[String]): Iterable[Card] = {
        input.map { line =>
            Card.parseCard(line)
        }
    }

    def getCardNumber(noPart: String): Int = {
        val r = "Card.*?([0-9]+).*?".r
        noPart match {
            case r(number) => number.trim.toInt
            case _ => throw new Exception(f"Could not match '$noPart''")
        }
    }

    def getSides(contentPart: String): (Iterable[Int], Iterable[Int]) = {
        val twoParts = contentPart
          .split('|')
          .map(side => {
              side
                .trim
                .split(" ")
                .filter(_.nonEmpty)
                .map(_.trim)
                .map(_.toInt)
          })
        (twoParts.head, twoParts(1))
    }

    def parseCard(line: String): Card = {
        val lSplit = line.split(":")

        val noPart = lSplit.head
        val contentPart = lSplit(1)

        val sides = getSides(contentPart)
        Card(
            getCardNumber(noPart), sides._1, sides._2
        )
    }
}