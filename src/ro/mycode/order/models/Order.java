package ro.mycode.order.models;



import ro.mycode.orderDetails.DetailsOrder;

import java.time.LocalDate;
import java.util.Objects;

public class Order implements DetailsOrder {
    private int id;
    private int productId;
    private float price;
    private LocalDate date;

    public Order(int id, int productId, float price, LocalDate date) {
        this.id = id;
        this.productId = productId;
        this.price = price;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String genertaInfo() {
        return "Id: " + id + ", price: " + price;
    }


    @Override
    public String adress() {
        return null;
    }

    @Override
    public float taxes() {
        return price * 1.19f;
    }


    @Override
    public String toString() {
        String text = "";
        text += "I am an order with the following characteristics:" + "\n";
        text +="id: "+this.id+"\n";
        text+="productId: "+this.productId+"\n";
        text+="price: "+this.price+"\n";
        text+="date: "+this.date;
        return text;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return id == order.id && productId == order.productId && Float.compare(order.price, price) == 0 && date.equals(order.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, price, date);
    }

    public Order(String prop) {
        String[] split = prop.split(",");
        this.id = Integer.parseInt(split[0]);
        this.productId = Integer.parseInt(split[1]);
        this.price = Float.parseFloat(split[2]);
        this.date = LocalDate.parse(split[3]);
    }


    public String toSave() {
        return id+","+productId+","+price+","+date;
    }

}

