package ro.mycode.products.models;

import java.util.Objects;

public class Product {
    private String type;
    private int id;
    private String name;
    private float price;
    private float weight;
    private String category;

   
    public Product() {
    }

    public Product(String type, int id, String name, float price, float weight, String category) {
        this.type = type;
        this.id = id;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    @Override
    public String toString() {
        String text = "";
        text += "I am a product with the following characteristics:" + "\n";
        text += "id: " + this.id + "\n";
        text += "name: " + this.name + "\n";
        text += "price: " + this.price + "\n";
        text += "weight: " + this.weight + "\n";
        text += "category: " + this.category;
        return text;

    }


    public Product(String prop) {
        String[] split = prop.split(",");
        this.type = split[0];
        this.id = Integer.parseInt(split[1]);
        this.name = split[2];
        this.price = Float.parseFloat(split[3]);
        this.weight = Float.parseFloat(split[4]);
        this.category = split[5];
    }


    public String toSave() {
        return type + "," + id + "," + name + "," + price + "," + weight + "," + category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id == product.id && Float.compare(product.price, price) == 0 && Float.compare(product.weight, weight) == 0 && type.equals(product.type) && name.equals(product.name) && category.equals(product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, id, name, price, weight, category);
    }
}


