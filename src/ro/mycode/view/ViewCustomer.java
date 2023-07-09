package ro.mycode.view;

import ro.mycode.products.services.ProductController;
import ro.mycode.user.models.Customer;

import java.util.Scanner;

public class ViewCustomer implements View {

    private ProductController productController;
    private Scanner scanner;
    public ViewCustomer(Customer customer) {
        productController = new ProductController();
        scanner = new Scanner(System.in);
        play();
    }


    public void meniu() {
        System.out.println("Buna!");
        System.out.println("Apasa 1 ca sa vezi toate produsele");

    }

    public void play() {
        int alegere = 0;
        boolean running = true;
        while (running) {
            meniu();
            alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:
                    productController.afisareProduct();
                    break;


                default:
                    System.out.println("Alegere incorecta!");
                    break;
            }
        }
    }


    @Override
    public void adaugareProdus() {

    }

    @Override
    public void stergereProdus() {

    }

    @Override
    public void adaugareClient() {

    }

    @Override
    public void stergereClient() {

    }

    @Override
    public void adaugareManager() {

    }

    @Override
    public void stergereManager() {

    }
}
