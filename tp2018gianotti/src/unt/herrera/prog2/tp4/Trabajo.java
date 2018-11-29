/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

	public String agregarProfesor(RolEnTrabajo unTrabajo) {

		if (!this.unosTrabajos.contains(unTrabajo)) { //Reviso que no este el mismo profesor con el mismo rol 

			this.unosTrabajos.add(unTrabajo);
			return "Profesor " + unTrabajo.getUnProfesor().getApellidos() + " agregado exitosamente";
		} else {
			return "ERROR: El profesor ya esta en el trabajo con este rol.";
		}
	}

	public void agregarSeminario(Seminario unSeminario) {

		if (!this.unosSeminarios.contains(unSeminario)) {

			this.unosSeminarios.add(unSeminario);
		} else {
			System.out.println("ERROR: El Seminario ya esta en el trabajo.");
		}
	}

	public void setFechaAprobacion(LocalDate fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}
	
	
	public void mostrar() {
            
                boolean jurado = false; //Solo para el caso que todavia no haya jurado en el trabajo.
            
                System.out.println("***************************************************");
		System.out.println("Trabajo: " + this.titulo + "\nDuración: " + this.meses + " Meses");
		System.out.println("Fecha de presentacion en la CA: " + fechaPresentacion.format(formato));
		
		if( fechaAprobacion != null){
			
			System.out.println("Fecha de Aprobacion: " + fechaAprobacion.format(formato));
		}
		if (fechaExposicion != null) {

			System.out.println("Fecha de Exposicion: " + fechaExposicion.format(formato));
		}

		System.out.println("\nAlumnos\n----------------------");
		for (AlumnoEnTrabajo i : unosAlumnos) {

			System.out.println("Cx: " + i.getUnAlumno().getCx() + " - " + i.getUnAlumno().getApellidos() + ", " + i.getUnAlumno().getNombres());
		}

		System.out.println("\nTutor\n----------------------");
		for (RolEnTrabajo i : unosTrabajos) {

			if (i.getUnRol() == Rol.TUTOR) {
				System.out.println(i.getUnProfesor().getNombres() + " " + i.getUnProfesor().getApellidos());
			}
		}


		for (RolEnTrabajo i : unosTrabajos) {

			if (i.getUnRol() == Rol.JURADO) {
                            
                                if(!jurado){ //Imprimo esto solo la primera ejecucion en el caso que haya jurado.
                                        System.out.println("\nJurado\n----------------------");
                                }
                                    
                                jurado = true;
				System.out.println(i.getUnProfesor().getNombres() + " " + i.getUnProfesor().getApellidos());
			}
		}
                
                if(!unosSeminarios.isEmpty()){ //Si hay seminarios los imprimimos.

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
		if (!Objects.equals(this.titulo, other.titulo)) {
			return false;
		}
		return true;
	}

}
