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
public class Carcel extends Casilla {
    private boolean esVeALaCarcel;
    
    public Carcel(String nombre, Color color, int posicion, boolean esVeALaCarcel){
        super(nombre, color, posicion);
        this.esVeALaCarcel = esVeALaCarcel;
    }
    
    @Override
    public void accion(Jugador jugador, Juego juego){
        if (esVeALaCarcel){
            //Enviar al jugador a la cárcel
            juego.mostrarDialogo(jugador.getNombre() + " va directo a la cárcel.");
            jugador.irACarcel();
        }
        else {
            //El jugador ya está en la carcel y debe sacar un 5 para salir
            if (jugador.isEnCarcel()){
                if (jugador.sacarCinco(juego.getDado())){
                    juego.mostrarDialogo(jugador.getNombre() + " ha sacado un 5 y sale de la cárcel");
                }
                else {
                    juego.mostrarDialogo(jugador.getNombre() + " no ha sacado un 5 y sigue en la cárcel");
                }
            }
        }
    }
    
    public boolean isEsVeALaCarcel(){
        return esVeALaCarcel;
    }
    
    public void setEsVeALaCarcel(boolean esVeALaCarcel){
        this.esVeALaCarcel = esVeALaCarcel;
    }
}
