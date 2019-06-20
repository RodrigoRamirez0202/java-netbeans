/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.io.*;
import java.net.*;
import java.util.logging.*;

/**
 *
 * @author Rodrigo
 */
public class Cliente implements Runnable {

    private int puerto;
    private String mensaje;
    
    public Cliente(int puerto, String mensaje){       
        this.puerto=puerto;
        this.mensaje=mensaje;
    }
    @Override
    public void run() {
        //host del servidor
        final String HOST = "192.168.1.41";
        DataOutputStream out;

        try {
            //creo el socket para conectarme con el servidor
            Socket sc = new Socket(HOST, puerto);
            out = new DataOutputStream(sc.getOutputStream());

            //envio un mensaje al servidor
            out.writeUTF(mensaje);

            sc.close();

        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
