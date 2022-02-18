package semaforos;

public class Persona extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Portero miPortero = Portero.getInstancia();
		miPortero.checkear();
	}

}
