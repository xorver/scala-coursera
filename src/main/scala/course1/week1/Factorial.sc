def factorial(n: Int): Int = {
  def factorialIter(n: Int, product: Int): Int =
    if (n == 1) product else factorialIter(n - 1, product * n)

  factorialIter(n, 1)
}

factorial(0)
factorial(1)
factorial(2)
factorial(3)
factorial(4)
