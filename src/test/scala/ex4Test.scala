import org.junit.Assert.assertEquals
import org.junit.Test
import u04lab.code.List.*
import u04lab.code.{Course, List, sameTeacher}

class ex4Test:
  @Test def listTest(): Unit =
    assertEquals(Cons(1, Cons(2, Cons(3, Nil()))), List(1, 2, 3))

  @Test def listTestEmpty(): Unit =
    assertEquals(Nil(), List())


  @Test def sameTeacherTest(): Unit =
    val cPPS = Course("PPS", "Viroli")
    val cOOP = Course("OOP", "Viroli")
    val courses = List(cPPS, cOOP)
    courses match
      case sameTeacher(t) => assertEquals("Viroli", t)
      case _ => throw IllegalStateException()

  @Test def sameTeacherTestFalse(): Unit =
    val cPPS = Course("PPS", "Viroli")
    val cPCD = Course("PCD", "Ricci")
    val cSDR = Course("SDR", "D'Angelo")
    val courses = List(cPPS, cPCD, cSDR)
    courses match
      case sameTeacher(t) => throw IllegalStateException()
      case _ =>