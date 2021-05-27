/* CellList.java
   Student Name: (PUT YOUR NAME HERE)
   UIN: (PUT YOUR UIN HERE)
   https://www.javatpoint.com/java-string-compareto
   https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#clone()
   https://www.geeksforgeeks.org/clone-method-in-java-2/
   On my honor, as an Aggie, I have neither given nor received any unauthorized
   aid on any portion of the academic work included in this assignment.
*/

import java.util.Arrays;
import java.util.Iterator;

// Total 65 points for the CellList class


public class CellList<E> implements Iterable<E>, Cloneable, Comparable<CellList<E>> {   
  private Cell<E> n;
  private int length;

  // Task 1(a): 4 points
  @Override
  public Iterator<E> iterator() {
	  //return new CellIterator<E>(n);
	  //Cell<E>.CellIterator<E> celliter = n.new CellIterator<E>(n);
	  //Iterator<E> n = Cell<E>.new CellIterator<E>(n);
	  //n.iterator();
	  return n.iterator();
	  //return celliter;
  }

  // Task 1(b): 8 points
  @Override
  protected CellList<E> clone() {
	  CellList<E> copy = new CellList<E>();
	  for(E e : this){
		  copy.push(e);
		  if (e == null){
			  break;
		  }
	  }
	  copy = copy.reverse();
	  return copy;
  }

  // Task 1(c): 8 points
  @Override
  public int compareTo(CellList<E> list) {
	  int len1 = this.getLength();
	  int len2 = list.getLength();
	  if ((len1 - len2) < 0){
		return -1;
	  }
	  else if((len1 - len2) > 0){
		return 1;
	  }
	  else{
	  return 0;
	  }
  }

  // Task 2: equals + hashCode = 15 points (hashCode can simply return 
  // the length; if no hashCode implementation is given, then -10 points;
  // if incorrect implementation of equals, then also -10 points; 
  // but maximum 15 points off for Task 2.)
  

  // override equals()
  @Override
  public boolean equals(Object o) { 
	  if (!(o instanceof CellList)){ //checking instance of o
		   return false;
	  }
	  CellList<?> list = (CellList<?>) o;
	  if (list.hashCode() != this.hashCode()){ //if the hashCode does not match (lengths of list)
		  return false;
	  }
	  
	  Object[] origList = new Object[length]; // length should be the same so list.getLength() is unnessesary.
	  Object[] passList = new Object[list.getLength()];
	  int i = 0;
	  for(E e : this){
		  origList[i] = e;
		  //System.out.println(e); //for testing purposes
		  i++;
	  }
	  int j = 0;
	  for(Object o1 : list){
		  passList[j] = o1;
		  //System.out.println(o1); //for testing purposes
		  j++;
	  }
	  Arrays.sort(origList);
	  Arrays.sort(passList);
	  for(int k = 0; k < length; k++){
		if(origList[k] != passList[k]){
			return false;
		}
	  }
	  return true;
  }

  // override hashCode()
  @Override
  public int hashCode(){ //works
	  return this.getLength(); //prob return length; is fine
  }

  // Task 3: two constructors (10 points)
  // 2 points
  public CellList() {
	  n = null;
	  length = 0;
  }
    
  // 8 points
  public CellList(Iterable<E> iterable) {
	  length = 0;
	  n = new Cell<E>(iterable.iterator().next(), null);
	  Cell<E> curr = n; //first add (head)
	  for(E e : iterable){
		  if (length == 0){
			  length++;
		  }
		  else{
			  Cell<E> next = new Cell<E>(e, null);
			  curr.setNext(next);
			  curr = next;
			  length++;
		  }
	  }
  }

				
  // Task 4: total 20 points for the following methods
  // 5 points
  public CellList<E> reverse() {
	  //Object[] list = new Object[length];
	  if (n == null){
		  return this;
	  }
	  CellList<E> reverseList = new CellList<E>();
	  for(E e : this){
		  reverseList.push(e);
	  }
	  return reverseList;
  }

  // 5 points
  @Override
  public String toString() {
	  String out = "[(head: ";
	  if (n == null){
		out = out + ")]";
		return out;
	  }
	  for(E e : this){
		  out = out + e + ") -> (";
	  }
	  out = out.substring(0, out.length() - 6);
	  out = out + ")]";
	  return out;
  }

  // 5 points
  public void push(E item) {
	  Cell<E> temp = new Cell<E>(item, n);
	  n = temp;
	  length = length + 1;
  }

  // 5 points
  public E pop() {
	  
	  E e = n.getVal();
	  if(n.getNext() == null){ //if this is the only cell in the list (1 cell list)
		  n = null;
	  }
	  else{
		  Cell<E> temp = new Cell<E>(n.getNext().getVal(), n.getNext().getNext());
		  n = temp;
	  }
	  length = length - 1;
	  return e;
  }

  // given 
  public E peek() { return n.getVal(); }

  // given 
  public int getLength() { return length; }
}

