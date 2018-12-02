/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp7.gui.personas.modelos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import unt.herrera.prog2.tp7.gui.trabajos.modelos.GestorTrabajos;
import unt.herrera.prog2.tp7.gui.trabajos.modelos.Trabajo;
import unt.herrera.prog2.tp7.gui.trabajos.modelos.AlumnoEnTrabajo;
import unt.herrera.prog2.tp7.gui.trabajos.modelos.RolEnTrabajo;
import unt.herrera.prog2.tp7.gui.interfaces.IGestorPersonas;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.PatternSyntaxException;

/**
 *
 * @author gabinete
 */
public class GestorPersonas implements IGestorPersonas{
    private static GestorPersonas gestor;
    private List<Persona> listaPersonas = new ArrayList<>();

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
		
		if( apellidos.isEmpty() || nombres.isEmpty() || dni <= 0 || cargo == null || apellidos.contains(SEPARADOR) || nombres.contains(SEPARADOR)){ //Si los parametros no son correctos entonces error.
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
		
		if( apellidos.isEmpty() || nombres.isEmpty() || dni <= 0 || cx.isEmpty() || apellidos.contains(SEPARADOR) || nombres.contains(SEPARADOR) || cx.contains(SEPARADOR)){
			
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
		
		//Si algun parametro es nulo no lo modificamos. Tambien verifico que las cadenas no contengan el separador.
		if( apellidos != null && !apellidos.isEmpty() && !apellidos.contains(SEPARADOR)){
			profesor.setApellidos(apellidos);
		}
		
		if( nombres != null && !nombres.isEmpty() && !apellidos.contains(SEPARADOR)){
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
		if( apellidos != null && !apellidos.isEmpty() && !apellidos.contains(SEPARADOR)){
			alumno.setApellidos(apellidos);
		}

		if( nombres != null && !nombres.isEmpty() && !nombres.contains(SEPARADOR)){
			alumno.setNombres(nombres);
		}
		
		if( cx != null && !cx.isEmpty() && !cx.contains(SEPARADOR)){
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
    
	public String escribirPersonas(){
		try{
            File f = new File("Personas.txt");
            FileWriter fw = new FileWriter(f);
            BufferedWriter bfw = new BufferedWriter(fw);
			Persona miPersona;
			String linea = null;
			
			System.out.println("escribiendo eprsonassss");
			
			//Guardo a los profesores y alumnos, utilizando ';' como separador y las constantes para diferenciar el tipo.
			for( Persona i : listaPersonas){
				
				if( i instanceof Profesor){
					
					//En getCargo utilizamos el metodo .name() de manera que devuelva el nombre exacto del enum y no el toString().
					linea = String.join(SEPARADOR, PROFESOR, i.getApellidos(), i.getNombres(), Integer.toString(i.getDni()), ((Profesor) i).getCargo().name());
				}
				else if ( i instanceof Alumno ){
					linea = String.join(SEPARADOR, ALUMNO,i.getApellidos(), i.getNombres(), Integer.toString(i.getDni()), ((Alumno) i).getCx());
				}
				
				//Una vez que determinamos el tipo de persona y sus atributos procedemos a guardar la linea en el buffer.
				if( linea != null && !linea.isEmpty()){
					bfw.write(linea);
					bfw.newLine();
				}
			}
			
			bfw.close();
			return WRITE_SUCCESS;
			
		}
		catch(IOException ex){
			return WRITE_FAIL;
		}
	}
	
	public String leerPersonas(){
		try{
            File f = new File("Personas.txt");
            FileReader fr = new FileReader(f);
            BufferedReader bfr = new BufferedReader(fr);
			String linea[] = new String[5];
			GestorPersonas gestor = GestorPersonas.instanciar();
			
			//Almaceno la linea en la primera parte y luego la desgloso segun el separador.
			while( ( linea[0] = bfr.readLine() )!= null ){
                
				//Desgloso la linea y obtengo los campos, luego armo la persona a partir de eso.
				//En el caso que la linea obtenida sea defectuosa por alguna razon la persona
				//Simplemente no se va a cargar por que nuevoProfesor/Alumno se encarga de eso.
				
				linea = linea[0].split(SEPARADOR,5);
				
				try{ //Hago un catch al caso que el cargo no coincida con uno existente o que al parser no le pasen un int de numeros puros.
				
					if( linea[0].equals(PROFESOR)){
						System.out.println(gestor.nuevoProfesor(linea[1], linea[2], Integer.parseInt(linea[3]), Cargo.valueOf(linea[4])));
					}
					else if( linea[0].equals(ALUMNO)){
						System.out.println(gestor.nuevoAlumno(linea[1], linea[2], Integer.parseInt(linea[3]), linea[4]));
					}
				}
				catch(NumberFormatException ex){
					System.out.println("El DNI de una de las personas esta mal guardado!");
				}
				catch(IllegalArgumentException ex){
					System.out.println("El Cargo de la persona esta mal guardado!");
				}
            }
			
			bfr.close();
			return READ_SUCCESS;
		}
		catch(IOException ex){
			return READ_FAIL;
		}
		catch(PatternSyntaxException EX){
			System.out.println("El archivo esta corrupto!!!!");
			return READ_FAIL;
		}
	}
    
}
