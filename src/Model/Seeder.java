package Model;

import Controller.DateController;

import java.util.ArrayList;

public class Seeder {
    public void fillProgram(){
        DateController dateController = new DateController();
        Profile profile1 = new Profile("Axel", "Tairi", DateController.seederDate("01-11-2001"));
        Profile profile2 = new Profile("Vanessa", "Garnica", DateController.seederDate("06-01-2001"));
        Profile profile3 = new Profile("Max", "Delgado", DateController.seederDate("10-10-2003"));
        Profile profile4 = new Profile("Agui", "Martinez", DateController.seederDate("07-08-2003"));
        Profile profile5 = new Profile("Esteban", "Larcos", DateController.seederDate("16-02-2002"));

        ArrayList<Book> books1 = new ArrayList<>();
        ArrayList<Book> books2 = new ArrayList<>();
        ArrayList<Book> books3 = new ArrayList<>();
        ArrayList<Book> books4 = new ArrayList<>();
        ArrayList<Book> books5 = new ArrayList<>();

        AuthorRepository authorRepository = new AuthorRepository();
        authorRepository.createAuthor(profile1, books1);
        authorRepository.createAuthor(profile2, books2);

        ClientRepository clientRepository = new ClientRepository();
        clientRepository.createClient(profile3,"Resilience","maxim123", books3);
        clientRepository.createClient(profile4,"judis21","ajm2021", books4);
        clientRepository.createClient(profile5,"Cactusslow","zomxx22", books5);

        BookRepository bookRepository = new BookRepository();
        Author author;
        bookRepository.createBook(0,"124","Harry Potter", AuthorRepository.getAuthors().get(0),
                DateController.seederDate("16-11-2021"),true);
        bookRepository.createBook(0,"224","Harry Potter 2", AuthorRepository.getAuthors().get(0),
                DateController.seederDate("14-05-2021"),true);
        bookRepository.createBook(1,"324","Paper Towns", AuthorRepository.getAuthors().get(1),
                DateController.seederDate("01-12-2021"),true);
        bookRepository.createBook(1,"424","Hunger Games", AuthorRepository.getAuthors().get(1),
                DateController.seederDate("10-09-2021"),true);
        bookRepository.createBook(1,"524","Maze Runner", AuthorRepository.getAuthors().get(1),
                DateController.seederDate("22-05-2021"),true);
    }
}
