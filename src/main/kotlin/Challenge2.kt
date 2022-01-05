fun reversedNumber(number: String) {
    val value = number
    var reversedValue = ""

    try {
        for (i in value.length - 1 downTo 0) {
            reversedValue += value[i]
        }
        println(reversedValue.toInt())
    } catch (e: Exception){
        println("O valor digitado não é um número.")
    }
}

fun main(){

    print("Digite o número para : ")
    val number = readLine()!!

    reversedNumber(number)

    println(10/0)
}