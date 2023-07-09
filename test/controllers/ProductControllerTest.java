package controllers;

import org.junit.Test;
import ro.mycode.products.models.Phone;
import ro.mycode.products.models.Product;
import ro.mycode.products.models.Tricou;
import ro.mycode.products.services.ProductController;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ProductControllerTest {

    @Test
    public void testFindById() {  //pb aici
        ArrayList<Product> products = new ArrayList<>();

        Product p1 = new Phone("Phone", 1, "Iphone11", 4000, 450, "Smartphone", "11 Pro", 256, "black");
        products.add(p1);
        Product p2 = new Phone("Phone", 2, "SamsungS14", 5000, 200, "Smartphone", "S14 Ultra", 500, "white");
        products.add(p2);
        Product p3 = new Phone("Phone", 3, "Nokia1300", 200, 800, "Smartphone", "1300", 0, "blue");
        products.add(p3);


        Product p4 = new Tricou("Tricou", 4, "tricou Polo", 250, 100, "Imbracaminte", "M", "in");
        products.add(p4);

        ProductController productController = new ProductController(products);
        assertEquals("Smartphone", productController.findProductById(1).getCategory());
        assertEquals("tricou Polo", productController.findProductById(4).getName());
    }



    @Test
    public void testFindByIdNull() {
        ArrayList<Product> products = new ArrayList<>();

        Product p1 = new Phone("Phone", 1, "Iphone11", 4000, 450, "Smartphone", "11 Pro", 256, "black");
        products.add(p1);
        Product p2 = new Phone("Phone", 2, "SamsungS14", 5000, 200, "Smartphone", "S14 Ultra", 500, "white");
        products.add(p2);
        Product p3 = new Phone("Phone", 3, "Nokia1300", 200, 800, "Smartphone", "1300", 0, "blue");
        products.add(p3);


        Product p4 = new Tricou("Tricou", 4, "tricou Polo", 250, 100, "Imbracaminte", "M", "in");
        products.add(p4);

        ProductController productController = new ProductController(products);
        assertNull(productController.findProductById(88));
    }

    @Test
    public void testAdd() {
        ArrayList<Product> products = new ArrayList<>();

        Product p1 = new Phone("Phone", 1, "Iphone11", 4000, 450, "Smartphone", "11 Pro", 256, "black");
        products.add(p1);
        Product p2 = new Phone("Phone", 2, "SamsungS14", 5000, 200, "Smartphone", "S14 Ultra", 500, "white");
        products.add(p2);
        Product p3 = new Phone("Phone", 3, "Nokia1300", 200, 800, "Smartphone", "1300", 0, "blue");
        products.add(p3);


        Product p4 = new Tricou("Tricou", 4, "tricou Polo", 250, 100, "Imbracaminte", "M", "in");
        products.add(p4);

        ProductController productController = new ProductController(products);

        productController.afisareProduct();

    }

    @Test
    public void testRemove() {
        ArrayList<Product> products = new ArrayList<>();

        Product p1 = new Phone("Phone", 1, "Iphone11", 4000, 450, "Smartphone", "11 Pro", 256, "black");
        products.add(p1);
        Product p2 = new Phone("Phone", 2, "SamsungS14", 5000, 200, "Smartphone", "S14 Ultra", 500, "white");
        products.add(p2);
        Product p3 = new Phone("Phone", 3, "Nokia1300", 200, 800, "Smartphone", "1300", 0, "blue");
        products.add(p3);


        Product p4 = new Tricou("Tricou", 4, "tricou Polo", 250, 100, "Imbracaminte", "M", "in");
        products.add(p4);

        ProductController productController = new ProductController(products);
        productController.removeProduct(p1);
        assertEquals(null, productController.findProductById(1));
    }


}

