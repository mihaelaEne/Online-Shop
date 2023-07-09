package ro.mycode.products.models;

import java.util.Objects;

public class Tricou extends Product {

    private String size;
    private String material;


    public Tricou(String size, String material) {
        this.size = size;
        this.material = material;
    }

    public Tricou(String type, int id, String name, float price, float weight, String category, String size, String material) {
        super(type, id, name, price, weight, category);
        this.size = size;
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
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
        text += "size: " + this.size + "\n";
        text += "material: " + this.material + "\n";
        return text;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tricou)) return false;
        if (!super.equals(o)) return false;
        Tricou tricou = (Tricou) o;
        return size.equals(tricou.size) && material.equals(tricou.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size, material);
    }

    public Tricou(String prop){
        String [] split=prop.split(",");
        this.size=split[6];
        this.material=split[7];
    }

    @Override
    public String toSave(){
        return size+","+material;
    }
}
