/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp7.gui.personas.modelos;


/**
 *
 * @author gabinete
 */
public enum Cargo {
    TITULAR,
    ASOCIADO,
    ADJUNTO,
    JTP,
    EXTERNO,
    ADG;
    
    @Override    
    public String toString() {
        switch(this){
            case TITULAR:
                return "Titular";
            case ASOCIADO:
                return "Asociado";
            case ADJUNTO:
                return "Adjunto";
            case JTP:
                return "JTP";
            case ADG:
                return "ADG";
            case EXTERNO:
                return "Externo";
            default:
                return "";
        }
    }
}
