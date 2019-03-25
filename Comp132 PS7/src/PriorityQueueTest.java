
import java.util.PriorityQueue;
import java.util.Stack;

public class PriorityQueueTest {
   public static void main(String[] args) {
      // queue of capacity 5 and a new Comparator
      PriorityQueue<Double> queue = new PriorityQueue<>();
      Stack<Double> stack = new Stack<Double>();
      // insert elements to queue
      queue.offer(3.2);
      queue.offer(9.8);
      queue.offer(5.4);

      System.out.print("Polling from queue: ");

      // display elements in queue
      while (queue.size()> 0) {
         double number = queue.poll(); // remove top element
         stack.add(number);
      }
      while (stack.size()> 0) {
          double number = stack.pop(); // remove top element
          System.out.printf(" %1.1f ",number);
       }
     
   } 

   // Write Double Comparator method here
}
