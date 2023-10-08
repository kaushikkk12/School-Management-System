import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserAuthenticationSystem {
    private List<User> users;
    private String userFile = "users.csv"; // File to store user data

    public UserAuthenticationSystem() {
        users = new ArrayList<>();
        loadUsers();
    }

    private void loadUsers() {
        try (BufferedReader br = new BufferedReader(new FileReader(userFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length == 2) {
                    String username = userData[0];
                    String password = userData[1];
                    users.add(new User(username, password));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveUsers() {
        try (FileWriter writer = new FileWriter(userFile)) {
            for (User user : users) {
                writer.write(user.getUsername() + "," + user.getPassword() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean addUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return false; // Username already exists
            }
        }
        users.add(new User(username, password));
        saveUsers();
        return true;
    }

    public boolean authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true; // Authentication successful
            }
        }
        return false; // Authentication failed
    }

    public static void main(String[] args) {
        UserAuthenticationSystem authenticationSystem = new UserAuthenticationSystem();

        // Example usage:
        authenticationSystem.addUser("user1", "password1");
        authenticationSystem.addUser("user2", "password2");

        if (authenticationSystem.authenticateUser("user1", "password1")) {
            System.out.println("Authentication successful for user1.");
        } else {
            System.out.println("Authentication failed for user1.");
        }

        if (authenticationSystem.authenticateUser("user3", "password3")) {
            System.out.println("Authentication successful for user3.");
        } else {
            System.out.println("Authentication failed for user3.");
        }
    }
}
