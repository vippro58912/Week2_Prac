import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Static list of users, acting as a database
    private static ArrayList<User> users = new ArrayList<>();

    // Mock authentication service that always returns the first user when log in, and does nothing when sign up
    private static IAuthenticationService authService = new IAuthenticationService() {
        @Override
        public User signUp(String username, String password) {
            return null;
        }

        @Override
        public User logIn(String username, String password) {
            return users.get(0);
        }
    };
private static boolean isRunning = true;
public static void main(String[] args) {

    users.add(new User("test", "test"));
    while (isRunning) {
        showMenu();
    }
}
public static void showMenu() {
    System.out.println("Welcome to the to-do list application!");
    System.out.println("1. Log in");
    System.out.println("2. Sign up");
    System.out.println("3. Exit");
    System.out.println("Enter your choice: ");
    Scanner scanner = new Scanner(System.in);
    int choice = scanner.nextInt();
    handleMenu(choice);
}
public static void handleMenu(int choice) {
    switch (choice) {
        case 1:
            onLogIn();
            break;
        case 2:
            onSignUp();
            break;
        default:
            System.out.println("Invalid choice!");
//            Quay ve show menu
            showMenu();
    }
}
public static void onLogIn() {
    System.out.println("Enter your name");
    Scanner scanner = new Scanner(System.in);
    String username = scanner.nextLine();
    System.out.println("Enter your password: ");
    String password = scanner.nextLine();
    User user = authService.logIn(username, password);
    System.out.println("Welcome, " + user.getUsername() + "!");

}
public static void onSignUp() {
    System.out.println("Enter your username: ");
    Scanner scanner = new Scanner(System.in);
    String username = scanner.nextLine();
    System.out.println("Enter your password");
    String password = scanner.nextLine();
    User user = authService.signUp(username, password);
}
//Exit the application
    public static void onExit() {
    isRunning = false;
    }
}