import java.util.*;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;

        do {
            System.out.println("\n1.Add 2.Sub 3.Mul 4.Div 5.Exit");
            ch = sc.nextInt();

            if (ch >= 1 && ch <= 4) {
                System.out.print("Enter 2 numbers: ");
                int a = sc.nextInt();
                int b = sc.nextInt();

                switch (ch) {
                    case 1: System.out.println(a + b); break;
                    case 2: System.out.println(a - b); break;
                    case 3: System.out.println(a * b); break;
                    case 4: System.out.println(a / b); break;
                }
            }

        } while (ch != 5);
    }
}
