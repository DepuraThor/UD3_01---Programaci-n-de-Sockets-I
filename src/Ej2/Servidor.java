package Ej2;

public class Servidor {
	private Jugador jugador1;
	private Jugador jugador2;
	private String posicionDelMonstruo1;
	private String posicionDelMonstruo2;
	public Servidor(Jugador jugador1, Jugador jugador2) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
	}
	
	private void establecerConneccion() {
		System.out.println("Creando socket del servidor");
	}
}
