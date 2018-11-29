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
public class GestorTrabajos implements IGestorTrabajos{
    private static GestorTrabajos gestor;
    private ArrayList<Trabajo> listaTrabajos = new ArrayList<>();
    
    private GestorTrabajos(){}; // Constructor Privado
    
    public static GestorTrabajos instanciar(){
        
        if( gestor == null){
            gestor = new GestorTrabajos();
        }
        return gestor;
    }

    @Override
    public String nuevoTrabajo(String titulo, int duracion, LocalDate fechaPresentacion, LocalDate fechaAprobacion, ArrayList<Area> areas, ArrayList<RolEnTrabajo> profesores, ArrayList<AlumnoEnTrabajo> aet) {
		Trabajo miTrabajo;
		boolean bandera = false;
		int contador = 0;
		
		// VERIFICO QUE LOS PARAMETROS NO SEAN NULOS.
		
		if( titulo.isEmpty() || duracion <= 0 || fechaPresentacion == null || areas == null || profesores == null || aet == null){
			return ERROR_MSG;
		}

		
		// CONTROLO QUE HAYA TUTOR/COTUTOR Y NO SE REPITAN.
		
		for( RolEnTrabajo i : profesores ){
			
			if( i.getUnRol() == Rol.TUTOR || i.getUnRol() == Rol.COTUTOR ){
				bandera = true;
			}
			if( bandera && i.getUnRol() == Rol.COTUTOR){
				for( RolEnTrabajo j : profesores ){
					if( j != i){ //Verifico que no sea la misma referencia sino es un falso positivo por asi decirlo.
						if( j.getUnRol() == Rol.TUTOR && j.getUnProfesor().equals(i.getUnProfesor()) ){ //Verifico que si j es un profesor no sea la misma persona que i.
							return ERROR_MSG;
						}
					}
				}
			}
		}
		
		if(bandera){bandera = false;}else{return ERROR_MSG;} //si no encontre tutores/cotutores devuelvo error. Si no reseteo mi bandera.
		
		// REVISO QUE HAYAN AREAS
		
		if( areas.size() < 1 ){
			return ERROR_MSG;
		}
		
		// CONTROLO LA FECHA DE APROBACION Y LA CANTIDAD DE JURADOS
		
		if(fechaAprobacion != null){ //Si hay fecha de aprobacion reviso los jurados.
			
			// VERIFICO QUE LA FECHA DE APROBACIONS SEA POSTERIOR A LA DE PRESENTACION
			
			if( fechaPresentacion.isAfter(fechaAprobacion)){
				return ERROR_MSG;
			}
			
			// VERIFICO LOS JURADOS Y SU CANTIDAD
			
			for( RolEnTrabajo i : profesores){
								
				if( i.getUnRol() == Rol.JURADO){ //controlo la cantidad de jurados y verifico que estos no se repitan con los tutores / cotutores.
					contador++;

					for( RolEnTrabajo j : profesores){
					
						//Si el profesor es el mismo pero con un rol distinto ( y no es la misma referencia ) devolvemos error.
						if( i.getUnProfesor().equals(j.getUnProfesor()) && i != j && ( j.getUnRol() == Rol.COTUTOR || j.getUnRol() == Rol.TUTOR )){
							return ERROR_MSG;
						}
					}
				}
			}
			
			if( contador < 3 ){ //Si sabemos que no hay suficientes jurados ( y hay fecha de aprobacion ) devolvemos error.
				return ERROR_MSG;
			}
		}
		
		// VERIFICO QUE HAYA AL MENOS 1 ALUMNO
		
		if( aet.size() < 1 ){
			return ERROR_MSG;
		}
		
		//VERIFICO QUE LOS ALUMNOS NO SE REPITAN
		
		for( AlumnoEnTrabajo i : aet){
			for( AlumnoEnTrabajo j : aet){
				if( i!=j && i.equals(j)){ // Si no es la misma referencia pero son el mismo alumno entonces error.
					return ERROR_MSG;
				}
			}
		}
		
		miTrabajo = new Trabajo(titulo, duracion, fechaPresentacion, fechaAprobacion, areas, profesores, aet);
		
		//VERIFICO NO AGREGAR UN TRABAJO REPETIDO
		
		if( listaTrabajos.contains(miTrabajo)){
			return ERROR_MSG;
		}
		
		listaTrabajos.add(miTrabajo);

		return SUCCESS_MSG;
	}

    @Override
    public Trabajo dameTrabajo(String titulo) {
		
		// VERIFICO LOS PARAMETROS.
		
		if(titulo.isEmpty()){
			return null;
		}
		
		// VERIFICO QUE COINCIDAN LOS TITULOS
		
		for( Trabajo i : listaTrabajos){ 
			if(titulo.equalsIgnoreCase(i.getTitulo())){
				return i;
			}
		}
		return null;
	}

    @Override
    public ArrayList<Trabajo> buscarTrabajos(String titulo) {
		ArrayList<Trabajo> misTrabajos = new ArrayList<>();
		
		// VERIFICO LOS PARAMETROS.
		
		if(titulo.isEmpty()){
			return null;
		}
		
		// VERIFICO QUE EL STRING ESTE CONTENIDA EN EL TITULO.
		
		for( Trabajo i : listaTrabajos){ 
			if(titulo.toUpperCase().contains(i.getTitulo().toUpperCase())){
				misTrabajos.add(i);
			}
		}
		
		return misTrabajos;
	}
	
	public ArrayList<Trabajo> buscarTrabajos(){ //doy una copia de los trabajos.
		ArrayList<Trabajo> misTrabajos = new ArrayList<>();
		
		misTrabajos.addAll(listaTrabajos);
		
		return misTrabajos;
	}

    @Override
    public void mostrarTrabajos() {
		for( Trabajo i : listaTrabajos){
			i.mostrar();
		}
	}
    
    
}
