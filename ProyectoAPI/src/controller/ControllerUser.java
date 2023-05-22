package controller;

import model.User;

import service.JPACrud;
import service.JPACrudImpl;

public class ControllerUser {//clase que procesa la solicitud http
    private String method;
    private String url = "http://localhost:8080/apis/users";
    private String headers = "Content-Type: application/json";
    private String body;
    private int id;
    private final String versionProtocol = "HTTP/1.1";
    private JPACrud userCrud;//referencia de una interfaz, no impplementemos la clase JPACrudImpl por que necesitamos inyeccion de dependencias

    public ControllerUser(String method, String url, String headers, String body) {
        if (url.equals("http://localhost:8080/apis/users")) {
            this.userCrud = new JPACrudImpl();
            this.method = method;
            this.url = url;
            this.headers = headers;
            this.body = body;


            switch (method) {
                case "GET":
                    GET();

                    break;
                case "POST":
                    POST(body);

                    break;
                default:
                    System.out.println("No se ha encontrado el metodo");
                    break;
            }
        } else {
            System.out.println("La URL anterior no dispone de un puerto para la conexión con el servidor");
            return;
        }
    }
    //constructor

    public ControllerUser(String method, String url, String headers, String body, int id) {
        if(url.equals("http://localhost:8080/apis/users")) {
            this.method = method;
            this.url = url;
            this.headers = headers;
            this.body = body;
            this.id = id;
            this.userCrud = new JPACrudImpl();
            switch (method) {
                case "GET":
                    GETUser(id);

                    break;
                case "PUT":
                    PUT(body, id);
                    break;
                case "DELETE":
                    DELETE(id);

                    break;
                default:
                    System.out.println("No se ha encontrado el metodo");
                    break;
            }
        }
        else{
            System.out.println("La URL anterior no dispone de un puerto para la conexión con el servidor");
            return;
        }
    }

    //constructor, recibe id para los metodos que requieren id, como para modificar, elminiar, leer, etc
    public String GETUser(int id) {//solicitud HTTP tipo GET
        userCrud.readUser(id);
        String response = versionProtocol + " 200 Ok\r\n" +
                "Content-Type: application/json\r\n" +
                "Date: " + java.time.LocalDate.now() + "\r\n" +
                "Content-Length: " + body.length() + "\r\n" +
                "\r\n" +
                body;
        return response;
    }

    public String GET() {
        userCrud.readAllUsers();
        String response = versionProtocol + " 200 Ok\r\n" +
                "Content-Type: application/json\r\n" +
                "Date: " + java.time.LocalDate.now() + "\r\n" +
                "Content-Length: " + body.length() + "\r\n" +
                "\r\n" +
                body;
        return response;
    }

    public String DELETE(int id) {
        userCrud.deleteUser(id);
        String response = versionProtocol + " 200 Ok\r\n" +
                "Content-Type: application/json\r\n" +
                "Date: " + java.time.LocalDate.now() + "\r\n" +
                "Content-Length: " + body.length() + "\r\n" +
                "\r\n" +
                body;
        return response;
    }

    public String POST(String body) {
        userCrud.createUser(body);
        String response = versionProtocol + " 201 Created\r\n" +
                "Content-Type: application/json\r\n" +
                "Date: " + java.time.LocalDate.now() + "\r\n" +
                "Content-Length: " + body.length() + "\r\n" +
                "\r\n" +
                body;
        return response;
    }

    public String PUT(String body, int id) {
        userCrud.updateUser(body, id);
        String response = versionProtocol + " 200 Ok\r\n" +
                "Content-Type: application/json\r\n" +
                "Date: " + java.time.LocalDate.now() + "\r\n" +
                "Content-Length: " + body.length() + "\r\n" +
                "\r\n" +
                body;
        return response;

    }
    @Override
    public String toString() {
        return "Server{" +
                "url='" + url + '\'' +
                ", headers='" + headers + '\'' +
                ", method='" + method + '\'' +
                ",\n body='" + body + '\'' +

                '}';

    }
}
