package Controller;

import Model.*;

import java.util.ArrayList;

public class MainController {
    public static void main(String[] args) {
        Seeder seeder = new Seeder();
        seeder.fillProgram();
        MenuController menuController = new MenuController();
        MenuController.mainOperations();
    }
}
