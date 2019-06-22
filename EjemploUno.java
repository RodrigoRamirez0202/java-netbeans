package ejemplouno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EjemploUno {

    public static void main(String[] args) {
        // TODO code application logic here
        Marco mimarco = new Marco();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class Marco extends JFrame {

    public Marco() {

        setBounds(700, 400, 400, 150);
        add(new Lamina());
        setVisible(true);
    }
}
class Lamina extends JPanel {

    public Lamina() {

        setLayout(new BorderLayout());        
        JPanel lamina1=new JPanel();
        lamina1.setLayout(new FlowLayout());

        invertir = new JButton("Invertir Array");
        texto = new JTextField(15);
        texto.setSize(180, 20);
        
        lamina1.add(texto);

        invertir.addActionListener(new eventos());

        add(lamina1, BorderLayout.CENTER);
        add(invertir, BorderLayout.SOUTH);
    }
    
    class eventos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String texto2 = texto.getText();
            String textoInvertido = "";
            int largo = texto2.length();

            for (int i = largo - 1; i >= 0; i--) {

                textoInvertido += texto2.charAt(i);
            }
            texto.setText(textoInvertido);
        }
    }
    JButton invertir;
    JTextField texto;
    System.out.print("Esto es una prueba de git hub");
}
