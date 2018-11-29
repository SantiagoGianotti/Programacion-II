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
public class AlumnoEnTrabajo {
    
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private String razon;   
    private Alumno unAlumno;

    public AlumnoEnTrabajo(LocalDate fechaDesde, LocalDate fechaHasta, String razon, Alumno unAlumno) {
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.razon = razon;
        this.unAlumno = unAlumno;
    }

    public AlumnoEnTrabajo(LocalDate fechaDesde, Alumno unAlumno) { // Sobrecargo el constructor para el caso que el alumno no haya abandonado el proyecto.
        this(fechaDesde, null, null, unAlumno);
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

    public Alumno getUnAlumno() {
        return unAlumno;
    }

    public void setUnAlumno(Alumno unAlumno) {
        this.unAlumno = unAlumno;
    }
    //</editor-fold>
    
    
}
