package semaforos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Lanzador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// creo 300 hilos de persona

		for (int i = 0; i < 300; i++) {

			Persona per = new Persona();
			per.start();

		}

	}

}
