/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.awt.Color;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Javi
 */
public class Suerte extends Casilla {
    private List<TarjetaSuerte> tarjetas;
    
    public Suerte (String nombre, Color color, int posicion, List<TarjetaSuerte> tarjetas){
        super(nombre, color, posicion);
        this.tarjetas = tarjetas;
    }
    
    @Override
    public void accion(Jugador jugador, Juego juego){
        TarjetaSuerte tarjeta = obtenerTarjetaAleatoria();
        juego.mostrarDialogo(jugador.getNombre() + " ha sacado una tarjeta de Suerte: " + tarjeta.getDescripcion());
        tarjeta.ejecutar(jugador, juego); //Ejecuta la acción de la tarjeta
    }
    
    private TarjetaSuerte obtenerTarjetaAleatoria(){
        Random rand = new Random();
        return tarjetas.get(rand.nextInt(tarjetas.size()));
    }
    
    public List<TarjetaSuerte> getTarjetas(){
        return tarjetas;
    }
    
    public void setTarjetas(List<TarjetaSuerte> tarjetas){
        this.tarjetas = tarjetas;
    }
}
