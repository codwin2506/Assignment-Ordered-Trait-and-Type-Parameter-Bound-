package edu.knoldus.com
import org.scalatest.flatspec.AnyFlatSpec

class NumTest extends AnyFlatSpec {

  val num1 = new EmptySet[ValCheck]

  "incl method" should "include element in EmptySet" in {
    val num2 = num1.incl(ValCheck(1)).incl(ValCheck(2))
    assert(num2.contains(ValCheck(1)))
  }

  "Contain method" should "check weather the value present or not " in {
    val num3 = num1.incl(ValCheck(1)).incl(ValCheck(2)).incl(ValCheck(4)).incl(ValCheck(5))

    assert(!num3.contains(ValCheck(30)))
    assert(num3.contains(ValCheck(4)))
  }
  val num3= new EmptySet[ValCheck]
  val num4 = new NonEmptySet[ValCheck](ValCheck(3),num3.incl(ValCheck(7)),num3.incl(ValCheck(1)))

  "incl method " should "include value present in nonempty set" in {
    val num5 = num4.incl(ValCheck(12)).incl(ValCheck(20))
    assert(num5.contains(ValCheck(12)))
  }

  "Contain method" should "check in non empty set that value is present in non-empty set or not" in {
    assert(num4.contains(ValCheck(10)))
    assert(!num4.contains(ValCheck(2)))
  }
}