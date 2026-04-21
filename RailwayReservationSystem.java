import java.util.Scanner;

class RailwayReservationSystem {
    static final int TOTAL_SEATS = 10;
    static boolean seats[] = new boolean[TOTAL_SEATS];

    
    static void bookTicket(int seatNo) {
        if (seatNo < 1 || seatNo > TOTAL_SEATS) {
            System.out.println("Invalid seat number!");
        } else if (seats[seatNo - 1]) {
            System.out.println("Seat already booked!");
        } else {
            seats[seatNo - 1] = true;
            System.out.println("Seat " + seatNo + " booked successfully!");
        }
    }


    static void cancelTicket(int seatNo) {
        if (seatNo < 1 || seatNo > TOTAL_SEATS) {
            System.out.println("Invalid seat number!");
        } else if (!seats[seatNo - 1]) {
            System.out.println("Seat is not booked yet!");
        } else {
            seats[seatNo - 1] = false;
            System.out.println("Seat " + seatNo + " cancelled successfully!");
        }
    }

    
    static void viewSeats() {
        int booked = 0, available = 0;

        System.out.println("\nSeat Status:");
        for (int i = 0; i < TOTAL_SEATS; i++) {
            if (seats[i]) {
                System.out.println("Seat " + (i + 1) + " : Booked");
                booked++;
            } else {
                System.out.println("Seat " + (i + 1) + " : Available");
                available++;
            }
        }

        System.out.println("\nTotal Booked Seats: " + booked);
        System.out.println("Total Available Seats: " + available);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice, seatNo;

        while (true) {
            System.out.println("\n--- Railway Reservation System ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. View Seats");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter seat number to book (1-10): ");
                    seatNo = sc.nextInt();
                    bookTicket(seatNo);
                    break;

                case 2:
                    System.out.print("Enter seat number to cancel (1-10): ");
                    seatNo = sc.nextInt();
                    cancelTicket(seatNo);
                    break;

                case 3:
                    viewSeats();
                    break;

                case 4:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
