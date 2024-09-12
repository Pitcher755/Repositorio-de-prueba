/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Javi
 */
public class Tablero {
    private List<Casilla> casillas;
    
    public Tablero(){
        this.casillas = new ArrayList<>();
        inicializarCasillas();
    }
    
    private void inicializarCasillas(){
        //Inicialización de 25 casillas
        for (int i = 0; i < 25; i++) {
            switch (i) {
                case 0:
                    casillas.add(new CasillaInicial("Salida", Color.BLACK, i));
                    break;
                case 5:
                case 15:
                    casillas.add(new Impuesto("Impuesto", Color.YELLOW, i, 10));
                    break;
                case 10:
                case 20:
                    casillas.add(new Carcel("Carcel", Color.BLUE, i, false));
                    break;
                case 12:
                    casillas.add(new Carcel("Ve a la cárcel", Color.BLUE, i , true));
                    break;
                case 7:
                case 17:
                case 22:
                    casillas.add(new Suerte("Suerte", Color.MAGENTA, i ,generarTarjetasSuerte()));
                    break;
                default:
                    casillas.add(new Calle("Calle " + i, Color.RED, i, 20, 40));
                    break;
            }
        }
    }
    
    private List<TarjetaSuerte> generarTarjetasSuerte(){
        List<TarjetaSuerte> tarjetas = new ArrayList<>();
        tarjetas.add(new TarjetaSuerte("Has ganado un premio en el concurso de belleza. Recibe 20 Mm.", 1));
        tarjetas.add(new TarjetaSuerte("Hoy es tu cumpleaños. Recibe 10 Mm de tu contrincante.", 2));
        tarjetas.add(new TarjetaSuerte("Has recibido una multa de tráfico. Paga 10 Mm.", 3));
        //Se pueden añadir más tarjetas
        return tarjetas;
    }
    
    public Casilla obtenerCasilla(int posicion){
        return casillas.get(posicion);
    }
    
    // Otro posibles métodos
}
