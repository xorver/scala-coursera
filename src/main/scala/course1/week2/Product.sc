def product(f: Int => Int)(a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int =
    if(a > b) acc
    else loop(a+1, f(a) * acc)

  loop(a, 1)
}

product(x => x)(1,3)

def fact(n: Int): Int =
  product(x => x)(1, n)

fact(3)

def mapReduceRange(map: Int => Int, reduce : (Int, Int) => Int, acc0: Int)(a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int =
    if(a > b) acc
    else loop(a+1, reduce(map(a), acc))

  loop(a, acc0)
}

mapReduceRange(x => x, (a, b) => a*b, 1)(1, 3)