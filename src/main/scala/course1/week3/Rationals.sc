
class Rational(x: Int, y: Int) {
  require(y!=0, "Denominator must be nonzero")

  def gcd(a: Int, b: Int): Int = if (b==0) a else gcd(b,a%b)

  def nom = x

  def denom = y

  def add(that: Rational) =
    new Rational(
      nom * that.denom + that.nom * denom,
      denom * that.denom
    )

  def neg() = new Rational(-nom, denom)

  def sub(that: Rational) = add(that.neg())

  override def toString = {
    val g = gcd(nom,denom)
    nom / g + "/" + denom / g
  }
}

val x = new Rational(1,3)
val y = new Rational(5,7)
val z = new Rational(3,2)

x.sub(y).sub(z)

new Rational(1,0)