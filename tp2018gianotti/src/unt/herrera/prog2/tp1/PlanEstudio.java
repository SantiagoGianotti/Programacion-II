/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp1;

/**
 *
 * @author estudiante
 */

import java.time.LocalDate;

public class PlanEstudio {
    
    String nombre;
    LocalDate fechaDesde;
	
       public void mostrar()
    {
        System.out.println("\tNombre: " + this.nombre);        
        System.out.println("\tFecha: " + this.fechaDesde);
    }
    
    
}
