package Proyecto;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * El programa consiste en un buscador de parejas, 
 * en el que se va a introducir nuevas personas, 
 * con sus propias características comparadonlas con las demás. 
 * Así se podrá encontrar la pareja mas adecuada.
 * (Las personas también pueden darse de alta por sí mismas)
 * @author Moi, Esperanza, Sandra, Jorge y Linares.
 * 
 */

public class LookingLove {
	Persona[] miembros = new Persona[1000];
	private int cantidad;

	public LookingLove() {
		cantidad = 0;
	}

	public LookingLove(Persona[] miembro) {
		this.miembros = miembro;
		this.cantidad = miembro.length;
	}
	
	/**Método para la recogida
	 * de datos de la persona 
	 * que va a ser dada de 
	 * alta en el programa
	 * 
	 * @return personaResultado, el 
	 * constructor con los atributos del
	 * objeto ya definidos
	 */

	public Persona recogeDatosPersona() {
		// ATRIBUTOS DE PERSONA POR DEFECTO
		String nombre = "";
		String apellidos = "";
		int edad = 18;
		Enum<Sexo> sexo = Sexo.HOMBRE;
		String ciudad = "";
		Enum<Complexion> complexion = Complexion.ATLETA;
		Enum<ColorPelo> colorPelo = ColorPelo.CASTANIO;
		double altura = 1.5;
		Enum<Orientacion> orientacion = Orientacion.AMBOS;
		Enum<Aficiones> aficiones[] = new Aficiones[Aficiones.values().length];

		boolean correcto = true;

		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("REGISTRANDO DATOS DE UNA PERSONA");
			do {
				System.out.println("Introduce nombre");
				nombre = sc.nextLine();
			} while (nombre.equals(""));
			
			do {
				System.out.println("Introduce apellidos");
				apellidos = sc.nextLine();
			} while (apellidos.equals(""));

			String sexoStr = "";
			do {
				System.out.println("Introduce sexo (h/m)");
				sexoStr = sc.nextLine();
			} while (!sexoStr.equalsIgnoreCase("h") && !sexoStr.equalsIgnoreCase("m"));
			if (sexoStr.equalsIgnoreCase("h")) {
				sexo = Sexo.HOMBRE;
			} else {
				sexo = Sexo.MUJER;
			}
			
			do {
				System.out.println("Introduce ciudad");
				ciudad = sc.nextLine();
			} while (ciudad.equals(""));
			String complexionStr = "";
			do {
				System.out.println("Complexión (delgado, grande, fuerte, atleta)");
				complexionStr = sc.nextLine();
			} while (!complexionStr.equalsIgnoreCase("delgado") && !complexionStr.equalsIgnoreCase("grande")
					&& !complexionStr.equalsIgnoreCase("fuerte") && !complexionStr.equalsIgnoreCase("atleta"));
			if (complexionStr.equalsIgnoreCase("delgado")) {
				complexion = Complexion.DELGADO;
			} else if (complexionStr.equalsIgnoreCase("grande")) {
				complexion = Complexion.GRANDE;
			} else if (complexionStr.equalsIgnoreCase("fuerte")) {
				complexion = Complexion.FUERTE;
			} else {
				complexion = Complexion.ATLETA;
			}
			
			String colorStr = "";
			do {
				System.out.println("Color de pelo (rubio, moreno, pelirrojo, castaño, varios)");
				colorStr = sc.nextLine();
			} while (!colorStr.equalsIgnoreCase("rubio") && !colorStr.equalsIgnoreCase("moreno")
					&& !colorStr.equalsIgnoreCase("pelirrojo") && !colorStr.equalsIgnoreCase("castaño")
					&& !colorStr.equalsIgnoreCase("varios"));
			if (colorStr.equalsIgnoreCase("rubio")) {
				colorPelo = ColorPelo.RUBIO;
			} else if (colorStr.equalsIgnoreCase("moreno")) {
				colorPelo = ColorPelo.MORENO;
			} else if (colorStr.equalsIgnoreCase("pelirrojo")) {
				colorPelo = ColorPelo.PELIRROJO;
			} else if (colorStr.equalsIgnoreCase("castaño")) {
				colorPelo = ColorPelo.CASTANIO;
			} else {
				colorPelo = ColorPelo.VARIOS;
			}
			
			String orientacionStr = "";
			do {
				System.out.println("Que sexo quieres encontrar? (hombre/mujer/ambos)");
				orientacionStr = sc.nextLine();
			} while (!orientacionStr.equalsIgnoreCase("hombre") && !orientacionStr.equalsIgnoreCase("mujer")
					&& !orientacionStr.equalsIgnoreCase("ambos"));

			if (orientacionStr.equalsIgnoreCase("hombre")) {
				orientacion = Orientacion.HOMBRE;
			} else if (orientacionStr.equalsIgnoreCase("mujer")) {
				orientacion = Orientacion.MUJER;
			} else {
				orientacion = Orientacion.AMBOS;
			}

			int i = 0;
			for (Aficiones aficion : Aficiones.values()) {
				String leGusta = "";
				do {
					System.out.println("Te gusta la afición (si/no): " + aficion);
					leGusta = sc.nextLine();
				} while (!leGusta.equalsIgnoreCase("si") && !leGusta.equalsIgnoreCase("no"));

				if (leGusta.equalsIgnoreCase("si")) {
					aficiones[i] = aficion;
				}
				i++;
			}
			
			boolean error = false;
			do {
				error = false;
				try {
					System.out.println("Introduce altura (desde 1m hasta 2,20m)");
					altura = sc.nextDouble();
				} catch (Exception e) {
					error = true;
					System.out.println("Error Introduzca un número con coma");
					sc.next();
				}
			} while (altura < 1 || altura > 2.20 || error == true);
			
			do {
				System.out.println("Introduce edad (desde 18 hasta 100 años)");
				edad = sc.nextInt();
			} while (edad < 18 || edad > 100);

		} catch (Exception e) {
			System.out.println("Error al introducir el dato");
			sc.next();
		}

