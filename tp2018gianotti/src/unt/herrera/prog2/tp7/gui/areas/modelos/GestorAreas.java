/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp7.gui.areas.modelos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import unt.herrera.prog2.tp7.gui.trabajos.modelos.GestorTrabajos;
import unt.herrera.prog2.tp7.gui.interfaces.IGestorAreas;
import unt.herrera.prog2.tp7.gui.trabajos.modelos.Trabajo;

/**
 *
 * @author gabinete
 */
public class GestorAreas implements IGestorAreas {
    private static GestorAreas gestor;
    private List<Area> listaAreas = new ArrayList<>();
    
    private GestorAreas(){}; // Constructor Privado// Constructor Privado// Constructor Privado// Constructor Privado
    
	
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
        
		Collections.sort(listaAreas);
		
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
    public List<Area> buscarAreas(String nombre) {
        List<Area> misAreas = new ArrayList<>();
        
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

    @Override
    public String borrarArea(Area area) {
        GestorTrabajos miGestorTrabajos = GestorTrabajos.instanciar();

        if( area == null){
            return ERROR_DEL;
        }
 
        if( !listaAreas.contains(area)){ // No puedo borrar de la lista un objeto que no esta en la lista.
            return ERROR_DEL;
        }
        
        for( Trabajo i : miGestorTrabajos.buscarTrabajos()){ //reviso todos los trabajos
            if( i.getAreas().contains(area)){ //Reviso si el area esta contenida en el trabajo.
                return ERROR_DEL;
            }
        }
        
        //Como el area obtenida no esta contenida en ninguno de los trabajos pero si en la lista
        for( Area i : listaAreas){
            if( i.equals(area)){
                
                listaAreas.remove(i);
                i = null;
                
                return SUCCESS_DEL;
            }
        }
        
        return ERROR_DEL;
    }
    
    public String escribirAreas(){
        try {
            File f = new File("Areas.txt");
            FileWriter fw = new FileWriter(f);
            BufferedWriter bfw = new BufferedWriter(fw);
            
            for( Area i : listaAreas){
                bfw.write(i.getNombre()+"\n");
            }
            
            bfw.close();
			return WRITE_SUCCESS;
        } catch (IOException ex) {
			return WRITE_FAIL;
        }
    }
   
    
    public String leerAreas(){
        String nombreArea;
        
        try {
            File f = new File("Areas.txt");
            FileReader fr = new FileReader(f);
            BufferedReader bfr = new BufferedReader(fr);
            Area miArea;
            
            while( ( nombreArea = bfr.readLine() )!= null ){
                
                GestorAreas.instanciar().nuevaArea(nombreArea);
            }
         
            bfr.close();
            return READ_SUCCESS;
        }
        catch (IOException ex) {
            return READ_FAIL;
        }
    }
    
}
