package ejercicio1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.channels.DatagramChannel;


class GuardianDelCementerio {
	private DatagramSocket socketUDP;
	private DatagramPacket recibido;
	
	public GuardianDelCementerio(int puerto) {
		try {
			this.socketUDP = new DatagramSocket(puerto);
			this.recibido = null;
		}catch(SocketException e) {
			e.printStackTrace();
		}
	}
	
	
	public String recibirMSG() {
		try {
			byte[] buffer = new byte[1000];
			recibido = new DatagramPacket(buffer, buffer.length);
			socketUDP.receive(recibido);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new String(recibido.getData()).trim();
	}
	
	public void enviarMSG(String msg) {
		try {
			DatagramPacket respuesta = new DatagramPacket(msg.getBytes(),
					msg.length(),
					recibido.getAddress(),
					recibido.getPort());
			socketUDP.send(respuesta);
		}catch(IOException E) {
			E.printStackTrace();
		}
	}
	
	public void closeServidorUDP() {
		socketUDP.close();
		System.out.println("El guardian se va a descansar");
	}
}


