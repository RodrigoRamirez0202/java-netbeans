/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp;

import java.io.IOException;
import java.net.*;
import java.util.logging.*;

/**
 *
 * @author Rodrigo
 */
public class ServidorUDP {
    
    public static void main(String[]args){
    
        final int PUERTO=5000;
        byte[]buffer=new byte[1024];
        
        try {
            System.out.println("Iniciando el servidor UDP");
            DatagramSocket socketUDP=new DatagramSocket(PUERTO);
            
            while(true){            
            DatagramPacket mipaquete=new DatagramPacket(buffer,buffer.length);
            
            //recibo el paquete
            socketUDP.receive(mipaquete);
            System.out.println("Informacion del cliente recibida");
            
            //imprimo el mensaje recibido
            String mensaje=new String(mipaquete.getData());
            System.out.println(mensaje);
            
            //obtengo los datos del cliente (direccion y puerto)
            int puertoCliente=mipaquete.getPort();
            InetAddress direccion=mipaquete.getAddress();
            
            //envio el mensaje al cliente
            mensaje="Hola desde el servidor";
            buffer = mensaje.getBytes();
            DatagramPacket respuesta=new DatagramPacket(buffer,buffer.length,direccion,puertoCliente);
            
            System.out.println("Informacion enviada al cliente");
            socketUDP.send(respuesta);
            }
                                      
        } catch (SocketException ex) {
            Logger.getLogger(ServidorUDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServidorUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
