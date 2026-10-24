import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Ticket {
    private String id;
    private int priority;


    public Ticket(String id, int priority) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Id cannot be empty or null");
        }

        this.id = id;
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }


    public static void offer(Queue<Ticket> ticketQueue, Ticket ticket) {
        if (ticket == null) {
            throw new IllegalArgumentException("Нельзя добавить пустой билет.");
        }
        ticketQueue.offer(ticket);
        System.out.println("Offered: " + ticket.getId() + " [Priority: " + ticket.getPriority() + "]");
    }

    public static Ticket sell(Queue<Ticket> ticketQueue) {
        if (ticketQueue.isEmpty()) {
            throw new IllegalStateException("Error: all tickets are sold");
        }

        Queue<Ticket> tempQueue = new PriorityQueue<>();

        Ticket minTicket = null;
        for (Ticket current : ticketQueue) {
            if (minTicket == null || current.getPriority() < minTicket.getPriority()) {
                minTicket = current;
            }
        }

        boolean removed = false;
        while (!ticketQueue.isEmpty()) {
            Ticket current = ticketQueue.poll();
            if (current == minTicket && !removed) {
                removed = true;
            }
            else {
                tempQueue.offer(current);
            }
        }
        ticketQueue.addAll(tempQueue);

        System.out.println("SOLD: " + minTicket.getId() + " [Priority: " + minTicket.getPriority() + "]");
        return minTicket;
    }
}