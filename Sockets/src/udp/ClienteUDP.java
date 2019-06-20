/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp;

import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rodrigo
 */
public class ClienteUDP {
    
    public static void main(String[]args){
        
        final int PUERTO=5000;
        byte[]buffer=new byte[1024];
                
        try {
            InetAddress direccion=InetAddress.getByName("localhost");
            DatagramSocket socketUDP=new DatagramSocket();
            
            //creo el paquete
            String mensaje="Hola desde el cliente";
            buffer=mensaje.getBytes();
            DatagramPacket pregunta=new DatagramPacket(buffer,buffer.length,direccion,PUERTO);
            
            //envio el paquete
            System.out.println("Envio datagrama");
            socketUDP.send(pregunta);
            
            //recibo el paquete
            DatagramPacket peticion=new DatagramPacket(buffer,buffer.length);
            System.out.println("Recibo peticion");
            socketUDP.receive(peticion);
            
            //imprimo el mensaje recibido
            mensaje=new String(peticion.getData());
            System.out.println(mensaje);
            socketUDP.close();
            
            
            
        } catch (SocketException ex) {
            Logger.getLogger(ClienteUDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(ClienteUDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClienteUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
