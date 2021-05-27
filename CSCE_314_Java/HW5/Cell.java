/* Cell.java skeleton 
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

import java.lang.Iterable;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Cell class: 15 points
// give correct class header - given in the problem statement
public final class Cell<E> implements Iterable<E> { // modify this header
  // private fields
	private E elem;
	private Cell<E> next;

	// (5 points) constructor
	public Cell (E elem, Cell<E> next) { 
		this.elem = elem;
		this.next = next;
	} 

	// (5 points) iterator() returns a CellIterator object for this object
	public CellIterator<E> iterator() {
		return new CellIterator<E>(this);
	}

  // (5 points) getter and setter methods for the private fields
  public E getVal() {
	  return elem;
  } 
  public void setVal(E v) {
	  this.elem = v;
  } 
  public Cell<E> getNext() {
	  return next;
  } 
  
  public void setNext(Cell<E> node) {
	  this.next = node;
  } 

  //*** CellIterator as an inner class: 20 points
  // (2 points) correct class header - given in the problem statement
  class CellIterator<E> implements Iterator<E> { // modify this header
    private Cell<E> p;  // also given

    // (3 points) constructor
    public CellIterator (Cell<E> n) {
		this.p = n;
	}

    // (15 points) methods to implement the Iterator interface
    // (5 points) hasNext()
    public boolean hasNext() {
		return p != null;
	} 

    // (10 points) next()
    public E next() {
		Cell<E> next = p.getNext();
		E val  = p.getVal();
		p = next;
		return val;
	}    

  } // end of CellIterator
} // end of Cell

