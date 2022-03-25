package u04lab.polyglot.a05b

/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a05b/sol2/ */
class LogicsImpl(private val size: Int) extends Logics :

  import u04lab.code.Option.*
  import scala.util.Random

  private var start = false
  private var center = None[(Int, Int)]()
  private var range = 0

  override def tick(): Unit = center match
    case Some(x, y) => range = range + 1
    case _ =>
      val random = Random()
      val x = random.nextInt(size)
      val y = random.nextInt(size)
      center = Some((x, y))

  def tick(x: Int, y: Int): Unit = center match
    case Some(x, y) => range = range + 1
    case _ => center = Some((x, y))

  override def isOver: Boolean = center match
    case Some(x, y) if x + range > size - 1 || x - range < 0 || y + range > size - 1 || y - range < 0 => true
    case _ => false

  override def hasElement(x: Int, y: Int): Boolean = center match
    case Some(_x, _y) if Math.abs(x - _x) <= range && Math.abs(y - _y) <= range
      && (Math.abs(y - _y) == Math.abs(x - _x) || Math.abs(y - _y) == 0 || Math.abs(x - _x) == 0) => true
    case _ => false
