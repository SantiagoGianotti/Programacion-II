/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * * @author gabinete
 */
public class GestorPersonas implements IGestorPersonas{
    private static GestorPersonas gestor;
    private List<Persona> listaPersonas = new ArrayList<>();

    private GestorPersonas(){}; // Constructor Privado// Constructor Privado
    
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
		Collections.sort(listaPersonas);
		
        for( Persona i : listaPersonas){
			i.mostrar();
		}
    }

    @Override
    public void mostrarAlumnos() {
		Collections.sort(listaPersonas);
		
        for( Persona i : listaPersonas){
			if( i instanceof Alumno )
				i.mostrar();
		}
	}

    @Override
    public void mostrarProfesores() {
		Collections.sort(listaPersonas);
		
	    for( Persona i : listaPersonas){
			if( i instanceof Profesor )
				i.mostrar();
		}
	}

    @Override
    public String modificarProfesor(Profesor profesor, String apellidos, String nombres, Cargo cargo) {
		
		//Si el profesor es nulo o apellido, nombre y cx son nulos devolvemos error.
		if( profesor == null || ( apellidos == null && nombres == null && cargo == null )){ //Si todos los parametros son nulos devolvemos error.
			return ERROR_MOD_PROFESOR;
		}
		
		//Si algun parametro es nulo no lo modificamos.
		if( apellidos != null && !apellidos.isEmpty() ){
			profesor.setApellidos(apellidos);
		}
		
		if( nombres != null && !nombres.isEmpty() ){
			profesor.setNombres(nombres);
		}
		
		if( cargo != null ){
			profesor.setCargo(cargo);
		}
			
		return SUCCESS_MOD_PROFESOR;
	}

    @Override
    public String modificarAlumno(Alumno alumno, String apellidos, String nombres, String cx) {
		
		//Si el alumno es nulo o apellido, nombre y cx son nulos devolvemos error.
		if( alumno == null || ( apellidos == null && nombres == null && cx == null )){
			return ERROR_MOD_ALUMNO;
		}
		
		//Si algun parametro es nulo no lo modificamos.
		if( apellidos != null && !apellidos.isEmpty()){
			alumno.setApellidos(apellidos);
		}

		if( nombres != null && !nombres.isEmpty() ){
			alumno.setNombres(nombres);
		}
		
		if( cx != null && !cx.isEmpty()){
			alumno.setCx(cx);
		}		
		
		return SUCCESS_MOD_ALUMNO;
	}

    @Override
    public String borrarProfesor(Profesor profesor) {
		GestorTrabajos miGestorDeTrabajos = GestorTrabajos.instanciar();
		
		if( profesor == null){
			return ERROR_DEL_PROFESOR;
		}
		
		//No tiene sentido buscar un profesor que no exista en esta lista( aunque sea como alumno ).
		if( !listaPersonas.contains(profesor) ){
			return ERROR_DEL_PROFESOR;
		}
		
		//reviso ahora en la lista de trabajos si el profesor esta ocupado.
		for( Trabajo iTrabajo : miGestorDeTrabajos.buscarTrabajos() ){
			
			//Ahora busco en la lista de rol de personas
			for( RolEnTrabajo jRol : iTrabajo.getRolesEnTrabajo()){
				
				//si el profesor esta ocupado entonces no podemos modificarlo
				if( profesor.equals(jRol.getUnProfesor())){
					return ERROR_DEL_PROFESOR;
				}
			}
		}
		
		//Si llegamos hasta aca entonces el profesor no esta ocupado y lo podemos borrar tranquilamente.
		listaPersonas.remove(profesor);
		
		return SUCCESS_DEL_PROFESOR;
	}

    @Override
    public String borrarAlumno(Alumno alumno) {
    
		GestorTrabajos miGestorDeTrabajos = GestorTrabajos.instanciar();
		
		if( alumno == null){
			return ERROR_DEL_ALUMNO;
		}
		
		//No tiene sentido buscar un profesor que no exista en esta lista( aunque sea como alumno ).
		if( !listaPersonas.contains(alumno) ){
			return ERROR_DEL_ALUMNO;
		}
		
		//reviso ahora en la lista de trabajos si el profesor esta ocupado.
		for( Trabajo iTrabajo : miGestorDeTrabajos.buscarTrabajos() ){
			
			//Ahora busco en la lista de rol de personas
			for( AlumnoEnTrabajo jRol : iTrabajo.getAlumnosEnTrabajo()){
				
				//si el profesor esta ocupado entonces no podemos modificarlo
				if( alumno.equals(jRol.getUnAlumno())){
					return ERROR_DEL_ALUMNO;
				}
			}
		}
		
		//Si llegamos hasta aca entonces el profesor no esta ocupado y lo podemos borrar tranquilamente.
		listaPersonas.remove(alumno);
		return SUCCESS_DEL_ALUMNO;
	}
    
    
    
    
}
