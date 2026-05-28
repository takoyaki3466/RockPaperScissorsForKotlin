fun main() {

    var isContinue = true
    var yourWinCount = 0
    var enemyWinCount = 0
    var drawCount = 0

    while (isContinue) {
        val handsStr = Hands.listString()
        println("please write your hand [$handsStr]")

        var yourHandInt: Int?
        do {
            print("what your hand? : ")
            yourHandInt = readln().toIntOrNull()
            if (yourHandInt == null || yourHandInt >= 3) {
                println("Enter a number within the specified range!!!!")
            }
        }while (yourHandInt == null || yourHandInt >= 3)
        val yourHand = Hands.getHandFromInt(yourHandInt)

        println("Your hand is $yourHand")
        val random = (0..(Hands.entries.size - 1)).random()

        val enemyHand = Hands.getHandFromInt(random)

        println("Enemy hand is ${enemyHand.getName()}")

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