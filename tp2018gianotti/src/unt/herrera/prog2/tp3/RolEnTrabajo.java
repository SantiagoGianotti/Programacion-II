/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp3;

import java.time.LocalDate;

/**
 *
 * @author gabinete
 */
public class RolEnTrabajo {
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private String razon;
    private Rol unRol;
    private Profesor unProfesor;

    public RolEnTrabajo(LocalDate fechaDesde, LocalDate fechaHasta, String razon, Rol unRol, Profesor unProfesor) {
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.razon = razon;
        this.unRol = unRol;
        this.unProfesor = unProfesor;
    }

    public RolEnTrabajo(LocalDate fechaDesde, Rol unRol, Profesor unProfesor) { // Sobrecargo para el caso que el profesor no haya renunciado.
        this(fechaDesde, null, null, unRol, unProfesor);
    }
    
    //<editor-fold desc="Get && set">
    public LocalDate getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(LocalDate fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public LocalDate getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(LocalDate fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public Rol getUnRol() {
        return unRol;
    }

    public void setUnRol(Rol unRol) {
        this.unRol = unRol;
    }

    public Profesor getUnProfesor() {
        return unProfesor;
    }

    public void setUnProfesor(Profesor unProfesor) {
        this.unProfesor = unProfesor;
    }
    //</editor-fold>
    
    
	// Creo un toString aca aunque el ejercicio no lo muestre en el diagrama debido a que simplifica mostrar el arraylist.

	@Override
	public String toString() {
		if(fechaHasta != null){
			return "RolEnTrabajo<"+unProfesor.getApellidos()+", "+unProfesor.getNombres()+">{" + "fechaDesde=" + fechaDesde + ", fechaHasta=" + fechaHasta + ", razon=" + razon + '}';
		}
		else
		{
			return "RolEnTrabajo<"+unProfesor.getApellidos()+", "+unProfesor.getNombres()+">{" + "fechaDesde=" + fechaDesde + '}';
		}
	}
	
	
	
}
