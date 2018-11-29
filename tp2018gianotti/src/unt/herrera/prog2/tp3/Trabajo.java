/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author gabinete
 */
public class Trabajo {
    private String titulo;
    private int meses;
    private LocalDate fechaPresentacion;
    private LocalDate fechaAprobacion;
    private LocalDate fechaExposicion;
    private ArrayList<Area> unasAreas;
    private ArrayList<RolEnTrabajo> unosTrabajos;
    private ArrayList<AlumnoEnTrabajo> unosAlumnos;
    private ArrayList<Seminario> unosSeminarios = new ArrayList<>();
    DateTimeFormatter formato = DateTimeFormatter.ofPattern( "dd/MM/yyyy");

	public Trabajo(String titulo, int meses, LocalDate fechaPresentacion, LocalDate fechaAprobacion, LocalDate fechaExposicion, ArrayList<Area> unasAreas, ArrayList<RolEnTrabajo> unosTrabajos, ArrayList<AlumnoEnTrabajo> unosAlumnos) {
		this.titulo = titulo;
		this.meses = meses;
		this.fechaPresentacion = fechaPresentacion;
		this.fechaAprobacion = fechaAprobacion;
		this.fechaExposicion = fechaExposicion;
		this.unasAreas = unasAreas;
		this.unosTrabajos = unosTrabajos;
		this.unosAlumnos = unosAlumnos;
	}

    public Trabajo(String titulo, int meses, LocalDate fechaPresentacion, LocalDate fechaAprobacion, ArrayList<Area> unasAreas, ArrayList<RolEnTrabajo> unosTrabajos, ArrayList<AlumnoEnTrabajo> unosAlumnos) {
        
		this(titulo, meses, fechaPresentacion, fechaAprobacion, null, unasAreas, unosTrabajos, unosAlumnos);
    }
    
    public void agregarProfesor(RolEnTrabajo unTrabajo){

		if( !this.unosTrabajos.contains(unTrabajo)){ //Reviso que no este el mismo profesor con el mismo rol 
			
			this.unosTrabajos.add(unTrabajo);
		}
		else
		{
			System.out.println("ERROR: El profesor ya esta en el trabajo con este rol.");
		}
    }
    
    public void agregarSeminario(Seminario unSeminario){
        
		if( !this.unosSeminarios.contains(unSeminario)){
			
			this.unosSeminarios.add(unSeminario);
		}
		else
		{
			System.out.println("ERROR: El Seminario ya esta en el trabajo.");
		}
    }
    
    public void mostrar(){
        
        System.out.println("Trabajo: "+this.titulo+"\nDuración: "+this.meses+" Meses");
        System.out.println("Fecha de presentaicon en la CA: "+fechaPresentacion.format(formato));
        System.out.println("Fecha de Aprobacion: "+ fechaAprobacion.format(formato));
		if( fechaExposicion != null){
			
			System.out.println("Fecha de Exposicion: "+ fechaExposicion.format(formato));
		}
		
        System.out.println("\n\nAlumnos\n----------------------");
        for( AlumnoEnTrabajo i : unosAlumnos){
			
            System.out.println("Cx: "+i.getUnAlumno().getCx() + " - " + i.getUnAlumno().getApellidos()+", "+i.getUnAlumno().getNombres());
        }
        
        System.out.println("\nTutor\n----------------------");
        for( RolEnTrabajo i: unosTrabajos ){
            
           if(i.getUnRol() == Rol.TUTOR){
           System.out.println( i.getUnProfesor().getNombres()+" "+i.getUnProfesor().getApellidos());
           }
        }
        
        System.out.println("\nJurado\n----------------------");
        for( RolEnTrabajo i: unosTrabajos ){
            
           if(i.getUnRol() == Rol.JURADO){
           System.out.println( i.getUnProfesor().getNombres()+" "+i.getUnProfesor().getApellidos());
           }
        }
    }
}


