/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp2;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
    
/**
 *
 * @author gabinete
 * Respuestas a algunas preguntas del practico.
 * 
 * 3)
 *      *b_ Si yo quiero crear un objeto vacio y defini los constructores, es imposible que cree un objeto vacio sin pasar nulls o creando un constructor vacio.
 *      *c_ Como yo encapsule todo en mis clases, no puedo cambiar ( o ver ) las variables sin utilizar los metodos que cree para ello ( Get & Set ).
 * 
 */
public class Principal {
    
    public static void main(String[] args) {
     
    ArrayList<Trabajo> unosTrabajos = new ArrayList<>();
    ArrayList<Alumno> unosAlumnos = new ArrayList<>();
    ArrayList<Profesor> unosProfesores = new ArrayList<>();
    
    Alumno unAlumno = new Alumno(1600924, 40438441, "Gianotti", "Santiago Jose");
    Alumno unAlumno2 = new Alumno(1804914, 45263951, "Hernandez", "Jose");
    Alumno unAlumno3 = new Alumno(1452312, 17614206, "Jerez", "Pedro");
    Alumno unAlumno4 = new Alumno(1956214, 16540107, "Gomez", "Mirta");
    Alumno unAlumno5 = new Alumno(1476214, 32545798, "Acosta", "Carlos");
    Profesor unProfesor = new Profesor(32651245, Cargo.ADJUNTO, "Escobar", "Pablo Emilio");
    Profesor unProfesor2 = new Profesor(19536924, Cargo.TITULAR, "Solari", "Ricardo");
    Profesor unProfesor3 = new Profesor(18645213, Cargo.JTP, "Ardohain", "Pampita");
    Profesor unProfesor4 = new Profesor(14521542, Cargo.ASOCIADO, "Tevez","Carlos");
    Profesor unProfesor5 = new Profesor(00000001, Cargo.ADG, "Legrand", "Mirtha");
    Trabajo unTrabajo = new Trabajo("Tesis sobre un homicidio","Sociologia", 4, LocalDate.of(1997,Month.AUGUST,17));
    Trabajo unTrabajo2 = new Trabajo("Inteligencia Artificial","Computacion",12,LocalDate.of(2018, Month.MARCH, 2));
    Trabajo unTrabajo3 = new Trabajo("Aplicaciones de la Electronica", "Electronica",6,LocalDate.of(2019,Month.APRIL,5));
    Trabajo unTrabajo4 = new Trabajo("Higiene y Seguridad en el ambiente","Higiene", 7, LocalDate.of(2020, Month.MARCH, 20));
    Trabajo unTrabajo5 = new Trabajo("Reinventando la rueda","Mecanica",99,LocalDate.of(2030,Month.DECEMBER, 31));
    // Alumno unAlumnoVacio = new Alumno(); Como no defini un constructor vacio no puedo crear un objeto vacio ( sin pasar nulls por referencia ).
    

    // Agrego los objetos a los arraylists
    unosAlumnos.add(unAlumno);
    unosAlumnos.add(unAlumno2);
    unosAlumnos.add(unAlumno3);
    unosAlumnos.add(unAlumno4);
    unosAlumnos.add(unAlumno5);    
    unosProfesores.add(unProfesor);
    unosProfesores.add(unProfesor2);  
    unosProfesores.add(unProfesor3);
    unosProfesores.add(unProfesor4);
    unosProfesores.add(unProfesor5);
    unosTrabajos.add(unTrabajo);
    unosTrabajos.add(unTrabajo2);
    unosTrabajos.add(unTrabajo3); 
    unosTrabajos.add(unTrabajo4);    
    unosTrabajos.add(unTrabajo5);
     
    //Defini un metodo auxiliar para recorrer las tres listas ya que lo tengo que hacer 2 veces y queda feo.
    
    recArrayLists(unosAlumnos, unosProfesores, unosTrabajos);
    
    // Ahora modifico algunos objetos que estan dentro de los arraylist y luego los vuelvo a imprimir.
    
        //Primero modifico directamente desde la referencia del objeto.
        unAlumno.setApellido("Maradona");
        unAlumno.setNombre("Diego");
        unAlumno.setDni(15432142);
        unAlumno.setLibreta(1504235);
    
       //Ahora voy a utilizar la referencia del arraylist para modificar estos valores.
       if(!unosProfesores.isEmpty()){ //Verifico que el arraylist no este vacio primero.
           unosProfesores.get(0).setApellido("Sarmiento");
           unosProfesores.get(0).setNombre("Domingo Faustino");
           unosProfesores.get(0).setDni(23217585);
           unosProfesores.get(0).setCargo(Cargo.TITULAR);
       }
    
    // Ahora re-imprimo los 3 arraylist con los nuevos cambios
    
    recArrayLists(unosAlumnos, unosProfesores, unosTrabajos);
       
    }
    
    
    public static void recArrayLists(ArrayList<Alumno> array1, ArrayList<Profesor> array2, ArrayList<Trabajo> array3){
    
        System.out.println("Alumnos:");
        for( Alumno i:array1 ){

            System.out.println("\t"+i); //Utilizo el toString ya que otro punto lo pedia previamente.
        }

        System.out.println("Docentes:");
        for( Profesor i:array2 ){

            System.out.println("\t"+i);
        }
        
        System.out.println("Trabajos:"); 
        for( Trabajo i:array3 ){

            System.out.println("\t"+i);
        }

    };
    
}