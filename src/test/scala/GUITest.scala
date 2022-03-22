import org.junit.{Before, Test}
import u04lab.polyglot.a05b.*
import org.junit.Assert.*
import u04lab.code.List

class GUITest:
  private var logics: LogicsImpl = _
  private val size = 5

  @Before
  def beforeEach(): Unit = logics = LogicsImpl(size)

  @Test def beforeTickTest(): Unit =
    (0 until  size).foreach(x =>
      (0 until  size).foreach(y =>
        assertFalse(logics.hasElement(x, y))
      )
    )

  @Test def firstTick(): Unit =
    logics.tick()
    var i = 0
    (0 until size).foreach(x =>
      (0 until size).foreach(y =>
        i = i + (if logics.hasElement(x, y) then 1 else 0)
      )
    )
    assertEquals(1, i)
    assertFalse(logics.isOver)

  @Test def secondTick(): Unit =
    logics.tick(2, 2)
    logics.tick()
    var i = 0
    (0 until size).foreach(x =>
      (0 until size).foreach(y =>
        i = i + (if logics.hasElement(x, y) then 1 else 0)
      )
    )
    assertEquals(9, i)
    assertFalse(logics.isOver)

  @Test def thirdTick(): Unit =
    logics.tick(2, 2)
    logics.tick()
    logics.tick()
    var i = 0
    (0 until size).foreach(x =>
      (0 until size).foreach(y =>
        i = i + (if logics.hasElement(x, y) then 1 else 0)
      )
    )
    assertEquals(17, i)
    assertFalse(logics.isOver)

  @Test def lastTick(): Unit =
    logics.tick(2, 2)
    logics.tick()
    logics.tick()
    logics.tick()
    assertTrue(logics.isOver)

  @Test def tickOver(): Unit =
    logics.tick(1, 1)
    logics.tick()
    logics.tick()
    assertTrue(logics.isOver)
