package Proyecto;

public class Main {

	public static void main(String[] args) {
		System.out.println("######## BIENVENID@ A LOOKINGLOVE ########");

		
		LookingLove plataforma = new LookingLove();// Creamos la plataforma


		registrarDatosEjemplo(plataforma); //Registramos las personas de ejemplo
		LookingLove.menuPrograma(plataforma); //Ejecutamos el programa con sus opciones



	}
	
	
	/**Método para dar de alta de 
	 * antemano en la plataforma 
	 * una serie de ejemplos 
	 * de personas, con sus datos
	 * correspondientes 
	 */

	private static void registrarDatosEjemplo(LookingLove plataforma) {
		Enum<Aficiones> a[] = new Aficiones[9];
		System.out.println("Añadiendo datos de ejemplo");
		// Ejemplo Persona1
		a = new Aficiones[9];
		a[0]=Aficiones.BICICLETA;
		a[1]=Aficiones.CONOCER;
		a[2]=Aficiones.MUSICA;
		a[3]=Aficiones.VIAJAR;
		Persona ej1= new Persona("Moises", "García", 28, Sexo.HOMBRE, "Sevilla", Complexion.FUERTE, ColorPelo.CASTANIO, 1.7, Orientacion.MUJER, a);
		plataforma.registrarMiembro(ej1);

		//Ejemplo Persona2
		a = new Aficiones[9];
		a[0]=Aficiones.CONOCER;
		a[1]=Aficiones.MUSICA;
		Persona ej2= new Persona("Manuel", "Linares", 21, Sexo.HOMBRE, "Sevilla", Complexion.DELGADO, ColorPelo.RUBIO, 1.65, Orientacion.AMBOS, a);
		plataforma.registrarMiembro(ej2);

		//Ejemplo Persona3
		a = new Aficiones[9];
		a[0]=Aficiones.CINE;
		a[1]=Aficiones.MOTOS;
		a[2]=Aficiones.TENIS;
		a[3]=Aficiones.VIAJAR;
		a[4]=Aficiones.MUSICA;
		a[5]=Aficiones.DISCO;
		Persona ej3= new Persona("Sandra", "Gallego", 28, Sexo.MUJER, "Sevilla", Complexion.DELGADO, ColorPelo.RUBIO, 1.7, Orientacion.HOMBRE, a);
		plataforma.registrarMiembro(ej3);

		//Ejemplo Persona4
		a = new Aficiones[9];
		a[0]=Aficiones.MUSICA;
		a[1]=Aficiones.DISCO;
		a[2]=Aficiones.TENIS;
		a[3]=Aficiones.VIAJAR;
		Persona ej4= new Persona("Espe", "Jiménez", 35, Sexo.MUJER, "Huelva", Complexion.DELGADO, ColorPelo.RUBIO, 1.75, Orientacion.AMBOS, a);
		plataforma.registrarMiembro(ej4);
	}

}
