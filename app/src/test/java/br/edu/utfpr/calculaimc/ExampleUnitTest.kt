package br.edu.utfpr.calculaimc

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun imc_isCorrect() {
        assertTrue(
            "O valor do IMC está correto?",
            MainActivity.calcularIMC( 90.0, 1.9, "pt" ) in 24.93 .. 24.94
        )
    }
}