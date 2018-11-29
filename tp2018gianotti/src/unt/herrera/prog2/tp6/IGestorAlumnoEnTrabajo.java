/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp6;

import java.time.LocalDate;

/**
 *
 * @author gabinete
 */
public interface IGestorAlumnoEnTrabajo {
    
    public AlumnoEnTrabajo nuevoAlumnoEnTrabajo( LocalDate fechaDesde, Alumno unAlumno);
}