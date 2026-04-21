import java.io.*;
import java.util.*;

class Book implements Serializable {
    int id;
    String name;
    String author;
    boolean issued;

    Book(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.issued = false;
    }
}

public class LibrarySystem {

    static final String FILE_NAME = "library.dat";

    // Read books safely
    static List<Book> readBooks() {
        List<Book> books = new ArrayList<>();

        try {
            File file = new File(FILE_NAME);
            if (!file.exists() || file.length() == 0) {
                return books; // empty list if file not ready
            }

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            books = (List<Book>) ois.readObject();
            ois.close();

        } catch (EOFException e) {
            // Empty file case (ignore)
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return books;
    }

    // Write books
    static void writeBooks(List<Book> books) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            oos.writeObject(books);
            oos.close();
        } catch (Exception e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    static void addBook(Scanner sc) {
        List<Book> books = readBooks();

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        books.add(new Book(id, name, author));
        writeBooks(books);

        System.out.println("Book Added!");
    }

    static void issueBook(Scanner sc) {
        List<Book> books = readBooks();

        System.out.print("Enter ID to issue: ");
        int id = sc.nextInt();

        boolean found = false;
        for (Book b : books) {
            if (b.id == id) {
                found = true;
                if (b.issued) {
                    System.out.println("Already issued!");
                } else {
                    b.issued = true;
                    System.out.println("Issued successfully!");
                }
                break;
            }
        }

        if (!found) System.out.println("Book not found!");

        writeBooks(books);
    }

    static void returnBook(Scanner sc) {
        List<Book> books = readBooks();

        System.out.print("Enter ID to return: ");
        int id = sc.nextInt();

        boolean found = false;
        for (Book b : books) {
            if (b.id == id) {
                found = true;
                if (!b.issued) {
                    System.out.println("Not issued!");
                } else {
                    b.issued = false;
                    System.out.println("Returned!");
                }
                break;
            }
        }

        if (!found) System.out.println("Book not found!");

        writeBooks(books);
    }

    static void updateBook(Scanner sc) {
        List<Book> books = readBooks();

        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        boolean found = false;
        for (Book b : books) {
            if (b.id == id) {
                found = true;

                System.out.print("Enter new name: ");
                b.name = sc.nextLine();

                System.out.print("Enter new author: ");
                b.author = sc.nextLine();

                System.out.println("Updated!");
                break;
            }
        }

        if (!found) System.out.println("Book not found!");

        writeBooks(books);
    }

    static void viewBooks() {
        List<Book> books = readBooks();

        if (books.isEmpty()) {
            System.out.println("No books available!");
            return;
        }

        for (Book b : books) {
            System.out.println("ID: " + b.id +
                    " | Name: " + b.name +
                    " | Author: " + b.author +
                    " | Status: " + (b.issued ? "Issued" : "Available"));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Add 2.Issue 3.Return 4.Update 5.View 6.Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            switch (ch) {
                case 1: addBook(sc); break;
                case 2: issueBook(sc); break;
                case 3: returnBook(sc); break;
                case 4: updateBook(sc); break;
                case 5: viewBooks(); break;
                case 6: System.exit(0);
                default: System.out.println("Invalid choice!");
            }
        }
    }
}
