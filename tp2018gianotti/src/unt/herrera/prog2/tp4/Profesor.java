/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp4;

/**
 *
 * @author gabinete
 */
public class Profesor extends Persona{

    private Cargo unCargo;

    public Profesor(String apellidos, String nombres, int dni, Cargo unCargo) {
        super(apellidos, nombres, dni);
        this.unCargo = unCargo;
    }
	
    //<editor-fold desc="Get && Set">

    public Cargo getCargo() {
        return unCargo;
    }

    public void setCargo(Cargo unCargo) {
        this.unCargo = unCargo;
    }
    //</editor-fold>
   
	@Override
    public String toString() {
        return "Profesor: " + super.toString() + "\t\tcargo: " + this.unCargo;
    }
	
    
	@Override
	public void mostrar()
    {
		//Utilizo el mostrar de la clase persona y le agrego el cx al final asi no copio tanto codigo.
		super.mostrar();
		System.out.println("\tCargo: "+this.unCargo);
	}
}
