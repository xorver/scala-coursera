
val list1 = List(1,2,3)
val list2 = List("a","b","c")

for (x <-list1 if x >= 2; y <- list2) yield s"$x $y"

for (x <-list1.withFilter(x => x>=2); y <- list2) yield s"$x $y"

list1.withFilter(x => x>=2).flatMap(x =>
  for (y <- list2) yield s"$x $y")

list1.withFilter(x => x>=2).flatMap(x =>
  list2.map(y => s"$x $y"))