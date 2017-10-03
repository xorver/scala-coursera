
def init[T](list: List[T]): List[T] = list match {
  case List() => throw new IllegalArgumentException("init of empty list")
  case head :: Nil => List()
  case head :: tail => head :: init(tail)
}

def removeAt[T](i: Int, chars: List[T]): List[T] =
  if(i==0) chars.tail
  else chars.head :: removeAt(i-1, chars.tail)

init(List(1, 2, 3))

removeAt(1, List('a', 'b', 'c', 'd'))

def flatten(xs: List[Any]): List[Any] = xs match{
  case List() => List()
  case List() :: ys => ys
  case (y :: ys) :: zs => flatten(y :: ys) ++ flatten(zs)
  case y :: ys => y :: flatten(ys)
}

flatten(List(List(1, 1), 2, List(3, List(5, 8))))

def merge(xs: List[Int], ys: List[Int]): List[Int] =
  (xs, ys) match {
    case (Nil, _) => ys
    case (_, Nil) => xs
    case (h1 :: r1, h2 :: r2) =>
      if(h1<h2) h1 :: merge(r1, ys)
      else h2 :: merge(xs, r2)

  }

merge(List(1, 4, 6), List(2, 5))