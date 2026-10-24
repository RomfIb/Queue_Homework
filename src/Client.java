import java.util.Deque;
import java.util.Map;

public class Client {
    private String name;
    private boolean isVIP;

    public Client(String name, boolean isVIP) {
        this.name = name;
        this.isVIP = isVIP;
    }

    public Client(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public static void offer(Deque<Client> clientDeque, Client client) {
        if (client == null) {
            throw new IllegalArgumentException("Нельзя добавить пустого клиента.");
        }

        if (client.isVIP()) {
            clientDeque.offerFirst(client);
            System.out.println("VIP client " + client.getName() + " is in the begining of queue");
        } else {
            clientDeque.offerLast(client);
            System.out.println("Client " + client.getName() + " is at the end of queue");
        }
    }

    public static void clientStatus(Map<Client, Double> clientDoubleMap) {
        for (Map.Entry<Client, Double> entry : clientDoubleMap.entrySet()) {
            if (entry.getValue() < 1000)
                System.out.println("Client " + entry.getKey() + " is standart");
            else if (entry.getValue() < 2000)
                System.out.println("Client " + entry.getKey() + " is silver");
            else if (entry.getValue() < 5000)
                System.out.println("Client " + entry.getKey() + " is gold");
            else
                System.out.println("Client " + entry.getKey() + " is vip");
        }
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean isVIP() {
        return isVIP;
    }

    public void setVIP(boolean VIP) {
        isVIP = VIP;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", isVIP=" + isVIP +
                '}';
    }
}