		Persona personaResultado = new Persona(nombre, apellidos, edad, sexo, ciudad, complexion, colorPelo, altura,
				orientacion, aficiones);
		
		return personaResultado;
	}

	/**
	 * Metodo utilizado para recibir un miembro 
	 * y añadirlo en el array.
	 * @param Persona P
	 * @return res
	 */
	public boolean registrarMiembro(Persona p) {
		boolean res = true;
		// Hay sitio libre?
		if (cantidad < miembros.length) {
			// Está ya registrado?
			for (int i = 0; i < cantidad; i++) {
				if (miembros[i].equals(p)) {
					res = false;
				}
			}

			if (res == true) {
				// hay posiciones libres y no se ha registrado anteriormente
				// Introducimos en el array de miembros en la posición siguiente vacía
				miembros[cantidad] = p;
				// Actualizamos la cantidad actual almacenada en miembros
				cantidad++;
				System.out.println("Añadid@! Somos: " + cantidad + " miembros de " + miembros.length);
			}
		} else {
			// no hay sitio en la comunidad de miembros
			res = false;
		}
		return res;
	}
	

	/**
	 * Metodo utilizado para buscar 
	 * la posicion de una persona en el array.
	 * 
	 * @param Persona p
	 * @return res
	 */

	public int buscarPosicionPersona(Persona p) {
		int res = -1;

		for (int i = 0; i < cantidad; i++) {
			if (miembros[i].equals(p)) {
				res = i;
			}
		}

		return res;
	}

	/**
	 * Metodo utilizado para para buscar 
	 * una persona aleatoriamente dentro del array
	 * en el quedan registrado cada perfil dado de alta.
	 * 
	 * @param Persona p
	 * @param posicion
	 * @return resultado
	 */

	public int busquedaAleatoria(Persona p, int posicion) {
		int resultado = -1;
		int intentos = 0;
		System.out.println("... Buscando tu media naranja ...");

		if (p.getOrientacion().equals(Orientacion.AMBOS)) {

			// Si a p le gustan ambos sexos le pasamos uno cualquiera
			do {
				resultado = generarNumeroAleatorio();
				intentos++;
			} while (resultado == posicion && intentos < cantidad); // No puede emparejar con si mismo

		} else {

			int[] aleatoriosGenerados = new int[cantidad];
			Arrays.fill(aleatoriosGenerados, 0);//Inicializa todos los elementos a 0
			

			do {
				int aleatorio = generarNumeroAleatorio();
				if (aleatoriosGenerados[aleatorio] == 0) {
					if (p.getOrientacion().toString().equals(miembros[aleatorio].getSexo().toString())) {
						resultado = aleatorio;
					}
					aleatoriosGenerados[aleatorio] = 1; //Indica que ya se ha comprobado a esa persona
					intentos++;
				}
			} while (resultado == -1 && intentos < cantidad);

		}

		return resultado;
	}
	
	/**Método que recoge 
	 * la fórmula para obtener
	 * un número aleatorio dentro 
	 * de los indices ocupados en 
	 * la array
	 */

	private int generarNumeroAleatorio() {
		return (int) (Math.random() * (cantidad - 1 - 0 + 1) + 0);
	}

	/**Método para cargar la literatura
	 * del menú y sus opciones
	 * y recoger por escaner la selección
	 * por parte del usuario
	 * 
	 * @return opcionElegida
	 */
	
	public int menu() {
		int opcionElegida;
		Scanner sc = new Scanner(System.in);
		do {

			System.out.println("Elige Opción:\n" + "1.\tAñadir nueva Persona\n" + "2.\tBuscar emparejamientos\n"
					+ "3.\tSalir del programa");
			opcionElegida = sc.nextInt();

			if (opcionElegida < 1 || opcionElegida > 3) {
				System.out.println("Error: Opción no disponible (introduce 1, 2 o 3)");
			}

		} while (opcionElegida < 1 || opcionElegida > 3);
		return opcionElegida;
	}

	/**Método para la opción del menú
	 * de buscar pareja, con sus distintas
	 * opciones y la literatura asociada
	 * 
	 * @return opcionElegida
	 */
	
	public int menuBuscarEmparejamiento() {
		int opcionElegida;
		Scanner sc = new Scanner(System.in);
		do {

			System.out.println(
					"Como desea buscar pareja?:\n" + "1.\tFiltrando\n" + "2.\tPersona con más datos en común\n"
							+ "3.\tPersona con menos aficiones en común\n" + "4.\tBúsqueda aleatoria");
			opcionElegida = sc.nextInt();

			if (opcionElegida < 1 || opcionElegida > 4) {
				System.out.println("Error: Opcion no disponible (introduce 1, 2, 3 o 4)");
			}

		} while (opcionElegida < 1 || opcionElegida > 4);
		return opcionElegida;

	}

	/**Método para seleccionar
	 * la persona con la que deseamos
	 * emparejar según el criterio
	 * de búsqueda elegido
	 * 
	 * @return posicion
	 */
	public int elegirPersona() {
		int posicion = 0;
		Scanner sc = new Scanner(System.in);

		// Mostrar listado de personas
		for (int i = 0; i < cantidad; i++) {
			System.out.println(i + ": " + miembros[i].toString());
		}

		do {
			// Elegir entre las mostradas
			System.out.println("Que persona busca pareja?");
			posicion = sc.nextInt();
		} while (posicion < 0 || posicion >= cantidad);

		return posicion;
	}
	/**
	 * El método nos permite
	 * realizar busqueda filtrada
	 * entre los miembros dados de 
	 * alta en la aplicación. 
	 * Se recogen dos tipos de filtros:
	 * búsqueda por ciudad y por edad.
	 * Con dicho filtro elegido realizará 
	 * una busqueda aleatoria entre los que 
	 * cumpla tal condicion
	 * @param persona
	 * @param personaElegida
	 * @return posicion
	 */
	

	public int busquedaFiltrada(Persona persona, int personaElegida) {
		int posicion = -1;
		Scanner sc = new Scanner(System.in);
		int menuFiltro;
		do {
			System.out.println("Menú de Filtros\n" + "1. Por Ciudad\n" + "2. Por edad");
			menuFiltro = sc.nextInt();
			if (menuFiltro < 1 || menuFiltro > 2) {
				System.out.println("Error: Opcion no disponible (introduce 1 o 2)");
			}
		} while (menuFiltro < 1 || menuFiltro > 2);

		int[] posicionesComprobadas = new int[cantidad];
		int cont = 0;

		switch (menuFiltro) {
		case 1: // filtro por ciudad

			String ciudadFiltrada = "";
			do {
				sc = new Scanner(System.in);
				System.out.println("Introduce ciudad:");
				ciudadFiltrada = sc.nextLine();
			} while (ciudadFiltrada == "");

			for (int i = 0; i < posicionesComprobadas.length; i++) {
				posicionesComprobadas[i] = 0; // NO COMPROBADAS
			}

			cont = 0; // limita el bucle infinito
			do {
				int aleatorio = generarNumeroAleatorio();
				if (posicionesComprobadas[aleatorio] == 0) {
					if (ciudadFiltrada.equalsIgnoreCase(miembros[aleatorio].getCiudad())
							&& persona.getOrientacion().toString().equals(miembros[aleatorio].getSexo().toString())) {
						posicion = aleatorio; // persona encontrada
					}
					posicionesComprobadas[aleatorio] = 1;
					cont++;
				}
			} while (cont < cantidad && posicion == -1);

			break;

		case 2: // filtro por edad
			
			int edadFiltrada = 0;
			do {
				sc = new Scanner(System.in);
				try {
					System.out.println("Introduce edad:");
					edadFiltrada = sc.nextInt();
				} catch (Exception e) {
					System.out.println("Error: debe introducir un número");
				}
			} while (edadFiltrada == 0);

			for (int i = 0; i < posicionesComprobadas.length; i++) {
				posicionesComprobadas[i] = 0; // NO COMPROBADAS
			}

			cont = 0; // limita el bucle infinito
			do {
				int aleatorio = generarNumeroAleatorio();
				if (posicionesComprobadas[aleatorio] == 0) {
					if (edadFiltrada == miembros[aleatorio].getEdad()
							&& persona.getOrientacion().toString().equals(miembros[aleatorio].getSexo().toString())) {
						posicion = aleatorio; // persona encontrada
					}
					posicionesComprobadas[aleatorio] = 1;
					cont++;
				}
			} while (cont < cantidad && posicion == -1);
			break;
		}

		return posicion;
	}

	/**
	 * Método para realizar
	 * una búsqueda de pareja
	 * por afinidad de aficiones.
	 * Se busca personas con mayor
	 * números de aficiones en común
	 * previamente registradas
	 * @param p
	 * @param personaElegida
	 * @return posicion
	 */
	
	public int busquedaAficionesComun(Persona p, int personaElegida) {
		int posicion = -1;

		// almacenamos la cantidad de aficiones en común con persona
		int[] posicionesComprobadas = new int[cantidad];

		// comprobamos cada miembro
		for (int i = 0; i < cantidad; i++) {
			int cantidadAficiones = 0;

			// contabilizar aficiones en común
			cantidadAficiones = contarAficiones(p.getAficiones(), i);

			posicionesComprobadas[i] = cantidadAficiones;
		}

		// Seleccionamos el miembro con mayor número de aficiones en común sin elegir el propio miembro
		int cantidadAficionesComun = 0;
		for (int i = 0; i < posicionesComprobadas.length; i++) {
			if (i != personaElegida && posicionesComprobadas[i] > cantidadAficionesComun) {
				cantidadAficionesComun = posicionesComprobadas[i];
				posicion = i;
			}
		}
		return posicion;
	}
	
	/**
	 * Método para realizar
	 * una búsqueda de pareja
	 * por menos afinidad.
	 * Se busca personas con menor
	 * números de aficiones en común
	 * previamente registradas
	 * @param p
	 * @param personaElegida
	 * @return posicion
	 */

	public int busquedaAficionesOpuestas(Persona p, int personaElegida) {
		int posicion = -1;

		// almacenamos la cantidad de aficiones en común con persona
		int[] posicionesComprobadas = new int[cantidad];

		// comprobamos cada miembro
		for (int i = 0; i < cantidad; i++) {
			int cantidadAficiones = 0;

			// contabilizar aficiones en común
			cantidadAficiones = contarAficiones(p.getAficiones(), i);

			posicionesComprobadas[i] = cantidadAficiones;
		}

		// Seleccionamos el miembro con menor número de aficiones en común sin elegir el propio miembro
		int cantidadAficionesOpuestas = 1000;
		for (int i = 0; i < posicionesComprobadas.length; i++) {
			if (i != personaElegida && posicionesComprobadas[i] < cantidadAficionesOpuestas) {
				cantidadAficionesOpuestas = posicionesComprobadas[i];
				posicion = i;
			}
		}

		return posicion;
	}

	/**
	 * Método para determinar
	 * el número de aficiones
	 * que tiene el perfil 
	 * registrado
	 * @param aficiones
	 * @param i
	 * @return total
	 */
	private int contarAficiones(Enum<Aficiones>[] aficiones, int i) {
		int total = 0;

		// recorro el array de aficion del miembro i
		for (Enum<Aficiones> aficion : miembros[i].getAficiones()) {
			if (miembros[i].getAficiones() != null) {
				total++;
			}
		}
		return total;
	}
	
	
	/**Método para desarrollar el 
	 * menú principal del programa.
	 * Recoge las distintas opciones 
	 * mediante switch y sus distintos case
	 * donde se recogen los distintos métodos 
	 * para la funcionalidad del programa
	 */
	public static void menuPrograma(LookingLove plataforma) {
		int opcionElegida;
		do {

			opcionElegida = plataforma.menu();

			switch (opcionElegida) {
			case 1: //Insertar miembro
				Persona p = plataforma.recogeDatosPersona();
				plataforma.registrarMiembro(p);
				break;

			case 2: //Buscar emparejamiento
				int opcion = plataforma.menuBuscarEmparejamiento();
				int personaElegida = plataforma.elegirPersona();

				switch(opcion) {
				case 1: // Filtrando
					System.out.println("BUSQUEDA FILTRADA");
					int encontrado1=plataforma.busquedaFiltrada(plataforma.miembros[personaElegida], personaElegida);

					if(encontrado1==-1) {
						System.out.println("No hemos podido encontrarle pareja");
					}else {
						System.out.println("La persona elegida es..."+encontrado1+"!!!");
						System.out.println(plataforma.miembros[encontrado1].toString());						
					}
					break;

				case 2: // Más gustos en común
					System.out.println("BÚSQUEDA CON MAS AFICIONES EN COMÚN");
					int encontrado2=plataforma.busquedaAficionesComun(plataforma.miembros[personaElegida], personaElegida);

					if(encontrado2==-1) {
						System.out.println("No hemos podido encontrarle pareja");
					}else {
						System.out.println("La persona elegida es..."+encontrado2+"!!!");
						System.out.println(plataforma.miembros[encontrado2].toString());						
					}
					break;

				case 3: // Con gustos opuestos (menos aficiones en común)
					System.out.println("BÚSQUEDA CON MENOS AFICIONES EN COMÚN");
					int encontrado3=plataforma.busquedaAficionesOpuestas(plataforma.miembros[personaElegida], personaElegida);

					if(encontrado3==-1) {
						System.out.println("No hemos podido encontrarle pareja");
					}else {
						System.out.println("La persona elegida es..."+encontrado3+"!!!");
						System.out.println(plataforma.miembros[encontrado3].toString());						
					}
					break;

				case 4: // Búsqueda Aleatoria
					System.out.println("BÚSQUEDA ALEATORIA");
					int encontrado = plataforma.busquedaAleatoria(plataforma.miembros[personaElegida], personaElegida);
					if(encontrado == -1 || encontrado == personaElegida) {
						System.out.println("No hemos podido encontrarle pareja");
					}else {						
						System.out.println("La persona elegida es..."+encontrado+"!!!");
						System.out.println(plataforma.miembros[encontrado].toString());
					}
					System.out.println("\n\n\n");
					break;
				default:
					System.out.println("opción no correcta");
				}
				break;
			case 3:// Salir
				System.out.println("Hasta pronto!!");
				break;
			}

		}while(opcionElegida !=3);

	}

}
