package machine

fun main() {
    val coffeeMaker = CoffeeMaker()
    println("Write action (buy, fill, take):")
    while (true) {
        when (readln()) {
            "buy" -> coffeeMaker.buy()
            "fill" -> coffeeMaker.fill()
            "take" -> coffeeMaker.take()
            "remaining" -> coffeeMaker.remaining()
            "exit" -> break
        }
    }
}

class CoffeeMaker (private var water: Int = 400, private var milk: Int = 540, private var coffee: Int = 120, private var cups: Int = 9, private var money: Int = 550) {
    fun buy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
        when (readln()) {
            "1" -> checkIng(250, 0, 16, 4)
            "2" -> checkIng(350, 75, 20, 7)
            "3" -> checkIng(200, 100, 12, 6)
            "back" -> return
        }
    }

    fun fill() {
        println("Write how many ml of water do you want to add:")
        water += readln().toInt()
        println("Write how many ml of milk do you want to add:")
        milk += readln().toInt()
        println("Write how many grams of coffee beans do you want to add:")
        coffee += readln().toInt()
        println("Write how many disposable cups of coffee do you want to add:")
        cups += readln().toInt()
    }

    fun remaining() {
        println("The coffee machine has:")
        println("$water of water")
        println("$milk of milk")
        println("$coffee of coffee beans")
        println("$cups of disposable cups")
        println("$$money of money")
    }

    fun take() {
        print("I gave you $money")
        money = 0
    }

    fun checkIng(waterX: Int, milkX: Int, cBeansX: Int, moneyX: Int) {
        if (water >= waterX && milk >= milkX && coffee >= cBeansX && cups >= 1) {
            water -= waterX
            milk -= milkX
            coffee -= cBeansX
            cups--
            money += moneyX
            println("I have enough resources, making you a coffee!")
        } else println("Not enough ingredients")
    }
}