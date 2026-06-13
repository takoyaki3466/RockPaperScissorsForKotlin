fun main() {

    var isContinue = true
    var yourWinCount = 0
    var enemyWinCount = 0
    var drawCount = 0

    while (isContinue) {
        val handStr = Hand.listString()
        println("please write your hand [$handStr]")

        var yourHandInt: Int?
        do {
            print("what your hand? : ")
            yourHandInt = readln().toIntOrNull()
            val isNumCriteria = yourHandInt == null || yourHandInt >= Hands.handList.size || yourHandInt < 0

            if (isNumCriteria) {
                println("Enter a number within the specified range!!!!")
            }

        }while (isNumCriteria)

        val yourHand = Hand.getHandFromInt(yourHandInt)

        println("Your hand is ${yourHand.name}")
        val random = (0..(Hands.handList.size - 1)).random()

        val enemyHand = Hand.getHandFromInt(random)

        println("Enemy hand is ${enemyHand.name}")

        val winOrLose = yourHand.isWinOrLose(enemyHand)
        when (winOrLose) {
            WinLoseDraw.WIN -> {
                println("Win")
                yourWinCount++
            }
            WinLoseDraw.LOSE -> {
                println("Lose")
                enemyWinCount++
            }
            WinLoseDraw.DRAW -> {
                println("Draw")
                drawCount++
            }
        }

        var readContinue: Int?
        println("0 is not continue..., but 1 is continue!!!")
        do {
            print("are you continue? : ")
            readContinue = readln().toIntOrNull()
            if (readContinue == null || readContinue >= 2) {
                println("Enter a number within the specified range!!!!")
            }
        }while (readContinue == null || readContinue >= 2)

        isContinue = readContinue == 1
        println()
    }

    println("total is ${yourWinCount + enemyWinCount + drawCount}")
    println("your win count is $yourWinCount")
    println("enemy win count is $enemyWinCount")
    println("drawCount is $drawCount")
}