
trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Nil[T] extends List[T] {
  override def isEmpty = true

  override def head = throw new NoSuchElementException("nil.bead")

  override def tail = throw new NoSuchElementException("nil.tail")
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  override def isEmpty = false
}

def nth[T](n: Int, list: List[T]): T =
  if(list.isEmpty) throw new IndexOutOfBoundsException("reached list end")
  else if(n==0) list.head
  else nth(n-1, list.tail)

object List {
  def apply[T]: List[T] = new Nil[T]
  def apply[T](x1: T): List[T] = new Cons[T](x1, new Nil[T])
}
