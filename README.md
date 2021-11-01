# Assignment-Ordered-Trait-and-Type-Parameter-Bound-

We know how to make classes generic it is natural to generalize some of
the earlier classes we have written. For instance, class IntSet could be generalized
to sets with arbitrary element types. Let’s try. The abstract class for generic sets is
easily written.



abstract class Set[A] {
 def incl(x: A): Set[A]
 def contains(x: A): Boolean
}



If we still want to implement sets as binary search trees, we encounter a
problem. The contains and incl methods both compare elements using methods
< and >. For IntSet this was OK since type Int has these two methods. But for
an arbitrary type parameter, we cannot guarantee this. Therefore, the StringSet implementation with of, say, contains would generate a compiler error.



def contains(x: Int): Boolean =
  if (x < elem) left contains x
          ^ < not a member of type A


One way to solve the problem is to restrict the legal types that can be substituted for
type A to only those types that contain methods < and > of the correct types. There is
a trait Ordered[A] in the standard class library Scala which represents values that
are comparable (via < and >) to values of type A. This trait is defined as follows:



/** A class for totally ordered data. */
trait Ordered[A] {
  /** Result of comparing ‘this’ with operand ‘that’.
    * returns ‘x’ where
    * x < 0 iff this < that

    * x == 0 iff this == that
    * x > 0 iff this > that
   */



 def compare(that: A): Int
 def < (that: A): Boolean = (this compare that) < 0
 def > (that: A): Boolean = (this compare that) > 0
 def <= (that: A): Boolean = (this compare that) <= 0
 def >= (that: A): Boolean = (this compare that) >= 0
 def compareTo(that: A): Int = compare(that) 
}



We can enforce the comparability of a type by demanding that the type is a subtype
of Ordered.



In this assignment write the data type of Set whose type is upper bounded by ordered trait. Must include these two methods


def incl(x: A): Set[A]
def contains(x: A): Boolean
