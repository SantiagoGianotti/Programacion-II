/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp5;

import java.util.ArrayList;

/**
 *
 * @author gabinete
 */
public interface IGestorPersonas {
    
    public String nuevoProfesor(String apellidos, String nombres, int dni, Cargo cargo);
    public String nuevoAlumno(String apellidos, String nombres, int dni, String cx);
    public ArrayList<Profesor> buscarProfesores(String apellidos);
    public ArrayList<Alumno> buscarAlumnos(String apellidos);
    public Profesor dameProfesor(int documento);
    public Alumno dameAlumno(String cx);
    public void mostrarPersonas();
    public void mostrarAlumnos();
    public void mostrarProfesores();
    static public String ERROR_MSG = "La persona no se pudo agregar.";
    static public String SUCCESS_MSG = "la persona fue creada exitosamente.";
	static public String ERROR_MSG_ALUMNO = "El alumno no se pudo agregar.";
    static public String SUCCESS_MSG_ALUMNO = "El alumno fue creado exitosamente.";
	static public String ERROR_MSG_PROFESOR = "El profesor no se pudo agregar.";
    static public String SUCCESS_MSG_PROFESOR = "El profesor fue creado exitosamente.";
}
