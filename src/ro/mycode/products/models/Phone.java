package ro.mycode.products.models;

import java.util.Objects;

public class Phone extends Product {

    private String model;
    private int memory;
    private String color;

    public Phone(String model, int memory, String color) {
        this.model = model;
        this.memory = memory;
        this.color = color;
    }

    public Phone(String type, int id, String name, float price, float weight, String category, String model, int memory, String color) {
        super(type, id, name, price, weight, category);
        this.model = model;
        this.memory = memory;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        String text = "";
        text += "I am a phone with the following characteristics:" + "\n";
        text += "id: " + super.getId() + "\n";
        text += "name: " + super.getName() + "\n";
        text += "price: " + super.getPrice() + "\n";
        text += "weight: " + super.getWeight() + "\n";
        text += "category: " + super.getCategory() + "\n";
        text += "model: " + this.model + "\n";
        text += "memory: " + this.memory + "\n";
        text += "color" + this.color;
        return text;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phone)) return false;
        if (!super.equals(o)) return false;
        Phone phone = (Phone) o;
        return memory == phone.memory && model.equals(phone.model) && color.equals(phone.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), model, memory, color);
    }

    public Phone(String prop){
        String [] split=prop.split(",");
        this.model=split[6];
        this.memory=Integer.parseInt(split[7]);
        this.color=split[8];
    }

    @Override
    public String toSave(){
        return model+","+memory+","+color;
    }
}

