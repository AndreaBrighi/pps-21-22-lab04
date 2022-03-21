import org.junit.Test
import org.junit.*
import org.junit.Assert.*
import u04lab.code.Complex

class ComplexTest:

  private val complex1 = Complex(2, 3)
  private val complex2 = Complex(3, 4)

  @Test def valueTest(): Unit =

    assertEquals(2, complex1.re, 0.01)
    assertEquals(3, complex1.im, 0.01)

  @Test def plusTest(): Unit =
    val complex = complex1 + complex2
    assertEquals(5, complex.re, 0.01)
    assertEquals(7, complex.im, 0.01)

  @Test def productTest(): Unit =
    val complex = complex1 * complex2
    assertEquals(-6, complex.re, 0.01)
    assertEquals(17, complex.im, 0.01)

  @Test def equalTest(): Unit =
    val v = Complex(2, 3)
    assertTrue(v == complex1)