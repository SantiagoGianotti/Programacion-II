/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp6;

import java.time.LocalDate;

/**
 *
 * @author Santi-PC
 */
public class GestorSeminarios implements IGestorSeminarios{
	static private GestorSeminarios gestor;
	
	
	private GestorSeminarios(){}; // Constructor Privado
    
	
    public static GestorSeminarios instanciar(){
        
        if( gestor == null){
            gestor = new GestorSeminarios();
        }
        return gestor;
    }
	
	@Override
	public String validarSeminario(LocalDate fechaExposicion, NotaAprobacion nota, String obs) {
	
		if( fechaExposicion == null  || nota == null){ // Si estamos pasando parametros vacios falla
			return ERROR_MSG;
		}

		if(  (nota == NotaAprobacion.APROBADO_CONOBS || nota == NotaAprobacion.DESAPROBADO )){
			
			if( obs == null || obs.isEmpty()){
				return ERROR_MSG;
			}
		}
		
		return SUCCESS_MSG;
	}
}
