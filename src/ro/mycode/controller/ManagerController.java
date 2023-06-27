package ro.mycode.controller;

import ro.mycode.model.Manager;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerController {

    private ArrayList<Manager> managers = new ArrayList();




    public ManagerController(ArrayList<Manager> managers) {
        this.managers = managers;
    }

    public ManagerController() {
        this.managers = new ArrayList();
        this.load();
    }


    public void load() {
        try {
            File file = new File("C:\\mycode\\OOP\\OnlineShop\\src\\ro\\mycode\\data\\manager.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                Manager manager = new Manager(scanner.nextLine());
                this.managers.add(manager);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afisareManager() {
        for (int i = 0; i < managers.size(); i++) {
            System.out.println(this.managers.get(i).toString());
            System.out.println("\n");
        }
    }

    public void addManager(Manager manager) {
        this.managers.add(manager);
    }

    public void removeManager(Manager manager) {
        this.managers.remove(manager);
    }


    public Manager findByName(String name) {
        for (int i = 0; i < this.managers.size(); i++) {
            if (managers.get(i).getName().equals(name)) {
                if (managers.get(i).getName().equals(name)) {
                    return managers.get(i);
                }
            }
        }
        return null;
    }

    public String toSave(){

        String text="";
        int i=0;
        for(i=0;i<managers.size()-1; i++){

            text+=managers.get(i).toSave()+"\n";
        }

        text+=managers.get(i).toSave();
        return text;
    }


    public void save(){
        try {
            File file = new File("C:\\mycode\\OOP\\OnlineShop\\src\\ro\\mycode\\data\\manager.txt");

            FileWriter fileWriter= new FileWriter(file);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.print(toSave());

            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public Manager findMangaerConectare(String email, String pass){
        for(int i=0; i<managers.size();i++){
            Manager manager=managers.get(i);
            if(manager.getEmail().equals(email)&&manager.getPass().equals(pass)){
                return manager;
            }
        }
        return null;
    }


}
