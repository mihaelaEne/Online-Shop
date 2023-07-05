package ro.mycode.model;

import java.util.Objects;

public class User {
    private String type;
    private int id;
    private String name;
    private String email;
    private String pass;


    public User(String type,int id, String name, String email, String pass) {
        this.type=type;
        this.id = id;
        this.name = name;
        this.email = email;
        this.pass = pass;
    }

    public User(){}

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id && type.equals(user.type) && name.equals(user.name) && email.equals(user.email) && pass.equals(user.pass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, id, name, email, pass);
    }

    @Override
    public String toString() {
        String text = "";
        text += "I am an user with the following characteristics:" + "\n";
        text+="type: "+this.type+"\n";
        text += "id: " + this.id + "\n";
        text += "name: " + this.name + "\n";
        text += "email: " + this.email + "\n";
        return text;

    }

    public User(String prop) {
        String[] split = prop.split(",");
        this.type=split[0];
        this.id = Integer.parseInt(split[1]);
        this.name = split[2];
        this.email = split[3];
        this.pass = split[4];
    }
    public String toSave() {
        return type+","+id + "," + name + "," + email + "," + pass;
    }




}
