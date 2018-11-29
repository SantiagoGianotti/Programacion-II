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


public interface IGestorSeminarios {
	
	String validarSeminario(LocalDate fechaExposicion, NotaAprobacion nota, String obs);

	static public String ERROR_MSG = "El seminario no se pudo agregar.";
    static public String SUCCESS_MSG = "El seminario fue creado exitosamente.";
	static public String ERROR_MOD = "El seminario no se pudo modificar.";
    static public String SUCCESS_MOD = "El seminario fue modificado exitosamente.";
	
}
