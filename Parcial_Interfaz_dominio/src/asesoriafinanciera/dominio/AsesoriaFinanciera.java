package asesoriafinanciera.dominio;

public class AsesoriaFinanciera {
	public static final Double RIESGO_0 = 0.03;
	public static final Double RIESGO_1 = 0.06;
	public static final Double RIESGO_2 = 0.15;
	private String nombre;
	private int edad;
	private int riesgo;
	private double monto;
	private int plazo;
	private double acumuladorGanancia;
	private int inversiones;
	private static double tasa;

	// CONSTRUCTOR PARAMETRIZADO
	public AsesoriaFinanciera(String nombre, int edad, int riesgo, double monto, int plazo, int inversiones) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.riesgo = riesgo;
		this.monto = monto;
		this.plazo = plazo;
		this.inversiones = inversiones;
	}

	// SETTERS AND GETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getRiesgo() {
		return riesgo;
	}

	public void setRiesgo(int riesgo) {
		this.riesgo = riesgo;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public int getPlazo() {
		return plazo;
	}

	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}

	public double getAcumuladorGanancia() {
		return acumuladorGanancia;
	}

	public void setAcumuladorGanancia(double acumuladorGanancia) {
		this.acumuladorGanancia = acumuladorGanancia;
	}

	public int getInversiones() {
		return inversiones;
	}

	public void setInversiones(int inversiones) {
		this.inversiones = inversiones;
	}

	// METODO PARA CALCULAR LA GANANCIA ESTIMADA
	public double aplicarGananciaEstimada(double monto, double tasa, int plazo) {
		double gananciaEstimada;
		String conteoInversiones;
		gananciaEstimada = this.monto * tasa * (this.plazo / 12.0);
		if (gananciaEstimada > 0) {
			this.setAcumuladorGanancia(gananciaEstimada);
			conteoInversiones = "Conteo de inversiones: " + this.getInversiones();
			this.monto += gananciaEstimada;
		}
		return gananciaEstimada;
	}

	// METODO PARA OBTENER LA TASA
	public static double obtenerTasaPorRiesgo(int riesgo) {
		switch (riesgo) {
		case 1:
			String mensaje1 = "3% anual equivale el riesgo '1:Bajo'";
			tasa = RIESGO_0;
		case 2:
			String mensaje2 = "6% anual equivale el riesgo '2:Normal'";
			tasa = RIESGO_1;
		case 3:
			String mensaje3 = "15% anual equivale el riesgo '1:Alto'";
			tasa = RIESGO_2;
			break;
		default:
			String mensajeOtro = "1% anual equivale el riesgo 'Otro:'";
			tasa = 0.01;
		}
		return tasa;
	}

	// METODO PARA RECOMENDAR DEPENDIENDO DE LOS PARAMETROS INGRESADOS
	public String recomendacion(int riesgo, double monto, int plazo) {
		String recomendacion = "", mensaje = "";
		if (monto <= 1000000) {
			if (riesgo == 1 && plazo > 3) {
				recomendacion = "Se recomienda un plazo fijo tradicional";
			} else if (riesgo == 2 && plazo >= 6) {
				recomendacion = "Se recomienda invertir en bonos del tesoro nacional";
			} else if (riesgo == 3 && monto > 50.000) {
				recomendacion = "Podes optar por acciones o criptomonedas";
			} else {
				recomendacion = "Se sugiere un fondo comun de inversiones de bajo riesgo";
			}
		} else {
			mensaje = "El monto es demasiado alto y debe ponerse en contacto con\r\n" + "su entidad bancaria";
		}
		return recomendacion;
	}

	// METODO PARA CAMBIAR NUMERO DE PLAZOS
	public String cambiarPlazo(int nuevoPlazo) {
		String mensaje;
		if (nuevoPlazo >= 1 && nuevoPlazo <= 12) {
			nuevoPlazo = plazo;
			this.setPlazo(nuevoPlazo);
			mensaje = "Plazo anterior es: " + plazo + ", el Nuevo es: " + nuevoPlazo;
		} else {
			mensaje = "Plazo invalido, ingresa uno entre (1-12):";
		}
		return mensaje;
	}

	// METODO TOSTRING
	@Override
	public String toString() {
		return "AsesoriaFinanciera [nombre=" + nombre + ", edad=" + edad + ", riesgo=" + riesgo + ", monto=" + monto
				+ ", plazo=" + plazo + ", acumuladorGanancia=" + acumuladorGanancia + ", inversiones=" + inversiones
				+ "]";
	}

}
