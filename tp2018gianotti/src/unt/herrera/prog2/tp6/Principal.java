/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp6;

import java.time.LocalDate;
import java.util.ArrayList;

/*
CONSULTA:
		1)	En los metodos para mostrar que involucran AlumnoEnTrabajo y RolEnTrabajo cuyas personas ya se retiraron del trabajo
			validamente con alguna razon y todo eso, los sigo mostrando, los muestro indicando que salieron del trabajo o los
			dejo de imprimir junto con el trabajo?.
		2)	Esta bien la manera en la que borro alumnos/profesores? Basicamente los estoy sacando de la lista y si no hay ninguna otra
			referencia que apunte hacia ellos deberian ser recolectados por el garbage collector.
		3)	Cuando el trabajo esta finalizado, para "liberar" a mis alumnos y profesores los borro de la lista o indico que
			tienen una razon ( terminaron el trabajo ) y pongo la fecha de exposicion como finalizado?.
		4)	En el caso de finalizar alumno falta el control de que fechaHasta debe ser posterior a fechaDesde
		5)	Preguntar bien la relacion de tutor/cotutor/jurado por que no esta clara del todo y creo que podria ser mas sencilla
			de la que tengo actualmente.
		6)	En finalizar trabajo estoy con la duda si tiene que existir un seminario aprobado o una fecha de aprobacion, o
			si el trabajo puede estar finalizado sin fechaAprobacion.
*/

/**
 *
 * @author mariana
 */
