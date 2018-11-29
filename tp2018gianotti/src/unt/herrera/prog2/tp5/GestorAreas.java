/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp5;

import java.util.ArrayList;

/**
 *
 * @author gabinete
 */
public class GestorAreas implements IGestorAreas{
    private static GestorAreas gestor;
    private ArrayList<Area> listaAreas = new ArrayList<>();
    
    private GestorAreas(){}; // Constructor Privado
    
	
    public static GestorAreas instanciar(){
        
        if( gestor == null){
            gestor = new GestorAreas();
        }
        return gestor;
    }
    
    @Override
    public String nuevaArea(String nombre) {
        Area miArea;
        
        if (nombre.isEmpty()){
            return ERROR_MSG;
        }
        
        miArea = new Area(nombre);
        if(listaAreas.contains(miArea)) // Si la lista contiene el area mensaje de error. Si no, agregamos el area al arraylist y devolvemos mensaje exitoso
        {
           return ERROR_MSG; 
        }
        
        listaAreas.add(miArea);
        
        return SUCCESS_MSG;
    }

    @Override
    public void mostrarAreas() {
        
        for( Area i : listaAreas){
            System.out.println(i.toString());
        }
    }

    @Override
    public Area dameArea(String nombre) {
        
        for( Area i : listaAreas){
            if(i.getNombre().equalsIgnoreCase(nombre)) // Si el area coincide con el nombre devuelve el area, sino sigue buscando
            {
                return i;
            }
        }
        return null; // Si no se encontro area devolvemos nulo.
    }

    @Override
    public ArrayList<Area> buscarAreas(String nombre) {
        ArrayList<Area> misAreas = new ArrayList<>();
        
        if( nombre == null ){
            
            return listaAreas; //Devuelvo todas las areas.
        }
        
        for( Area i : listaAreas){
            if( i.getNombre().toUpperCase().contains(nombre.toUpperCase())){ //Paso ambos string a mayusculas y reviso si nombre esta contenido en i.getnombre
                misAreas.add(i);
            }
        }
        
        if(misAreas.isEmpty()){ // Si hay areas que cumplen la condicion las devuelvo, sino devuelvo el nulo.
            return null;
        }

        return misAreas;
    }
    
    
    
    
}
