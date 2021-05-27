/* CSCE 314 [Sections 502, 503] Programming Languages Spring 2021
   Homework 5 Problem 1 
   class CellTest

   Student Name: Khoa Diep
   UIN: 926005094
   https://www.javatpoint.com/java-string-compareto
   https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#clone()
   https://www.geeksforgeeks.org/clone-method-in-java-2/
   https://www.geeksforgeeks.org/how-to-add-an-element-to-an-array-in-java/
   https://www.geeksforgeeks.org/overriding-equals-method-in-java/
   https://docs.oracle.com/javase/10/docs/api/java/util/Arrays.html
   https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#clone()
   https://www.tutorialspoint.com/what-can-cause-the-cannot-find-symbol-error-in-java
   Textbook and Class Slides
   On my honor, as an Aggie, I have neither given nor received any unauthorized
   aid on any portion of the academic work included in this assignment.
*/

public class CellTest {

  // 15 points for the three methods: int_sum, num_sum, print
  // int_sum
  public static int int_sum(Cell<Integer> intlist){ //sum of int
	  if (intlist == null){
		return 0;
	  }
			
	  int sum = 0;
	  for(Integer i : intlist){
		  if(i != null){
			  sum = sum + i;
		  }
	  }
	  return sum;
  }

  // num_sum
  public static double num_sum(Cell<? extends Number> numlist){ //same implemetation as int_sum but extends to all numbers
	  if (numlist == null){
		return 0;
	  }
			
	  double sum = 0.0;
	  for(Number n : numlist){
		  if(n != null){
			  sum += n.doubleValue();
		  }
	  }
	  return sum;
  }
  
  
  // print
	public static <E> void print(Cell <E> printlist){ //print as specified
		String p = "";
		for(E e : printlist){
			if ((printlist == null) || (e == null)){
				return;
			}
			p = p + e + " ";
		}
		System.out.println(p);
  }
  // Feel free to "expand" the main method but keep whatever provided 
  public static void main (String args[]) {
    Cell<Integer> intlist = 
        new Cell<Integer>(1, 
          new Cell<Integer>(22, 
            new Cell<Integer>(21, 
              new Cell<Integer>(12, 
                new Cell<Integer>(24, 
                  new Cell<Integer>(17, null))))));
				      
    Cell<Integer> nullintlist = null;
	
    System.out.println("===");
    print(intlist);
    System.out.println("sum of intlist is " + int_sum(intlist));
    System.out.println("sum of null list is " + int_sum(nullintlist));
    System.out.println("===");
	
    Cell<Double> doublelist = 
        new Cell<Double>(1., 
          new Cell<Double>(16., 
            new Cell<Double>(13.72, 
              new Cell<Double>(5., 
                new Cell<Double>(22., 
                  new Cell<Double>(7.1, null))))));

    System.out.println("===");
    print(doublelist);
    System.out.println("sum ints = " + num_sum(intlist));
    System.out.println("sum doubles = " + num_sum(doublelist));
    System.out.println("===");
	
	
	
  }
}

