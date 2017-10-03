package course1.week3

object EmptySet extends IntSet{
  override def contains(x: Int) = false

  override def include(x: Int) = new NonEmptySet(x, EmptySet, EmptySet)

  override def union(other: IntSet) = other
}
