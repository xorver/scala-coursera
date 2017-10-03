
def insert(x: Int, xs: List[Int]): List[Int] = xs match{
  case List() => List(x)
  case head :: tail =>
    if (head > x) x :: head :: tail
    else head :: insert(x,tail)
}

insert(10, List())
insert(10, List(5))
insert(10, List(12))
insert(10, List(3,4,13))