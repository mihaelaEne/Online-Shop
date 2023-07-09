package ro.mycode.view;

import ro.mycode.user.models.Customer;
import ro.mycode.user.models.Manager;
import ro.mycode.user.services.UserController;

import java.util.Scanner;

public class ViewLogIn {

    private UserController userController;
    private Scanner scanner;


    public ViewLogIn() {
        userController = new UserController();
        scanner = new Scanner(System.in);
        play();
    }

    public void meniu() {
        System.out.println("Apasa tasta 1 pentru a va loga");
        System.out.println("Apasa tasta 2 pentru a va inregistra");

    }

    public void meniu2() {
        System.out.println("Apasa 1 daca esti  client ");
        System.out.println("Apasa 2 daca esti manager");
    }

    public void play() {
        int alegere = 0;
        boolean running = true;
        while (running) {
            meniu();
            alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {

                case 1:
                    conectare();
                    break;
                case 2:
                    inregistrare();
                    userController.save();
                    break;
                default:
                    System.out.println("Eroare");
                    break;
            }
        }
    }

    public void conectare() {

        int alegere = 0;
        boolean running = true;
        while (running) {
            meniu2();
            alegere = Integer.parseInt(scanner.nextLine());

            System.out.println("Introduceti adersa de email: ");
            String mail = scanner.nextLine();
            System.out.println("Introduceti parola:");
            String password = scanner.nextLine();
            switch (alegere) {
                case 1:

                    Customer customer = (Customer) userController.findUserConectare(mail, password);
                    if (customer != null) {
                        ViewCustomer viewCustomer = new ViewCustomer(customer);
                    } else {
                        System.out.println("eroare la customer");
                    }
                    break;
                case 2:

                    Manager m1 = (Manager) userController.findUserConectare(mail, password);
                    if (m1 != null) {
                        ViewManager viewManager = new ViewManager(m1);
                    } else {
                        System.out.println("eroare la manager");
                    }
                    break;

                default:
                    System.out.println("eroare la switch");
                    break;
            }
        }
    }


    public void inregistrare() {
        int alegere = 0;
        boolean running = true;
        while (running) {
            meniu2();
            alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:

                    System.out.println("Introduceti info:");
                    System.out.println("id:");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("nume:");
                    String nume = scanner.nextLine();
                    System.out.println("mail:");
                    String mail = scanner.nextLine();
                    System.out.println("parola:");
                    String parola = scanner.nextLine();


                    Customer customer = (Customer) userController.findUserByName(nume);
                    if (customer == null) {
                        String type="Customer";
                        Customer cNou = new Customer(type,id, nume, mail, parola);
                        userController.addUser(cNou);
                        System.out.println("Clientul a fost adaugat!");

                    } else {
                        System.out.println("Clientul este inregistrat deja");
                    }
                    break;
                case 2:
                    System.out.println("Introduceti info:");
                    System.out.println("id:");
                    int id1 = Integer.parseInt(scanner.nextLine());
                    System.out.println("nume:");
                    String nume1 = scanner.nextLine();
                    System.out.println("mail:");
                    String mail1 = scanner.nextLine();
                    System.out.println("parola:");
                    String parola1 = scanner.nextLine();
                    System.out.println("phoneNumber:");
                    String phoneNumber1 = scanner.nextLine();
                    System.out.println("role:");
                    String role = scanner.nextLine();
                    System.out.println("Phone number:");
                    String phoneNumber=scanner.nextLine();


                    Manager manager = (Manager) userController.findUserByName(nume1);
                    if (manager == null) {
                        Manager mNou = new Manager(id1, nume1, mail1, parola1, role,phoneNumber);
                        userController.addUser(mNou);
                        System.out.println("Managerul a fost adaugat cu succes");
                    } else {
                        System.out.println("Managerul este deja in baza de date");
                    }
                    break;
                default:
                    System.out.println("Eroare");
                    break;

            }
        }
    }

}

