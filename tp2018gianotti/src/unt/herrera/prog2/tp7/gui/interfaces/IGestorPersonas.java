/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp7.gui.interfaces;

import java.util.List;
import unt.herrera.prog2.tp7.gui.personas.modelos.Alumno;
import unt.herrera.prog2.tp7.gui.personas.modelos.Cargo;
import unt.herrera.prog2.tp7.gui.personas.modelos.Profesor;

/**
 *
 * @author gabinete
 */
public interface IGestorPersonas {
    
    public String nuevoProfesor(String apellidos, String nombres, int dni, Cargo cargo);
    public String nuevoAlumno(String apellidos, String nombres, int dni, String cx);
    public List<Profesor> buscarProfesores(String apellidos);
    public List<Alumno> buscarAlumnos(String apellidos);
    public Profesor dameProfesor(int documento);
    public Alumno dameAlumno(String cx);
    public void mostrarPersonas();
    public void mostrarAlumnos();
    public void mostrarProfesores();
    public String modificarProfesor(Profesor profesor, String apellidos, String nombres, Cargo cargo);
    public String modificarAlumno(Alumno alumno, String apellidos, String nombres, String cx);
    public String borrarProfesor(Profesor profesor);
    public String borrarAlumno(Alumno alumno);
    
    
    static public final String ERROR_MSG = "La persona no se pudo agregar.";
    static public final String SUCCESS_MSG = "la persona fue creada exitosamente.";
	
	static public final String ERROR_MSG_ALUMNO = "El alumno no se pudo agregar.";
    static public final String SUCCESS_MSG_ALUMNO = "El alumno fue creado exitosamente.";
	static public final String ERROR_MOD_ALUMNO = "El alumno no se pudo modificar.";
    static public final String SUCCESS_MOD_ALUMNO = "El alumno fue modificado exitosamente.";
	static public final String ERROR_DEL_ALUMNO = "El alumno no se pudo borrar.";
    static public final String SUCCESS_DEL_ALUMNO = "El alumno fue borrado exitosamente.";
	
	static public final String ERROR_MSG_PROFESOR = "El profesor no se pudo agregar.";
    static public final String SUCCESS_MSG_PROFESOR = "El profesor fue creado exitosamente.";
	static public final String ERROR_MOD_PROFESOR = "El profesor no se pudo modificar.";
    static public final String SUCCESS_MOD_PROFESOR = "El profesor fue modificado exitosamente.";
	static public final String ERROR_DEL_PROFESOR = "El profesor no se pudo borrar.";
    static public final String SUCCESS_DEL_PROFESOR = "El profesor fue borrado exitosamente.";
}
