import java.time.LocalDateTime;
import java.util.Scanner;
public class Library {
    private Node head = null;
    private Node2 head1 = null;
    private final Scanner scanner = new Scanner(System.in); // Creating a Scanner object for input

    private String Studentname;
    private int SeNumber;
    private String bookname;
    static class Node {
        int id;
        String name;
        String Book_Content;
        String author;
        String publisher;
        Node next_Node;
        int count;

        Node(int id, String name, String author) {
            this.id = id;
            this.name = name;
            this.author = author;
            this.next_Node = null;
        }
    }

    static class Node2 {
        String pn;
        String name;
        String bookname1;
        String author1;
        String publisher1;
        String category1;
        Node2 next_Node2;

        Node2(String pn, String name, String bookname1, String author1, String publisher1, String category1) {
            this.pn = pn;
            this.name = name;
            this.bookname1 = bookname1;
            this.author1 = author1;
            this.publisher1 = publisher1;
            this.category1 = category1;
            next_Node2 = null;
        }
    }

    private String getLogin() {
        // Define your getLogin() method implementation here
        // For now, I'll just return a placeholder string
        return "<====== Login ======>";
    }

    public void menu() {
        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("<====== Welcome to Library Management System ======>");
            System.out.println("1. Librarian");
            System.out.println("2. Student");
            System.out.println("0. Exit");
            System.out.print("Enter Choice: ");
            int press = scanner.nextInt();
            switch (press) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    librarian();
                    break;
                case 2:
                    student();
                    break;
                default:
                    System.out.println("Invalid Entry");
            }
        }
    }

    private void librarian() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println(getLogin());
        System.out.print("Enter UserName: ");
        String username = scanner.next();
        System.out.print("Enter Password: ");
        String password = scanner.next();
        if (username.equals("Admin") && password.equals("Admin123")) {
            librarianDashboard();
        } else {
            System.out.println("Incorrect UserName or Password");
        }
    }

    private void librarianDashboard() {
        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("<===== Librarian DashBoard =====>");
            System.out.println("1. Insert Book");
            System.out.println("2. Search Book");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Show All Record");
            System.out.println("0. Main Menu");
            System.out.print("Enter Choice: ");
            int press = scanner.nextInt();
            switch (press) {
                case 0:
                    return;
                case 1:
                    insert();
                    break;
                case 2:
                    search();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    show();
                    break;
                default:
                    System.out.println("Invalid Entry");
            }
        }
    }

    private void insert() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("<=== Add Books ===>");
        System.out.print("Book Id: ");
        int id = scanner.nextInt();
        System.out.print("Book Name: ");
        String name = scanner.next();
        System.out.print("Author: ");
        String author = scanner.next();

        Node new_Node = new Node(id, name, author);

        if (head == null) {
            head = new_Node;
        } else {
            Node ptr = head;
            while (ptr.next_Node != null) {
                ptr = ptr.next_Node;
            }
            ptr.next_Node = new_Node;
        }
        System.out.println(" ");
        System.out.println("Book Added Successfully!");
        try {
            // Pause the program for one and a half seconds
            Thread.sleep(1500); // 1500 milliseconds = 1.5 seconds
        } catch (InterruptedException e) {
            // Handle interrupted exception if needed
            System.out.println("Error in adding book!");
            e.printStackTrace();
        }
    }

    private void search() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("<=== Search Books ===>");
        System.out.println("1. Search By Id");
        System.out.println("2. Search By Book Name");
        System.out.println("0. Main Menu");

        System.out.print("Enter Choice: ");
        int press = scanner.nextInt();
        switch (press) {
            case 0:
                return;
            case 1:
                searchById();
                break;
            case 2:
                searchByBookName();
                break;
            default:
                System.out.println("Invalid Entry");
        }
    }

    private void searchById() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("<=== Search Books ===>");
        System.out.print("Enter Book Id: ");
        int t_id = scanner.nextInt();
        Node ptr = head;
        int found = 0;
        while (ptr != null) {
            if (t_id == ptr.id) {
                displayBook(ptr);
                found++;
            }
            ptr = ptr.next_Node;
        }
        if (found == 0) {
            System.out.println("Book not found");
        }
        try {
            // Pause the program for five seconds
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle interrupted exception if needed
            e.printStackTrace();
        }
    }

    private void searchByBookName() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("<=== Search Books ===>");
        System.out.print("Enter Book Name: ");
        String t_name = scanner.next();
        Node ptr = head;
        int found = 0;
        while (ptr != null) {
            if (t_name.equals(ptr.name)) {
                displayBook(ptr);
                found++;
            }
            ptr = ptr.next_Node;
        }
        if (found == 0) {
            System.out.println("Book not found");
        }
        try {
            // Pause the program for five seconds
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle interrupted exception if needed
            e.printStackTrace();
        }
    }

    private void displayBook(Node node) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("<========= Available Books =========>");
        System.out.println("Book Id: " + node.id);
        System.out.println("Book Name: " + node.name);
        System.out.println("Author: " + node.author);
        try {
            // Pause the program for one and a half seconds
            Thread.sleep(1500); // 1500 milliseconds = 1.5 seconds
        } catch (InterruptedException e) {
            // Handle interrupted exception if needed
            e.printStackTrace();
        }
    }

    private void update() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("<=== Update Book ===>");
        System.out.println("Only One Book At A Time");
        System.out.print("Enter Book Id To Update: ");
        int t_id = scanner.nextInt();
        Node ptr = head;
        int found = 0;
        while (ptr != null) {
            if (t_id == ptr.id) {
                System.out.print("New Book Id: ");
                ptr.id = scanner.nextInt();
                System.out.print("Book Name: ");
                ptr.name = scanner.next();
                System.out.print("Author: ");
                ptr.author = scanner.next();
                found++;
                System.out.println("Book Has Been Updated Successfully");
            }
            ptr = ptr.next_Node;
        }
        if (found == 0) {
            System.out.println("Book not found");
        }
        try {
            // Pause the program for one and a half seconds
            Thread.sleep(1500); // 1500 milliseconds = 1.5 seconds
        } catch (InterruptedException e) {
            // Handle interrupted exception if needed
            System.out.println("Error occurred while updating book");
            e.printStackTrace();
        }
    }

    private void delete() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("<=== Delete Books ===>");
        System.out.print("Enter Book Id: ");
        int t_id = scanner.nextInt();
        int found = 0;
        if (head == null) {
            System.out.println("Book Shelf Is Empty");
        } else {
            if (t_id == head.id) {
                head = head.next_Node;
                found++;
                System.out.println("Book Deleted Successfully");
            } else {
                Node pre = head;
                Node ptr = head;
                while (ptr != null) {
                    if (t_id == ptr.id) {
                        pre.next_Node = ptr.next_Node;
                        found++;
                        System.out.println("Book Deleted Successfully");
                        break;
                    }
                    pre = ptr;
                    ptr = ptr.next_Node;
                }
            }
        }
        if (found == 0) {
            System.out.println("Book not found");
        }
    }

    private void show() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("<=== Books Record ===>");
        Node ptr = head;
        while (ptr != null) {
            displayBook(ptr);
            ptr = ptr.next_Node;
        }
        try {
            // Pause the program for five seconds
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle interrupted exception if needed
            e.printStackTrace();
        }
    }

    private void student() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println(getLogin());
        System.out.print("Enter UserName: ");
        String username = scanner.next();
        System.out.print("Enter Password: ");
        String password = scanner.next();
        if (username.equals("DSU") && password.equals("123")) {
            studentDashboard();
        } else {
            System.out.println("Incorrect UserName or Password");
        }
    }

    private void studentDashboard() {
        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("<===== Student DashBoard =====>");
            System.out.println("1. Borrow Book");
            System.out.println("2. Purchase Book");
            System.out.println("3. Donate Book");
            System.out.println("0. Main Menu");
            System.out.print("Enter Choice: ");
            int press = scanner.nextInt();
            switch (press) {
                case 0:
                    return;
                case 1:
                    borrow();
                    break;
                case 2:
                    purchase();
                    break;
                case 3:
                    donate();
                    break;
                default:
                    System.out.println("Invalid Entry");
            }
        }
    }

    private void borrow() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("<=== Borrow Books ===>");
        Node ptr = head;
        System.out.print("Enter Your Name: ");
        Studentname = scanner.next();
        System.out.print("Enter Your Student Id: ");
        SeNumber = scanner.nextInt();
        System.out.print("Enter Book Id to Borrow: ");
        int IdSearch = scanner.nextInt();
        int found = 0;
        while (ptr != null) {
            if (IdSearch == ptr.id) {
                displayBook(ptr);
                found++;
                System.out.println(" ");
                System.out.println("Borrow By: " + Studentname);
                System.out.println("Student-ID: " + SeNumber);
                System.out.println(" ");
                System.out.println("Book Borrowed Successfully");
                ptr.count++;
            }
            ptr = ptr.next_Node;
        }
        if (found == 0) {
            System.out.println("Book not found");
        }
        try {
            // Pause the program for five seconds
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle interrupted exception if needed
            e.printStackTrace();
        }
    }

    private void purchase() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("<=== Purchase Books ===>");
        System.out.print("Enter Your Name: ");
        Studentname = scanner.next();
        System.out.print("Enter Your Student Id: ");
        SeNumber = scanner.nextInt();
        System.out.println("Do you want PreOrder or Buy from Library?");
        System.out.println("Press 1 for PreOrder");
        System.out.println("Press 2 for Order From Library");
        System.out.print("Enter Your Choice: ");
        int press = scanner.nextInt();
        switch (press) {
            case 1:
                preOrder();
                break;
            case 2:
                order();
                break;
            default:
                System.out.println("Invalid Entry");
        }
    }

    private void order() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("You Can Purchase Only One Book !");
        System.out.print("Enter Book Id to Purchase: ");
        int IdSearch = scanner.nextInt();
        Node ptr = head;
        int found = 0;
        while (ptr != null) {
            if (IdSearch == ptr.id) {
                displayBook(ptr);
                System.out.print("Enter Price: ");
                int Price = scanner.nextInt();
                int addon = Price + 100;
                System.out.println("Total Bill with GST: " + addon);
                found++;
            }
            ptr = ptr.next_Node;
        }
        if (found == 0) {
            System.out.println("Book not found");
        }
    }

    private void preOrder() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("<======= PreOrder Book =======>");
        System.out.println("Welcome To Book Store");
        System.out.println("Book Name |  Price");
        System.out.println("          |     ");
        System.out.println("1.C++     |  100");
        System.out.println("2.Java    |  200");
        System.out.println("3.C       |  300");
        System.out.println("4.Python  |  400");
        System.out.println("5.Ruby    |  500");
        System.out.print("Enter Your Choice: ");
        int Book = scanner.nextInt();
        int price = 0;
        switch (Book) {
            case 1:
                price = price + 100;
                bookname = "C++";
                break;
            case 2:
                price = price + 200;
                bookname = "Java";
                break;
            case 3:
                price = price + 300;
                bookname = "C";
                break;
            case 4:
                price = price + 400;
                bookname = "Python";
                break;
            case 5:
                price = price + 500;
                bookname = "Ruby";
                break;
            default:
                System.out.println("Invalid Choice");
                return;
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("<========= PURCHASER DETAILS ========>");
        System.out.println("Buyer Name: " + Studentname);
        System.out.println("Buyer Id: " + SeNumber);
        System.out.println("Book Name: " + bookname);
        System.out.println("Price: " + price);

        System.out.println("<========= ORDER TIME/DATE ========>");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Day: " + now.getDayOfMonth());
        System.out.println("Month: " + now.getMonthValue());
        System.out.println("Year: " + now.getYear());
        System.out.println("Time: " + now.getHour() + ":" + now.getMinute() + ":" + now.getSecond());
    }

    private void donate() {
        System.out.println("<=== Donate Books ===>");
        System.out.println("<======= Donor Details =======>");
        System.out.print("Donor Name: ");
        String name1 = scanner.next();
        System.out.print("Donor Phone Number: ");
        String pn = scanner.next();
        System.out.println("<=============================>");
        System.out.println("<======== Book Details ========>");
        System.out.print("Book Name: ");
        String bookname1 = scanner.next();
        System.out.print("Book Author: ");
        String author1 = scanner.next();
        System.out.print("Book Publisher: ");
        String publisher1 = scanner.next();
        System.out.print("Book Category: ");
        String category1 = scanner.next();
        Node2 newNode = new Node2(pn, name1, bookname1, author1, publisher1, category1);
        if (head1 == null) {
            head1 = newNode;
        } else {
            Node2 ptr = head1;
            while (ptr.next_Node2 != null) {
                ptr = ptr.next_Node2;
            }
            ptr.next_Node2 = newNode;
        }
        System.out.println("Thank You For Donating the Book");
        System.out.println("Book Donated Successfully");
    }
}
