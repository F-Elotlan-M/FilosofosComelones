/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FiloComelones;

import static java.lang.Thread.sleep;
/**
 *
 * @author Elotlan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        UtensilioComida utensilioComida = new UtensilioComida(5);
        int contador = 1;
        while (contador <=5){
            Filosofo filosofo = new Filosofo(utensilioComida, contador);
            filosofo.comensalFilosofo.start();
            contador++;
        }
    }
}
