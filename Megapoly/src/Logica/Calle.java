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
public class Calle extends Casilla {
    
    private int precio;
    private Jugador propietario;
    private int impuesto;

    public Calle(String nombre, Color color, int posicion, int precio, int impuesto) {
        super(nombre, color, posicion);
        this.precio = precio;
        this.propietario = null;
        this.impuesto = impuesto;
    }
    
    //Getters

    public int getPrecio() {
        return precio;
    }

    public Jugador getPropietario() {
        return propietario;
    }

    public int getImpuesto() {
        return impuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public Color getColor() {
        return this.color;
    }

    public int getPosicion() {
        return posición;
    }
    
    //Setters

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setPropietario(Jugador propietario) {
        this.propietario = propietario;
    }

    public void setImpuesto(int impuesto) {
        this.impuesto = impuesto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setPosicion(int posición) {
        this.posición = posición;
    }
    
    @Override
    public void accion(Jugador jugador, Juego juego){
        if (this.propietario == null){
            //verificar si el jugador desea comprar la propiedad y tiene suficiente saldo
            if (jugador.getSaldo() >= this.precio){
                //Preguntar si desea comprar
                boolean deseaComprar = juego.mostrarDialogoCompra(jugador, this);
                
                if (deseaComprar){
                    //El jugador acepta la compra
                    jugador.pagar(this.precio); //Se resta el precio de la propiedad a su saldo
                    this.asignarPropietario(jugador); //Dar la propiedad al jugador
                    jugador.getPropiedades().add(this); //Añadir la propiedad a su lista
                    //Mostrar dialogo de compra exitosa
                    juego.mostrarDialogo(jugador.getNombre() + " ha comprado " + this.nombre + " por " + this.precio + " Mm.");
                }
                else {
                    //Mostrar mensaje de que el jugador no quiere comprar
                    juego.mostrarDialogo(jugador.getNombre() + " no quiere comprar");
                }                
            }
            else {
                //El jugador no tiene saldo suficiente para comprar
                juego.mostrarDialogo(jugador.getNombre() + " no tiene suficiente saldo para comprar la propiedad");
                
            }
            
        }else if (this.propietario != jugador){
            //Si la propiedad tiene dueño, verificar si el jugador tiene suficiente saldo para pagar el impuesto
            if (jugador.getSaldo() < this.impuesto){
                //El jugador no puede pagar y queda en bancarrota
                juego.mostrarDialogo(jugador.getNombre()+ " no tiene suficiente saldo para pagar " + this.impuesto + " Mm. ¡Bancarrota!");
                juego.terminarJuego(jugador); //Método que finaliza el juego
            }
            else {
                //El jugador puede pagar el impuesto
                jugador.pagar(this.impuesto);
                this.propietario.recibir(this.impuesto);
                juego.mostrarDialogo(jugador.getNombre() + " ha pagado " + this.impuesto + " Mm a " + this.propietario.getNombre() + " por caer en " + this.nombre);
            }            
        }
    }
    
    public boolean estaDisponible(){
        return this.propietario == null;
    }
    
    public void asignarPropietario(Jugador jugador){
        this.propietario = jugador;
    }
    
    
    
}
