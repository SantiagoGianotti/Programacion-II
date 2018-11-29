/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp7.gui.personas.modelos;

import java.util.Objects;

/**
 *
 * @author gabinete
 */
public class Alumno extends Persona{
    private String cx;

    public Alumno(String apellidos, String nombres, int dni, String cx) {
		super(apellidos, nombres, dni);
        this.cx = cx;
    }

    //<editor-fold desc="Get & Set">
    public String getCx() {
        return cx;
    }

    public void setCx(String cx) {
        this.cx = cx;
    }

    //</editor-fold>

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 11 * hash + super.getDni();
		hash = 11 * hash + Objects.hashCode(this.cx);
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

                if( getClass() == obj.getClass()){ //Si son de la clase alumno revisamos la igualdad de los cx
                    
                            if (Objects.equals(this.cx.toUpperCase(), ((Alumno)obj).cx.toUpperCase())) { //si el cx es igual son la misma persona.
                                return true;
                            }
                }

		return super.equals(obj); //Ahora reviso el DNI de la persona.
	}
	
	@Override
	public void mostrar(){ //Sobrecargo utilizando el mostrar de la clase persona.
		
		super.mostrar();
		System.out.println("Cx: "+this.cx);
	}

	@Override
	public String toString() {
		return "Alumno: " + super.toString() + "\t\tcx:" + cx;
	}
}
