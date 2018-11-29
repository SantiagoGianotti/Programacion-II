/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp7.gui.seminarios.modelos;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * @author gabinete
 */
public class Seminario implements Comparable<Seminario>{
    private LocalDate fechaExposicion;
    private String observaciones;
    private NotaAprobacion estado;
	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	
    public Seminario(LocalDate fechaExposicion, NotaAprobacion estado, String observaciones) {
        this.fechaExposicion = fechaExposicion;
        this.observaciones = observaciones;
        this.estado = estado;
    }

	@Override
	public int compareTo(Seminario o) {
		//Planteo los objetos al reves asi este en orden descendiente.
		return o.fechaExposicion.compareTo(this.fechaExposicion);
	}

    
    //<editor-fold desc="Set && get">
    public LocalDate getFechaExposicion() {
        return fechaExposicion;
    }
	
	public void setAprobacion( NotaAprobacion estado ){
		this.estado = estado;
	}

	public NotaAprobacion getAprobacion(){
		return this.estado;
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
        System.out.print("Seminario rendido el: "+ fechaExposicion.format(formato) +" Nota: " + this.estado);
        
        if(this.estado != null){ //Solo imprimimos esta parte del texto si el alumno fue aprobado con obs o desaprobado
            
			//Disculpen por usar el ternary operator pero era lo mas practico. 
			//( si no hay observacion imprime '-' y sino imprime la obs ).
			System.out.print(" Observaciones: "+ ( this.estado != NotaAprobacion.APROBADO_SINOBS && this.observaciones != null? this.observaciones : "-") );
        }
		System.out.println();
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
