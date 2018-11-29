/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp4;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mariana
 */
public class Principal {
    public static void main (String Args[] ) { 
        ArrayList<Trabajo> listaTrabajos = new ArrayList<>();
        //ya no se necesitan, uso una sola lista
//        ArrayList<Profesor> listaProfesores = new ArrayList<>();
//        List<Alumno> listaAlumnos = new ArrayList<>();
        ArrayList<Persona> listaPersonas = new ArrayList<>();
        ArrayList<Area> listaAreas =new ArrayList<> ();
        
        //***************************Areas**********************************
        Area area1= new Area("Software");
        Area area2=new Area("Hardware");
        Area area3=new Area("Sistemas Embebidos");
        Area area4=new Area("Redes");
        Area area5=new Area("Redes");
        if(!listaAreas.contains(area1))
            listaAreas.add(area1);
        if(!listaAreas.contains(area2))
            listaAreas.add(area2);
        if(!listaAreas.contains(area3))
            listaAreas.add(area3);
        if(!listaAreas.contains(area4))
            listaAreas.add(area4);
        if(!listaAreas.contains(area5))  // NO la debería agregar
            listaAreas.add(area5);
        
        ArrayList<Area> listaA1= new ArrayList<>();
        listaA1.add(listaAreas.get(0));
        ArrayList<Area> listaA2= new ArrayList<>();
        listaA2.add(listaAreas.get(0));
        listaA2.add(listaAreas.get(1));
        ArrayList<Area> listaA3= new ArrayList<>();
        listaA3.add(listaAreas.get(1));
        listaA3.add(listaAreas.get(3));
        System.out.println("\n***Lista de Areas *** \n ");
        for (Area a :listaAreas)
            System.out.println(a);
        //***************************Areas**********************************
        //***************************PERSONAS**********************************
        //PROFESOR
        Persona prof1= new Profesor("Juarez", "Juan José", 12345678, Cargo.ASOCIADO);
        Persona prof2= new Profesor("Diaz", "Juan Pablo", 13345678, Cargo.JTP);
        Persona prof3= new Profesor("Juarez", "Ana María", 14345678, Cargo.ADJUNTO);
        Persona prof4= new Profesor("San Martin","Jose Manuel", 15345678, Cargo.ADG); 
        //CUIDADO! con el orden de los parámetros.
        Persona prof5= new Profesor("Ortega", "Laura", 16345678, Cargo.ASOCIADO);
        Persona prof6= new Profesor("Rodriguez","Juliana", 15345678, Cargo.TITULAR); 
        
        if(!listaPersonas.contains(prof1)){
            listaPersonas.add(prof1);
            System.out.println("Se agregó el prof 1");
        }//lo agrega
        else
            System.out.println("NO se agregó el prof 1");
        
        if(!listaPersonas.contains(prof2)) {
            listaPersonas.add(prof2);
            System.out.println("Se agregó el prof 2");
        }//lo agrega
        else
            System.out.println("NO se agregó el prof 2");
        if(!listaPersonas.contains(prof3)) {
            listaPersonas.add(prof3);
            System.out.println("Se agregó el prof 3");
        }//lo agrega
        else
            System.out.println("NO se agregó el prof 3");
        if(!listaPersonas.contains(prof4)) {
            listaPersonas.add(prof4);
            System.out.println("Se agregó el prof 4");
        } //lo agrega
        else
            System.out.println("NO se agregó el prof 4");
        if(!listaPersonas.contains(prof5)) {
            listaPersonas.add(prof5);
            System.out.println("Se agregó el prof 5");
        }//lo agrega
        else
            System.out.println("NO se agregó el prof 5");
        if(!listaPersonas.contains(prof6)) {
            listaPersonas.add(prof6);
            System.out.println("Se agregó el prof 6");
        }// NO debería poder agregarlo
        else
            System.out.println("NO se agregó el prof 6");
               
        //ALUMNO
        Alumno al1= new Alumno("Musa", "Ezequiel", 34567890, "16345");
        Alumno al2= new Alumno("Martinez", "Ricardo Juan", 34567891, "16343");
        Alumno al3= new Alumno("Gimenez", "María José", 34567892, "16344");
        Alumno al4= new Alumno("Flores", "Mauricio José", 34567890, "16543");
        Alumno al5= new Alumno("Campos", "Juan Pablo", 34567895, "17345");
        Alumno al6= new Alumno("Campos", "Augusto", 15345678, "17348");
        Alumno al7= new Alumno("Rodriguez", "Miguel Angel", 34567852, "17346");
        Alumno al8= new Alumno("Alvarez", "Ezequiel", 44567890, "16345");
        Alumno al9= new Alumno("Aguero", "Luciana", 45567890, "17349");
        Alumno al10= new Alumno("Campos Figueroa", "Juana", 46567890, "16345");
        Alumno al11= new Alumno("Apud", "Josefina", 45367890, "18345");
        		
		
        if(!listaPersonas.contains(al1)) {
            listaPersonas.add(al1);
            System.out.println("Se agregó el alumno 1");
        }//lo agrega
        else
            System.out.println("NO se agregó el alumno 1");
        
        if(!listaPersonas.contains(al2)){
            listaPersonas.add(al2);
            System.out.println("Se agregó el alumno 2");
        }//lo agrega
        else
            System.out.println("NO se agregó el alumno 2");
        
        if(!listaPersonas.contains(al3)){
            listaPersonas.add(al3);
            System.out.println("Se agregó el alumno 3");
        }//lo agrega
        else
            System.out.println("NO se agregó el alumno 3");
        
        if(!listaPersonas.contains(al4)) {
            listaPersonas.add(al4);
            System.out.println("Se agregó el alumno 4");
        }//No debería poder agregarlo
        else
            System.out.println("NO se agregó el alumno 4");
        
        if(!listaPersonas.contains(al5)) {
            listaPersonas.add(al5);
            System.out.println("Se agregó el alumno 5");
        }//lo agrega
        else
            System.out.println("NO se agregó el alumno 5");
        
        if(!listaPersonas.contains(al6)) {
            listaPersonas.add(al6);
            System.out.println("Se agregó el alumno 6");
        }//no deberia poder agregarlo
        else
            System.out.println("NO se agregó el alumno 6");
        
        if(!listaPersonas.contains(al7)) {
            listaPersonas.add(al7);
            System.out.println("Se agregó el alumno 7");
        }//lo agrega
        else
            System.out.println("NO se agregó el alumno 7");
        
        if(!listaPersonas.contains(al8)) {
            listaPersonas.add(al8);
            System.out.println("Se agregó el alumno 8");
        }//No lo agrega
        else
            System.out.println("NO se agregó el alumno 8");
        
        if(!listaPersonas.contains(al9)) {
            listaPersonas.add(al9);
            System.out.println("Se agregó el alumno 9");
        }//lo agrega
        else
            System.out.println("NO se agregó el alumno 9");
        
        if(!listaPersonas.contains(al10)){
            listaPersonas.add(al10);
            System.out.println("Se agregó el alumno 10");
        }//No lo agrega
        else
            System.out.println("NO se agregó el alumno 10");
        
        if(!listaPersonas.contains(al11)){
            listaPersonas.add(al11);
            System.out.println("Se agregó el alumno 11");
        }//lo agrega 
        else
            System.out.println("NO se agregó el alumno 11");
        
        System.out.println("\n*** Lista de Personas *** \n ");
        for(Persona p: listaPersonas)
            System.out.println(p);
//        
        System.out.println("\n*** Lista de Profesores *** \n ");
        for(Persona p: listaPersonas)
            if(p instanceof Profesor)
                System.out.println(p);
        
        System.out.println("\n*** Lista de Alumnos *** \n ");
        for(Persona p: listaPersonas)
            if(p instanceof Alumno)
                System.out.println(p);
        System.out.println("\n\n");
        //*****************************TRABAJOS***********************************
        LocalDate fecha1 = LocalDate.of(2017, 10, 2);
        LocalDate fecha2 = null; 
        LocalDate fecha3 = LocalDate.of(2017, 11, 2);
        LocalDate fecha4= LocalDate.of(2017, 8, 12);
        LocalDate fecha5= LocalDate.of(2017, 9, 12);
        LocalDate fecha6= LocalDate.of(2017, 10, 2);
        //TRABAJO
        //TRABAJO 1 Un trabajo Presentado sin aprobarse aun, con dos alumnos tutor y cotutor
        ArrayList<AlumnoEnTrabajo> listaAeT = new ArrayList<>();
        ArrayList<RolEnTrabajo> listaRT = new ArrayList<>();
        //Alumnos en el Trabajo
        AlumnoEnTrabajo aET11 = new AlumnoEnTrabajo(fecha1, (Alumno)listaPersonas.get(7));
        AlumnoEnTrabajo aET12 = new AlumnoEnTrabajo(fecha1, (Alumno)listaPersonas.get(8));
        listaAeT.add(aET11);
        listaAeT.add(aET12);
        //Profesores en el Trabajo
        RolEnTrabajo rt11= new RolEnTrabajo(fecha1, (Profesor)listaPersonas.get(0), Rol.TUTOR);
        listaRT.add(rt11);
        RolEnTrabajo rt12= new RolEnTrabajo(fecha1, (Profesor)listaPersonas.get(1), Rol.COTUTOR);
        listaRT.add(rt12);
        Trabajo trab1 = new Trabajo ("Protocolos de comunicación", listaA1,6, fecha1, listaAeT, listaRT);
        //fecha2
        if(!listaTrabajos.contains(trab1)) {
            listaTrabajos.add(trab1);
            System.out.println("Se agregó el trabajo 1");
        }
        else
            System.out.println("No se agregó el trabajo 1");
            
        
        //TRABAJO
        //TRABAJO 2 
        ArrayList<AlumnoEnTrabajo> listaAeT2 = new ArrayList<>();
        ArrayList<RolEnTrabajo> listaRT2 = new ArrayList<>();
        //Alumnos en el Trabajo    
        AlumnoEnTrabajo aET21 = new AlumnoEnTrabajo(fecha1, (Alumno)listaPersonas.get(6));
        AlumnoEnTrabajo aET22 = new AlumnoEnTrabajo(fecha1, (Alumno)listaPersonas.get(8));
        //OJO CON EL ALUMNO 8 lo puse en dos trabajos
        listaAeT2.add(aET21);
        listaAeT2.add(aET22);
        //Profesores en el Trabajo
        RolEnTrabajo rt21= new RolEnTrabajo(fecha1, (Profesor)listaPersonas.get(3), Rol.TUTOR);
        listaRT2.add(rt21);
        Trabajo trab2 = new Trabajo ("Gestión de Trabajos Finales", listaA2, 8, fecha1, listaAeT2, listaRT2);
        //fecha2
        if(!listaTrabajos.contains(trab2)) {
            listaTrabajos.add(trab2);
            System.out.println("Se agregó el trabajo 2");
        }
        else
            System.out.println("No se agregó el trabajo 2");
        
       //TRABAJO 3 
        ArrayList<AlumnoEnTrabajo> listaAeT3 = new ArrayList<>();
        ArrayList<RolEnTrabajo> listaRT3 = new ArrayList<>();
        //Alumnos en el Trabajo
        AlumnoEnTrabajo aET31 = new AlumnoEnTrabajo(fecha4, (Alumno)listaPersonas.get(10));
        listaAeT3.add(aET31);
        //Profesores en el Trabajo
        RolEnTrabajo rt31= new RolEnTrabajo(fecha4, (Profesor)listaPersonas.get(0), Rol.TUTOR);
        listaRT3.add(rt31);
        Trabajo trab3 = new Trabajo ("Este es el titulo del Trabajo", listaA3,4, fecha4, listaAeT2, listaRT2); //Aca no se si es un error o no pero se crearon listaAet3 y listaRT3 y nunca se usaron
        if(!listaTrabajos.contains(trab3)) {
            listaTrabajos.add(trab3);
            System.out.println("Se agregó el trabajo 3");
        }
        else
            System.out.println("No se agregó el trabajo 3");
//        
        //TRABAJO 4  NO LO AGREGA
        ArrayList<AlumnoEnTrabajo> listaAeT4 = new ArrayList<>();
        ArrayList<RolEnTrabajo> listaRT4 = new ArrayList<>();
        //Alumnos en el Trabajo
        AlumnoEnTrabajo aET41 = new AlumnoEnTrabajo(fecha5, (Alumno)listaPersonas.get(9));
        AlumnoEnTrabajo aET42 = new AlumnoEnTrabajo(fecha5,(Alumno)listaPersonas.get(6));
        listaAeT4.add(aET41);
        //Profesores en el Trabajo
        RolEnTrabajo rt41= new RolEnTrabajo(fecha5,(Profesor)listaPersonas.get(4), Rol.TUTOR);
        listaRT4.add(rt41);
        Trabajo trab4 = new Trabajo ("Este es el titulo del Trabajo", listaA1,5, fecha5, listaAeT4, listaRT4);
        if(!listaTrabajos.contains(trab4)) {
            listaTrabajos.add(trab4);
            System.out.println("Se agregó el trabajo 4");
        }
        else
            System.out.println("No se agregó el trabajo 4");
        //*****************************TRABAJOS***********************************
        
        System.out.println("\n*** LISTA DE TRABAJOS *** \n ");
        for (Trabajo t : listaTrabajos)
            t.mostrar();
        
        //System.out.println(listaTrabajos.size());
        System.out.println("\n*** Agregar Jurado al Trabajo *** \n ");
        //AGREGAR JURADO, FECHA APROBACION
        RolEnTrabajo rt42= new RolEnTrabajo(fecha4, (Profesor)listaPersonas.get(3), Rol.JURADO);
        RolEnTrabajo rt43= new RolEnTrabajo(fecha4, (Profesor)listaPersonas.get(2), Rol.JURADO);
        RolEnTrabajo rt44= new RolEnTrabajo(fecha4, (Profesor)listaPersonas.get(0), Rol.JURADO);
        System.out.println(trab3.agregarProfesor(rt43));
        System.out.println(trab3.agregarProfesor(rt42));
        System.out.println(trab3.agregarProfesor(rt44)); //No debería poder agregarlo.
        trab3.setFechaAprobacion(fecha4);
        
        System.out.println("\n*** TRABAJOS CON JURADO *** \n ");
        listaTrabajos.get(2).mostrar();  
        
        System.out.println("\n*** Agregar Jurado al Trabajo *** \n ");
        //AGREGAR JURADO, FECHA APROBACION
        RolEnTrabajo rt22= new RolEnTrabajo(fecha4, (Profesor)listaPersonas.get(1), Rol.JURADO);
        RolEnTrabajo rt23= new RolEnTrabajo(fecha4, (Profesor)listaPersonas.get(3), Rol.JURADO);
        RolEnTrabajo rt24= new RolEnTrabajo(fecha4, (Profesor)listaPersonas.get(0), Rol.JURADO);
        System.out.println(trab1.agregarProfesor(rt22));// no deberia poder 
        System.out.println(trab1.agregarProfesor(rt23));
        System.out.println(trab1.agregarProfesor(rt24)); // no deberia poder 
        trab2.setFechaAprobacion(fecha4);
        
        System.out.println("\n*** TRABAJOS CON JURADO *** \n ");
        listaTrabajos.get(0).mostrar();
   
        //***********************AGREGAR SEMINARIO******************************
        
        Seminario unSeminario = new Seminario(fecha6, NotaAprobacion.APROBADO_SINOBS, null);
        listaTrabajos.get(2).agregarSeminario(unSeminario);
        
        System.out.println("\n*** TRABAJOS CON Seminario *** \n ");
        for (Trabajo t : listaTrabajos)
            t.mostrar();

    } 
}