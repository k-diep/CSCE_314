NOTE: Ran on a Windows System.
On command prompt go to the directory where these files exist.


Problem 1:
PrintServerV1

Run: 
javac PrintServerV1.java
java PrintServerV1
--------------------------------------------------------------
Results: 
Printing ... client 11 sends you message 11: 0 client of class PrintServerV1
Printing ... client 15 sends you message 15: 0 client of class PrintServerV1
Printing ... client 15 sends you message 15: 1 client of class PrintServerV1
Printing ... client 11 sends you message 11: 1 client of class PrintServerV1
Printing ... client 15 sends you message 15: 2 client of class PrintServerV1
Printing ... client 11 sends you message 11: 2 client of class PrintServerV1
Printing ... client 15 sends you message 15: 3 client of class PrintServerV1
Printing ... client 15 sends you message 15: 4 client of class PrintServerV1
Printing ... client 11 sends you message 11: 3 client of class PrintServerV1
Printing ... client 15 sends you message 15: 5 client of class PrintServerV1
Printing ... client 11 sends you message 11: 4 client of class PrintServerV1
Printing ... client 15 sends you message 15: 6 client of class PrintServerV1
Printing ... client 11 sends you message 11: 5 client of class PrintServerV1
Printing ... client 15 sends you message 15: 7 client of class PrintServerV1
Printing ... client 15 sends you message 15: 8 client of class PrintServerV1
Printing ... client 11 sends you message 11: 6 client of class PrintServerV1
Printing ... client 15 sends you message 15: 9 client of class PrintServerV1
Printing ... client 11 sends you message 11: 7 client of class PrintServerV1
Printing ... client 15 sends you message 15: 10 client of class PrintServerV1
Printing ... client 11 sends you message 11: 8 client of class PrintServerV1
Printing ... client 15 sends you message 15: 11 client of class PrintServerV1
Printing ... client 15 sends you message 15: 12 client of class PrintServerV1
Printing ... client 11 sends you message 11: 9 client of class PrintServerV1
Printing ... client 15 sends you message 15: 13 client of class PrintServerV1
Printing ... client 11 sends you message 11: 10 client of class PrintServerV1
Printing ... client 15 sends you message 15: 14 client of class PrintServerV1
Printing ... client 11 sends you message 11: 11 client of class PrintServerV1
Printing ... client 15 sends you message 15: 15 client of class PrintServerV1
^C

(NOTE: Runs forever, stopped using CTRL-C)


Problem 2:
PrintServerV2
Run: 
javac PrintServerV2.java
java PrintServerV2
--------------------------------------------------------------
Results: (NOTE: Runs forever, stopped using CTRL-C)
Printing ... client 15 sends you message 15: 0 client of class PrintServerV2
Printing ... client 11 sends you message 11: 0 client of class PrintServerV2
Printing ... client 15 sends you message 15: 1 client of class PrintServerV2
Printing ... client 11 sends you message 11: 1 client of class PrintServerV2
Printing ... client 15 sends you message 15: 2 client of class PrintServerV2
Printing ... client 11 sends you message 11: 2 client of class PrintServerV2
Printing ... client 15 sends you message 15: 3 client of class PrintServerV2
Printing ... client 15 sends you message 15: 4 client of class PrintServerV2
Printing ... client 11 sends you message 11: 3 client of class PrintServerV2
Printing ... client 15 sends you message 15: 5 client of class PrintServerV2
Printing ... client 11 sends you message 11: 4 client of class PrintServerV2
Printing ... client 15 sends you message 15: 6 client of class PrintServerV2
Printing ... client 11 sends you message 11: 5 client of class PrintServerV2
Printing ... client 15 sends you message 15: 7 client of class PrintServerV2
Printing ... client 15 sends you message 15: 8 client of class PrintServerV2
Printing ... client 11 sends you message 11: 6 client of class PrintServerV2
Printing ... client 15 sends you message 15: 9 client of class PrintServerV2
Printing ... client 11 sends you message 11: 7 client of class PrintServerV2
Printing ... client 15 sends you message 15: 10 client of class PrintServerV2
Printing ... client 11 sends you message 11: 8 client of class PrintServerV2
Printing ... client 15 sends you message 15: 11 client of class PrintServerV2
Printing ... client 15 sends you message 15: 12 client of class PrintServerV2
Printing ... client 11 sends you message 11: 9 client of class PrintServerV2
Printing ... client 15 sends you message 15: 13 client of class PrintServerV2
Printing ... client 11 sends you message 11: 10 client of class PrintServerV2
Printing ... client 15 sends you message 15: 14 client of class PrintServerV2
Printing ... client 11 sends you message 11: 11 client of class PrintServerV2
Printing ... client 15 sends you message 15: 15 client of class PrintServerV2
^C

(NOTE: Runs forever, stopped using CTRL-C)


For the outputs of both PrintServer, I had the same outputs for both classes .(except for the class name 
for obvious reasons). However my output is different from the output from the hw6.pdf, however it follows 
a similar stucture. That is for each subsequent from a particular client, it outputs the next messageNo. 
As such, each run of either code will produce the same output. 

However, the differences in my output vs. the output of the PDF's is entirely because mutlithreading in 
Java is unpreditable. This means we as programmers do not know which Thread will execute first. The JVM 
(as well as the OS) will choose the first thread. 