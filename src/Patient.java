import java.util.ArrayDeque;
import java.util.Queue;

public class Patient {
    private String name;
    private int age;

    public Patient(String name, int age) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Invalid age of patient: " + age);
        }

        this.name = name;
        this.age = age;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public static void offer(Queue<Patient> queue,Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException("Cannot offer null");
        }
        queue.offer(patient);
        System.out.println("Patient " + patient.getName() + " is offered to queue");
    }

    public static Patient poll(Queue<Patient> queue) {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Error: queue is empty");
        }
        Patient nextPatient = queue.poll();
        System.out.println("Patient " + nextPatient.getName() + " is called to doctor");
        return nextPatient;
    }

    public static int size(Queue<Patient> queue) {
        return queue.size();
    }

    public static boolean isEmpty(Queue<Patient> queue) {
        return queue.isEmpty();
    }

    public static void print(Queue<Patient> queue) {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("=== Current patient queue ===");
        for (Patient p : queue) {
            System.out.println("- " + p.getName() + " (" + p.getAge() + " years)");
        }
        System.out.println("=================================");
    }
}
