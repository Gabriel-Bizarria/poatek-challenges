//Enum class that defines the existent types of fuel that we can use
enum class FuelTypes(var actualPrice: Double) {
    STANDART(0.0),
    PREMIUM(0.0),
    DIESEL(0.0),
    ALCOHOL(0.0);
}

//Class that defines the atributes and methods of the Fuel Pump
class FuelPump(var fuelType: FuelTypes = FuelTypes.STANDART, var fuelPrice: Double, var fuelQuantity: Double){

    fun setPrice(fuelType: FuelTypes, price: Double){
        fuelType.actualPrice = price
        this.fuelPrice = fuelType.actualPrice
    }

    fun fillWithPrice(price: Double): Double{
        var liters: Double
        return try{
            liters = price / fuelPrice
            if(liters > fuelQuantity) {
                return 0.0
            } else {
                fuelQuantity -= liters
                liters
            }
        }catch(e: Exception){
            0.0
        }
    }

    fun fillWithLiters(liters: Double): Double{
        var totalPrice = 0.0
        if(liters > fuelQuantity || fuelPrice == 0.0){
            return 0.0
        } else {
            fuelQuantity -= liters
            totalPrice += liters * fuelPrice
            return totalPrice
        }
    }
}

fun main(){

    var pump = FuelPump(FuelTypes.STANDART, 0.0,1000.0)

    println("With which fuel do you want to fill the car with?")
    println("1 - STANDART")
    println("2 - PREMIUM")
    println("3 - DIESEL")
    println("4 - ALCOHOL")

    var optionFuel = readLine()!!.toInt()

    when(optionFuel){
        1 -> { pump = FuelPump(FuelTypes.STANDART, 0.0, 1000.0) }
        2 -> { pump = FuelPump(FuelTypes.PREMIUM, 0.0, 1000.0) }
        3 -> { pump = FuelPump(FuelTypes.DIESEL, 0.0, 1000.0) }
        4 -> { pump = FuelPump(FuelTypes.ALCOHOL, 0.0, 1000.0) }
        else -> println("Invalid option.")
    }

    println("Type the actual price of this fuel")
    var actualPrice = readLine()!!.toDouble()
    pump.setPrice(pump.fuelType, actualPrice)

    println("Do you wanna fill up the tank by price or by liters of fuel?")
    println("1 - BY PRICE")
    println("2 - BY LITERS")
    var optionFilling = readLine()!!.toInt()

    when(optionFilling){
        1 -> {
            println("Type the value: ")
            var price = readLine()!!.toDouble()

            var amountFilled = pump.fillWithPrice(price)

            if(amountFilled > 0.0){
                println("Quantity of ${pump.fuelType} fuel filled in the tank will cost $amountFilled")
            } else {
                println("Quantity of fuel in the pump isn't enough to fill the tank.")
            }
        }

        2 -> {
            println("Type desired amount of fuel in liters: ")
            var liters = readLine()!!.toDouble()

            var totalPrice = pump.fillWithLiters(liters)

            if(totalPrice > 0.0){
                println("Total cost of $liters of ${pump.fuelType} = $totalPrice")
            } else {
                println("Quantity of fuel in the pump isn't enough to fill the tank.")
            }
        }
        else -> println("This option doesn't exist")
    }
    println("${pump.fuelQuantity} still remaining in the pump.")
}