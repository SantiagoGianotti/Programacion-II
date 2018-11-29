/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp7.gui.interfaces;

import unt.herrera.prog2.tp7.gui.areas.modelos.Area;
import java.util.List;

/**
 *
 * @author gabinete
 */
public interface IGestorAreas {
    
    public String nuevaArea(String nombre);
    public void mostrarAreas();
    public Area dameArea(String nombre);
    public List<Area> buscarAreas(String nombre);
    public String borrarArea(Area area);
    
    //Mensajes de error.
    static public String ERROR_MSG = "El area no se pudo agregar.";
    static public String SUCCESS_MSG = "El area fue creada exitosamente.";
    static public String ERROR_DEL = "El area no se pudo borrar.";
    static public String SUCCESS_DEL = "El area fue borrada exitosamente.";
}
