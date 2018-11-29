/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp6;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author gabinete
 */
public class Trabajo implements Comparable<Trabajo>{

	private String titulo;
	private int meses;
	private LocalDate fechaPresentacion;
	private LocalDate fechaAprobacion;
	private LocalDate fechaExposicion;
	private List<Area> unasAreas;
	private List<RolEnTrabajo> unosTrabajos;
	private List<AlumnoEnTrabajo> unosAlumnos;
	private List<Seminario> unosSeminarios = new ArrayList<>();
	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Trabajo(String titulo, List<Area> unasAreas, int meses, LocalDate fechaPresentacion, List<AlumnoEnTrabajo> unosAlumnos, List<RolEnTrabajo> unosTrabajos) {
		this.titulo = titulo;
		this.meses = meses;
		this.fechaPresentacion = fechaPresentacion;
		this.unasAreas = unasAreas;
		this.unosTrabajos = unosTrabajos;
		this.unosAlumnos = unosAlumnos;
	}

	public Trabajo(String titulo, int meses, LocalDate fechaPresentacion, LocalDate fechaAprobacion, List<Area> unasAreas, List<RolEnTrabajo> unosTrabajos, List<AlumnoEnTrabajo> unosAlumnos) {
		this.titulo = titulo;
		this.meses = meses;
		this.fechaPresentacion = fechaPresentacion;
		this.fechaAprobacion = fechaAprobacion;
		this.unasAreas = unasAreas;
		this.unosTrabajos = unosTrabajos;
		this.unosAlumnos = unosAlumnos;
	}

	@Override
	public int compareTo(Trabajo o) {
		int val = this.fechaPresentacion.compareTo(o.fechaPresentacion);

		//Si la fecha es la misma revisamos el titulo.
		if( val != 0 ){
			return val;
		}
		
		return this.titulo.compareToIgnoreCase(o.titulo);
	}
        
	
	public String getTitulo() {
		return titulo;
	}
	
	
	public String agregarProfesor(RolEnTrabajo unTrabajo) {

		if (!this.unosTrabajos.contains(unTrabajo)) { //Reviso que no este el mismo profesor

			this.unosTrabajos.add(unTrabajo);
			return "Profesor " + unTrabajo.getUnProfesor().getApellidos() + " agregado exitosamente";
		} else {
			return "ERROR: El profesor " + unTrabajo.getUnProfesor().getApellidos() + " ya esta en el trabajo.";
		}
	}

	/* // CLASE EN DESUSO LA COMENTO POR LAS DUDAS YA QUE NO NOS DIJERON NADA.
	
	public void agregarSeminario(Seminario unSeminario) {

		if (!this.unosSeminarios.contains(unSeminario)) {

			this.unosSeminarios.add(unSeminario);
		} else {
			System.out.println("ERROR: El Seminario ya esta en el trabajo.");
		}
	}

	*/
	
