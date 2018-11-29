/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp7.gui.interfaces;

import java.time.LocalDate;
import unt.herrera.prog2.tp7.gui.personas.modelos.Profesor;
import unt.herrera.prog2.tp7.gui.trabajos.modelos.Rol;
import unt.herrera.prog2.tp7.gui.trabajos.modelos.RolEnTrabajo;

/**
 *
 * @author gabinete
 */
public interface IGestorRolEnTrabajo {
    
    public RolEnTrabajo nuevoRolEnTrabajo(Profesor unProfesor, Rol unRol, LocalDate fechaDesde);
}
