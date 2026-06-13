class Hand private constructor(val index: Int, val name: String, val winners: List<Int>, val losers: List<Int>) {

    fun isWinOrLose(hand: Hand): WinLoseDraw {
        val index = hand.index
        for (winHand in getWiner()) {
            if (winHand == index) {
                return WinLoseDraw.WIN
            }
        }
        for (loseHand in getLoser()) {
            if (loseHand == index) {
                return WinLoseDraw.LOSE
            }
        }
        return WinLoseDraw.DRAW
    }

    //自分が勝つ手のリスト
    fun getWiner(): List<Int> {
        return winners
    }

    //自分が負ける手のリスト
    fun getLoser(): List<Int> {
        return losers
    }

    companion object {

        fun create(index: Int, name: String, winner: List<Int>, loser: List<Int>): Hand {
            val hand = Hand(index, name, winner, loser)
            Hands.handList.add(hand)
            return hand
        }

        fun create(index: Int, name: String, winner: Int, loser: Int): Hand {
            val hand = create(index, name, listOf(winner), listOf(loser))
            return hand
        }

        fun listString(): String {
            var string = ""
            for (hand in Hands.handList) {
                val handInt = hand.index
                val handString = hand.name
                val str = "$handInt: $handString"
                string += "$str, "
            }
            return string
        }

        fun getHandFromInt(handIndex: Int): Hand {
            return if (handIndex <= Hands.handList.size) {
                Hands.handList[handIndex]
            }else {
                Hands.handList[0]
            }
        }
    }
}