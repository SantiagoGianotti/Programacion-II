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
public class Seminario {
    private LocalDate fechaExposicion;
    private String observaciones;
    private Aprobacion estado;

    public Seminario(LocalDate fechaExposicion, String observaciones, Aprobacion estado) {
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
        System.out.println("Fecha del seminario: "+ fechaExposicion+"\n\tEstado: "+this.estado);
        
        if(this.estado == Aprobacion.APROBADO_CO){ //Solo imprimimos esta parte del texto si el alumno fue aprobado con observaciones.
            System.out.println("\tObservaciones: "+this.observaciones);
        }
    }
    
}
