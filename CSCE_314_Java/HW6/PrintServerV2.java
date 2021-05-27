/* Skeleton for PrintServerV2.  Written by Hyunyoung Lee */

/* Student Name: Khoa Diep
 * Student UIN: 926005094
 * Acknowledgements: 
 https://www.knowprogram.com/java/getclass-method-java/
 https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/locks/Condition.html#await()
 Class Slides
 Textbook (Java Programming)
 */

// Do not modify the import statements
import java.util.Queue;
import java.util.LinkedList;

public class PrintServerV2 implements Runnable {
  // Shared fields among all threads: Do not modify
  private static final Queue<String> requests = new LinkedList<String>();

  // Instance members for each thread
  private String title; // manager or client
  private int id; // just some sequential number
  private int messageNo = 0; // sequential number for messages per client
  
  //Object lockA = new Object();
  

  // Constructor with two arguments (see main())
  public PrintServerV2(String title, int id) { 
	this.title = title;
	this.id = id;
  }

  public void printRequest(String s) {
    // use a synchronized block with the print job queue synchronized
    // in the block, place the client's message in the print job queue and
    // notify all other threads
	synchronized(requests){
		//String cMessage = "Printing ... client " + id + " sends you message " + id + ": " +  messageNo + " client of class " + this.getClass().getName(); ;// TBD
		requests.add(s);
		requests.notifyAll();
		//realPrint(cMessage);
	} 
  }

  // The run() method structure is exactly the same as that of PrintServerV1
  // but instead of using lock, here use synchronized
  public void run() {
	for(;;) {
      // if manager
      if (title == "manager") {
        // aquire the lock
		synchronized (requests){
			
		  try {
            // if () ; // if there is a message to print, then print it 
            // else 
		    if(requests.size()!=0){
			    String message = requests.remove();
			    realPrint(message);
				
		    }
		    else{
               // wait for the condition to change that
               // new messages are added
			   while(requests.size()==0){
				requests.wait();
			   }
		    }
		  }
		  catch (InterruptedException e) {
			  System.out.println("Error");
		  }
        }
	  }
      else {// client 
        try {
          // invoke printRequest with a meaningful message (see 
          // hw6.pdf for the message contents requirement)
          // let the thread sleep a bit to slow down so I can read the output
		  String cMessage = "Printing ... client " + id + " sends you message " + id + ": " +  messageNo + " client of class " + this.getClass().getName(); ;// TBD
		  printRequest(cMessage);
		  messageNo++;
          Thread.sleep(1000/id);
        } catch (InterruptedException e) {
			System.out.println("Error");
		
		}
	  }
    }
  }

  // realPrint() simply prints out the message s
  private void realPrint(String s) {
	  System.out.println(s); // same as V1
  }

  public static void main(String[] args) {
    // In the following invocations of the constructor,
    // the first argument is the title and the second argument is the ID
    PrintServerV2 m = new PrintServerV2("manager", 0);
    PrintServerV2 c1 = new PrintServerV2("client1", 11);
    PrintServerV2 c2 = new PrintServerV2("client2", 15);
    new Thread(m).start();
    new Thread(c1).start();
    new Thread(c2).start();
  }
}

