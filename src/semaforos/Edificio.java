package semaforos;

import java.util.ArrayList;

public class Edificio {

	private static Edificio instancia = new Edificio();

	private ArrayList<Integer> aforo_Actual = new ArrayList<Integer>();

	private static final int AFORO_MAXIMO = 31;

	private int aforo_total = 0;

	private Edificio() {

	}

	// mismo SINGLETON que en la clase portero, para no cambiar el edificio a
	// modificar entre hilos y que siempre accedan al mismo
	public static Edificio getInstancia() {
		return instancia;
	}

	// metodo principal de edificio que añade al array que controla el aforo una
	// nueva posicion cada vez que se ejecuta y a la vez muestra por pantalla la
	// cantidad de aforo que hay actualmente y la que han pasado en algun momento
	// por el edificio
	public void estancia() {
		synchronized (this) {

			aforo_Actual.add(1);
			aforo_total++;

			System.out.println(infoLocal());

		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		synchronized (this) {

			aforo_Actual.remove(aforo_Actual.size() - 1);

			System.out.println(infoLocal());

		}

	}

	public String infoLocal() {

		String texto = "Aforo actual: " + aforo_Actual.size() + "\nAforo total a lo largo del dia: " + aforo_total;

		return texto;
	}

}
