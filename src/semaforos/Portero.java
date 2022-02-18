package semaforos;

import java.util.concurrent.Semaphore;

public class Portero {

	private static Portero instancia = new Portero();

	private Edificio miEdificio = Edificio.getInstancia();

	private Semaphore sem = new Semaphore(31, true);

	// pongo privado el constructor para no poder instanciar desde fuera de la clase
	// este objeto Portero
	private Portero() {

	}

	// retorna la instancia del objeto especificada como atributo, para que no varie
	// y trabajar con una unica instancia todo el rato(patron SINGLETON)
	public static Portero getInstancia() {
		return instancia;
	}

	// este metodo se asegura de descontar una plaza del semaforo antes de acceder
	// al edificio y de volver a liberarla al terminar la ejecucion
	public void checkear() {

		try {
			sem.acquire();

			miEdificio.estancia();

			sem.release();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
