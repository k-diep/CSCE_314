/* Skeleton for PrintServerV1.  Written by Hyunyoung Lee */

/* Student Name: Khoa Diep
 * Student UIN: 926005094
 * Acknowledgements: 
 https://www.knowprogram.com/java/getclass-method-java/
 https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/locks/Condition.html#await()
 
 */

// Do not modify the import statements 
import java.util.Queue;
import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class PrintServerV1 implements Runnable {
  // Shared fields among all threads: Do not modify
  private static final Queue<String> requests = new LinkedList<String>();
  private static Lock changeLock = new ReentrantLock();
  private static Condition newMessage = changeLock.newCondition();

  // Instance members for each thread
  private String title; // manager or client
  private int id; // just some sequential number
  private int messageNo = 0; // sequential number for messages per client

  // Constructor with two arguments (see main())
  public PrintServerV1(String title, int id) {
	  this.title = title;
	  this.id = id;
  }

  public void printRequest(String s) {
    // aquire the lock
	changeLock.lock();
    try {
      // place the client's message in the print job queue and
      // signal all other threads
	  requests.add(s);
	  newMessage.signalAll();
    }
    finally {
      // release the lock
	  changeLock.unlock();
    }
  }

  public void run() {
    for(;;) {
      // if manager
      if (title == "manager") {
        // aquire the lock
		changeLock.lock();
        try {
          // if () ; // if there is a message to print, then print it 
          // else 
		  if(requests.size()!=0){
			  String message = requests.remove();
			  realPrint(message);
		  }
		  else{
            try {
               // wait for the condition to change that
               // new messages are added
			   newMessage.await();
            } catch (InterruptedException e) {
				System.out.println("Error");
			}
		  }
        } finally {
          changeLock.unlock();
        }
      } else // client 
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

  // realPrint() simply prints out the message s
  private void realPrint(String s) { 
	System.out.println(s);
  }

  public static void main(String[] args) {
    // In the following invocations of the constructor,
    // the first argument is the title and the second argument is the ID
    PrintServerV1 m = new PrintServerV1("manager", 0);
    PrintServerV1 c1 = new PrintServerV1("client", 11);
    PrintServerV1 c2 = new PrintServerV1("client", 15);
    new Thread(m).start();
    new Thread(c1).start();
    new Thread(c2).start();
  }
}

