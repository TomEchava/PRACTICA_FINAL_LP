package service;

import model.User;

import java.util.ArrayList;
import java.util.List;


public class JPACrudImpl implements JPACrud {//clase que le da cuerpo y desarollo a JPACrud
    private static List<User> lista=new ArrayList();
    private User user;

    @Override
    public void createUser(String body) {
        if(verifyBody(body)) {
            String[] data = body.split(",");

            this.user = new User(0, data[0], data[1], data[2]);
            String response = "Se ha creado el usuario exitosamente, sus datos son:\n" + "Id:" + user.getId() + ", " + " Nombres: " + user.getName() + ", " +
                    "Email: " + user.getEmail() + ", " + "Teléfono: " + user.getPhone();
            lista.add(user);
            System.out.println(response);
        }
        else{
            System.out.println("No se ha creado el usuario");
        }

    }

    @Override
    public void readUser(int id) {
        boolean found=false;
        for(User user:lista) {
            if (user.getId() == id) {
                found = true;
                System.out.println("Usuario encontrado: " + user.toString());
                break;
            }
        }
        if (!found){
            System.out.println("Usuario no encontrado");
        }


    }

    @Override
    public List<User> readAllUsers() {
        printUsers(lista);
        return lista;
    }

    @Override
    public void updateUser(String body, int id) {
        if(verifyBody(body)) {
            String data[] = body.split(",");
            boolean found = false;
            for (User user : lista) {
                if (user.getId() == id) {
                    user.setName(data[0]);
                    user.setEmail(data[1]);
                    user.setPhone(data[2]);
                    found = true;
                    System.out.println("Se ha actualizado el usuario con éxito y sus datos son:\n" + "Id:" + user.getId() + ", " + " Nombres: " + user.getName() + ", " +
                            "Email: " + user.getEmail() + ", " + "Teléfono: " + user.getPhone());
                    break;

                }
            }
            if (!found) {
                System.out.println("No se ha encontrado el usuario con el id: " + id);
            }
        }
        else{
            System.out.println("No se ha actualizado el usuario");
        }
    }

    @Override
    public void deleteUser(int id) {
        lista.removeIf((user -> user.getId()==id));
        System.out.println("Se ha eliminado el usuario con Id: "+id+" correctamente");
    }

    void printUsers(List<User> lista) {
        System.out.println("Lista de usuarios:");
        for (User value : lista) {
            System.out.println("\n{\n\t\"id\":" + value.getId() + "," + "\n\t\"nombres\":" + value.getName() + "\"," +
                    "\n\t\"email\":" + "\"" + value.getEmail() + "\",\n\t\"phone\":" + "\"" + value.getPhone() + "\"\n\t\t\t\t\t\t},");
        }
    }
    boolean verifyBody(String body){
        String[] data=body.split(",");
        if(data.length==3){
            if(verifyNombre(data[0])){
                if(data[1].matches("[A-Za-z0-9]*@[a-z]*\\.[a-z]*")){
                    if(data[2].matches("[0-9]*")){
                        return true;
                    }
                    else{
                        System.out.println("El teléfono no es válido, debe contener solo números");
                        return false;
                    }
                }
                else{
                    System.out.println("El email no es válido");
                    return false;
                }
            }
            else{
                System.out.println("El nombre no es válido, no debe contener números o caracteres especiales");
                return false;
            }
            }
        else{
            System.out.println("El body no es válido, cantidad de campos "+data.length+" invalida, distinto de 3");
            return false;
        }
        }

    boolean verifyNombre(String nombre){
        if(nombre.matches("[A-Z][a-z]*\\s[A-Z][a-z]*")){
            return true;
        }
        else if(nombre.matches("[A-Z][a-z]*")) {
            return true;
        }
        else if(nombre.matches("[a-z]*\\s[a-z]*")){
            return true;
        }
        else if(nombre.matches("[a-z]*")){
            return true;
        }
        else{
            return false;
        }
    }
}
