import java.io.*;
import java.util.*;

class Student implements Serializable {
    int id;
    String name;
    double marks;

    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
}

public class StudentSystem {

    static final String FILE_NAME = "students.dat";

    
    static List<Student> readStudents() {
        List<Student> list = new ArrayList<>();
        try {
            File file = new File(FILE_NAME);
            if (!file.exists() || file.length() == 0) return list;

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            list = (List<Student>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            System.out.println("Error reading file!");
        }
        return list;
    }

   
    static void writeStudents(List<Student> list) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            oos.writeObject(list);
            oos.close();
        } catch (Exception e) {
            System.out.println("Error writing file!");
        }
    }

    
    static void addStudent(Scanner sc) {
        List<Student> list = readStudents();

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        list.add(new Student(id, name, marks));
        writeStudents(list);

        System.out.println("Student added!");
    }

    
    static void deleteStudent(Scanner sc) {
        List<Student> list = readStudents();

        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        boolean removed = list.removeIf(s -> s.id == id);

        if (removed) {
            writeStudents(list);
            System.out.println("Student deleted!");
        } else {
            System.out.println("Student not found!");
        }
    }

    
    static void searchStudent(Scanner sc) {
        List<Student> list = readStudents();

        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();

        boolean found = false;
        for (Student s : list) {
            if (s.id == id) {
                System.out.println("Found: ID=" + s.id +
                        " Name=" + s.name +
                        " Marks=" + s.marks);
                found = true;
                break;
            }
        }

        if (!found) System.out.println("Student not found!");
    }

    
    static void sortStudents() {
        List<Student> list = readStudents();

        if (list.isEmpty()) {
            System.out.println("No data!");
            return;
        }

        list.sort((a, b) -> Double.compare(b.marks, a.marks)); // descending

        System.out.println("\n--- Sorted by Marks ---");
        for (Student s : list) {
            System.out.println("ID: " + s.id +
                    " Name: " + s.name +
                    " Marks: " + s.marks);
        }
    }

    
    static void viewAll() {
        List<Student> list = readStudents();

        if (list.isEmpty()) {
            System.out.println("No students!");
            return;
        }

        for (Student s : list) {
            System.out.println("ID: " + s.id +
                    " Name: " + s.name +
                    " Marks: " + s.marks);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Insert 2.Delete 3.Search 4.Sort 5.View 6.Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1: addStudent(sc); break;
                case 2: deleteStudent(sc); break;
                case 3: searchStudent(sc); break;
                case 4: sortStudents(); break;
                case 5: viewAll(); break;
                case 6: System.exit(0);
                default: System.out.println("Invalid choice!");
            }
        }
    }
}
