package Controller;

import java.util.Scanner;

public class LoginController {
    public static Scanner scanner = new Scanner(System.in);
    public void Login (){
        System.out.println("******************************");
        System.out.println("*           LOGIN            *");
        System.out.println("******************************");
        System.out.println("Enter your username and password");
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
    }
}
