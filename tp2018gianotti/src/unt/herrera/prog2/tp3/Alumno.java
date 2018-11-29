/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp3;

/**
 *
 * @author gabinete
 */
public class Alumno {
    private int cx;
    private String apellidos;
    private String nombres;
    private int dni;

    public Alumno(int dni, int cx, String apellidos, String nombres) {
        this.cx = cx;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.dni = dni;
    }

    //<editor-fold desc="Get & Set">
    public int getCx() {
        return cx;
    }

    public void setCx(int cx) {
        this.cx = cx;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    //</editor-fold>
    
    @Override
    public String toString() {
        return "Alumno{" + "cx=" + cx + ", apellidos=" + apellidos + ", nombres=" + nombres + ", dni=" + dni + '}';
    }
    
    public void mostrar()
    {
        System.out.println("\tAlumno: "+this.apellidos+", "+this.nombres+"\n\t Cx: "+this.cx + "\n\t Dni: "+ this.dni);
    }
    
}
