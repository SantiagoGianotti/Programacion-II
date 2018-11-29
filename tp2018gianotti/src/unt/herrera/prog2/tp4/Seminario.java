/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp4;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author gabinete
 */
public class Seminario {
    private LocalDate fechaExposicion;
    private String observaciones;
    private NotaAprobacion estado;

	
    public Seminario(LocalDate fechaExposicion, NotaAprobacion estado, String observaciones) {
        this.fechaExposicion = fechaExposicion;
        this.observaciones = observaciones;
        this.estado = estado;
    }

    
    //<editor-fold desc="Set && get">
    public LocalDate getFechaExposicion() {
        return fechaExposicion;
    }

    public void setFechaExposicion(LocalDate fechaExposicion) {
        this.fechaExposicion = fechaExposicion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    //</editor-fold>

    @Override
    public String toString() {
        return "Seminario{" + "fechaExposicion=" + fechaExposicion + ", observaciones=" + observaciones + ", estado=" + estado + '}';
    }
    
    public void mostrar(){
        System.out.println("Fecha del seminario: "+ fechaExposicion+"\nEstado: "+this.estado);
        
        if(this.estado == NotaAprobacion.APROBADO_CONOBS){ //Solo imprimimos esta parte del texto si el alumno fue aprobado con observaciones.
            System.out.println("Observaciones: "+this.observaciones);
        }
    }

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 23 * hash + Objects.hashCode(this.fechaExposicion);
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
		final Seminario other = (Seminario) obj;
		if (!Objects.equals(this.fechaExposicion, other.fechaExposicion)) {
			return false;
		}
		return true;
	}
    
}
