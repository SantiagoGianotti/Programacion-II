/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp7.gui.trabajos.modelos;

import java.time.LocalDate;
import java.util.Objects;
import unt.herrera.prog2.tp7.gui.personas.modelos.Profesor;

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

// RolEnTrabajo rt11= new RolEnTrabajo(fecha1, (Profesor)listaPersonas.get(0), Rol.TUTOR);
	
	public RolEnTrabajo(LocalDate fechaDesde, Profesor unProfesor, Rol unRol) {
		this.fechaDesde = fechaDesde;
		this.unRol = unRol;
		this.unProfesor = unProfesor;
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
			return "{" + unProfesor.getApellidos()+", "+unProfesor.getNombres() + " Rol: " + this.unRol  + " FechaDesde: " + fechaDesde + " FechaHasta: " + fechaHasta + " Razon: " + this.razon + "}";
		}
		else
		{
			return "{" + unProfesor.getApellidos()+", "+unProfesor.getNombres()+" Rol: " + this.unRol  + " FechaDesde: " + fechaDesde + "}";
		}
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 47 * hash + Objects.hashCode(this.unProfesor);
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
		final RolEnTrabajo other = (RolEnTrabajo) obj;
		if (!Objects.equals(this.unProfesor, other.unProfesor)) {
			return false;
		}
		return true;
	}
	
	
	
}