	public void setFechaAprobacion(LocalDate fechaAprobacion) {

		this.fechaAprobacion = fechaAprobacion;
	}
	
	
	public void mostrar() {
        boolean bandera = false; //Solo para el caso que todavia no haya jurado en el trabajo.
            
        System.out.println("***************************************************");
		System.out.println("Trabajo: " + this.titulo.toUpperCase() + "\nDuración: " + this.meses + " Meses");
		System.out.println("Fecha de presentacion en la CA: " + fechaPresentacion.format(formato));
		
		if( fechaAprobacion != null){
			
			System.out.println("Fecha de Aprobacion: " + fechaAprobacion.format(formato));
		}
		if (fechaExposicion != null) {

			System.out.println("Fecha de Exposicion: " + fechaExposicion.format(formato));
		}

		System.out.println("\nAlumnos\n----------------------");
		
		for (AlumnoEnTrabajo i : unosAlumnos) {

			System.out.println("Cx: " + i.getUnAlumno().getCx() + " - " + i.getUnAlumno().getApellidos().toUpperCase() + ", " + i.getUnAlumno().getNombres().toUpperCase());
		}

		System.out.println("\nTutor\n----------------------");
		for (RolEnTrabajo i : unosTrabajos) {

			if (i.getUnRol() == Rol.TUTOR) {
				System.out.println(i.getUnProfesor().getNombres().toUpperCase() + " " + i.getUnProfesor().getApellidos().toUpperCase());
			}
		}

		for (RolEnTrabajo i : unosTrabajos) {

			if (i.getUnRol() == Rol.COTUTOR) {
				
				if( !bandera ){ // Imprimo solo si es la primera vez en el caso que hayan cotutores.
					System.out.println("\nCotutor\n----------------------");
				}
				
				System.out.println(i.getUnProfesor().getNombres().toUpperCase() + " " + i.getUnProfesor().getApellidos().toUpperCase());
			}
		}
		if( bandera ){ bandera = false;} // reciclo mi bandera

		for (RolEnTrabajo i : unosTrabajos) {

			if (i.getUnRol() == Rol.JURADO) {
                            
                                if(!bandera){ //Imprimo esto solo la primera ejecucion en el caso que haya jurado.
                                        System.out.println("\nJurado\n----------------------");
                                }
                                    
                                bandera = true;
				System.out.println(i.getUnProfesor().getNombres().toUpperCase() + " " + i.getUnProfesor().getApellidos().toUpperCase());
			}
		}
                
        if(!unosSeminarios.isEmpty()){ //Si hay seminarios los imprimimos.
		Collections.sort(unosSeminarios);
			
            System.out.println("\nSeminario\n----------------------");
            for (Seminario i : unosSeminarios) {

                i.mostrar();
            }
        }
		
        System.out.println("***************************************************\n");
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 61 * hash + Objects.hashCode(this.titulo);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Trabajo other = (Trabajo) obj;
		if (!Objects.equals(this.titulo.toUpperCase(), other.titulo.toUpperCase())) {
			return false;
		}
		return true;
	}

    public List<Area> getAreas() {
        return unasAreas;
    }

	public String nuevoSeminario(LocalDate fechaExposicion, NotaAprobacion notaAprobacion, String observaciones){
		GestorSeminarios miGestorDeSeminarios = GestorSeminarios.instanciar();
		Seminario miSeminario;
		
		//Reviso que el seminario sea valido.
		if( Objects.equals(miGestorDeSeminarios.ERROR_MSG, miGestorDeSeminarios.validarSeminario(fechaExposicion, notaAprobacion, observaciones)) ){
			return GestorSeminarios.ERROR_MSG;
		}
		
		//Reviso que la fecha de aprobacion sea anterior a la de exposicion
		if( !fechaExposicion.isAfter(this.fechaAprobacion) ){
			return GestorSeminarios.ERROR_MSG;
		}
		
		miSeminario = new Seminario(fechaExposicion, notaAprobacion, observaciones);
		
		if( this.unosSeminarios.contains(miSeminario) ){
			return GestorSeminarios.ERROR_MSG;
		}
		
		this.unosSeminarios.add(miSeminario);
		return GestorSeminarios.SUCCESS_MSG;
	}

	public String modificarSeminario(Seminario seminario, NotaAprobacion notaAprobacion, String observaciones){
		GestorSeminarios miGestorDeSeminarios = GestorSeminarios.instanciar();
		
		if( seminario == null){
			return GestorSeminarios.ERROR_MOD;
		}
		
		//Reviso que el seminario sea valido.
		if( Objects.equals(miGestorDeSeminarios.ERROR_MSG, miGestorDeSeminarios.validarSeminario( seminario.getFechaExposicion() , notaAprobacion, observaciones)) ){
			return GestorSeminarios.ERROR_MOD;
		}
		
		for( Seminario i : unosSeminarios){ //Busco el seminario que quiero modificar.
			if( i.equals(seminario) ) {
				
				//Modifico el seminario y una vez termino devuelvo que la operacion fue exitosa.
				i.setAprobacion(notaAprobacion);
				i.setObservaciones(observaciones);
				return GestorSeminarios.SUCCESS_MOD;
			}
		}

		return GestorSeminarios.ERROR_MOD;
	}

	public List<Seminario> getSeminarios() {
		return unosSeminarios;
	}

	public List<RolEnTrabajo> getRolesEnTrabajo() {
		return unosTrabajos;
	}

	public List<AlumnoEnTrabajo> getAlumnosEnTrabajo() {
		return unosAlumnos;
	}

	public LocalDate getFechaExposicion() {
		return fechaExposicion;
	}

	public void setFechaExposicion(LocalDate fechaExposicion) {
		this.fechaExposicion = fechaExposicion;
	}
}
