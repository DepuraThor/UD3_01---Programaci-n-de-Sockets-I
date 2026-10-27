package Ej2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class Jugador {
	private Servidor servidor;
	private boolean[][] tablero;
	private int idJugador;
	private String posicionDelMonstruo;
	private OutputStream os;
	private InputStream is;
	// Los del server
	private OutputStream sos;
	private InputStream sis;

	public Jugador(Servidor servidor, int idJugador) {
		this.servidor = servidor;
		this.tablero = new boolean[10][10];
		this.idJugador = idJugador;
		// Colocamos el fantasma aleatoreamente
		int posicionX = new Random().nextInt(0,10);
		int posicionY = new Random().nextInt(0,10);
		tablero[posicionX][posicionY] = true;
		// Solo se pueden mandar bytes asi que hacemos un casting
		this.posicionDelMonstruo = posicionX + " " + posicionY;
		
	}
	
	private void establecerConeccion(int puertoCliente, int puertoServidor) throws IOException {
		System.out.println("Creamos el socket cliente en jugador " + idJugador);
		Socket cliente = new Socket();
		InetSocketAddress addr = new InetSocketAddress("localhost", puertoCliente);
		cliente.connect(addr);
		this.is = cliente.getInputStream();
		this.os = cliente.getOutputStream();
		System.out.println("Creamos el socket servidor en jugador: " + idJugador);
		ServerSocket server = new ServerSocket(puertoServidor);
		Socket newSocket = server.accept();
	}
	
	private boolean turno() throws IOException {
		int victoria = 0;
		Scanner sc = new Scanner(System.in);
			victoria = sis.read();
			if (victoria != 0) {
				System.out.println("Turno del jugador " + idJugador);
				// A B C D E F G H I J K
				System.out.println("Introduzca una posicion en X [A - k]: ");
				String ataqueEnX = sc.nextLine();
				System.out.println("Introduzca una posicion en Y [1 - 10]: ");
				String ataqueEny = sc.nextLine();
				os.write((ataqueEnX + " " + ataqueEny).getBytes());
				victoria = is.read();
			}
		return false;
	}
}
