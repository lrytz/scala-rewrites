/*
rule = ScalaSeq
*/
package fix

class ScalaSeq {
  def f(a: Seq[Int], b: List[Seq[Int]]): Seq[Any] = List(a, b)
}
