package fix

import scala.compat.Platform
import scala.{collection => sc}
import scala.collection.{immutable => sci}
import scala.io.StdIn

object Scala_2_13 {
  def eol1 = "Hello World!" + System.lineSeparator
  def eol2 = s"Hello World!${System.lineSeparator}"
  def eol3 = "Hello World!" + System.lineSeparator
  def eol4 = s"Hello World!${System.lineSeparator}"
  def eol5 = "Hello World!" + System.lineSeparator
  def eol6 = s"Hello World!${System.lineSeparator}"

  def currentTimeMillis1 = System.currentTimeMillis
  def currentTimeMillis2 = System.currentTimeMillis
  def currentTimeMillis3 = System.currentTimeMillis
  def currentTimeMillis4 = s"now: ${System.currentTimeMillis}"

  def length(xs: sc.Seq[Int], ys: List[sc.Seq[Int]], zs: sc.Seq[List[sc.Seq[Int]]]): sci.Seq[Int] = List(xs.length, ys.size, zs.length)
  def singleton[A](x: A): sci.Seq[A] = List(x)

  def arrayCopy1() = System.arraycopy(null, 0, null, 0, 0)
  def arrayCopy2() = System.arraycopy(null, 0, null, 0, 0)
  def arrayCopy3() = System.arraycopy(null, 0, null, 0, 0)

  def consoleReadBoolean                        = StdIn.readBoolean()
  def consoleReadByte                           = StdIn.readByte()
  def consoleReadChar                           = StdIn.readChar()
  def consoleReadDouble                         = StdIn.readDouble()
  def consoleReadFloat                          = StdIn.readFloat()
  def consoleReadInt                            = StdIn.readInt()
  def consoleReadLine                           = StdIn.readLine()
  def consoleReadLine(text: String, args: Any*) = StdIn.readLine(text, args: _*)
  def consoleReadLong                           = StdIn.readLong()
  def consoleReadShort                          = StdIn.readShort()
  def consoleReadf(format: String)              = StdIn.readf(format)
  def consoleReadf1(format: String)             = StdIn.readf1(format)
  def consoleReadf2(format: String)             = StdIn.readf2(format)
  def consoleReadf3(format: String)             = StdIn.readf3(format)

  def arrow1: PartialFunction[Int, String] = {
    case 0          => "zero"
    case 1           => "one"
    case 2 =>           "two"
    case n if n > 10 => "ginormous"
  }
  def arrow2(f: Int => String) = f(1)
  def arrow3 = {
    import scala.{ PartialFunction => ?=> }
    def f: Int ?=> String = {
      case 1 => "one"
    }
  }

  def singleArrow1: (Int, Int) = 1 -> 1
  def singleArrow2: (Int, Int) = 1.->(1)

  def symbolLiteral0 = Symbol("foo")
  def symbolLiteral1 = Symbol("foo")
}
