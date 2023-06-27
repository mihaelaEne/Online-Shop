package ro.mycode.model;

import java.util.Objects;

public class Manager{
    private int id;
    private String name;
    private String email;
    private String pass;
    private String phoneNumber;
    private String role;

    public Manager(int id, String name, String email, String pass, String phoneNumber, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.phoneNumber = phoneNumber;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manager)) return false;
        Manager manager = (Manager) o;
        return id == manager.id && name.equals(manager.name) && email.equals(manager.email) && pass.equals(manager.pass) && phoneNumber.equals(manager.phoneNumber) && role.equals(manager.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, pass, phoneNumber, role);
    }

    @Override
    public String toString() {
        String text = "";
        text += "I am a manager with the following characteristics:" + "\n";
        text += "id: " + this.id + "\n";
        text += "name: " + this.name + "\n";
        text += "email: " + this.email + "\n";
        text += "phoneNumber: " + this.phoneNumber + "\n";
        text+="role: "+this.role;
        return text;

    }

    public Manager(String prop) {
        String[] split = prop.split(",");
        this.id = Integer.parseInt(split[0]);
        this.name = split[1];
        this.email = split[2];
        this.pass = split[3];
        this.phoneNumber =split[4];
        this.role=split[5];

    }


    public String toSave() {
        return id + "," + name + "," + email + "," + pass + "," + phoneNumber+","+role;
    }
}
