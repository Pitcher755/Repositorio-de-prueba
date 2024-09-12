/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.Scanner;

/**
 *
 * @author Javi
 */
public class Juego {
    
    private Jugador jugador1;
    private Jugador jugador2;
    private Tablero tablero;
    private Jugador jugadorActual;
    private boolean finDeJuego;
    private Dado dado;
    
    public Juego (String nombreJugador1, String nombreJugador2){
        this.jugador1 = new Jugador(nombreJugador1);
        this.jugador2 = new Jugador(nombreJugador2);
        this.tablero = new Tablero();
        this.jugadorActual = jugador1;
        this.finDeJuego = false;
        this.dado = new Dado();
    }
    
    //Getters

    public Dado getDado() {
        return dado;
    }
            
    
    public void iniciarJuego(){
        //Mostrar pantalla de inicio, información de jugadores, etc.
        while (!finDeJuego){
            lanzarDado();
            int resultado = dado.lanzar();
            moverFicha(resultado);
            verificarEstado();
            cambiarTurno();
        }
        terminarJuego(jugadorActual); //Finalizar cuando el juego termina
    }
    
    public void lanzarDado(){
        int resultado = dado.lanzar();
        mostrarDialogo("El dado ha dado: " + resultado);
    }
    
    public void moverFicha(int pasos){
        //Guardar la posición anterior del jugador
        int posicionAnterior = jugadorActual.getPosicion();
        
        //Mover la ficha del jugador actual
        jugadorActual.mover(pasos);
        
        //Obtener la nueva posición del jugador
        int nuevaPosicion = jugadorActual.getPosicion();
        
        //Verificar si el jugador ha pasado por la casilla inicial
        if (posicionAnterior > nuevaPosicion) { //Si la nueva posición es menor que la anterior, ha pasado por la salida
            jugadorActual.recibir(20);
            mostrarDialogo(jugadorActual.getNombre() + " ha pasado por la salida y recibe 20 Mm.");
        }
        //Obtener la casilla en la que cayó el jugador
        Casilla casilla = tablero.obtenerCasilla(jugadorActual.getPosicion());
        
        //Ejecutar la acción correspondiente a la casilla
        casilla.accion(jugadorActual, this);
    }
    
    public void verificarEstado(){
        if (jugadorActual.getSaldo() <= 0){
            terminarJuego(jugadorActual);
        }
    }
    
    public void cambiarTurno(){
        jugadorActual = (jugadorActual == jugador1) ? jugador2 : jugador1;
    }
    
    public void terminarJuego(Jugador jugadorEnBancarrota){
        Jugador ganador = (jugadorEnBancarrota == jugador1) ? jugador2 : jugador1;
        mostrarDialogo("¡" + jugadorEnBancarrota.getNombre() + " está en bancarrota! " + ganador.getNombre() + " es el ganador.");
        finDeJuego = true;
    }
    
    public boolean mostrarDialogoCompra(Jugador jugador, Calle calle){
        System.out.println(jugador.getNombre() + ", deseas comprar " + calle.getNombre() + " por " + calle.getPrecio() + " Mm? (S/N");
        Scanner scanner = new Scanner(System.in);
        String respuesta = scanner.nextLine();
        return respuesta.equalsIgnoreCase("S");
    }
    
    public void mostrarDialogo(String mensaje){
        System.out.println(mensaje);
    }
}
