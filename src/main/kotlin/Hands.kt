class Hands {

    companion object {
        val handList = mutableListOf<Hand>()

        val ROCK = Hand.create(0, "rock", 2, 1)
        val PAPER = Hand.create(1, "paper", 0, 2)
        val SCISSORS = Hand.create(2, "scissors", 1, 0)
    }
}