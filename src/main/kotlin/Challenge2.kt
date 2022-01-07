fun reversedNumber(number: String) {
    val value = number
    var reversedValue = ""

    try {
        for (i in value.length - 1 downTo 0) {
            reversedValue += value[i]
        }
        //This variable break the code if it isn't a number
        val checkIsNumber = reversedValue.toInt()

        /*
        If the code above didn't break, we print that as string, because values like '200', when as Integer,
        it only prints 2, when it should print 002.
         */
        println(reversedValue)

    } catch (e: Exception){
        println("O valor digitado não é um número.")
    }
}

fun main(){

    print("Digite o número para : ")
    val number = readLine()!!

    reversedNumber(number)

}