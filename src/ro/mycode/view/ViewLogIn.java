package ro.mycode.view;

import ro.mycode.controller.CustomerController;
import ro.mycode.controller.ManagerController;
import ro.mycode.model.Customer;
import ro.mycode.model.Manager;

import java.util.Scanner;

public class ViewLogIn {


    private ManagerController managerController;
    private CustomerController customerController;
    private Scanner scanner;


    public ViewLogIn() {
        managerController = new ManagerController();
        customerController = new CustomerController();
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
                    customerController.save();
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

                    Customer customer = customerController.findCustomerConectare(mail, password);
                    if (customer != null) {
                        ViewCustomer viewCustomer = new ViewCustomer(customer);
                    } else {
                        System.out.println("eroare la customer");
                    }
                    break;
                case 2:

                    Manager m1 = managerController.findMangaerConectare(mail, password);
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
                    System.out.println("phoneNumber:");
                    String phoneNumber = scanner.nextLine();

                    Customer customer = customerController.findByName(nume);
                    if (customer == null) {
                        Customer cNou = new Customer(id, nume, mail, parola, phoneNumber);
                        customerController.addCustomer(cNou);
                        System.out.println("Clientul a fost adaugat!");

                    } else {
                        System.out.println("Studentul este inregistrat deja");
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


                    Manager manager = managerController.findByName(nume1);
                    if (manager == null) {
                        Manager mNou = new Manager(id1, nume1, mail1, parola1, phoneNumber1, role);
                        managerController.addManager(mNou);
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
