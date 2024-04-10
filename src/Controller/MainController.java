package Controller;

import Model.*;
public class MainController {
    public static void main(String[] args) {
        Seeder seeder = new Seeder();
        seeder.fillProgram();
        LoginController loginController = new LoginController();
        loginController.Login();
        MenuController menuController = new MenuController();
        MenuController.mainOperations();
    }
}
