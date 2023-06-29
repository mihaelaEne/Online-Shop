package ro.mycode.view;

import ro.mycode.controller.CustomerController;
import ro.mycode.controller.ManagerController;
import ro.mycode.controller.OrderController;
import ro.mycode.controller.ProductController;
import ro.mycode.model.Customer;
import ro.mycode.model.Manager;
import ro.mycode.model.Product;

import java.util.Scanner;

public class ViewManager {

    private CustomerController customerController;
    private Scanner scanner;
    private ManagerController managerController;
    private OrderController orderController;
    private ProductController productController;

    public ViewManager(Product product) {
        productController = new ProductController();
        managerController = new ManagerController();
        orderController=new OrderController();
        scanner = new Scanner(System.in);
        play();
    }


    public void meniu() {
        System.out.println("Buna!");
        System.out.println("Apasa 1 ca sa vezi toate produsele");
        System.out.println("Apasa 2 pentru a adauga un produs");
        System.out.println("Apasa 3 pentru a sterge un produs");
        System.out.println("Apasa 4 pentru a salava produsul si a ieesi");
        System.out.println("Apasa 5 pentru a afisa toti managerii");
        System.out.println("Apasa 6 pt a adauga un manager ");
        System.out.println("Apasa 7 pt a sterge un manager");
        System.out.println("Apasa 8 pt a salva managerul si a iesi");
        System.out.println("Apasa 9 pt a afisa toti clientii ");
        System.out.println("Apasa tasta 10 pt a adauga un client ");
        System.out.println("Apasa tasta 11 pt a sterge un client ");
        System.out.println("Apasa 12 pt a salva managerul si a iesi");

    }

    public void play() {
        int alegere = 0;
        boolean running = true;
        while (running) {
            meniu();
            alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:
                    productController.toString();
                    break;
                case 2:
                    adaugareProdus();
                    break;
                case 3:
                    stergereProdus();
                    break;
                case 4:
                    running = false;
                    productController.save();
                    System.out.println("V-ati delogat");
                    break;
                case 5:
                    managerController.toString();
                    break;
                case 6:
                    adaugareManager();
                    break;
                case 7:
                    stergereManager();
                    break;
                case 8:
                    running = false;
                    managerController.save();
                    System.out.println("V-ati delogat");
                    break;
                case 9:
                    orderController.toString();
                    break;
                case 10:
                    adaugareClient();
                    break;
                case 11:
                    stergereClient();
                    break;
                case 12:
                    running = false;
                    customerController.save();
                    System.out.println("V-ati delogat");
                    break;

                default:
                    System.out.println("Alegere incorecta!");
                    break;
            }
        }
    }


    private void adaugareProdus() {
        System.out.println("type:");
        String type = scanner.nextLine();
        System.out.println("Id:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("name:");
        String name = scanner.nextLine();
        System.out.println("price:");
        float price = Float.parseFloat(scanner.nextLine());
        System.out.println("weight:");
        float weight = Float.parseFloat(scanner.nextLine());
        System.out.println("category:");
        String category = scanner.nextLine();
        Product product = productController.findProductById(id);
        if (product == null) {
            Product pNou = new Product(type,id,name,price,weight,category);
            productController.addProduct(pNou);

        } else {
            System.out.println("Produsul deja exista ");
        }

    }

    private void stergereProdus() {
        System.out.println("Intr id-ul:");
        int id = Integer.parseInt(scanner.nextLine());
        Product product = productController.findProductById(id);
        if (product == null) {
            System.out.println("Nu exista produsul");
        } else {
            productController.removeProduct(product);
            System.out.println("Produsul a fost sters");
        }
    }

    private void adaugareManager() {

        System.out.println("Id:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("name:");
        String name = scanner.nextLine();
        System.out.println("email:");
        String email = scanner.nextLine();
        System.out.println("pass:");
        String pass = scanner.nextLine();
        System.out.println("phoneNumber:");
        String phoneNumber = scanner.nextLine();
        System.out.println("role:");
        String role = scanner.nextLine();
        Manager manager = managerController.findByName(name);
        if (manager == null) {
            Manager mNou = new Manager(id,name,email,pass,phoneNumber,role);
            managerController.addManager(mNou);

        } else {
            System.out.println("Managerul deja exista ");
        }

    }

    private void stergereManager() {
        System.out.println("Intr numele:");
        String name = scanner.nextLine();
        Manager manager = managerController.findByName(name);
        if (manager == null) {
            System.out.println("Nu exista managerul");
        } else {
            managerController.removeManager(manager);
            System.out.println("Managerul a fost sters");
        }
    }

    private void adaugareClient() {

        System.out.println("Id:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("name:");
        String name = scanner.nextLine();
        System.out.println("email:");
        String email = scanner.nextLine();
        System.out.println("pass:");
        String pass = scanner.nextLine();
        System.out.println("phoneNumber:");
        String phoneNumber = scanner.nextLine();
        Customer customer = customerController.findByName(name);
        if (customer == null) {
            Customer cNou = new Customer(id,name,email,pass,phoneNumber);
            customerController.addCustomer(cNou);

        } else {
            System.out.println("Clientul deja exista ");
        }

    }

    private void stergereClient() {
        System.out.println("Intr numele:");
        String name = scanner.nextLine();
        Customer customer = customerController.findByName(name);
        if (customer == null) {
            System.out.println("Nu exista clientul");
        } else {
            customerController.removeCustomer(customer);
            System.out.println("Clientul a fost sters");
        }
    }
}