public class Principal {
    public static void main (String Args[] ) { 
		/*
        ArrayList<Trabajo> listaTrabajos = new ArrayList<>(); // Borrar esto en un futuro.
        ArrayList<Persona> listaPersonas = new ArrayList<>();
        ArrayList<Area> listaAreas =new ArrayList<> ();
		
		*/
		GestorAreas miGestorArea;
		GestorPersonas miGestorPersonas;
		GestorTrabajos miGestorTrabajos;
		GestorRolEnTrabajo miGestorDeRoles;
		GestorAlumnoEnTrabajo miGestorDeAlumnos;
		
        //***************************Areas**********************************
		
		miGestorArea = GestorAreas.instanciar();
		
	//<editor-fold desc="Agregado de areas">
		
		System.out.println(miGestorArea.nuevaArea("Software"));
		System.out.println(miGestorArea.nuevaArea("Hardware"));
		System.out.println(miGestorArea.nuevaArea("Sistemas Embebidos"));
		System.out.println(miGestorArea.nuevaArea("Redes"));
		System.out.println(miGestorArea.nuevaArea("Redes"));
		
		ArrayList<Area> listaA1= new ArrayList<>();
        listaA1.add(miGestorArea.dameArea("Software"));
		
        ArrayList<Area> listaA2= new ArrayList<>();
        listaA2.add(miGestorArea.dameArea("Software"));
        listaA2.add(miGestorArea.dameArea("Hardware"));
		
        ArrayList<Area> listaA3= new ArrayList<>();
        listaA3.add(miGestorArea.dameArea("Redes"));
		
		//</editor-fold>

        System.out.println("\n***Lista de Areas *** \n ");
		miGestorArea.mostrarAreas();
		
		//<editor-fold desc="Pruebas adicionales de las funciones de areas ( comentadas )">
		/*
		System.out.println("Buscamos por ware");
		for(Area i : miGestorArea.buscarAreas("ware")){
			System.out.println(i);
		}
		
		System.out.println("Buscamos el area Software");
		System.out.println(miGestorArea.dameArea("Software"));
		*/
                
		//</editor-fold>

        //***************************PERSONAS**********************************
		
	miGestorPersonas = GestorPersonas.instanciar();
		
	//<editor-fold desc="Agregado de profesores y alumnos">

        //PROFESOR
		
		System.out.println(miGestorPersonas.nuevoProfesor("Juarez", "Juan José", 12345678, Cargo.ASOCIADO)); // Persona 0
		System.out.println(miGestorPersonas.nuevoProfesor("Diaz", "Juan Pablo", 13345678, Cargo.JTP));
		System.out.println(miGestorPersonas.nuevoProfesor("Juarez", "Ana María", 14345678, Cargo.ADJUNTO));
		System.out.println(miGestorPersonas.nuevoProfesor("San Martin","Jose Manuel", 15345678, Cargo.ADG)); // Persona 3
		System.out.println(miGestorPersonas.nuevoProfesor("Ortega", "Laura", 16345678, Cargo.ASOCIADO));
		System.out.println(miGestorPersonas.nuevoProfesor("Rodriguez","Juliana", 15345678, Cargo.TITULAR)); //No lo deberia agregar, comparte doc con San Martin

               
        //ALUMNO
		System.out.println(miGestorPersonas.nuevoAlumno("Musa", "Ezequiel", 34567890, "16345")); // persona 5
		System.out.println(miGestorPersonas.nuevoAlumno("Martinez", "Ricardo Juan", 34567891, "16343"));
		System.out.println(miGestorPersonas.nuevoAlumno("Gimenez", "María José", 34567892, "16344"));
		System.out.println(miGestorPersonas.nuevoAlumno("Flores", "Mauricio José", 34567890, "16543")); // Deberia fallar
		System.out.println(miGestorPersonas.nuevoAlumno("Campos", "Juan Pablo", 34567895, "17345")); // persona 8
		System.out.println(miGestorPersonas.nuevoAlumno("Campos", "Augusto", 15345678, "17348")); //Deberia fallar
		System.out.println(miGestorPersonas.nuevoAlumno("Rodriguez", "Miguel Angel", 34567852, "17346")); // persona 9
		System.out.println(miGestorPersonas.nuevoAlumno("Alvarez", "Ezequiel", 44567890, "16345")); //Deberia fallar
		System.out.println(miGestorPersonas.nuevoAlumno("Aguero", "Luciana", 45567890, "17349")); // persona 10
		System.out.println(miGestorPersonas.nuevoAlumno("Campos Figueroa", "Juana", 46567890, "16345")); //Deberia fallar		
		System.out.println(miGestorPersonas.nuevoAlumno("Apud", "Josefina", 45367890, "18345"));
        		
		//</editor-fold>

        System.out.println("\n*** Lista de Personas *** \n ");
        miGestorPersonas.mostrarPersonas();
		
        System.out.println("\n*** Lista de Profesores *** \n ");
        miGestorPersonas.mostrarProfesores();
        
        System.out.println("\n*** Lista de Alumnos *** \n ");
        miGestorPersonas.mostrarAlumnos();
		
        System.out.println("\n\n");
		
		//<editor-fold desc="Pruebas adicionales de las funciones de personas ( comentadas )">
		/*
		System.out.println("Buscamos Alumnos con filtro: ez");
		for(Alumno i : miGestorPersonas.buscarAlumnos("ez")){
			System.out.println(i);
		}
		
		System.out.println("Buscamos al ayudante con su cx: (16345)");
		System.out.println(miGestorPersonas.dameAlumno("16345")); //Aca imprime a musa
		
		System.out.println("Buscamos Profesores con filtro: z"); // juareZ, juareZ, diaZ
		for(Profesor i : miGestorPersonas.buscarProfesores("z")){
			System.out.println(i);
		}
		
		System.out.println("Buscamos al general san martin");
		System.out.println(miGestorPersonas.dameProfesor(15345678)); // San martin
		*/
		//</editor-fold>
		
		
		//<editor-fold desc="Pruebas parte 2 ( comentadas )">
		// PRUEBAS PARTE 2
		
		/*
		Alumno ref1 = miGestorPersonas.dameAlumno("18345"); // Apud Josefina	
		
		//Deberia fallar por pasar todo nulo.
		System.out.println("1: " + miGestorPersonas.modificarAlumno(ref1, null, null, null));
		System.out.println(ref1);
		
		//Deberia cambiar el apellido a gonzales
		System.out.println("2: " + miGestorPersonas.modificarAlumno(ref1, "Gonzales", null, null));	
		System.out.println(ref1);
		
		//Deberia el nombre a Jose Luis
		System.out.println("3: " + miGestorPersonas.modificarAlumno(ref1, null, "Jose Luis", null));
		System.out.println(ref1);
		
		//Deberia cambiar el cx a 12345
		System.out.println("4: " + miGestorPersonas.modificarAlumno(ref1, null, null, "12345"));
		System.out.println(ref1);
		
		//Deberia cambiar todo a Sanchez, Miguel, 12341
		System.out.println("4: " + miGestorPersonas.modificarAlumno(ref1, "Gomez", "Miguel", "12341"));
		System.out.println(ref1);
		
		//Deberia borrar exitosamente el alumno.
		System.out.println("5: " + miGestorPersonas.borrarAlumno(miGestorPersonas.dameAlumno("12341")));
		System.out.println("Gomez en referencia: " + ref1);
		System.out.println("Gomez en lista: " + miGestorPersonas.dameAlumno("12341"));
		ref1 = null; //Borro toda referencia de sanchez asi se borra del todo.
		
		//Volvemos a poner al alumno como era anteriormente
		System.out.println("6: " + miGestorPersonas.nuevoAlumno("Apud", "Josefina", 45367890, "18345")+"\n");
		miGestorPersonas.mostrarAlumnos();
		System.out.println("\n\n");
		*/
		
		//</editor-fold>	
		
        //*****************************TRABAJOS***********************************
		
		miGestorTrabajos = GestorTrabajos.instanciar();
		miGestorDeRoles = GestorRolEnTrabajo.instanciar();
		miGestorDeAlumnos = GestorAlumnoEnTrabajo.instanciar();
		
	//<editor-fold desc="Creacion de fechas">
        LocalDate fecha1 = LocalDate.of(2017, 10, 2);
        LocalDate fecha2 = null; 
        LocalDate fecha3 = LocalDate.of(2017, 11, 2);
        LocalDate fecha4 = LocalDate.of(2017, 8, 12);
        LocalDate fecha5 = LocalDate.of(2017, 9, 12);
        LocalDate fecha6 = LocalDate.of(2017, 10, 2);
		//</editor-fold>
		
        //TRABAJOS
		
        
        //<editor-fold desc="TRABAJO 1">
		// Un trabajo Presentado sin aprobarse aun, con dos alumnos tutor y cotutor
		
        ArrayList<AlumnoEnTrabajo> listaAeT = new ArrayList<>();
        ArrayList<RolEnTrabajo> listaRT = new ArrayList<>();
        //Alumnos en el Trabajo
		
        AlumnoEnTrabajo aET11 = miGestorDeAlumnos.nuevoAlumnoEnTrabajo(fecha1, miGestorPersonas.dameAlumno("16345"));
        AlumnoEnTrabajo aET12 = miGestorDeAlumnos.nuevoAlumnoEnTrabajo(fecha1, miGestorPersonas.dameAlumno("16344"));
        listaAeT.add(aET11);
        listaAeT.add(aET12);
        //Profesores en el Trabajo
		
        RolEnTrabajo rt11 = miGestorDeRoles.nuevoRolEnTrabajo(miGestorPersonas.dameProfesor(12345678), Rol.TUTOR, fecha1);
        RolEnTrabajo rt12 = miGestorDeRoles.nuevoRolEnTrabajo(miGestorPersonas.dameProfesor(13345678), Rol.COTUTOR, fecha1);
		listaRT.add(rt11);
        listaRT.add(rt12);
		
		System.out.println( miGestorTrabajos.nuevoTrabajo("Protocolos de comunicación", 6, fecha1, null, listaA1, listaRT, listaAeT) );
		
		//</editor-fold>

        //<editor-fold desc="TRABAJO 2">
        // 2 alumnos, tutor y sin fecha de presentacion.
		
        ArrayList<AlumnoEnTrabajo> listaAeT2 = new ArrayList<>();
        ArrayList<RolEnTrabajo> listaRT2 = new ArrayList<>();
		
        //Alumnos en el Trabajo    
        AlumnoEnTrabajo aET21 = miGestorDeAlumnos.nuevoAlumnoEnTrabajo(fecha1, miGestorPersonas.dameAlumno("16343")); // persona 6
        AlumnoEnTrabajo aET22 = miGestorDeAlumnos.nuevoAlumnoEnTrabajo(fecha1, miGestorPersonas.dameAlumno("17345")); // persona 8
		
        //OJO CON EL ALUMNO 8 lo puse en dos trabajos
        listaAeT2.add(aET21);
        listaAeT2.add(aET22);
		
        //Profesores en el Trabajo
        RolEnTrabajo rt21 = miGestorDeRoles.nuevoRolEnTrabajo(miGestorPersonas.dameProfesor(15345678), Rol.TUTOR, fecha1); // persona 3
        listaRT2.add(rt21);
		
		System.out.println( miGestorTrabajos.nuevoTrabajo("Gestión de Trabajos Finales", 8, fecha1, null, listaA2, listaRT2, listaAeT2) );

		//</editor-fold>
		
		//<editor-fold desc="TRABAJO 3"> 
		//Trabajo con tutor, un alumno y sin fecha de presentacion.
	   
        ArrayList<AlumnoEnTrabajo> listaAeT3 = new ArrayList<>();
        ArrayList<RolEnTrabajo> listaRT3 = new ArrayList<>();
        //Alumnos en el Trabajo
        AlumnoEnTrabajo aET31 = miGestorDeAlumnos.nuevoAlumnoEnTrabajo(fecha4, miGestorPersonas.dameAlumno("17349")); // persona 10
        listaAeT3.add(aET31);
        //Profesores en el Trabajo
        RolEnTrabajo rt31 = miGestorDeRoles.nuevoRolEnTrabajo(miGestorPersonas.dameProfesor(12345678), Rol.TUTOR, fecha1); // persona 0
        listaRT3.add(rt31);
		
		System.out.println( miGestorTrabajos.nuevoTrabajo("Este es el titulo del Trabajo", 4, fecha4, null, listaA3, listaRT3, listaAeT3) );
		
        //</editor-fold>

        //<editor-fold desc="TRABAJO 4">
		//NO LO AGREGA
        ArrayList<AlumnoEnTrabajo> listaAeT4 = new ArrayList<>();
        ArrayList<RolEnTrabajo> listaRT4 = new ArrayList<>();
        //Alumnos en el Trabajo
        AlumnoEnTrabajo aET41 = miGestorDeAlumnos.nuevoAlumnoEnTrabajo(fecha5, miGestorPersonas.dameAlumno("17346")); // persona 9
        AlumnoEnTrabajo aET42 = miGestorDeAlumnos.nuevoAlumnoEnTrabajo(fecha5, miGestorPersonas.dameAlumno("16343")); // persona 6
        listaAeT4.add(aET41);
        //Profesores en el Trabajo
        RolEnTrabajo rt41 = miGestorDeRoles.nuevoRolEnTrabajo(miGestorPersonas.dameProfesor(16345678), Rol.TUTOR, fecha5); // persona 4
        listaRT4.add(rt41);
		
		System.out.println( miGestorTrabajos.nuevoTrabajo("Este es el titulo del Trabajo", 5, fecha5, null, listaA1, listaRT4, listaAeT4) );

		//</editor-fold>
		
		miGestorTrabajos.mostrarTrabajos();	
		
		//<editor-fold desc="Controles Adicionales">
		/*	
			//finalizo un alumno del trabajo 1. Primero falla luego entra bien.
			Trabajo refTrab1 = miGestorTrabajos.buscarTrabajos().get(0);
			Alumno refAl1 = miGestorPersonas.dameAlumno("16345");
			Alumno refAl2 = miGestorPersonas.dameAlumno("17345");
			
			System.out.println("1: " + miGestorTrabajos.finalizarAlumno(refTrab1, refAl1, fecha6, null)); //falla
			
			System.out.println("2: " + miGestorTrabajos.finalizarAlumno(refTrab1, refAl1, fecha4, "Se mudo a Timbuctu")); //falla por la fecha.
			
			System.out.println("3: " + miGestorTrabajos.finalizarAlumno(refTrab1, refAl1, fecha3, "Se mudo a Timbuctu")); //entra bien
			
			System.out.println("4: " + miGestorTrabajos.finalizarAlumno(refTrab1, refAl2, fecha3, "Se mudo a Timbuctu")); //falla por que el alumno no esta
			
			System.out.println("razon de alumno: " + refTrab1.getAlumnosEnTrabajo().get(0).getRazon());
			
			//Reemplazo un profesor en el trabajo 1.
			Profesor refProf1 = miGestorPersonas.dameProfesor(15345678);
			
			System.out.println("1: " + miGestorTrabajos.reemplazarProfesor(refTrab1, refTrab1.getRolesEnTrabajo().get(0).getUnProfesor(), fecha6, "Capo maximo", refProf1));

			refTrab1.mostrar();
		*/	
		//</editor-fold>
		
        //*****************************TRABAJOS***********************************
 
        System.out.println("\n*** Agregar Jurado al Trabajo *** \n ");
        //AGREGAR JURADO, FECHA APROBACION
	//<editor-fold desc="Agregar jurado">
		
        RolEnTrabajo rt42 = miGestorDeRoles.nuevoRolEnTrabajo(miGestorPersonas.dameProfesor(15345678), Rol.JURADO, fecha4); // persona 3
        RolEnTrabajo rt43 = miGestorDeRoles.nuevoRolEnTrabajo(miGestorPersonas.dameProfesor(14345678), Rol.JURADO, fecha4); // persona 2
        RolEnTrabajo rt44 = miGestorDeRoles.nuevoRolEnTrabajo(miGestorPersonas.dameProfesor(12345678), Rol.JURADO, fecha4); // persona 0
        System.out.println(miGestorTrabajos.buscarTrabajos().get(2).agregarProfesor(rt43) ); // agregamos rt43 al trabajo 3
        System.out.println(miGestorTrabajos.buscarTrabajos().get(2).agregarProfesor(rt44) );
        System.out.println(miGestorTrabajos.buscarTrabajos().get(2).agregarProfesor(rt42) ); //No debería poder agregarlo.
        miGestorTrabajos.buscarTrabajos().get(2).setFechaAprobacion(fecha4);
        
		//</editor-fold>
		
        System.out.println("\n*** TRABAJOS CON JURADO *** \n ");
        miGestorTrabajos.buscarTrabajos().get(2).mostrar();  

		
        System.out.println("\n*** Agregar Jurado al Trabajo *** \n ");
        //AGREGAR JURADO, FECHA APROBACION
		
	//<editor-fold desc="Agregar Jurado">
        RolEnTrabajo rt22 = miGestorDeRoles.nuevoRolEnTrabajo(miGestorPersonas.dameProfesor(13345678), Rol.JURADO, fecha4); // persona 1
        RolEnTrabajo rt23 = miGestorDeRoles.nuevoRolEnTrabajo(miGestorPersonas.dameProfesor(15345678), Rol.JURADO, fecha4); // persona 3
        RolEnTrabajo rt24 = miGestorDeRoles.nuevoRolEnTrabajo(miGestorPersonas.dameProfesor(12345678), Rol.JURADO, fecha4); // persona 0
        System.out.println(miGestorTrabajos.buscarTrabajos().get(0).agregarProfesor(rt22));// no deberia poder 
        System.out.println(miGestorTrabajos.buscarTrabajos().get(0).agregarProfesor(rt23));
        System.out.println(miGestorTrabajos.buscarTrabajos().get(0).agregarProfesor(rt24)); // no deberia poder
        miGestorTrabajos.buscarTrabajos().get(0).setFechaAprobacion(fecha4);
        
	//</editor-fold>
		
        System.out.println("\n*** TRABAJOS CON JURADO *** \n ");
        miGestorTrabajos.buscarTrabajos().get(0).mostrar();
   

        //***********************AGREGAR SEMINARIO******************************
        
		System.out.println(miGestorTrabajos.buscarTrabajos().get(2).nuevoSeminario(fecha6, NotaAprobacion.APROBADO_CONOBS, null));
        //OJO: Si o si falla ya que no tiene obs.
		
        System.out.println("\n*** TRABAJOS CON Seminario *** \n ");
        miGestorTrabajos.buscarTrabajos().get(2).mostrar();
		
		//<editor-fold desc="Controles de seminarios extra (Comentados)">
		/*
		
		// Paso fecha nula, falla
		Trabajo ref2 = miGestorTrabajos.buscarTrabajos().get(2);
		
		System.out.println("1: " + ref2.nuevoSeminario(fecha2, NotaAprobacion.APROBADO_SINOBS, null));
 
		//Paso fecha posterior a la de aprobacion
		System.out.println("2: " + ref2.nuevoSeminario(fecha4, NotaAprobacion.APROBADO_SINOBS, null));

		//Paso la nota de aprobacion nula
		System.out.println("3: " + ref2.nuevoSeminario(fecha6, null, null));
 
		//Falla por falta de obs
		System.out.println("4: " + ref2.nuevoSeminario(fecha6, NotaAprobacion.APROBADO_CONOBS, null));
 		
		//Falla por falta de obs
		System.out.println("5: " + ref2.nuevoSeminario(fecha6, NotaAprobacion.DESAPROBADO, null));
 
		//Falla por obs vacia
		System.out.println("6: " + ref2.nuevoSeminario(fecha6, NotaAprobacion.APROBADO_CONOBS, ""));
 		
		//pasa bien!
		System.out.println("7: " + ref2.nuevoSeminario(fecha3, NotaAprobacion.APROBADO_CONOBS, "Soy una observacion"));

		//pasa bien!
		System.out.println("8: " + ref2.nuevoSeminario(fecha6, NotaAprobacion.DESAPROBADO, "Aca me clavaron"));
		
		//no pasa por repeticion de fechas.
		System.out.println("9: " + ref2.nuevoSeminario(fecha6, NotaAprobacion.DESAPROBADO, "Aca me clavaron"));
		
		ref2.mostrar();
		
		// modifico el seminario de "7" y lo dejo como desaprobado ( falla por q no hay obs )
		System.out.println("MOD A 7: " + ref2.modificarSeminario(ref2.getSeminarios().get(0), NotaAprobacion.DESAPROBADO, null));		
		
		// modifico el seminario de "7" y lo dejo como desaprobado
		System.out.println("MOD A 7: " + ref2.modificarSeminario(ref2.getSeminarios().get(0), NotaAprobacion.DESAPROBADO, "En realidad en este me clavaron!"));
		
		// modifico el seminario de "8" y lo dejo como aprobado sin obs
		System.out.println("MOD A 8: " + ref2.modificarSeminario(ref2.getSeminarios().get(0), NotaAprobacion.APROBADO_SINOBS, null));
	
		ref2.mostrar();
		
		*/
		//</editor-fold>

	//**********************CONTROLES ADICIONALES**********************
		//<editor-fold desc="Controles Adicionales ( comentados )">
		//Creo el trabajo numero 4 ( ya que el anterior siempre falla pero tiene creada algunas listas.)
		/*
		
		
		//La duracion es negativa y falla
		System.out.println( "1: " + miGestorTrabajos.nuevoTrabajo("Soy un trabajo que siempre falla!", -1, fecha5, null, listaA1, listaRT4, listaAeT4) );

		//Las fechas no pasan ( fecha2 = null )
		System.out.println( "2: " + miGestorTrabajos.nuevoTrabajo("Soy un trabajo que siempre falla!", 5, fecha2, null, listaA1, listaRT4, listaAeT4) );
		
		//La fecha de aprobacion es anterior a la de presentacion
		System.out.println( "3: " + miGestorTrabajos.nuevoTrabajo("Soy un trabajo que siempre falla!", 5, fecha5, fecha4, listaA1, listaRT4, listaAeT4) );

		//listaA1 ( de alumnos )no tiene nada.
		listaA1.clear();
		System.out.println( "4: " + miGestorTrabajos.nuevoTrabajo("Soy un trabajo que siempre falla!", 5, fecha4, null, listaA1, listaRT4, listaAeT4) );
		listaA1.add(miGestorArea.dameArea("Software"));

		//Mando la lista de jurados incompleta con la fecha de aprobacion
		System.out.println( "5: " + miGestorTrabajos.nuevoTrabajo("Soy un trabajo que siempre falla!", 5, fecha4, fecha5, listaA1, listaRT4, listaAeT4) );
		
		//Mando la lista sin tutores/cotutores
		listaRT4.clear(); //La lista ya tenia dos personas aca, con sanmartin son 3 jurados
		listaRT4.add(rt23); //Agrego a sanmartin como jurado
		System.out.println( "6: " + miGestorTrabajos.nuevoTrabajo("Soy un trabajo que siempre falla!", 5, fecha4, fecha5, listaA1, listaRT4, listaAeT4) );
		
		//Mando la lista de tutores con tutor y jurado repetido con fechaAprobacion existente.
		//En la lista esta sanmartin como tutor y jurado
		listaRT4.add(rt21); //San martin como tutor
		System.out.println( "7: " + miGestorTrabajos.nuevoTrabajo("Soy un trabajo que siempre falla!", 5, fecha4, fecha5, listaA1, listaRT4, listaAeT4) );
	
		//Mando a sanmartin como tutor y cotutor.
		listaRT4.clear();
		listaRT4.add(rt21); //San martin como tutor
		listaRT4.add(miGestorDeRoles.nuevoRolEnTrabajo(miGestorPersonas.dameProfesor(15345678), Rol.COTUTOR, fecha1)); // San martin como cotutor.
		System.out.println( "8: " + miGestorTrabajos.nuevoTrabajo("Soy un trabajo que siempre falla!", 5, fecha4, fecha5, listaA1, listaRT4, listaAeT4) );

		//Mando la lista tutores y jurados vacia
		listaRT4.clear();
		System.out.println( "9: " + miGestorTrabajos.nuevoTrabajo("Soy un trabajo que siempre falla!", 5, fecha4, fecha5, listaA1, listaRT4, listaAeT4) );

		//Armo la lista con tutor, cotutor, 3 jurados distintos y la mando.

		listaRT4.add(rt21);//San Martin como tutor
		listaRT4.add(miGestorDeRoles.nuevoRolEnTrabajo(miGestorPersonas.dameProfesor(16345678),Rol.COTUTOR,fecha1));
		listaRT4.add(rt22);//Persona 1 como jurado.
		listaRT4.add(rt24);//Persona 0 como jurado.
		listaRT4.add(rt43);//Persona 2 como jurado.
		System.out.println( "9: " + miGestorTrabajos.nuevoTrabajo("Soy un trabajo que siempre falla!", 5, fecha4, fecha5, listaA1, listaRT4, listaAeT4) );
		System.out.println(listaRT4);
		
                
                
                //Checkeo las areas.
                System.out.println("Yo fallo: " + miGestorArea.borrarArea(miGestorArea.dameArea("Hardware")));
                System.out.println("Yo no fallo: " + miGestorArea.borrarArea(miGestorArea.dameArea("Sistemas Embebidos")));
 
                
                */
		
		//</editor-fold>
       
		//<editor-fold desc="Mas Controles! (comentados)">
		/*
		
		//borro protocolos de comuninacion.
		System.out.println("1: " + miGestorTrabajos.borrarTrabajo(miGestorTrabajos.buscarTrabajos().get(0)));
		
		System.out.println("2: " + miGestorTrabajos.finalizarTrabajo(miGestorTrabajos.buscarTrabajos().get(0), fecha1));
				
		miGestorTrabajos.mostrarTrabajos();
		*/
		//</editor-fold>
    } 
}
