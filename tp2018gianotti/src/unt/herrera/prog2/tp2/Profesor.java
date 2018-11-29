/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp2;

/**
 *
 * @author gabinete
 */
public class Profesor {
    private int dni;
    private Cargo cargoDocente;
    private String apellido;
    private String nombre;

    public Profesor(int dni, Cargo cargoDocente, String apellido, String nombre) {
        this.dni = dni;
        this.cargoDocente = cargoDocente;
        this.apellido = apellido;
        this.nombre = nombre;
    }

    //<editor-fold desc="Get & Set">
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Cargo getCargo() {
        return cargoDocente;
    }

    public void setCargo(Cargo cargo) {
        this.cargoDocente = cargo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    //</editor-fold>

    @Override
    public String toString() {
        return "Apellido y nombre: " + apellido + ", " + nombre + "\n\tDni: " + dni + "\n\tCargo del Docente " + cargoDocente + '\n';
    }
    
    
}
