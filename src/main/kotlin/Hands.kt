enum class Hands(name: String) {
    ROCK("rock"){
        override fun getWiner(): List<Hands> {
            return listOf(SCISSORS)
        }

        override fun getLoser(): List<Hands> {
            return listOf(PAPER)
        }
    },
    PAPER("paper") {
        override fun getWiner(): List<Hands> {
            return listOf(ROCK)
        }

        override fun getLoser(): List<Hands> {
            return listOf(SCISSORS)
        }
    },
    SCISSORS("scissors") {
        override fun getWiner(): List<Hands> {
            return listOf(PAPER)
        }

        override fun getLoser(): List<Hands> {
            return listOf(ROCK)
        }
    };

    companion object {
        fun listString(): String {
            var string = ""
            for (hand in entries) {
                val handInt = hand.ordinal
                val handString = hand.getName()
                val str = "$handInt: $handString"
                string += "$str, "
            }
            return string
        }

        fun getHandFromInt(handInt: Int): Hands {
            if (handInt <= Hands.entries.size) {
                return entries[handInt]
            }else {
                return Hands.entries[0]
            }
        }

    }

    fun isWinOrLose(hand: Hands): WinLoseDraw {
        for (winHand in getWiner()) {
            if (winHand == hand) {
                return WinLoseDraw.WIN
            }
        }
        for (loseHand in getLoser()) {
            if (loseHand == hand) {
                return WinLoseDraw.LOSE
            }
        }
        return WinLoseDraw.DRAW
    }

    //自分が勝つ手のリスト
    abstract fun getWiner(): List<Hands>

    //自分が負ける手のリスト
    abstract fun getLoser(): List<Hands>

    fun getName(): String {
        return name
    }
}