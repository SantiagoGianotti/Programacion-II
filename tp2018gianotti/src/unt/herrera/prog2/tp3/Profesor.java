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
public class Profesor {
    private String apellidos;
    private String nombres;
    private int dni;
    private Cargo unCargo;

    public Profesor(int dni, Cargo unCargo, String apellidos, String nombres) {
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.dni = dni;
        this.unCargo = unCargo;
    }
    
    //<editor-fold desc="Get && Set">
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

    public Cargo getUnCargo() {
        return unCargo;
    }

    public void setUnCargo(Cargo unCargo) {
        this.unCargo = unCargo;
    }
    //</editor-fold>

    @Override
    public String toString() {
        return "Profesor{" + "apellidos=" + apellidos + ", nombres=" + nombres + ", dni=" + dni + '}';
    }
    
    public void mostrar()
    {
        System.out.println("\tProfesor: "+this.apellidos+", "+this.nombres+"\n\t Dni: "+ this.dni);
    }
}
