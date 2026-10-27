package ejercicio1;

import java.util.Scanner;

public class Chat {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int puerto = 5555;
		String linea = "";
		
		System.out.println("Comienza a escribir hasta adios");
		
		GuardianDelCementerio guardian = new GuardianDelCementerio(puerto);
		FantasmaRecienLLegado recienLLegado = new FantasmaRecienLLegado();		
		
		while(!linea.equals("Adios")){
			linea = sc.nextLine();
			recienLLegado.enviarMsg(linea, "localhost", puerto);
			String mensaje = guardian.recibirMSG();
			System.out.println("Cliente: " + mensaje);
			String mensajeGuardian = sc.nextLine();
			System.out.println("Guardian: " + mensajeGuardian);
			guardian.enviarMSG(mensaje);
			mensaje = recienLLegado.recibirMsg();
		}
		guardian.closeServidorUDP();
		recienLLegado.closeClienteUDP();
	}
}
