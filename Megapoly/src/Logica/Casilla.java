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
public abstract class Casilla {
    protected String nombre;
    protected Color color;
    protected int posición;

    public Casilla(String nombre, Color color, int posición) {
        this.nombre = nombre;
        this.color = color;
        this.posición = posición;
    }
    
    public abstract void accion(Jugador jugador, Juego juego);
    
    //Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public Color getColor() {
        return color;
    }

    public int getPosición() {
        return posición;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setPosición(int posición) {
        this.posición = posición;
    }
}
