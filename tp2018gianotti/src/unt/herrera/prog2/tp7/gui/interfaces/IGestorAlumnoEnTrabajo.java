/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp7.gui.interfaces;

import java.time.LocalDate;
import unt.herrera.prog2.tp7.gui.personas.modelos.Alumno;
import unt.herrera.prog2.tp7.gui.trabajos.modelos.AlumnoEnTrabajo;

/**
 *
 * @author gabinete
 */
public interface IGestorAlumnoEnTrabajo {
    
    public AlumnoEnTrabajo nuevoAlumnoEnTrabajo( LocalDate fechaDesde, Alumno unAlumno);
}