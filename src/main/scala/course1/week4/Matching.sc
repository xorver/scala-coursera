trait Expr

case class Number(n:Int) extends Expr
case class Sum(x: Expr, y: Expr) extends Expr
case class Var(x: String) extends Expr
case class Product(x: Expr, y: Expr) extends Expr

def show(e:Expr): String = e match {
  case Number(n) => n.toString
  case Var(x) => x
  case Sum(a, b) => show(a) + "+" + show(b)
  case Product(Sum(a,b), c) => "("+show(Sum(a,b)) + ")*" + show(c)
  case Product(c, Sum(a,b)) => show(c) + "*(" + show(Sum(a,b)) + ")"
  case Product(a, b) => show(a) + "*" + show(b)
}


show(Number(5))

show(Sum(Sum(Number(1),Number(2)), Number(5)))

show(Sum(Product(Number(1),Number(2)), Number(5)))

show(Sum(Number(5), Product(Number(1),Number(2))))
show(Product(Number(5), Sum(Number(1),Number(2))))