package Servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import Objeto.Persona;

public class Servidor {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
    int port = 1236;

    ServerSocket server = new ServerSocket(port);
    Socket cliente = server.accept();

    ObjectInputStream entradaDatos = new ObjectInputStream(cliente.getInputStream());

    System.out.println("SERVIDOR EN FUNCIONAMIENTO ... \nA LA ESPERA DE DATOS ... ");

    int cantidadPersonas = entradaDatos.readInt();
    ArrayList<Persona> arrayPersona = new ArrayList<Persona>();

    for (int i = 0 ; i < cantidadPersonas ; i++) {
        Persona datoPersona = (Persona)entradaDatos.readObject();
        arrayPersona.add(datoPersona);
    }
    
    System.out.println("NOMBRE\t\tEDAD\t\tEMAIL");
    for (Persona datoPersona : arrayPersona) {
        System.out.println(datoPersona.getNombre() +"\t\t" +
        datoPersona.getEdad()+"\t\t"+datoPersona.getEmail());
    }

    server.close();
    }
}
