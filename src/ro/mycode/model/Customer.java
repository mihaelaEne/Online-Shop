package ro.mycode.model;

import java.util.Objects;

public class Customer {

    private int id;
    private String name;
    private String email;
    private String pass;
    private String phoneNumber;

    public Customer(int id, String name, String email, String pass, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return id == customer.id && name.equals(customer.name) && email.equals(customer.email) && pass.equals(customer.pass) && phoneNumber.equals(customer.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, pass, phoneNumber);
    }

    @Override
    public String toString() {
        String text = "";
        text += "I am a customer with the following characteristics:" + "\n";
        text += "id: " + this.id + "\n";
        text += "name: " + this.name + "\n";
        text += "email: " + this.email + "\n";
        text += "phoneNumber: " + this.phoneNumber + "\n";
        return text;

    }

    public Customer(String prop) {
        String[] split = prop.split(",");
        this.id = Integer.parseInt(split[0]);
        this.name = split[1];
        this.email = split[2];
        this.pass = split[3];
        this.phoneNumber =split[4];

    }


    public String toSave() {
        return id + "," + name + "," + email + "," + pass + "," + phoneNumber;
    }

}
