/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.Random;

/**
 *
 * @author Javi
 */
public class Dado {
    private Random random;
    
    public Dado(){
        this.random = new Random();
    }
    
    public int lanzar(){
        return random.nextInt(6) + 1; //Devuelve un numero entre 1 y 6
    }
}
