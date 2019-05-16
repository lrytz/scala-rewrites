package fix

import scalafix.v1._

import scala.collection.mutable.ListBuffer
import scala.meta._
import scala.meta.transversers.Traverser

final class ScalaSeq extends SemanticRule("ScalaSeq") {
  val patches = ListBuffer.empty[Patch]

  class SeqTraverser()(implicit doc: SemanticDocument) extends Traverser {
    var inParam = false

    val scalaSeq = SymbolMatcher.exact("scala/package.Seq#")

    override def apply(tree: Tree): Unit = tree match {
      case p: Term.Param =>
        inParam = true
        super.apply(p)
        inParam = false

      case scalaSeq(Type.Apply(t, _)) =>
        if (inParam)
          patches += Patch.replaceTree(t, "scala.collection.Seq")
        else
          patches += Patch.replaceTree(t, "scala.collection.immutable.Seq")

      case _ => super.apply(tree)
    }
  }

  override def fix(implicit doc: SemanticDocument): Patch = {
    new SeqTraverser()(doc).apply(doc.tree)
    patches.asPatch
  }
}
