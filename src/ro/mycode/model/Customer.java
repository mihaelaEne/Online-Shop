package ro.mycode.model;

import java.util.Objects;

public class Customer extends User {

  private int numberOfOrders;
  private String typeOfMembership;

    public Customer(int numberOfOrders, String typeOfMembership) {
        this.numberOfOrders = numberOfOrders;
        this.typeOfMembership = typeOfMembership;
    }

    public Customer(String type, int id, String name, String email, String pass, int numberOfOrders, String typeOfMembership) {
        super(type, id, name, email, pass);
        this.numberOfOrders = numberOfOrders;
        this.typeOfMembership = typeOfMembership;
    }

    public int getNumberOfOrders() {
        return numberOfOrders;
    }

    public void setNumberOfOrders(int numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
    }

    public String getTypeOfMembership() {
        return typeOfMembership;
    }

    public void setTypeOfMembership(String typeOfMembership) {
        this.typeOfMembership = typeOfMembership;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return numberOfOrders == customer.numberOfOrders && typeOfMembership.equals(customer.typeOfMembership);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfOrders, typeOfMembership);
    }

    @Override
    public String toString() {
        String text = "";
        text += "I am a customer with the following characteristics:" + "\n";
        text+="type: "+super.getType()+"\n";
        text += "id: " + super.getId() + "\n";
        text += "name: " + super.getName() + "\n";
        text += "email: " + super.getEmail() + "\n";
        text += "role: " + this.numberOfOrders + "\n";
        text += "experience: " + this.typeOfMembership;
        return text;
    }

    public Customer(String prop){
        String [] split=prop.split(",");
        this.numberOfOrders=Integer.parseInt(split[5]);
        this.typeOfMembership=split[6];
    }
    public String toSave(){ return super.toSave()+","+numberOfOrders+","+typeOfMembership;}


}
