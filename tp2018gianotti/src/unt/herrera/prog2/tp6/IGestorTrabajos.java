/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp6;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author gabinete
 */
public interface IGestorTrabajos {
    
    public String nuevoTrabajo(String titulo, int duracion, LocalDate fechaPresentacion,
    LocalDate fechaAprobacion, List<Area> areas, List<RolEnTrabajo> profesores,
    List<AlumnoEnTrabajo> aet);
    
    public Trabajo dameTrabajo(String titulo);
    public List<Trabajo> buscarTrabajos(String titulo);
    public void mostrarTrabajos();
    public String finalizarTrabajo(Trabajo trabajo, LocalDate fechaExposicion);
    public String borrarTrabajo(Trabajo trabajo);
    public String reemplazarProfesor(Trabajo trabajo, Profesor profesorReemplazado, LocalDate fechaHasta, String razon, Profesor nuevoProfesor);
    public String finalizarAlumno(Trabajo trabajo, Alumno alumno, LocalDate fechaHasta, String razon);
    
	
	static public final String ERROR_MSG = "El trabajo no se pudo agregar.";
    static public final String SUCCESS_MSG = "El trabajo fue creado exitosamente.";
	static public final String ERROR_FIN = "El trabajo no pudo terminarse.";
	static public final String SUCCESS_FIN = "El trabajo termino exitosamente!";
	static public final String ERROR_DEL = "El trabajo no pudo borrarse.";
	static public final String SUCCESS_DEL = "El trabajo se borro exitosamente!";
	static public final String ERROR_REEMP = "El profesor no se pudo reemplazar.";
	static public final String SUCCESS_REEMP = "El profesor se reemplazo exitosamente!";
	static public final String ERROR_FIN_ALU = "El alumno no pudo finalizar.";
	static public final String SUCCESS_FIN_ALU = "El alumno finalizo exitosamente!";
}
