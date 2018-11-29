/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp6;

import java.time.LocalDate;

/**
 *
 * @author gabinete
 */
public class GestorRolEnTrabajo implements IGestorRolEnTrabajo{
    private static GestorRolEnTrabajo gestor;
    //private ArrayList<RolEnTrabajo> listaRoles = new ArrayList<>();

    private GestorRolEnTrabajo(){}; // Constructor Privado// Constructor Privado
    
    public static GestorRolEnTrabajo instanciar(){
        
        if( gestor == null){
            gestor = new GestorRolEnTrabajo();
        }
        return gestor;
    }

    @Override
    public RolEnTrabajo nuevoRolEnTrabajo(Profesor unProfesor, Rol unRol, LocalDate fechaDesde) {
        RolEnTrabajo miTrabajo;
        
        if( unProfesor == null || unRol == null || fechaDesde == null ){ //Verifico que ninguna variable sea nula
            return null;
        }
        
        miTrabajo = new RolEnTrabajo(fechaDesde, unProfesor, unRol);

        return miTrabajo;
    }
}
