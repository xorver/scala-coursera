import sun.nio.cs.Surrogate.Generator

trait Tree

case class Inner(left: Tree, right: Tree) extends Tree

case class Leaf(x: Int) extends Tree

def trees: Generator[Tree] = for {
  isLeaf <-  booleans
  node <- if(isLeaf) leafs else inners
} yield node

def leafs: Generator[Leaf] = for {
  value <- integers
} yield Leaf(value)

def inners: Generator[Inner] = for {
  left <- trees
  right <- trees
} yield Inner(left, right)