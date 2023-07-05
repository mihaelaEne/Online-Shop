package ro.mycode.model;

import java.util.Objects;

public class Manager extends User {

    public String role;
    public int experince;

    public Manager(){}
    public Manager(String role, int experince) {
        this.role = role;
        this.experince = experince;
    }

    public Manager(String type, int id, String name, String email, String pass, String role, int experince) {
        super(type, id, name, email, pass);
        this.role = role;
        this.experince = experince;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getExperince() {
        return experince;
    }

    public void setExperince(int experince) {
        this.experince = experince;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manager)) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return experince == manager.experince && role.equals(manager.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), role, experince);
    }

    @Override
    public String toString() {
        String text = "";
        text += "I am a manager with the following characteristics:" + "\n";
        text+="type: "+super.getType()+"\n";

        text += "id: " + super.getId() + "\n";
        text += "name: " + super.getName() + "\n";
        text += "email: " + super.getEmail() + "\n";
        text+="role: "+this.role+"\n";
        text+="experience: "+this.experince;
        return text;

    }

    public Manager(String prop){
        String [] split=prop.split(",");
        this.role=split[5];
        this.experince=Integer.parseInt(split[6]);
    }

    public String toSave(){ return super.toSave()+","+role+","+experince;}

}