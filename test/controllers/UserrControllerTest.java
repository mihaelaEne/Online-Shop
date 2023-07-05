package controllers;

import org.junit.Test;
import ro.mycode.controller.UserController;
import ro.mycode.model.Customer;
import ro.mycode.model.Manager;
import ro.mycode.model.User;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class UserrControllerTest {

    @Test
    public void testFindById() {
        ArrayList<User> users = new ArrayList<>();
        User u1 = new Manager("Manager", 1, "Ion", "emailIon", "passIon", "asistent manager", 5);
        users.add(u1);
        User u2 = new Manager("Manager", 2, "Maria", "emailMaria", "passMaria", "asistent ", 8);
        users.add(u2);
        User u3 = new Customer("Customer", 3, "Ionela", "emailIonela", "passIonela", 8, "silver");
        users.add(u3);
        User u4 = new Customer("Customer", 4, "Mana", "emailMana", "passMana", 50, "gold");
        users.add(u4);

        UserController userController = new UserController(users);
        assertEquals("emailIon", userController.findUserById(1).getEmail());
        assertEquals("Mana", userController.findUserById(4).getName());

    }

    @Test
    public void testFindByIdNull() {
        ArrayList<User> users = new ArrayList<>();
        User u1 = new Manager("Manager", 1, "Ion", "emailIon", "passIon", "asistent manager", 5);
        users.add(u1);
        User u2 = new Manager("Manager", 2, "Maria", "emailMaria", "passMaria", "asistent ", 8);
        users.add(u2);
        User u3 = new Customer("Customer", 3, "Ionela", "emailIonela", "passIonela", 8, "silver");
        users.add(u3);
        User u4 = new Customer("Customer", 4, "Mana", "emailMana", "passMana", 50, "gold");
        users.add(u4);

        UserController userController = new UserController(users);
        assertNull(userController.findUserById(88));
    }

    @Test
    public void testAdd() {
        ArrayList<User> users = new ArrayList<>();
        User u1 = new Manager("Manager", 1, "Ion", "emailIon", "passIon", "asistent manager", 5);
        users.add(u1);
        User u2 = new Manager("Manager", 2, "Maria", "emailMaria", "passMaria", "asistent ", 8);
        users.add(u2);
        User u3 = new Customer("Customer", 3, "Ionela", "emailIonela", "passIonela", 8, "silver");
        users.add(u3);
        User u4 = new Customer("Customer", 4, "Mana", "emailMana", "passMana", 50, "gold");
        users.add(u4);

        UserController userController=new UserController(users);

       userController.afisareUser();

    }

    @Test
    public void testRemove() {
        ArrayList<User> users = new ArrayList<>();
        User u1 = new Manager("Manager", 1, "Ion", "emailIon", "passIon", "asistent manager", 5);
        users.add(u1);
        User u2 = new Manager("Manager", 2, "Maria", "emailMaria", "passMaria", "asistent ", 8);
        users.add(u2);
        User u3 = new Customer("Customer", 3, "Ionela", "emailIonela", "passIonela", 8, "silver");
        users.add(u3);
        User u4 = new Customer("Customer", 4, "Mana", "emailMana", "passMana", 50, "gold");
        users.add(u4);

        UserController userController=new UserController(users);

        userController.removeUser(u1);
        assertEquals(null, userController.findUserById(1));
    }



}
