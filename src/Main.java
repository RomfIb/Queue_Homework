import java.util.*;

public class Main {
    public static void main(String[] args) {

        Queue<Patient> patientQueue = new ArrayDeque<>();
        try {
            Patient.offer(patientQueue ,new Patient("Ali", 30));
            Patient.offer(patientQueue ,new Patient("Vali", 25));
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();
        Patient.print(patientQueue);
        System.out.println("Queue size: " + Patient.size(patientQueue));
        System.out.println();
        Patient.poll(patientQueue);

        System.out.println();
        Patient.print(patientQueue);

        Queue<Ticket> ticketQueue = new PriorityQueue<>(
                Comparator.comparingInt(Ticket::getPriority)
        );

        Ticket.offer(ticketQueue, new Ticket("Standart", 2));
        Ticket.offer(ticketQueue, new Ticket("VIP", 4));
        Ticket.offer(ticketQueue, new Ticket("Budget", 1));
        Ticket.offer(ticketQueue, new Ticket("Business", 3));

        System.out.println("\n--- Selling minimal prioriry ---");

        Ticket.sell(ticketQueue);
        Ticket.sell(ticketQueue);
        Ticket.sell(ticketQueue);
        Ticket.sell(ticketQueue);


        Deque<Client> clientDeque = new ArrayDeque<>();
        Client.offer(clientDeque, new Client("Ali", false));
        Client.offer(clientDeque, new Client("Vali", true));
        Client.offer(clientDeque, new Client("Pivalli", false));
        System.out.println(clientDeque);


        Map<Client, Double> clientMap = new HashMap<>();
        clientMap.put(new Client("Ali"), 1500.0);
        clientMap.put(new Client("Vali"), 400.0);
        clientMap.put(new Client("Pirvali"), 2800.0);
        clientMap.put(new Client("Ceyhun"), 5500.0);
        Client.clientStatus(clientMap);
    }
}