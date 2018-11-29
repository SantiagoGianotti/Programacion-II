/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp2;
import java.time.LocalDate;

/**
 *
 * @author gabinete
 */
public class Trabajo {

    private String titulo;
    private String area;
    private int duracion; //Tiempo en meses que dura el proyecto.
    private LocalDate fechaPresentacion; //fecha de presentación para su aprobación
    private LocalDate fechaAprobado; // Fecha en la que fue aprobado por la comisión
    private LocalDate fechaFinalizacion;

    public Trabajo(String titulo, String area, int duracion, LocalDate fechaPresentacion, LocalDate fechaAprobado, LocalDate fechaFinalizacion) {
        this.titulo = titulo;
        this.area = area;
        this.duracion = duracion;
        this.fechaPresentacion = fechaPresentacion;
        this.fechaAprobado = fechaAprobado;
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public Trabajo(String titulo, String area, int duracion, LocalDate fechaPresentacion) {
        this(titulo, area, duracion, fechaPresentacion, null, null);
    }
    
    
//<editor-fold desc="Get && Set">
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public LocalDate getFechaPresentacion() {
        return fechaPresentacion;
    }

    public void setFechaPresentacion(LocalDate fechaPresentacion) {
        this.fechaPresentacion = fechaPresentacion;
    }

    public LocalDate getFechaAprobado() {
        return fechaAprobado;
    }

    public void setFechaAprobado(LocalDate fechaAprobado) {
        this.fechaAprobado = fechaAprobado;
    }

    public LocalDate getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(LocalDate fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }
// </editor-fold>
    
    @Override
    public String toString() {
        return "Titulo: " + titulo + "\n \tArea: " + area + "\n \tDuracion: " + duracion + '\n';
    }
    
}

