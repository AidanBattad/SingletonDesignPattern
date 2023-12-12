import java.util.LinkedList;
import java.util.Queue;
public class Application {
    static class QueuingSystem
    {
        private static QueuingSystem instance;
        private Queue<Integer> queue;
        private QueuingSystem() {
            queue = new LinkedList<>();
        }
        public static QueuingSystem getInstance()
        {
            if (instance == null)
            {
                instance = new QueuingSystem();
            }
            return instance;
        }
        public void enqueue(int number)
        {
            queue.add(number);
        }
        public int dequeue()
        {
            if (!queue.isEmpty())
            {
                return queue.poll();
            } else
            {
                System.out.println("Queue is empty.");
                return -1;
            }
        }
        public int getCurrentNumber()
        {
            if (!queue.isEmpty())
            {
                return queue.peek();
            } else
            {
                System.out.println("Queue is empty.");
                return -1;
            }
        }

        public void resetQueue(int newStartingNumber)
        {
            queue.clear();
            enqueue(newStartingNumber);
            System.out.println("Queue has been reset to " + newStartingNumber);
        }

        public int getQueueSize()
        {
            return queue.size();
        } }
    static class HelpDeskStation
    {
        private String name;

        public HelpDeskStation(String name) {
            this.name = name;
        }

        public void serveNext()
        {
            QueuingSystem queuingSystem = QueuingSystem.getInstance();
            int nextNumber = queuingSystem.dequeue();
            if (nextNumber != -1)
            {
                System.out.println(name + " serving customer with number: " + nextNumber);
            }
        }

        public void resetQueue(int newStartingNumber)
        {
            QueuingSystem queuingSystem = QueuingSystem.getInstance();
            queuingSystem.resetQueue(newStartingNumber);
        } }

    static class OnlineMonitoringSystem
    {
        public void displayCurrentNumber()
        {
            QueuingSystem queuingSystem = QueuingSystem.getInstance();
            int currentNumber = queuingSystem.getCurrentNumber();
            if (currentNumber != -1)
            {
                System.out.println(" Monitoring: Current queued Customer number is " + currentNumber);
            }
        }
    }

}
