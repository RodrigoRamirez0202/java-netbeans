
package ventanas;

import javax.swing.*;
import java.awt.event.*;


public class Formulario extends JFrame implements ActionListener {

    private JTextField textField1;
    private JLabel label1;
    private JButton boton1;
    
    public Formulario(){
        
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        label1=new JLabel("Mensaje: ");
        label1.setBounds(15, 10 , 100, 30);
        add(label1);
        
        textField1=new JTextField();
        textField1.setBounds(80, 16, 190, 20);
        add(textField1);
        
        boton1=new JButton("Mostrar");
        boton1.setBounds(10, 60, 100, 30);
        boton1.addActionListener(this);       
        add(boton1);   
    }  
    @Override
    public void actionPerformed(ActionEvent e) {
     
        if(e.getSource()==boton1){
            
            String cadena=textField1.getText();
            JOptionPane.showMessageDialog(null, cadena);
        }       
    } 
    public static void main(String[] args) {
        
        Formulario mimarco=new Formulario();
        mimarco.setBounds(200,200,300,150);
        //mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mimarco.setVisible(true);
        mimarco.setLocationRelativeTo(null);
    }
}
