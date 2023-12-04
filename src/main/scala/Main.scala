object Main {

    def main(args: Array[String]): Unit = {
        val puzzle = Utils.readInput("puzzle.txt")

        println(Utils.sumWinningScores(puzzle))

    }

}
