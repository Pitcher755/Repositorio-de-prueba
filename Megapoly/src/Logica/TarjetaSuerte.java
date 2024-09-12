/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author Javi
 */
public class TarjetaSuerte {
    private String descripcion;
    private int tipo; // 1 = recibir dinero, 2 = a pagar, 3 = ir a la carcel, etc

    public TarjetaSuerte(String descripcion, int tipo) {
        this.descripcion = descripcion;
        this.tipo = tipo;
    }
    
    public void ejecutar(Jugador jugador, Juego juego){
        switch (tipo) {
            case 1:
                jugador.recibir(20); // Ejemplo de recibir 20 Mm
                juego.mostrarDialogo(jugador.getNombre() + " ha recibido 20 Mm.");
                break;
            case 2:
                jugador.pagar(10); //Ejemplo pagar 10 Mm
                juego.mostrarDialogo(jugador.getNombre() + " ha pagado 10 Mm.");
                break;
            case 3:
                jugador.irACarcel(); //Ejemplo ir a la cárcel
                juego.mostrarDialogo(jugador.getNombre() + " va a la cárcel");
                break;
                //SEGUIR AÑADIENDO TODAS LAS TARJETAS Y OPCIONES
        }
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    public int getTipo(){
        return tipo;
    }
    
    public void setTipo(int tipo){
        this.tipo = tipo;
    }
}
