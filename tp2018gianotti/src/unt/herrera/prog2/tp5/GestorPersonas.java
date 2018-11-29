/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp5;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author gabinete
 */
public class GestorPersonas implements IGestorPersonas{
    private static GestorPersonas gestor;
    private ArrayList<Persona> listaPersonas = new ArrayList<>();

    private GestorPersonas(){}; // Constructor Privado
    
    public static GestorPersonas instanciar(){
        
        if(gestor == null){
            gestor = new GestorPersonas();
        }
        return gestor;
    }

    @Override
    public String nuevoProfesor(String apellidos, String nombres, int dni, Cargo cargo) {
        Persona miProfesor;
		
		if( apellidos.isEmpty() || nombres.isEmpty() || dni <= 0 || cargo == null){ //Si los parametros no son correctos entonces error.
			return ERROR_MSG_PROFESOR;
		}
		
		miProfesor = new Profesor(apellidos, nombres, dni, cargo);
		
		if( listaPersonas.contains(miProfesor)){ //Si la persona esta contenida en la lista devolvemos error
			return ERROR_MSG_PROFESOR;
		}
		
		listaPersonas.add(miProfesor); // Agregamos el profesor a la lista del gestor.
		return SUCCESS_MSG_PROFESOR;
	}

    @Override
    public String nuevoAlumno(String apellidos, String nombres, int dni, String cx) {
		Alumno miAlumno;
		
		if( apellidos.isEmpty() || nombres.isEmpty() || dni <= 0 || cx.isEmpty()){
			return ERROR_MSG_ALUMNO;
		}
		
		miAlumno = new Alumno(apellidos, nombres, dni, cx);
		
		if( listaPersonas.contains(miAlumno)){
			return ERROR_MSG_ALUMNO;
		}
		listaPersonas.add(miAlumno); // Agregamos el alumno a la lista del gestor.
		return SUCCESS_MSG_ALUMNO;
	}

    @Override
    public ArrayList<Profesor> buscarProfesores(String apellidos) {
		ArrayList<Profesor> listaProfes = new ArrayList<>();
		
		for( Persona i : listaPersonas){
			if( i instanceof Profesor){ // Verifico que i sea un profesor.
				
				if( i.getApellidos().toUpperCase().contains(apellidos.toUpperCase()) ){ //Si el apellido esta contenido agrego el profesor a un arraylist utilizando un cast y el metodo add
					listaProfes.add((Profesor)i);
				}
			}
		}
		
		return listaProfes;
	}

    @Override
    public ArrayList<Alumno> buscarAlumnos(String apellidos) {
		ArrayList<Alumno> listaAlumnos = new ArrayList<>();
		
		for( Persona i : listaPersonas){
			if( i instanceof Alumno){ // Verifico que i sea un alumno.
				
				if( i.getApellidos().toUpperCase().contains(apellidos.toUpperCase()) ){ //Si el apellido esta contenido agrego el alumno a un arraylist utilizando un cast y el metodo add
					listaAlumnos.add((Alumno)i);
				}
			}
		}
		
		if(listaAlumnos.isEmpty()){ // Si la lista esta vacia devolvemos null. De lo contrario devolvemos la lista.
			return null;
		}
		
		return listaAlumnos;
	}

    @Override
    public Profesor dameProfesor(int documento) {
        
		for( Persona i : listaPersonas){ // Verifico que sea un profesor y luego que los documentos coincidan.
			if( i instanceof Profesor){
				
				if( i.getDni() == documento)
				{
					return (Profesor)i;
				}
			}
		}
		return null;
	}

    @Override
    public Alumno dameAlumno(String cx) {
		
		for(Persona i : listaPersonas){ //Verifico que sea un alumno y luego que los cx sean iguales.
			if( i instanceof Alumno){
				
				if( Objects.equals( ((Alumno)i).getCx() ,cx)){ //Realizo un cast de persona a alumno para poder utilizar getCx
					
					return (Alumno)i;
				}
			}
		}
		return null;
	}

    @Override
    public void mostrarPersonas() {
        for( Persona i : listaPersonas){
			i.mostrar();
		}
    }

    @Override
    public void mostrarAlumnos() {
        for( Persona i : listaPersonas){
			if( i instanceof Alumno )
				i.mostrar();
		}
	}

    @Override
    public void mostrarProfesores() {
	    for( Persona i : listaPersonas){
			if( i instanceof Profesor )
				i.mostrar();
		}
	}
    
}
