import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

case class ExampleTest() extends AnyFunSpec with Matchers {


    describe("A single card") {
        val c = Card.parseCard("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53")

        it("Should be n°1") {
            c.cardNumber shouldEqual 1
        }
        it("Should have 5 winning numbers") {
            c.getWinningNumber.length shouldEqual 4
        }
        it("Should sum winning numbers to 8") {
            c.getWinningScore shouldEqual 8
        }

    }



}
