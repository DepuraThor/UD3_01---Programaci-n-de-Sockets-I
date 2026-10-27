package ejercicio1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class FantasmaRecienLLegado {
	
	private DatagramSocket socketUDP;
	
	public FantasmaRecienLLegado() {
		try {
			socketUDP = new DatagramSocket();
		}catch(SocketException e) {
			e.printStackTrace();
		}
	}
	
	public void enviarMsg(String msg, String ip, int puerto) {
		InetAddress hostServidor;
		try {
			hostServidor = InetAddress.getByName(ip);
			byte[] mensaje = msg.getBytes();
			DatagramPacket peticion = new DatagramPacket(mensaje,
					mensaje.length,
					hostServidor,
					puerto);
			socketUDP.send(peticion);
		}catch(IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public String recibirMsg() {
		DatagramPacket respuesta = null;
		try {
			byte [] bufer = new byte[1000];
			respuesta = new DatagramPacket(bufer, bufer.length);
			socketUDP.receive(respuesta);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return new String(respuesta.getData()).trim();
	}
	
	public void closeClienteUDP() {
		socketUDP.close();
		System.out.println("El fantasma entra");
	}

//	@Override
//	public void run() {
//		
//		
//	}

}
