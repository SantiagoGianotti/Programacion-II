/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp7.gui.trabajos.modelos;

/**
 *
 * @author gabinete
 */
public enum Rol {
    TUTOR, COTUTOR, JURADO;
    
    @Override    
    public String toString() {
        switch(this){
            case TUTOR:
                return "Tutor";
            case COTUTOR:
                return "Cotutor";
            case JURADO:
                return "Jurado";
            default:
                return ""; 
        }
    }
}
