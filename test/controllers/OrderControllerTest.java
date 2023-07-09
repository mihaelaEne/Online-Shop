package controllers;

import org.junit.Test;
import ro.mycode.order.services.OrderController;
import ro.mycode.order.models.Order;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class OrderControllerTest {

    @Test
    public void testFindById() { //pb aici
        ArrayList<Order> orders = new ArrayList<>();
        Order o1=new Order(1,1,2500, LocalDate.of(2023,11,12));
        orders.add(o1);
        Order o2=new Order(2,2,3000,LocalDate.of(2023,10,10));
        orders.add(o2);
        Order o3=new Order(3,3,100,LocalDate.of(2023,06,06));
        orders.add(o3);

        OrderController orderController = new OrderController(orders);
        assertEquals(1, orderController.findById(1).getProductId());

    }


    @Test
    public void testFindByIdNull() {
        ArrayList<Order> orders = new ArrayList<>();
        Order o1=new Order(1,1,2500, LocalDate.of(2023,11,12));
        orders.add(o1);
        Order o2=new Order(2,2,3000,LocalDate.of(2023,10,10));
        orders.add(o2);
        Order o3=new Order(3,3,100,LocalDate.of(2023,06,06));
        orders.add(o3);


        OrderController orderController = new OrderController(orders);
        assertNull(orderController.findById(88));
    }

    @Test
    public void testAdd() {
        ArrayList<Order> orders = new ArrayList<>();
        Order o1=new Order(1,1,2500, LocalDate.of(2023,11,12));
        orders.add(o1);
        Order o2=new Order(2,2,3000,LocalDate.of(2023,10,10));
        orders.add(o2);
        Order o3=new Order(3,3,100,LocalDate.of(2023,06,06));
        orders.add(o3);


        OrderController orderController = new OrderController(orders);

        orderController.afisareOrder();

    }

    @Test
    public void testRemove() {
        ArrayList<Order> orders = new ArrayList<>();
        Order o1=new Order(1,1,2500, LocalDate.of(2023,11,12));
        orders.add(o1);
        Order o2=new Order(2,2,3000,LocalDate.of(2023,10,10));
        orders.add(o2);
        Order o3=new Order(3,3,100,LocalDate.of(2023,06,06));
        orders.add(o3);

        OrderController orderController = new OrderController(orders);

        orderController.removeOrder(o1);
        assertEquals(null, orderController.findById(1));
    }
}
