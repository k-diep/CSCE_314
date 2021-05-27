For Fibonacci.java
Run these lines in the command line in the directory these files exist on. 

javac Fibonacci.java
java SubsetOutputFeb be en, where be and en are int command line arguments.
--------------------------------------------------------------------
ex. 1 
java SubsetOutputFeb 4 7

returns:
4: 3
5: 5
6: 8 *
7: 13

java ImprovedFibonacci
--------------------------------------------------------------------
returns:
1: 1
2: 1
3: 2 *
4: 3
5: 5
6: 8 *
7: 13
8: 21
9: 34 *




For Vehicle.java
Run these lines in the command line in the directory these files exist on. 

javac Vehicle.java
java VehicleTest
--------------------------------------------------------------------

returns:
V1 ------------------------
10
359
Anon
0
10 359 Anon 0

V2 ------------------------
20
90
Khoa
1
20 90 Khoa 1

V3 ------------------------
8000
0
Sonic
2
8000 0 Sonic 2

V4 ------------------------
10
50
Turtle
3
10 50 Turtle 3

V5 ------------------------
20
100
John Doe
4
20 100 John Doe 4

Highest ID so far is: 4

Testing changeSpeed() and stop() ------------------------
Speed before changeSpeed(1000): 20
Speed after changeSpeed(1000): 1000
Speed after stop(): 0

Testing turn() ------------------------
Direction before turn(-180): 100
Direction after turn(-180): 280
Direction after turn(-90): 190
Direction after turn(45): 235
Direction after turn(Vehicle.TURN_LEFT): 145
Direction after turn(Vehicle.TURN_LEFT): 55
Direction after turn(Vehicle.TURN_RIGHT): 145
Direction after turn(Vehicle.TURN_RIGHT): 235


This tests all the problems in the homework, which are both constructors, setters and getters, HighestID, changeSpeed(), stop(), and turn().

java VehicleTestP5
--------------------------------------------------------------------
returns:
V1 ------------------------
10
359
Khoa
0

V2 ------------------------
20
0
Bob
1

V3 ------------------------
80
0
Highwayman
2

V4 ------------------------
200000000
100
Sonic
3

V5 ------------------------
10
50
Turtle
4

This test setters and getters for vehicle.