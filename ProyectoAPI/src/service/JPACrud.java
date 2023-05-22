package service;

import model.User;

import java.util.List;

public interface JPACrud {//Clase que contiene los metodos para las funciones del proyecto

    public void createUser(String body);//body es la informacion del usuario

    public void readUser(int id);

    public List<User> readAllUsers();

    public void updateUser(String body, int id);

    public void deleteUser(int id);

}
