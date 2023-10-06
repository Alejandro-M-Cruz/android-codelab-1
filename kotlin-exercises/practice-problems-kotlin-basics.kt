// Print messages
fun main() {
    val message = """
        Use the val keyword when the value doesn't change. 
        Use the var keyword when the value can change.
        When you define a function, you define the parameters that can be passed to it. 
        When you call a function, you pass arguments for the parameters.
    """.trimIndent()
    println(message)
}

// Fix compile error
fun main() { 
    println("New chat message from a friend")
}

// String templates
fun main() {
    val discountPercentage = 20
    val item = "Google Chromecast"
    val offer = "Sale - Up to $discountPercentage% discount on $item! Hurry up!"
    println(offer)
}

// String concatenation
fun main() {
    val numberOfAdults = 20
    val numberOfKids = 30
    val total = numberOfAdults + numberOfKids
    println("The total party size is: $total")
}

// Message formatting
fun main() {
    val baseSalary = 5000
    val bonusAmount = 1000
    val totalSalary = baseSalary + bonusAmount
    println("Congratulations for your bonus! You will receive a total of $totalSalary (additional bonus).")
}

// Implement basic math operations
fun add(a: Int, b: Int): Int {
    return a + b
}

fun subtract(a: Int, b: Int): Int {
    return a - b
}

fun main() {
    val firstNumber = 10
    val secondNumber = 5
    val thirdNumber = 8
    
    val result = add(firstNumber, secondNumber)
    val anotherResult = add(firstNumber, thirdNumber)
    val subtractionResult = subtract(secondNumber, firstNumber)

    println("$firstNumber + $secondNumber = $result")
    println("$firstNumber + $thirdNumber = $anotherResult")
    println("$secondNumber - $firstNumber = $subtractionResult")
}

// Default parameters
fun main() {
    val firstUserEmailId = "user_one@gmail.com"
    println(displayAlertMessage(emailId = firstUserEmailId))
    println()

    val secondUserOperatingSystem = "Windows"
    val secondUserEmailId = "user_two@gmail.com"

    println(displayAlertMessage(secondUserOperatingSystem, secondUserEmailId))
    println()

    val thirdUserOperatingSystem = "Mac OS"
    val thirdUserEmailId = "user_three@gmail.com"

    println(displayAlertMessage(thirdUserOperatingSystem, thirdUserEmailId))
    println()
}

fun displayAlertMessage(operatingSystem: String = "Unknown OS", emailId: String): String {
    return "There's a new sign-in request on $operatingSystem for your Google Account $emailId."
}

// Pedometer
fun main() {
    val steps = 4000
    val caloriesBurned = pedometerStepsToCalories(steps)
    println("Walking $steps steps burns $caloriesBurned calories") 
}

fun pedometerStepsToCalories(numberOfSteps: Int): Double {
    val caloriesBurnedForEachStep = 0.04
    val totalCaloriesBurned = numberOfSteps * caloriesBurnedForEachStep
    return totalCaloriesBurned
}

// Compare two numbers
fun spentMoreTimeTodayThanYesterday(minutesSpentToday: Int, minutesSpentYesterday: Int): Boolean {
    return minutesSpentToday > minutesSpentYesterday
}


// Move duplicate code into a function
fun main()  {
    printCityInformation("Madrid", 20, 30, 5)
}

fun printCityInformation(city: String, lowTemperature: Int, highTemperature: Int, chanceOfRain: Int) {
    println("City: $city")
    println("Low temperature: $lowTemperature, High temperature: $highTemperature")
    println("Chance of rain: $chanceOfRain%")
    println()
}