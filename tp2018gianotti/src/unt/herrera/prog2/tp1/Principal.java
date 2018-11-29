/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp1;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 *
 * @author estudiante
 */
public class Principal {
    
    public static void main(String[] args) {
        
        Nivel objNivel1 = new Nivel();
        Nivel objNivel2 = new Nivel();
        Nivel objNivel3 = new Nivel();
        Nivel objNivel4 = new Nivel();
        Nivel objNivel5 = new Nivel();
        
        PlanEstudio objPlan1 = new PlanEstudio();
        PlanEstudio objPlan2 = new PlanEstudio();
        PlanEstudio objPlan3 = new PlanEstudio();
        PlanEstudio objPlan4 = new PlanEstudio();
        PlanEstudio objPlan5 = new PlanEstudio();
        
        //Le pongo datos a los objetos
        objNivel1.codigo = 1; objNivel1.nombre = "Hola";
        objNivel2.codigo = 2; objNivel2.nombre = "Como";
        objNivel3.codigo = 3; objNivel3.nombre = "Estas";
        objNivel4.codigo = 4; objNivel4.nombre = "Todo";
        objNivel5.codigo = 5; objNivel5.nombre = "Bien?";
    
        objPlan1.fechaDesde = LocalDate.of(1997,Month.AUGUST,17);
        objPlan2.fechaDesde = LocalDate.of(1997,Month.AUGUST,18);
        objPlan3.fechaDesde = LocalDate.of(1997,Month.AUGUST,19);
        objPlan4.fechaDesde = LocalDate.of(1997,Month.AUGUST,20);
        objPlan5.fechaDesde = LocalDate.of(1997,Month.AUGUST,21);
        
        objPlan1.nombre = "Plan A";
        objPlan2.nombre = "Plan B";
        objPlan3.nombre = "Plan C";
        objPlan4.nombre = "Plan D";
        objPlan5.nombre = "Plan E";   
        
        
        ArrayList<PlanEstudio> unosPlanes = new ArrayList<>();
        Nivel[] unosNiveles = new Nivel[5];
                
        //Agrego las cosas al arraylist y al vector
        unosPlanes.add(objPlan1);unosPlanes.add(objPlan2);unosPlanes.add(objPlan3);unosPlanes.add(objPlan4);unosPlanes.add(objPlan5);
        unosNiveles[0] = objNivel1; unosNiveles[1] = objNivel2; unosNiveles[2] = objNivel3; unosNiveles[3] = objNivel4; unosNiveles[4] = objNivel5;    
        
        //Imprimo el vector y el arraylist
        recorrerCosas(unosPlanes, unosNiveles);
        
        //Modifico los objetos.
        objPlan3.nombre = "Soy un plan modificado!";
        objPlan4.nombre = "Yo tambien!";
        objNivel1.nombre = "Ami me modificaron!";
        objNivel1.codigo = 999;
        
        //Reimprimo
        
        System.out.println("\tObjetos modificados: ");
        recorrerCosas(unosPlanes, unosNiveles);
        
        
    }
    
    static void recorrerCosas(ArrayList<PlanEstudio> array, Nivel[] vector){
    
    if(!array.isEmpty()){
        System.out.println();
        for( PlanEstudio i: array)
            i.mostrar();
    }
        System.out.println();
        for( Nivel i: vector)
            i.mostrar();
    }
    
}
