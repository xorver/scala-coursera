
class Poly(terms0: Map[Int, Double]) {
  def this(bindings: (Int, Double)*) = this(bindings.toMap)
  val terms = terms0.withDefaultValue(0.0)

  def + (other: Poly): Poly =
    new Poly(other.terms.foldLeft(terms)(addTerm))

  def addTerm(terms: Map[Int, Double], term: (Int, Double)) =
  terms + term

  override def toString = terms.toString()
}

new Poly(1 -> 2.0, 2-> 4.0)