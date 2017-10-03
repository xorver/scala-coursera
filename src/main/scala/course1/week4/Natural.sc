abstract class Nat {
  def isZero: Boolean

  def predecessor: Nat

  def successor: Nat

  def +(that: Nat): Nat

  def -(that: Nat): Nat
}

object Zero extends Nat {
  override def isZero = true

  override def predecessor = throw new IndexOutOfBoundsException()

  override def successor = new Succ(Zero)

  override def +(that: Nat) = that

  override def -(that: Nat) =
    if (that.isZero) Zero
    else throw new IndexOutOfBoundsException()
}

class Succ(n: Nat) extends Nat {
  override def isZero = false

  override def predecessor = n

  override def successor = new Succ(this)

  override def +(that: Nat) = n + that.successor

  override def -(that: Nat) =
    if (that.isZero) this
    else n - that.predecessor
}

val one = Zero.successor
val two = Zero.successor.successor
val three = two.successor

((one+two) - three).isZero

((three - two) - one).isZero


(two - two).isZero
(two - one).isZero
((two - one) - one).isZero
