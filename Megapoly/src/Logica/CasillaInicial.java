/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.awt.Color;

/**
 *
 * @author Javi
 */
public class CasillaInicial extends Casilla {
    
    public CasillaInicial(String nombre, Color color, int posicion){
        super(nombre, color, posicion);
    }
    
    @Override
    public void accion(Jugador jugador, Juego juego){
        //El jugador recibe 20 Mm al pasar por la salida
        jugador.recibir(20);
        juego.mostrarDialogo(jugador.getNombre() + " ha pasado por " + this.getNombre() + " y recibe 20 Mm.");
    }
}
