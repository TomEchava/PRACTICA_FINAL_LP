package model;//Los atributos de la tabla de datos/base de datos
import java.util.concurrent.atomic.AtomicInteger;

public class User {//Clase que crea usuarios.
    private int id=0;
    private String name;
    private String email;
    private String phone;
    //encabezados o campos de la tabla
    private static final AtomicInteger count = new AtomicInteger(0);


    public User(int id, String name, String email, String phone) {
        this.id = count.incrementAndGet();
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    //Constructor
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
    //Getters

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    //Setters

    public String toString() {
        return "User{" +
                "id=" + id +
                ", names='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
