/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp3;

/**
 *
 * @author gabinete
 */
public class Area {
    
    private String nombre;

    public Area(String nombre) {
        this.nombre = nombre;
    }
    
    //<editor-fold desc="Get && Set">
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //</editor-fold>
            
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
}
