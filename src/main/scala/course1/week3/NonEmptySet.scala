package course1.week3

class NonEmptySet(val value: Int, left: IntSet, right: IntSet) extends IntSet{
  override def contains(x: Int) =
    if(x < value) left contains x
    else if (x > value) right contains x
    else x == value

  override def include(x: Int) =
    if(x==value) this
    else if(x<value) new NonEmptySet(value, left include x, right)
    else new NonEmptySet(value, left, right include x)

  override def union(other: IntSet) =
    left.union(right).union(other).include(value)
}
