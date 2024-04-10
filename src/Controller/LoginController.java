package Controller;

import Model.ClientRepository;
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
    }
}
