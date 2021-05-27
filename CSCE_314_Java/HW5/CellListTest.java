/* CSCE 314 [Sections 502, 503] Programming Languages Spring 2021
   Homework 5 Problem 2
   class CellListTest: Feel free to "expand" it, but keep the original contents 
                     (i.e., do not completely change the main() method)

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

import java.util.Iterator;
import java.util.Arrays;
import static java.lang.System.out; 
    
class Tester {
  public static void test (boolean cond) { test(cond, "unnamed"); }
  public static void test (boolean cond, String testname) {
    String msg = testname + " ";
    if (cond) msg = msg + "OK"; else msg = msg + "failed!";
    out.println(msg);
  }
}

public class CellListTest {
  public static void main (String args[]) {
	
    CellList<Integer> empty_list = new CellList<Integer>();
    CellList<Integer> list = new CellList<Integer>(Arrays.asList(1,2,3,4));
    CellList<Integer> list1 = new CellList<Integer>(Arrays.asList(2,4,3,1));
    CellList<Integer> list2 = new CellList<Integer>(list.clone()); 

    CellList<Integer> list3 = new CellList<Integer>(Arrays.asList(1,2,3,1));
    CellList<Integer> list4 = new CellList<Integer>(Arrays.asList(1,2,3,1,4));

    CellList<String> stringlist = 
        new CellList<String>(Arrays.asList("A", "the", "the", "dove"));
    CellList<String> stringlist2 = 
        new CellList<String>(Arrays.asList("A", "dove", "the", "the"));
    CellList<String> stringlist3 = 
        new CellList<String>(Arrays.asList("A", "dove", "dove", "the"));


    out.println("stringlist = " + stringlist);
    out.println("stringlist2 = " + stringlist2);
    out.println("stringlist3 = " + stringlist3);
    out.println("stringlist equals to stringlist2 ? " + 
                 stringlist.equals(stringlist2));
 
    out.println("stringlist equals to stringlist3 ? " + 
                 stringlist.equals(stringlist3));

    out.println("CellList<Integer> equals to CellList<String> ? " + 
                 list.equals(stringlist));
 
    out.println("list  = " + list);
    out.println("list1 = " + list1);

    if (list == list1) out.println("list == list1 is true");
    else out.println("list == list1 is false");

    out.println("list.equals(list1) = " + list.equals(list1));
    out.println("list3 = " + list3);
    out.println("list4 = " + list4);
    out.println("list1.equals(list3) = " + list1.equals(list3));
    out.println("list1.equals(list4) = " + list1.equals(list4));
    out.println("list.compareTo(list1) = " + list.compareTo(list1));
    out.println("list.compareTo(list4) = " + list.compareTo(list4));
    out.println(empty_list);
    out.println(empty_list.reverse());
    out.println(list);
    out.println(list.reverse());
    out.println(list.reverse());
    out.println(list.pop());
    list.push(21);
    list.push(22);
    out.println(list);
    out.println(list.peek());
    out.println(list);
    for (int i : list) {
      list2.push(i); 
      out.println(i + " " + list.pop());
    }
    out.println(list);
    out.println("list1 = " + list1);
    out.println("list2 = " + list2);
    out.println("list2.compareTo(list1) = " + list2.compareTo(list1));
    out.println("=== end of test");
	
	/*
	// testing as I built CellList
	CellList<Integer> list = new CellList<Integer>(Arrays.asList(1,2,3,4,5));
	CellList<Integer> list1 = new CellList<Integer>(Arrays.asList(1,2,3,5,5));
	out.println("list  = " + list);
	out.println(list.reverse());
	CellList<Integer> empty_list = new CellList<Integer>();
	out.println(empty_list.reverse());
	CellList<Integer> list2 = new CellList<Integer>(list.clone()); 
	out.println("list1 = " + list1);
	out.println("list.equals(list1) = " + list.equals(list1));
	out.println(list1.hashCode());
	*/
  } // end of main()
}

