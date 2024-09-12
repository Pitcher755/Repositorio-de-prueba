/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Javi
 */
public class Jugador {
    
    private String nombre;
    private int saldo;
    private int posicion;
    private List<Casilla> propiedades;
    private boolean enCarcel;
    
    public Jugador(String nombre){
        this.nombre = nombre;
        this.saldo = 100;
        this.posicion = 0;
        this.propiedades = new ArrayList<>();
        this.enCarcel = false;
    }

    //GETTERS
    
    public String getNombre() {
        return nombre;
    }

    public int getSaldo() {
        return saldo;
    }

    public int getPosicion() {
        return posicion;
    }

    public List<Casilla> getPropiedades() {
        return propiedades;
    }

    public boolean isEnCarcel() {
        return enCarcel;
    }
    
    //SETTERS

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public void setPropiedades(List<Casilla> propiedades) {
        this.propiedades = propiedades;
    }

    public void setEnCarcel(boolean enCarcel) {
        this.enCarcel = enCarcel;
    }
    
    //MÉTODOS
    
    public void mover(int pasos){
        //Tablero de 25 posiciones, la nueva posicion se calcula en base al tamaño del tablero
        this.posicion = (this.posicion + pasos) % 25; // 25 es el número total de casillas
        
        //cuando el jugador pasa por la casilla de salida
        
    }
    
    public void comprarPropiedad(Casilla casilla){
        if (casilla instanceof Calle && ((Calle)casilla).estaDisponible()){
            if (this.saldo >= ((Calle)casilla).getPrecio()){
                this.saldo -= ((Calle)casilla).getPrecio();
                ((Calle)casilla).asignarPropietario(this);
                this.propiedades.add(casilla);
                System.out.println("Propiedad comprada con exito");
            }
            else {
                System.out.println("Saldo insuficiente");
            }
        }
    }
    
    public void pagar(int cantidad){
        this.saldo -= cantidad;
    }
    
    public void recibir(int cantidad){
        this.saldo += cantidad;
    }
    
    public void irACarcel(){
        this.enCarcel = true;
    }
    
    public boolean sacarCinco(Dado dado){
        int resultado = dado.lanzar();
        if (resultado == 5){
            this.enCarcel = false; //El Jugador sale de la cárcel
            return true; //Consiguió sacar un 5
        }
        else {
            return false; //Sigue en la carcel
        }
    }      
}
