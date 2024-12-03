import java.io.*;

// Employee class implementing Serializable
class Employee implements Serializable {
    private String name;
    private int id;

    // Constructor
    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // Override toString for easy printing
    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + id;
    }
}

public class EmployeeSerialization {
    public static void main(String[] args) {
        String filename = "employees.ser";

        // Create Employee objects
        Employee emp1 = new Employee("Alice", 101);
        Employee emp2 = new Employee("Bob", 102);
        Employee emp3 = new Employee("Charlie", 103);

        // Serialize Employee objects to a file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(emp1);
            oos.writeObject(emp2);
            oos.writeObject(emp3);
            System.out.println("Employees serialized successfully.");
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }

        // Deserialize Employee objects from the file
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Employee deserializedEmp1 = (Employee) ois.readObject();
            Employee deserializedEmp2 = (Employee) ois.readObject();
            Employee deserializedEmp3 = (Employee) ois.readObject();

            // Print deserialized Employee objects
            System.out.println("Deserialized Employees:");
            System.out.println(deserializedEmp1);
            System.out.println(deserializedEmp2);
            System.out.println(deserializedEmp3);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
        }
    }
}
