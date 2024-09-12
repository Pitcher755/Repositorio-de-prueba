/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;
import javax.swing.*;

/**
 *
 * @author Javi
 */
public class MegaPolyGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Crear Ventaja principal
        JFrame ventana = new JFrame("MegaPoly");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600, 600);
        
        //Crear el panel de juego
        JPanel panelJuego = new JPanel();
        JLabel etiqueta = new JLabel("¡Bienvenidos a MegaPoly!");
        panelJuego.add(Etiqueta);
        
        //Añadir el panel a la ventana
        venatana.add(panelJuego);
        
        //Mostrar la ventana
        ventana.setVisible(true);
    }
    
}
