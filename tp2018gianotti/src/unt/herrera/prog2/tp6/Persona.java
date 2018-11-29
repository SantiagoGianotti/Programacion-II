/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp6;


/**
 *
 * @author Santi-PC
 */
public abstract class Persona implements Comparable<Persona>{ 
//Solo existen alumnos y docentes por lo tanto debe ser una clase abstracta.
//Implementamos comparable ya que apellido y nombre es un solo tipo de comparacion.
	
	private String apellidos;
    private String nombres;
    private int dni;

	public Persona(String apellidos, String nombres, int dni) {
		this.apellidos = apellidos;
		this.nombres = nombres;
		this.dni = dni;
	}

	@Override
	public int compareTo(Persona o) {
		int val = this.apellidos.compareToIgnoreCase(o.apellidos);
		
		//Si los apellidos coinciden entonces revisamos el nombre, si no devolvemos el valor.
		if( val == 0 ){
			return this.nombres.compareToIgnoreCase(o.nombres);
		}
		
		return val;
	}
	
	
	//<editor-fold desc="Get & Set">
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
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + this.dni;
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
	if ( getClass().getSuperclass() != obj.getClass().getSuperclass()) {
		return false;
	}
        final Persona other = (Persona) obj;
        if (this.dni != other.dni) {
            return false;
        }
        return true;
    }

    
	public void mostrar(){
		System.out.println("[" + this.dni + "] " + this.apellidos.toUpperCase() + ", "+ this.nombres.toUpperCase());
	}

        
	@Override
	public String toString() {
		return apellidos.toUpperCase() + ", " + nombres.toUpperCase() + "\t\tdni: " + dni;
	}	
}
