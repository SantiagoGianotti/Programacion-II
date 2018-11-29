/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp7.gui.seminarios.modelos;


/**
 *
 * @author gabinete
 */
public enum NotaAprobacion {
    
    APROBADO_SINOBS,
    APROBADO_CONOBS,
    DESAPROBADO;
	
	@Override	
	public String toString() {
		switch( this ){
			case APROBADO_SINOBS:
			case APROBADO_CONOBS:
				return "Aprobado";
			case DESAPROBADO:
				return "Desaprobado";
			default:
				return "";
		}
	}
}
