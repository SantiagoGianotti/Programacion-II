/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp3;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 *
 * @author gabinete
 */
public class Principal{
    
    public static void main(String[] args) {
       // Creamos los objetos de afuera para adentro.
    
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
    Area unArea = new Area("Software");
    Area unArea2 = new Area("Hardware");
    Area unArea3 = new Area("Robotica");
    Area unArea4 = new Area("Politica");
    Area unArea5 = new Area("Ecologia");
    
    //Creo ahora los objetos que se relacionan con trabajo.
    AlumnoEnTrabajo unAlumnoEnTrabajo = new AlumnoEnTrabajo( LocalDate.now(), unAlumno);
    AlumnoEnTrabajo unAlumnoEnTrabajo2 = new AlumnoEnTrabajo( LocalDate.now(), unAlumno2);
    AlumnoEnTrabajo unAlumnoEnTrabajo3 = new AlumnoEnTrabajo( LocalDate.now(), unAlumno3);
    AlumnoEnTrabajo unAlumnoEnTrabajo4 = new AlumnoEnTrabajo( LocalDate.now(), unAlumno4);
    AlumnoEnTrabajo unAlumnoEnTrabajo5 = new AlumnoEnTrabajo( LocalDate.now(), unAlumno5);
    AlumnoEnTrabajo unAlumnoEnTrabajo6 = new AlumnoEnTrabajo( LocalDate.of(2017, Month.APRIL, 1), LocalDate.now(),"Impedimentos medicos", unAlumno5);
    RolEnTrabajo unRolEnTrabajo = new RolEnTrabajo(LocalDate.now(), Rol.JURADO, unProfesor);
    RolEnTrabajo unRolEnTrabajo2 = new RolEnTrabajo(LocalDate.now(), Rol.JURADO, unProfesor2);
    RolEnTrabajo unRolEnTrabajo3 = new RolEnTrabajo(LocalDate.now(), Rol.JURADO, unProfesor3);
    RolEnTrabajo unRolEnTrabajo4 = new RolEnTrabajo(LocalDate.now(), Rol.TUTOR, unProfesor4);
    RolEnTrabajo unRolEnTrabajo5 = new RolEnTrabajo(LocalDate.now(), Rol.TUTOR, unProfesor5);
    RolEnTrabajo unRolEnTrabajo6 = new RolEnTrabajo(LocalDate.now(), Rol.TUTOR, unProfesor2);
    
    //Creo las arraylists para los grupos de alumnos tutores y jurados.
    ArrayList<AlumnoEnTrabajo> unosAlumnos = new ArrayList<>();
    ArrayList<AlumnoEnTrabajo> unosAlumnos2 = new ArrayList<>();
    ArrayList<AlumnoEnTrabajo> unosAlumnos3 = new ArrayList<>();
    ArrayList<RolEnTrabajo> unosRolesEnTrabajo = new ArrayList<>();
    ArrayList<RolEnTrabajo> unosRolesEnTrabajo2 = new ArrayList<>();
    ArrayList<RolEnTrabajo> unosRolesEnTrabajo3 = new ArrayList<>();
    ArrayList<Area> unasAreas = new ArrayList<>();
    ArrayList<Area> unasAreas2 = new ArrayList<>();
    ArrayList<Area> unasAreas3 = new ArrayList<>();
    

    //Agrego Alumnos, tutores y jurados a los ArrayList.
    unosAlumnos.add(unAlumnoEnTrabajo);
    unosAlumnos.add(unAlumnoEnTrabajo3);
    unosAlumnos2.add(unAlumnoEnTrabajo2);
    unosAlumnos2.add(unAlumnoEnTrabajo4);
    unosAlumnos2.add(unAlumnoEnTrabajo5);
    unosAlumnos3.add(unAlumnoEnTrabajo);
    unosAlumnos3.add(unAlumnoEnTrabajo4);
    unosAlumnos3.add(unAlumnoEnTrabajo3);
    unosAlumnos3.add(unAlumnoEnTrabajo5);
    unosRolesEnTrabajo.add(unRolEnTrabajo4);    // tutor
    unosRolesEnTrabajo.add(unRolEnTrabajo2);    //jurado
    unosRolesEnTrabajo.add(unRolEnTrabajo3);    //jurado
    unosRolesEnTrabajo.add(unRolEnTrabajo);     //jurado
    unosRolesEnTrabajo2.add(unRolEnTrabajo5);   //tutor
    unosRolesEnTrabajo2.add(unRolEnTrabajo2);   //jurado
    unosRolesEnTrabajo2.add(unRolEnTrabajo);    //jurado
    unosRolesEnTrabajo2.add(unRolEnTrabajo3);   //jurado
    unosRolesEnTrabajo3.add(unRolEnTrabajo6);   //tutor
    unosRolesEnTrabajo3.add(unRolEnTrabajo);    //jurado
    unosRolesEnTrabajo3.add(unRolEnTrabajo2);     //jurado
    unasAreas.add(unArea);
    unasAreas.add(unArea2);
    unasAreas2.add(unArea3);
    unasAreas2.add(unArea4);
    unasAreas3.add(unArea5);

    //Creo seminarios
    Seminario unSeminario = new Seminario(LocalDate.of(1858, Month.JULY, 3), null, Aprobacion.DESAPROBADO);
    Seminario unSeminario2 = new Seminario(LocalDate.of(1987, Month.AUGUST, 17), null, Aprobacion.APROBADO_SO);
    Seminario unSeminario3 = new Seminario(LocalDate.of(2000, Month.OCTOBER, 22), "Falta de contenido", Aprobacion.APROBADO_CO);
    Seminario unSeminario4 = new Seminario(LocalDate.of(1997, Month.MARCH, 5), null, Aprobacion.APROBADO_SO);
    Seminario unSeminario5 = new Seminario(LocalDate.of(2001, Month.DECEMBER, 17), null, Aprobacion.DESAPROBADO);
    
    //Creo los trabajos.
    Trabajo unTrabajo = new Trabajo("El software y yo", 6, LocalDate.of(2015, Month.AUGUST, 3), LocalDate.now(), unasAreas, unosRolesEnTrabajo, unosAlumnos);
    Trabajo unTrabajo2 = new Trabajo("Avances en la robotica", 12, LocalDate.of(1999, Month.MARCH, 2), LocalDate.of(1998, Month.MARCH, 5), unasAreas2, unosRolesEnTrabajo2, unosAlumnos2);
    Trabajo unTrabajo3 = new Trabajo("Luis Miguel mi unico i2lo", 2, LocalDate.of(2000, Month.APRIL, 2), LocalDate.now(), unasAreas3, unosRolesEnTrabajo3, unosAlumnos3);
    
    //Agrego jurados. ( Cabe destacar que solo voy a agregar dos jurados ya que estos entraron previamente con el arraylist).
	//Tambien uno de estos va a fallar ya que ya esta agregado ( unRolEnTrabajo ya esta en el arraylist unosRolesEnTrabajo3 y por lo tanto ya esta en la "nomina" del trabajo).
	unTrabajo3.agregarProfesor(unRolEnTrabajo); // Este va a fallar
	unTrabajo3.agregarProfesor(unRolEnTrabajo3); // Este se va a agregar exitosamente.
	
	//Agrego los seminarios.
	unTrabajo.agregarSeminario(unSeminario);
	unTrabajo.agregarSeminario(unSeminario2);
	unTrabajo2.agregarSeminario(unSeminario3);
	unTrabajo3.agregarSeminario(unSeminario4);
	unTrabajo3.agregarSeminario(unSeminario5);
    }
    
}