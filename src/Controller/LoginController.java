package Controller;

import Model.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class LoginController {
    public static Scanner scanner = new Scanner(System.in);
    public void Login (){
        System.out.println("******************************");
        System.out.println("*           LOGIN            *");
        System.out.println("******************************");
        System.out.println("Enter your username and password");
        String username = null;
        String password = null;
        String hashedPassword = null;
        String role = null;
        do {
            System.out.println("Enter your username: ");
            username = scanner.nextLine();
            System.out.println("Enter your password: ");
            password = scanner.nextLine();
            hashedPassword = checkPassword(password);

            role = authenticateUser(username,hashedPassword);

            if (role.equals("admin")) {
                System.out.println("Welcome Admin");
            } else if (role.equals("client")) {
                System.out.println("Welcome Client");
            }else {
                System.out.println("Invalid username or password");
            }
        }while(role.equals("NoAuthenticated"));
    }
    public String authenticateUser (String username, String password){
        if (username.equals("admin") && password.equals("password")) {
            return "Admin";
        } else if (username.equals("client") && password.equals("password")) {
            return "Client";
        } else {
            return "NoAuthenticated";
        }
    }
    public String checkPassword (String password){
        User user = new User();
        return user.hashString(password);
    }
}
