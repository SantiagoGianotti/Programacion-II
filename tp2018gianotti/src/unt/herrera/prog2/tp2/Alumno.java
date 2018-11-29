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
public class Alumno {
    
    private int libreta;
    private int dni;
    private String apellido;
    private String nombre;

    public Alumno(int libreta, int dni, String apellido, String nombre) {
        this.libreta = libreta;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
    }

    
    // <editor-fold desc="Get & Set">
    
    public int getLibreta() {
        return libreta;
    }

    public void setLibreta(int libreta) {
        this.libreta = libreta;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //</editor-fold>

    @Override
    public String toString() {
        return "apellido y nombre: " + apellido + ", " + nombre+ "\n\tLibreta: " + libreta + "\n\tDni: " + dni + '\n';
    }
    
    
    
    
}
