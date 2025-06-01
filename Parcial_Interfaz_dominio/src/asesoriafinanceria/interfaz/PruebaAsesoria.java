package asesoriafinanceria.interfaz;

import java.util.Scanner;

import asesoriafinanciera.dominio.AsesoriaFinanciera;

public class PruebaAsesoria {

	private static Scanner teclado = new Scanner(System.in);
	public static final String MOSTRAR_ASESORIA = "ASESORIA";
	public static final String APLICAR_GANANCIA = "GANANCIA";
	public static final String MOSTRAR_RECOMENDACION = "RECOMENDACION";
	public static final String CAMBIAR_PLAZO = "PLAZO";
	public static final String SALIR = "SALIR";

	public static void main(String[] args) {
		String opcionMenu = "";
		String nombre;
		int edad, riesgo, plazo, inversiones;
		double monto;

		System.out.println("Hola, completa los siguientes datos para ingresar al menu");
		System.out.println("Ingresa tu nombre porfavor: \n");
		nombre = teclado.next();
		System.out.println("Ingresa tu edad porfavor: \n");
		edad = ingresarEntero();
		System.out.println("Ingresa nivel de riesgo aceptado(1=bajo/2=medio/3=alto): \n");
		riesgo = ingresarEntero();
		System.out.println("Ingresa tu monto a invertir porfavor: \n");
		monto = teclado.nextDouble();
		System.out.println("Ingresa el plazo de la inversion en meses: \n");
		plazo = ingresarEntero();
		System.out.println("Ingresa la cantidad de inversiones realizadas: \n");
		inversiones = ingresarEntero();
		teclado.nextLine();

		AsesoriaFinanciera asesoria = new AsesoriaFinanciera(nombre, inversiones, inversiones, monto, inversiones,
				inversiones);

		do {
			menu();
			opcionMenu = ingresarString();

			switch (opcionMenu) {
			case MOSTRAR_ASESORIA:
				System.out.println("Vamos a mostrar todos tus datos: \n");
				System.out.println(asesoria.toString());
				teclado.nextLine();
				break;
			case APLICAR_GANANCIA:
				System.out.println("Vamos aplicar ganancia estimada: \n");
				asesoria.aplicarGananciaEstimada(monto, riesgo, plazo);
				System.out.println("El nuevo monto es: " + asesoria.getMonto() + " Monto aplicando ganancias: "
						+ asesoria.aplicarGananciaEstimada(monto, monto, plazo));
				teclado.nextLine();
				break;
			case MOSTRAR_RECOMENDACION:
				System.out.println("Estamos por mostrarte la mejor recomendacion: \n");
				System.out.println(asesoria.recomendacion(riesgo, monto, plazo));
				teclado.nextLine();
				break;
			case CAMBIAR_PLAZO:
				int cambiarPlazo;
				System.out.println("Vamos a cambiar el plazo, ingresa un numero entero de 1 al 12 : \n");
				cambiarPlazo = teclado.nextInt();
				asesoria.cambiarPlazo(cambiarPlazo);
				asesoria.setPlazo(cambiarPlazo);
				System.out.println("El nuevo plazo es: " + asesoria.getPlazo());
				teclado.nextLine();
				break;
			case SALIR:
				System.out.println("SALIENDO DEL PROGRAMA, TE ESPERAMOS DEVUELTA \n");
				System.out.println(asesoria.toString());
				break;

			}

		} while (!opcionMenu.equals(SALIR));
	}

	private static void menu() {
		System.out.println("=======Bienvenido a tu Asesoria Financiera===== \n");
		System.out.println("1-PARA MOSTRAR ASESORIA INGRESA: 'ASESORIA'");
		System.out.println("2-PARA APLICAR GANANCIA: 'GANANCIA'");
		System.out.println("3-PARA MOSTRAR RECOMENDACION: 'RECOMENDACION'");
		System.out.println("4-PARA CAMBIAR PLAZO: 'PLAZO'");
		System.out.println("5-PARA SALIR: 'SALIR'");
	}

	// QUISE CREAR EL MENU CON TAL SOLO EL MENU PERO LLEGUE MUY JUSTO CON EL TIEMPO
	// Y ABARQUE DESDE EL DO-WHILE

	private static int ingresarEntero() {
		return teclado.nextInt();
	}

	private static String ingresarString() {
		return teclado.nextLine().toUpperCase().trim();
	}

}
