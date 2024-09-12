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
public class Impuesto extends Casilla {
    private int cantidad;
    
    public Impuesto(String nombre, Color color, int posicion, int cantidad){
        super(nombre, color, posicion);
        this.cantidad = cantidad;
    }
    
    @Override
    public void accion(Jugador jugador, Juego juego){
        if (jugador.getSaldo() < this.cantidad){
            //El jugador no puede pagar y queda en bancarrota
            juego.mostrarDialogo(jugador.getNombre() + " no tiene suficiente dinero para pagar el jimpuesto de " + this.cantidad + " Mm. ¡Bancarrota!");
            juego.terminarJuego(jugador);
        }
        else{
            //El jugador paga el impuesto
            jugador.pagar(this.cantidad);
            juego.mostrarDialogo(jugador.getNombre() + " ha pagado un impuesto de " + this.cantidad + " Mm.");
        }
    }
    
    public int getCantidad(){
        return cantidad;
    }
    
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }    
}
