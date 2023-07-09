package ro.mycode.products.services;

import ro.mycode.products.models.Product;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductController {
    private ArrayList<Product> products;
    public ProductController(ArrayList<Product>products){
        this.products=products;
    }

    public ProductController(){
        this.products=new ArrayList();
        this.load();
    }

    public void load(){
        try{
            File file=new File("C:\\mycode\\OOP\\OnlineShop\\src\\ro\\mycode\\products\\repository\\product.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                Product product=new Product(scanner.nextLine());
                this.products.add(product);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }



    public void afisareProduct(){
        for(int i=0; i< products.size(); i++){
            System.out.println(this.products.get(i).toString());
            System.out.println("\n");
        }
    }


    public void addProduct(Product product){
        this.products.add(product);
    }

    public void removeProduct(Product product){
        this.products.remove(product);
    }


    public Product findProductById(int id){
        for(int i=0; i<products.size();i++){
            if(products.get(i).getId()==id){
                return products.get(i);
            }
        }
        return null;
    }

    public String toSave(){
        String text="";
        int i=0;
        for (i=0; i< products.size()-1; i++){
            text+=products.get(i).toSave()+"\n";
        }
        text+=products.get(i).toSave();
        return text;
    }

    public void save(){
        try{
            File file=new File("C:\\mycode\\OOP\\OnlineShop\\src\\ro\\mycode\\products\\repository\\product.txt");
            FileWriter fileWriter=new FileWriter(file);
            PrintWriter printWriter=new PrintWriter(fileWriter);
            printWriter.print(toSave());
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
