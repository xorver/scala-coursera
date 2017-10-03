
def isPrime(n: Int) = (2 until n).forall(n % _ != 0)

isPrime(1)
isPrime(2)
isPrime(3)
isPrime(4)
isPrime(5)
isPrime(6)
isPrime(7)


def scalarProduct(xs: List[Double], ys: List[Double]): Double =
  (for ((x,y) <- xs.zip(ys)) yield x*y).sum

def isSafe(col: Int, queens: List[Int]): Boolean =
  !queens.contains(col) &&
  !(for {
    q1 <- queens.indices.zip(queens)
    q2 <- queens.indices.zip(queens)
    if q1 != q2
  } yield (q1,q2)).exists{case ((x1, y1), (x2, y2)) => x1+y1 == x2+y2 || x1-y1 == x2-y2}