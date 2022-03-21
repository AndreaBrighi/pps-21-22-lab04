import org.junit.Test
import org.junit.Assert.*
import u04lab.code.{Course, Student}
import u04lab.code.List.*

class StudentTest:

  @Test def courseTest(): Unit =
    val cPPS = Course("PPS", "Viroli")
    assertEquals("PPS", cPPS.name)
    assertEquals("Viroli", cPPS.teacher)

  @Test def studentTest(): Unit =
    val student = Student("mario", 2015)
    assertEquals("mario", student.name)
    assertEquals(2015, student.year)

  @Test def studentCoursesTest(): Unit =
    val cPPS = Course("PPS", "Viroli")
    val cPCD = Course("PCD", "Ricci")
    val student = Student("mario", 2015)
    student.enrolling(cPPS)
    student.enrolling(cPCD)
    assertEquals(Cons("PCD",Cons("PPS",Nil())), student.courses)

  @Test def studentMultipleCoursesTest(): Unit =
    val cPPS = Course("PPS", "Viroli")
    val cPCD = Course("PCD", "Ricci")
    val cSDR = Course("SDR", "D'Angelo")
    val student = Student("rino")
    student.enrolling(cPPS, cPCD, cSDR)
    assertEquals(Cons("SDR",Cons("PCD",Cons("PPS",Nil()))), student.courses)
