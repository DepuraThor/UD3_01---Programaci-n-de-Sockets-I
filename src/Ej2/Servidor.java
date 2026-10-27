package Ej2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketImpl;

public class Servidor {
	private Jugador jugador1;
	private Jugador jugador2;
	private String posicionDelMonstruo1;
	private String posicionDelMonstruo2;
	private ServerSocket socketServidor;
	private Socket socketJ1;
	public Servidor(Jugador jugador1, Jugador jugador2, int puerto1) throws IOException {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		socketServidor = new ServerSocket(puerto1);
		socketJ1 = socketServidor.accept();
		socketJ2 = socketServidor.accept();
	}
	

	private void establecerConneccion() {
		System.out.println("Creando socket del servidor");
	}
}
