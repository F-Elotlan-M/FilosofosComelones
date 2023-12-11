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
public class Filosofo  implements Runnable {
    private UtensilioComida utensilioComida;
    public Thread comensalFilosofo;
    private int numeroComensal;
    private int indiceComensal;
     
    public Filosofo(UtensilioComida utensilio, int comensal){
        this.utensilioComida = utensilio;
        this.numeroComensal = comensal;
        this.indiceComensal = comensal - 1;
        this.comensalFilosofo = new Thread(this, String.valueOf(numeroComensal));
    }
     
    @Override
    public void run(){    
        while(true){
            this.pensar();
            this.utensilioComida.tomarTenedores(this.indiceComensal);
            this.comer();
            System.out.println("Filosofo " + comensalFilosofo.getName() +  " dejo de comer, los tenedores " + 
                (this.utensilioComida.tenedorIzquierda(this.indiceComensal, "") + 1) + " y " + 
                    (this.utensilioComida.tenedorDerecha(this.indiceComensal, "") + 1) + " están desocupados :p" );
            this.utensilioComida.soltarTenedores(this.indiceComensal);
        }
         
    }
     
    public void pensar(){
        
        System.out.println("El filosofo " + comensalFilosofo.getName() + " esta pensando");
        try {
            sleep((long) (Math.random() * 1000));
        } catch (InterruptedException ex) {
            ex.getStackTrace();
        }
         
    }
     
    public void comer(){
        System.out.println("Filosofo " + comensalFilosofo.getName() + " esta comiendo");
        try {
            sleep((long) (Math.random() * 1000));
        } catch (InterruptedException ex) { 
            ex.getStackTrace();
        }
    }
    
}
