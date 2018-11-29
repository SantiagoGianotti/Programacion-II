/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp5;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author gabinete
 */
public interface IGestorTrabajos {
    
    public String nuevoTrabajo(String titulo, int duracion, LocalDate fechaPresentacion,
    LocalDate fechaAprobacion, ArrayList<Area> areas, ArrayList<RolEnTrabajo> profesores,
    ArrayList<AlumnoEnTrabajo> aet);
    
    public Trabajo dameTrabajo(String titulo);
    public ArrayList<Trabajo> buscarTrabajos(String titulo);
    public void mostrarTrabajos();
	
	static public String ERROR_MSG = "El trabajo no se pudo agregar.";
    static public String SUCCESS_MSG = "El trabajo fue creado exitosamente.";
}
