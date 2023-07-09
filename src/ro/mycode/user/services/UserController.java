package ro.mycode.user.services;


import ro.mycode.user.models.Customer;
import ro.mycode.user.models.Manager;
import ro.mycode.user.models.User;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserController {
    private ArrayList<User> users = new ArrayList<>();


    public UserController() {
        this.users = new ArrayList<>();

        load();

    }

    //constructor care ma ajuta mereu la testare
   public  UserController(ArrayList<User>users){

        this.users=users;
   }

    public void load() {
        //mereu clar la lista ca sa nu imi af de 2 ori, adica sa nu imi faca load ul de sus
        this.users.clear();
        try {
            File file = new File("C:\\mycode\\OOP\\OnlineShop\\src\\ro\\mycode\\user\\repository\\user.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String text = scanner.nextLine();
                switch (text.split(",")[0]) {
                    case "Manager":
                        this.users.add(new Manager(text));
                        break;

                    case "Customer":
                        this.users.add(new Customer(text));
                        break;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void afisareUser(){
        for(int i=0; i<users.size();i++){
            System.out.println(this.users.get(i));
            System.out.println("\n");
        }
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public void removeUser(User user){
        this.users.remove(user);
    }

    public User findUserById(int id){
        for(int i=0; i<users.size();i++){
            if(users.get(i).getId()==id){
                return users.get(i);
            }
        }
        return null;
    }

    public User findUserByName(String name){
        for(int i=0; i<users.size();i++){
            if(users.get(i).getName().equals(name)){
                return users.get(i);
            }
        }
        return null;
    }

    public User findUserConectare(String email, String pass){
        for(int i=0; i<users.size();i++){
            User user=users.get(i);
            if(user.getEmail().equals(email)&& user.getPass().equals(pass)){
                return user;
            }

        }
        return null;
    }


    public String toSave(){
        String text="";
        for(int i=0;i<users.size();i++){
            User user =(User) users.get(i);
            text+=user.toSave()+"\n";
        }
        return text;
    }


    public void save(){
        try {
            File file = new File("C:\\mycode\\OOP\\OnlineShop\\src\\ro\\mycode\\user\\repository\\user.txt");
            FileWriter fileWriter=new FileWriter(file);
            PrintWriter printWriter=new PrintWriter(fileWriter);
            printWriter.print(toSave());
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
