import controller.ControllerUser;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        while(true){
            System.out.println("1. Crear usuario");
            System.out.println("2. Leer usuario");
            System.out.println("3. Leer todos los usuarios");
            System.out.println("4. Actualizar usuario");
            System.out.println("5. Eliminar usuario");
            System.out.println("6. Salir");
            System.out.println("Ingrese una opcion: ");
            int opcion = input.nextInt();

            switch(opcion){
                case(1):
                    System.out.println("Ingrese el nombre del usuario: ");
                    String nombre = input.next();
                    System.out.println("Ingrese el correo del usuario: ");
                    String correo = input.next();
                    System.out.println("Ingrese el telefono del usuario: ");
                    String telefono = input.next();
                    ControllerUser request = new ControllerUser("POST","http://localhost:8080/apis/users", "headers", nombre+","+correo+","+telefono);
                    System.out.println(request);//respuesta del servidor
                    System.out.println("---------------------------------------------");
                    break;
                case(2):
                    System.out.println("Ingrese el id del usuario: ");
                    int id = input.nextInt();
                    ControllerUser request2 = new ControllerUser("GET","http://localhost:8080/apis/users", "headers", "",id);
                    System.out.println(request2);//respuesta del servidor
                    System.out.println("---------------------------------------------");
                    break;
                case(3):
                    ControllerUser request3 = new ControllerUser("GET","http://localhost:8080/apis/users", "headers", "");
                    System.out.println(request3);//respuesta del servidor
                    System.out.println("---------------------------------------------");
                    break;
                case(4):
                    System.out.println("Ingrese el id del usuario: ");
                    int id2 = input.nextInt();
                    System.out.println("Ingrese el nombre del usuario: ");
                    String nombre2 = input.next();
                    System.out.println("Ingrese el correo del usuario: ");
                    String correo2 = input.next();
                    System.out.println("Ingrese el telefono del usuario: ");
                    String telefono2 = input.next();
                    ControllerUser request4 = new ControllerUser("PUT","http://localhost:8080/apis/users", "headers", nombre2+","+correo2+","+telefono2,id2);
                    System.out.println(request4);//respuesta del servidor
                    System.out.println("---------------------------------------------");
                    break;
                case(5):
                    System.out.println("Ingrese el id del usuario: ");
                    int id3 = input.nextInt();
                    ControllerUser request5 = new ControllerUser("DELETE","http://localhost:8080/apis/users", "headers", "",id3);
                    System.out.println(request5);//respuesta del servidor
                    System.out.println("---------------------------------------------");
                    break;
                case(6):
                    System.exit(0);
                    break;

            }

        }
























        /*ControllerUser request = new ControllerUser("POST","http://localhost:8080/apis/users", "headers", "Tomas,tomy@gmail.com,12312413");
        System.out.println(request);//respuesta del servidor
        System.out.println("---------------------------------------------");

        request = new ControllerUser("POST","http://localhost:8080/apis/users", "headers", "Pedro,peter@gmail.com,65453513");
        System.out.println(request);//respuesta del servidor
        System.out.println("---------------------------------------------");

        request = new ControllerUser("POST","http://localhost:8080/apis/users", "Content-Type: application/json", "Juli,julili@outlook.com,132222222");
        System.out.println(request);//respuesta del servidor
        System.out.println("---------------------------------------------");

        request = new ControllerUser("GET","http://localhost:8080/apis/users", "Content-Type: application/json", "");
        System.out.println(request);//respuesta del servidor
        System.out.println("---------------------------------------------");

        request = new ControllerUser("PUT","http://localhost:8080/apis/users", "Content-Type: application/json", "Mama,juigil@hotial.com,31333333",2);
        System.out.println(request);//respuesta del servidor
        System.out.println("---------------------------------------------");

        request = new ControllerUser("DELETE","http://localhost:8080/apis/users", "Content-Type: application/json", "",1);
        System.out.println(request);//respuesta del servidor
        System.out.println("---------------------------------------------");

        request = new ControllerUser(" GET","http://localhost:8080/apis/users", "Content-Type: application/json", "");
        System.out.println(request.GET());//respuesta del servidor
        System.out.println("---------------------------------------------");*/
    }
}