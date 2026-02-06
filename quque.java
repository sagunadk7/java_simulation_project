import java.util.LinkedList;
import java.util.Queue;
public class quque {
  public static void main(String[] args) {
    Queue<String> queue = new LinkedList<>();
    queue.add("Alice");
    queue.add("Hero");
    System.out.println("Initial queue: "+queue);
    System.out.println("Front element: "+queue.peek());
    System.out.println("Queue contains ALice?"+queue.contains("alice"));
    if(!queue.isEmpty()){
        String removed = queue.poll();
        System.out.println("Rremoved: "+removed);
        String old = queue.poll();
        // queue.offer(old);
    }
    System.out.println("Queue after updated: "+queue);
  } 
}
