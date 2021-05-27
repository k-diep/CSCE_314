NOTE: Ran on a Windows System
On command prompt go to the directory where these files exist. 

Problem 1:
Run: 
javac CellTest.java
java CellTest
----------------------------------------------------------------------
Results: 
===
1 22 21 12 24 17
sum of intlist is 97
sum of null list is 0
===
===
1.0 16.0 13.72 5.0 22.0 7.1
sum ints = 97.0
sum doubles = 64.82
===
NOTE: same outputs as the Homework pdf.



Problem 2:
Run: 
javac CellListTest.java
java CellListTest
----------------------------------------------------------------------
Results: 
stringlist = [(head: A) -> (the) -> (the) -> (dove)]
stringlist2 = [(head: A) -> (dove) -> (the) -> (the)]
stringlist3 = [(head: A) -> (dove) -> (dove) -> (the)]
stringlist equals to stringlist2 ? true
stringlist equals to stringlist3 ? false
CellList<Integer> equals to CellList<String> ? false
list  = [(head: 1) -> (2) -> (3) -> (4)]
list1 = [(head: 2) -> (4) -> (3) -> (1)]
list == list1 is false
list.equals(list1) = true
list3 = [(head: 1) -> (2) -> (3) -> (1)]
list4 = [(head: 1) -> (2) -> (3) -> (1) -> (4)]
list1.equals(list3) = false
list1.equals(list4) = false
list.compareTo(list1) = 0
list.compareTo(list4) = -1
[(head: 1) -> (2) -> (3) -> (4)]
[(head: 4) -> (3) -> (2) -> (1)]
[(head: 4) -> (3) -> (2) -> (1)]
1
[(head: 22) -> (21) -> (2) -> (3) -> (4)]
22
[(head: 22) -> (21) -> (2) -> (3) -> (4)]
22 22
21 21
2 2
3 3
4 4
list1 = [(head: 2) -> (4) -> (3) -> (1)]
list2 = [(head: 4) -> (3) -> (2) -> (21) -> (22) -> (1) -> (2) -> (3) -> (4)]
list2.compareTo(list1) = 1
=== end of test
NOTE: same outputs as the Homework pdf.
