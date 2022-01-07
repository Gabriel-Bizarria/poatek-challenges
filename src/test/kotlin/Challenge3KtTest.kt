import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Challenge3KtTest{

    private val pump = FuelPump(FuelTypes.ALCOHOL, 0.0, 1000.0)

    @Test
    fun `Fun fill with liters test`(){
        assertEquals(0.0, pump.fillWithLiters(80.0))
    }

    @Test
    fun `Fun fill with price test`(){
        assertEquals(100.0, pump.fillWithPrice(380.0))
    }
}