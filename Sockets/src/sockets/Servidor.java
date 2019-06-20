/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author Rodrigo
 */
public class Servidor extends Observable implements Runnable {
    
    private int puerto;
    
    public Servidor(int puerto){
        
        this.puerto=puerto;
    }

    @Override
    public void run() {
        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        
        try {
            //creamos el socket de nuestro servidor
            servidor = new ServerSocket(puerto);
            System.out.println("Servidor iniciado");

            //siempre escuchando peticiones
            while (true) {
                //a la escucha de un cliente
                sc = servidor.accept();              
                System.out.println("Cliente conectado");
                in = new DataInputStream(sc.getInputStream());
                
                //leo el mensaje que me envia
                String mensaje = in.readUTF();
                System.out.println(mensaje);

                //metodos de la clase observable
                this.setChanged();//algo va a cambiar
                this.notifyObservers(mensaje);//envia notificacion
                this.clearChanged();//algo cambio

                //cierro el socket
                sc.close();
                System.out.println("Cliente desconectado");
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
