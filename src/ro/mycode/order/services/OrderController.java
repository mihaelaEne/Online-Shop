package ro.mycode.order.services;

import ro.mycode.order.models.Order;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderController {

    private ArrayList<Order> orders;

    public OrderController(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public OrderController() {
        this.orders = new ArrayList();
        this.load();
    }


    public void load() {
        try {
            File file = new File("C:\\mycode\\OOP\\OnlineShop\\src\\ro\\mycode\\order\\repository\\order.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                Order order = new Order(scanner.nextLine());
                this.orders.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afisareOrder() {
        for (int i = 0; i < orders.size(); i++) {
            System.out.println(this.orders.get(i).toString());
            System.out.println("\n");
        }
    }

    //todo:functie ce primeste id prod si returneaza o lista de product


    public ArrayList<Order> findAllProductsOrders(int productId) {
        ArrayList<Order> productsOrder = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getProductId() == productId) {
                productsOrder.add(orders.get(i));
            }
        }
        return productsOrder;
    }


    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public void removeOrder(Order order) {
        this.orders.remove(order);
    }

    public Order findById(int id) {
        for (int i = 0; i < this.orders.size(); i++) {
            if (orders.get(i).getId() == id) {
                return orders.get(i);
            }
        }
        return null;
    }



    public int generareId() {
        int id = (int) Math.round(Math.random() * 1000 + 10000);
        while (this.findById(id) != null) {
            id = (int) Math.round(Math.random() * 1000 + 10000);

        }
        return id;
    }




    public String toSave() {
        String text = "";
        int i = 0;
        for (i = 0; i < orders.size() - 1; i++) {
            text += orders.get(i).toSave() + "\n";
        }
        text += orders.get(i).toSave();
        return text;
    }

    public void save() {
        try {
            File file = new File("C:\\mycode\\OOP\\OnlineShop\\src\\ro\\mycode\\order\\repository\\order.txt");

            FileWriter fileWriter = new FileWriter(file);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.print(toSave());

            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
